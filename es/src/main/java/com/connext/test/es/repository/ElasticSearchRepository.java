package com.connext.test.es.repository;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.connext.test.es.entity.User;
import com.connext.test.es.es.ElasticSearchBase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ElasticSearchRepository extends ElasticSearchBase {

    public void batchCreate(String index, String type, List<User> userList) {
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        userList.forEach(user -> {
            bulkRequest.add(client.prepareIndex(index,type,user.getId()+user.getUserName()).setSource(toJSON(user), XContentType.JSON));
        });
        bulkRequest.execute().actionGet();
    }


    public String toJSON(User user){
        String str = JSON.toJSON(user).toString();
        //JSONObject jo = JSON.parseObject(str);
        return str;
    }

}
