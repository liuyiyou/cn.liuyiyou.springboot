package cn.liuyiyou.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/***
 * @author: liuyiyou
 * @date: 2018/5/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PayRequest {

    private Double amount;
    private PayType payType;
}
