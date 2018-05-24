package cn.liuyiyou.spring.propertysource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/***
 * @author: liuyiyou
 * @date: 2018/2/6
 */
@Component("dataSourceConfig")
//@PropertySource(value = "classpath:datasource.properties")
public class DataSourceConfig {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    //    @Value("#{spring.datasource.driverClassName}")
    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}
