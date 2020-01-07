package cn.liuyiyou.springboot;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: liuyiyou.cn
 * @date: 2020/1/7
 * @version: V1.0
 */
@Data
@Accessors(chain = true)
public class RefundResultJacksonVo {

    @JsonProperty("return_code")
    private int returnCode;
    @JsonProperty("return_msg")
    private String returnMsg;
    @JsonProperty("err_return_msg")
    private String errReturnMsg;

}
