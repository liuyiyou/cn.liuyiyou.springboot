/*
 * This file is generated by jOOQ.
*/
package cn.liuyiyou.springboot.db.h2;


import cn.liuyiyou.springboot.db.h2.tables.Author;
import cn.liuyiyou.springboot.db.h2.tables.Book;
import cn.liuyiyou.springboot.db.h2.tables.BookStore;
import cn.liuyiyou.springboot.db.h2.tables.BookToBookStore;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>PUBLIC</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index PRIMARY_KEY_7 = Indexes0.PRIMARY_KEY_7;
    public static final Index FK_T_BOOK_AUTHOR_ID_INDEX_1 = Indexes0.FK_T_BOOK_AUTHOR_ID_INDEX_1;
    public static final Index FK_T_BOOK_CO_AUTHOR_ID_INDEX_1 = Indexes0.FK_T_BOOK_CO_AUTHOR_ID_INDEX_1;
    public static final Index PRIMARY_KEY_1 = Indexes0.PRIMARY_KEY_1;
    public static final Index PRIMARY_KEY_F = Indexes0.PRIMARY_KEY_F;
    public static final Index FK_B2BS_BS_NAME_INDEX_2 = Indexes0.FK_B2BS_BS_NAME_INDEX_2;
    public static final Index FK_B2BS_B_ID_INDEX_2 = Indexes0.FK_B2BS_B_ID_INDEX_2;
    public static final Index PRIMARY_KEY_2 = Indexes0.PRIMARY_KEY_2;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index PRIMARY_KEY_7 = Internal.createIndex("PRIMARY_KEY_7", Author.AUTHOR, new OrderField[] { Author.AUTHOR.ID }, true);
        public static Index FK_T_BOOK_AUTHOR_ID_INDEX_1 = Internal.createIndex("FK_T_BOOK_AUTHOR_ID_INDEX_1", Book.BOOK, new OrderField[] { Book.BOOK.AUTHOR_ID }, false);
        public static Index FK_T_BOOK_CO_AUTHOR_ID_INDEX_1 = Internal.createIndex("FK_T_BOOK_CO_AUTHOR_ID_INDEX_1", Book.BOOK, new OrderField[] { Book.BOOK.CO_AUTHOR_ID }, false);
        public static Index PRIMARY_KEY_1 = Internal.createIndex("PRIMARY_KEY_1", Book.BOOK, new OrderField[] { Book.BOOK.ID }, true);
        public static Index PRIMARY_KEY_F = Internal.createIndex("PRIMARY_KEY_F", BookStore.BOOK_STORE, new OrderField[] { BookStore.BOOK_STORE.NAME }, true);
        public static Index FK_B2BS_BS_NAME_INDEX_2 = Internal.createIndex("FK_B2BS_BS_NAME_INDEX_2", BookToBookStore.BOOK_TO_BOOK_STORE, new OrderField[] { BookToBookStore.BOOK_TO_BOOK_STORE.BOOK_STORE_NAME }, false);
        public static Index FK_B2BS_B_ID_INDEX_2 = Internal.createIndex("FK_B2BS_B_ID_INDEX_2", BookToBookStore.BOOK_TO_BOOK_STORE, new OrderField[] { BookToBookStore.BOOK_TO_BOOK_STORE.BOOK_ID }, false);
        public static Index PRIMARY_KEY_2 = Internal.createIndex("PRIMARY_KEY_2", BookToBookStore.BOOK_TO_BOOK_STORE, new OrderField[] { BookToBookStore.BOOK_TO_BOOK_STORE.BOOK_STORE_NAME, BookToBookStore.BOOK_TO_BOOK_STORE.BOOK_ID }, true);
    }
}