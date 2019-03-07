/**
 * @Title: CustomPoemRepository
 * @ProjectName poem
 * @Description: TODO
 * @author 谢浩哲
 * @date 2019/3/619:39
 */

package com.baizhi.poem.es;

import com.baizhi.poem.entity.PoemDTO;

import java.util.List;

public interface CustomPoemRepository {
    List<PoemDTO> findByNameLikeAndHighLightAndPageAble(Integer start,Integer page,String name);

    List<PoemDTO> findByTitleLikeAndHighLightAndPageAble(Integer start,Integer page,String name);

    List<PoemDTO> findByContentLikeAndHighLightAndPageAble(Integer start, Integer page, String name);
}
