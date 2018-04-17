package com.connext.test.es;

import com.connext.test.es.entity.User;
import com.connext.test.es.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EsApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	@Test
	public void contextLoads() {

		//增加对象
//		User user=new User(3,"田玉","18888888888");
//		userService.save(user);
//		System.out.println("插如成功  "+ "id: "+user.getId()+"  uername:"+user.getUserName()+"  telephone:"+user.getUserPhone());

		//删除对象
//		userService.deleteByUserId(2);

		//查询所有对象
//		Iterable<User>iterable=userService.findAll();
//		for(User user1:iterable){
//			System.out.println("id: "+user1.getId()+"  uername:"+user1.getUserName()+"  telephone:"+user1.getUserPhone());
//
//		}

		//创建索引插入对象
		String index="user";
		String type="User";
		User user=new User(1,"孙涵","15555555555");
		List<User>list=new ArrayList<>();
		list.add(user);
		userService.addElasticsearch(index,type,list);
	};
}
