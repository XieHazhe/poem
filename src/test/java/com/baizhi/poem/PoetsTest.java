/**
 * @Title: PoetsTest
 * @ProjectName poem
 * @Description: TODO
 * @author 谢浩哲
 * @date 2019/3/618:53
 */

package com.baizhi.poem;

import com.baizhi.poem.dao.PoetsDao;
import com.baizhi.poem.entity.PoemDTO;
import com.baizhi.poem.es.CustomPoemRepository;
import com.baizhi.poem.es.PoemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PoetsTest {
    @Autowired
    private PoetsDao poetsDao;

    @Autowired
    private PoemRepository poemRepository;


    @Autowired
    private CustomPoemRepository customPoemRepository;
    @Test
    public void testSelect(){
        List<PoemDTO> poemDTOS = poetsDao.selectAll();
        poemRepository.saveAll(poemDTOS);

//        for (PoemDTO poemDTO : poemDTOS) {
//            System.out.println("poemDTO = " + poemDTO);
//        }
    }

    @Test
    public void selectPage(){
        List<PoemDTO> list = customPoemRepository.findByTitleLikeAndHighLightAndPageAble(1, 10, "送");
        for (PoemDTO poemDTO : list) {
            System.out.println("poemDTO = " + poemDTO);
        }
    }


}
