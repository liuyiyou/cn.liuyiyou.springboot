/*
 * This file is generated by jOOQ.
*/
package cn.liuyiyou.springboot.db.h2;


import javax.annotation.Generated;

import org.jooq.Sequence;
import org.jooq.impl.SequenceImpl;


/**
 * Convenience access to all sequences in PUBLIC
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>PUBLIC.S_AUTHOR_ID</code>
     */
    public static final Sequence<Long> S_AUTHOR_ID = new SequenceImpl<Long>("S_AUTHOR_ID", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT);
}
