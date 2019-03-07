/**
 * @Title: PoemDTO
 * @ProjectName poem
 * @Description: TODO
 * @author 谢浩哲
 * @date 2019/3/618:27
 */

package com.baizhi.poem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "poem", type = "poets")
public class PoemDTO implements Serializable {
    @Id
    private String id;
    private String name;
    private Date created;
    private Date update;
    private String content;
    private String title;
}

