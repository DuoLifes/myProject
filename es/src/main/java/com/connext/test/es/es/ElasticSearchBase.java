package com.connext.test.es.es;


import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"unchecked", "Duplicates"})
public class ElasticSearchBase {
    private final static Logger LOGGER = LoggerFactory.getLogger(ElasticSearchBase.class);

    @Autowired
    protected TransportClient client;

    /**
     * 新建索引文档
     */
    public IndexResponse addOneLeadsInfoDoc(String index, String type, String id, Object source) {
        ObjectMapper objectMapper = new ObjectMapper();
        String sourceStr = "";
        try {
            sourceStr = objectMapper.writeValueAsString(source);
        } catch (Exception e) {
            e.printStackTrace();
        }
        IndexResponse response = client.prepareIndex(index, type, id)
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
                .setSource(sourceStr, XContentType.JSON).execute().actionGet();
        return response;
    }

    /**
     * 更新文档
     */
    public Object updateEsDoc(String index, String type, String id, Map<String, Object> maps) {
        ObjectMapper objectMapper = new ObjectMapper();
        String sourceStr = "";
        try {
            sourceStr = objectMapper.writeValueAsString(maps);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return client.prepareUpdate(index, type, id)
                .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
                .setDoc(sourceStr, XContentType.JSON)
                .execute().actionGet();
    }

    /**
     * 根据文档Id获取索引名        入参索引支持 *
     *
     * @param id
     * @param index
     * @param type
     * @return
     */
    protected String getModifyIndexName(String index, String type, String id) {

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery().must(QueryBuilders.termQuery("_id", id));
        SearchResponse searchResponse = client
                .prepareSearch(index)
                .setTypes(type)
                .setPostFilter(boolQueryBuilder)
                .setFetchSource(new String[]{"0"}, null)
                .execute()
                .actionGet();

        SearchHits hits = searchResponse.getHits();
        if (hits.totalHits == 0) {
            throw new RuntimeException("can not find leads by leadsId:" + id);
        }
        return hits.getAt(0).getIndex();
    }


    /**
     * 分页查询
     */
    public <T> Page<T> findPage(String index, String type, QueryBuilder queryBuilder, Pageable pageable, Class<T> clazz) {

        LOGGER.debug(MessageFormat.format("Search ElasticSearch : index={0},type={1},queryinfo={2}", index, type, queryBuilder.toString()));

        SearchRequestBuilder builder = client
                .prepareSearch(index)
                .setTypes(type)
                .setQuery(queryBuilder)
                .setFrom(pageable.getPageNumber() * pageable.getPageSize())
                .setSize(pageable.getPageSize());

        if (pageable.getSort() != null) {
            Sort sort = pageable.getSort();
            for (Sort.Order order : sort) {
                String sortField = order.getProperty();
                SortOrder sortOrder = order.getDirection().isDescending() ? SortOrder.DESC : SortOrder.ASC;
                builder.addSort(sortField, sortOrder);
            }
        }

//        ElasticSearchDocument elasticSearchDocument = clazz.getAnnotation(ElasticSearchDocument.class);
//        if (elasticSearchDocument != null) {
//
//        }

        List<T> list = new ArrayList();
        SearchResponse searchResponse = builder.execute().actionGet();
        SearchHits hits = searchResponse.getHits();
        for (SearchHit searchHit : hits) {
            try {
                T t = JSON.parseObject(searchHit.getSourceAsString(), clazz);
                if (t == null) {
                    continue;
                }
                list.add(t);
            } catch (Exception ex) {
                // do noting
            }
        }
        return new PageImpl<>(list, pageable, hits.getTotalHits());
    }


    public long count(String index, String type, QueryBuilder queryBuilder) {
        LOGGER.debug(MessageFormat.format("Search ElasticSearch : index={0},type={1},queryinfo={2}", index, type, queryBuilder.toString()));

        return client.prepareSearch(index)
                .setTypes(type)
                .setSize(0)
                .setQuery(queryBuilder).get().getHits().getTotalHits();
    }


    //分组查询
    public Map<String, Integer> countGroup(String index, String type, String groupName, String field, QueryBuilder queryBuilder, Class t) {

        //构造分组字段及别名groupName 、field
        TermsAggregationBuilder tb = AggregationBuilders.terms(groupName).field(field);
        SearchRequestBuilder builder = client.prepareSearch(index)
                .setTypes(type)
                .setQuery(queryBuilder)
                .addAggregation(tb);
        SearchResponse searchResponse = builder.execute()
                .actionGet();
        Terms terms = searchResponse.getAggregations().get(groupName);
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        Map<String, Integer> dataMap = new HashMap<String, Integer>();
        for (Terms.Bucket bucket : buckets) {
            String key = (String) bucket.getKey();
            dataMap.put(key, (int) bucket.getDocCount());
        }
        return dataMap;
    }

}
