/**
 * @Title: PoemController
 * @ProjectName poem
 * @Description: TODO
 * @author 谢浩哲
 * @date 2019/3/619:37
 */

package com.baizhi.poem.controller;

import com.baizhi.poem.entity.PoemDTO;
import com.baizhi.poem.service.CustomPoem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/poem")
public class PoemController {
    @Autowired
    private CustomPoem customPoem;

    @RequestMapping("/find")
    public ModelAndView findByName(Integer start, Integer page, String name,ModelAndView modelAndView,Integer id) {
        if (start==null){
            start = 1;
        }
        if (id==null){
            id = 1;
        }
        if (page==null){
            page = 10;
        }
        List<PoemDTO> pageAble = customPoem.findAll(start, page, name, id);
        if (start==null){
            start = 1;
        }
        modelAndView.addObject("page", start);
        modelAndView.addObject("name", name);
        modelAndView.addObject("id", id);
        modelAndView.setViewName("result");
        modelAndView.addObject("poem", pageAble);
        return modelAndView;
    }
}
