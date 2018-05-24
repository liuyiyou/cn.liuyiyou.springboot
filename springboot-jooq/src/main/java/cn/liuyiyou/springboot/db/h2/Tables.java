/*
 * This file is generated by jOOQ.
*/
package cn.liuyiyou.springboot.db.h2;


import cn.liuyiyou.springboot.db.h2.tables.Author;
import cn.liuyiyou.springboot.db.h2.tables.Book;
import cn.liuyiyou.springboot.db.h2.tables.BookStore;
import cn.liuyiyou.springboot.db.h2.tables.BookToBookStore;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in PUBLIC
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>PUBLIC.AUTHOR</code>.
     */
    public static final Author AUTHOR = cn.liuyiyou.springboot.db.h2.tables.Author.AUTHOR;

    /**
     * The table <code>PUBLIC.BOOK</code>.
     */
    public static final Book BOOK = cn.liuyiyou.springboot.db.h2.tables.Book.BOOK;

    /**
     * The table <code>PUBLIC.BOOK_STORE</code>.
     */
    public static final BookStore BOOK_STORE = cn.liuyiyou.springboot.db.h2.tables.BookStore.BOOK_STORE;

    /**
     * The table <code>PUBLIC.BOOK_TO_BOOK_STORE</code>.
     */
    public static final BookToBookStore BOOK_TO_BOOK_STORE = cn.liuyiyou.springboot.db.h2.tables.BookToBookStore.BOOK_TO_BOOK_STORE;
}