package cn.liuyiyou.springboot.elasticsearch.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: liuyiyou.cn
 * @date: 2019/8/30
 * @version: V1.0
 */
@Data
@Entity
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 文章id
     */
    @Id
    private Long id;

    /**
     * 对应author表uid
     */
    private Long uid;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 列表缩略图
     */
    private String thumbnailPics;

    /**
     * 封面图
     */
    private String coverPics;

    /**
     * 摘要
     */
    private String summary;

    /**
     * 创建时间也是发布时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 浏览量，要减去虚拟浏览量
     */
    private Integer readNum;

    /**
     * _num int(11)
     */
    private Integer commentNum;

    /**
     * 点赞数，要减去虚拟点赞量
     */
    private Integer praiseNum;

    /**
     * 状态:0-审核中，1-通过，2-不通过，3-删除
     */
    private Integer status;

    /**
     * 状态变更时间
     */
    private Date statusTime;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 虚拟浏览量
     */
    private Integer virtualReadNum;

    /**
     * 虚拟点赞量
     */
    private Integer virtualPraiseNum;

    /**
     * 是否有视频信息
     */
    private String videoInfo;

    public Article() {
    }

}
