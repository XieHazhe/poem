/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PoemRepository
 * Author:   谢浩哲
 * Date:     2019/3/6 19:14
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.baizhi.poem.es;

import com.baizhi.poem.entity.PoemDTO;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 * @author 谢浩哲
 */
public interface PoemRepository extends ElasticsearchCrudRepository<PoemDTO,String> {
}
