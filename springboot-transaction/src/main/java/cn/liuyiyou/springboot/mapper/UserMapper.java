package cn.liuyiyou.springboot.mapper;

import cn.liuyiyou.springboot.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: liuyiyou.cn
 * @date: 2019/3/15
 * @version: V1.0
 */
@Repository
public interface UserMapper {

    List<User> findAll();

    int add(User user);
}
