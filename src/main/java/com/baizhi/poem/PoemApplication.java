package com.baizhi.poem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.baizhi.poem.es")
@MapperScan("com.baizhi.poem.dao")
public class PoemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoemApplication.class, args);
    }

}
