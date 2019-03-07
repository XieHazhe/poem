/**
 * @Title: PoemService
 * @ProjectName poem
 * @Description: TODO
 * @author 谢浩哲
 * @date 2019/3/619:18
 */

package com.baizhi.poem.service;

import com.baizhi.poem.entity.PoemDTO;
import com.baizhi.poem.es.PoemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoemService {
    @Autowired
    private PoemRepository poemRepository;

    public void save(List<PoemDTO> list){
        poemRepository.saveAll(list);
    }
}
