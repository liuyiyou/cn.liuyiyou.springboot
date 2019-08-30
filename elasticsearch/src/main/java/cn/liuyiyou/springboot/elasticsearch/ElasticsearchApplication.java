package cn.liuyiyou.springboot.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
@EnableJpaRepositories
public class ElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchApplication.class, args);
    }


//    @Bean
//    public ElasticsearchTemplate elasticsearchTemplate(Client client) throws Exception {
//        return new ElasticsearchTemplate(client);
//    }


}