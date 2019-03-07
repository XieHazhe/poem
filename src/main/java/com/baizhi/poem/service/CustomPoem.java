/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: CustomPoem
 * Author:   谢浩哲
 * Date:     2019/3/6 20:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.baizhi.poem.service;

import com.baizhi.poem.entity.PoemDTO;

import java.util.List;

public interface CustomPoem {
    List<PoemDTO> findAll(Integer start, Integer page, String filed, int id);
}
