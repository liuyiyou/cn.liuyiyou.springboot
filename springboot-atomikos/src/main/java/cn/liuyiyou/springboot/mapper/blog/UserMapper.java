package cn.liuyiyou.springboot.mapper.blog;

import cn.liuyiyou.springboot.model.User;
import org.springframework.stereotype.Repository;

/**
 * User: liuyiyou
 * Date: 2017/9/9
 * Time: 上午11:41
 */
@Repository
public interface UserMapper {

    User selectByPrimaryKey(Long id);

    int insert(User user);
}
