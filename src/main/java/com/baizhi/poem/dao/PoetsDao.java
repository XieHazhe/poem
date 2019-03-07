/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PoetsDap
 * Author:   谢浩哲
 * Date:     2019/3/6 17:43
 * Description: PoetsDao
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.baizhi.poem.dao;

import com.baizhi.poem.entity.PoemDTO;

import java.util.List;

public interface PoetsDao {
    List<PoemDTO> selectAll();
}
