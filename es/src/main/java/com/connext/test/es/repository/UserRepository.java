package com.connext.test.es.repository;

import com.connext.test.es.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserRepository extends ElasticsearchRepository<User,Integer> {
    /**
     * 根据用户名，获取用户分页列表
     * @param userName 用户名
     * @param pageable 分页模型
     * @return 分页用户列表
     */
    Page<User> findByUserName(String userName, Pageable pageable);
    /**
     * 根据用户手机号，获取用户列表
     * @param userPhone 用户手机
     * @return  用户列表
     */
    List<User> findByUserPhone(String userPhone);

}
