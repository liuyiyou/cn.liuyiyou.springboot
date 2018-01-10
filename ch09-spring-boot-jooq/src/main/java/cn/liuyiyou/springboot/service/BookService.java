package cn.liuyiyou.springboot.service;

import org.springframework.transaction.annotation.Transactional;

/***
 * @author: liuyiyou
 * @date: 2018/1/4
 */
public interface BookService {

    @Transactional
    void create(int id, int authorId, String title);
}
