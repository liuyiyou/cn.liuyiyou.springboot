package cn.liuyiyou.springboot.starter;

import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static com.alibaba.fastjson.JSON.parseObject;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2018/8/23
 * @Copyright 2018 liuyiyou.cn Inc. All rights reserved
 */
public class ResultMessageConvert extends AbstractHttpMessageConverter<Result> {

    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;


    public ResultMessageConvert() {
        super(DEFAULT_CHARSET, MediaType.APPLICATION_JSON_UTF8, MediaType.ALL);
        logger.info("ResultMessageCovert init ");
    }

    @Override
    protected boolean supports(Class clazz) {
        return true;
    }

    @Override
    protected Result readInternal(Class<? extends Result> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String param = StreamUtils.copyToString(inputMessage.getBody(), DEFAULT_CHARSET);
        return parseObject(JSON.toJSONString(param), Result.class);
    }

    @Override
    protected void writeInternal(Result result, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        StreamUtils.copy(JSON.toJSONString(result), DEFAULT_CHARSET, outputMessage.getBody());
    }
}
