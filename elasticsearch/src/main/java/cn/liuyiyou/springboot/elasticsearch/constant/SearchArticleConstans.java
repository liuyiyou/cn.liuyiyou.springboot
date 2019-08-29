package cn.liuyiyou.springboot.elasticsearch.constant;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;


/**
 * @author lzt
 * @Date 2018.07.11
 */
public class SearchArticleConstans {
    /**
     * index 为 prod 的基础查询字段
     */
    public static List<String> ARTICLE_HIGHLIGHT_FIELDS = newArrayList("title", "summary");


    /**
     * 聚合的桶的关键字
     */
    public static String BUCKETS = "buckets";
    /**
     *聚合的桶中的key 的关键字
     */
    public static String BUCKETKEYS_KEY = "key";
    /**
     * 聚合的关键字
     */
    public static String AGGREGATIONS = "aggregations";
    /**
     * article的索引名称
     */
    public static String ARTICLE_INDEX = "article_index";
    /**
     * article字段：title
     */
    public static String ARTICLE_FIELD_TITLE = "title";
    /**
     * article字段：title.SPY
     */
    public static String ARTICLE_FIELD_TITLE_SPY = "title.SPY";
    /**
     * article字段：title.FPY
     */
    public static String ARTICLE_FIELD_TITLE_FPY = "title.FPY";
    /**
     * article字段：summary
     */
    public static String ARTICLE_FIELD_SUMMARY = "summary";
    /**
     * article字段：summary.SPY
     */
    public static String ARTICLE_FIELD_SUMMARY_SPY = "summary.SPY";
    /**
     * article字段：summary.FPY
     */
    public static String ARTICLE_FIELD_SUMMARY_FPY = "summary.FPY";
    /**
     * article字段：content
     */
    public static String ARTICLE_FIELD_CONTENT = "content";
    /**
     * article字段：content.SPY
     */
    public static String ARTICLE_FIELD_CONTENT_SPY = "content.SPY";
    /**
     * article字段：content.FPY
     */
    public static String ARTICLE_FIELD_CONTENT_FPY = "content.FPY";
    /**
     * type searchArticle 文章
     */
    public static String SEARCH_ARTICLE_TYPE = "search_article_type";

    public static final String ARTICLE_INDEX_MAPPING = "{\n" +
            "    \"" + SEARCH_ARTICLE_TYPE + "\": {\n" +
            "        \"properties\": {\n" +
            "            \"id\": {\n" +
            "                \"type\": \"long\",\n" +
            "                \"index\": \"not_analyzed\"\n" +
            "            },\n" +
            "            \"title\": {\n" +
            "                \"type\": \"text\",\n" +
            "                \"index\": \"analyzed\",\n" +
            "                \"analyzer\": \"ikIndexAnalyzer\",\n" +
            "                \"fields\": {\n" +
            "                    \"SPY\": {\n" +
            "                        \"type\": \"text\",\n" +
            "                        \"index\": \"analyzed\",\n" +
            "                        \"analyzer\": \"pinyinSimpleIndexAnalyzer\"\n" +
            "                    },\n" +
            "                    \"FPY\": {\n" +
            "                        \"type\": \"text\",\n" +
            "                        \"index\": \"analyzed\",\n" +
            "                        \"analyzer\": \"pinyinFullIndexAnalyzer\"\n" +
            "                    }\n" +
            "                }\n" +
            "            },\n" +
            "            \"thumbnailPics\": {\n" +
            "                \"type\": \"text\",\n" +
            "                \"fielddata\": true\n" +
            "            },\n" +
            "            \"summary\": {\n" +
            "                \"type\": \"text\",\n" +
            "                \"index\": \"analyzed\",\n" +
            "                \"analyzer\": \"ikIndexAnalyzer\",\n" +
            "                \"fields\": {\n" +
            "                    \"SPY\": {\n" +
            "                        \"type\": \"text\",\n" +
            "                        \"index\": \"analyzed\",\n" +
            "                        \"analyzer\": \"pinyinSimpleIndexAnalyzer\"\n" +
            "                    },\n" +
            "                    \"FPY\": {\n" +
            "                        \"type\": \"text\",\n" +
            "                        \"index\": \"analyzed\",\n" +
            "                        \"analyzer\": \"pinyinFullIndexAnalyzer\"\n" +
            "                    }\n" +
            "                }\n" +
            "            },\n" +
            "            \"readNum\": {\n" +
            "                \"type\": \"integer\",\n" +
            "                \"index\": \"not_analyzed\"\n" +
            "            },\n" +
            "            \"commentNum\": {\n" +
            "                \"type\": \"integer\",\n" +
            "                \"index\": \"not_analyzed\"\n" +
            "            },\n" +
            "            \"praiseNum\": {\n" +
            "                \"type\": \"integer\",\n" +
            "                \"index\": \"not_analyzed\"\n" +
            "            },\n" +
            "            \"statusTime\": {\n" +
            "                \"type\": \"date\",\n" +
            "                \"format\": \"yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis\"\n" +
            "            },\n" +
            "            \"content\": {\n" +
            "                \"type\": \"text\",\n" +
            "                \"index\": \"analyzed\",\n" +
            "                \"analyzer\": \"ikIndexAnalyzer\",\n" +
            "                \"fields\": {\n" +
            "                    \"SPY\": {\n" +
            "                        \"type\": \"text\",\n" +
            "                        \"index\": \"analyzed\",\n" +
            "                        \"analyzer\": \"pinyinSimpleIndexAnalyzer\"\n" +
            "                    },\n" +
            "                    \"FPY\": {\n" +
            "                        \"type\": \"text\",\n" +
            "                        \"index\": \"analyzed\",\n" +
            "                        \"analyzer\": \"pinyinFullIndexAnalyzer\"\n" +
            "                    }\n" +
            "                }\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "}";
}
