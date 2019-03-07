/**
 * @Title: CustomPoemService
 * @ProjectName poem
 * @Description: TODO
 * @author 谢浩哲
 * @date 2019/3/620:34
 */

package com.baizhi.poem.service;

import com.baizhi.poem.entity.PoemDTO;
import com.baizhi.poem.es.CustomPoemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomPoemService  implements CustomPoem{
    @Autowired
    private CustomPoemRepository customPoemRepository;

    @Override
    public List<PoemDTO> findAll(Integer start, Integer page, String filed, int id) {
        List<PoemDTO> poemDTOS = null;
        if (id == 1) {
            poemDTOS=customPoemRepository.findByNameLikeAndHighLightAndPageAble(start, page, filed);
        } else if (id == 2) {
            poemDTOS=customPoemRepository.findByTitleLikeAndHighLightAndPageAble(start, page, filed);
        }else{
            poemDTOS=customPoemRepository.findByContentLikeAndHighLightAndPageAble(start, page, filed);
        }
        return poemDTOS;
    }
}
