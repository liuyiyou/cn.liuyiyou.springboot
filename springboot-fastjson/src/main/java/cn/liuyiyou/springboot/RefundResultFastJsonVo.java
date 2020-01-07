package cn.liuyiyou.springboot;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: liuyiyou.cn
 * @date: 2020/1/7
 * @version: V1.0
 */
@Data
@Accessors(chain = true)
public class RefundResultFastJsonVo {

    @JSONField(name = "return_code", label = "Y")
    private int returnCode;
    @JSONField(name = "return_msg", label = "Y")
    private String returnMsg;
    @JSONField(name = "err_return_msg", label = "Y")
    private String errReturnMsg;

}
