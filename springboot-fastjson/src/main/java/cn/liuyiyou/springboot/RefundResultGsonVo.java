package cn.liuyiyou.springboot;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: liuyiyou.cn
 * @date: 2020/1/7
 * @version: V1.0
 */
@Data
@Accessors(chain = true)
public class RefundResultGsonVo {

    @SerializedName("return_code")
    private int returnCode;
    @SerializedName("return_msg")
    private String returnMsg;
    @SerializedName("err_return_msg")
    private String errReturnMsg;

}
