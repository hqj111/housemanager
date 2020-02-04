package com.house.manager.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.house.manager.entity.po.MemberPO;
import com.house.manager.entity.po.MemberPOExample;
import com.house.manager.mapper.MemberPOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Create 2020-01-22 1:55
 */
@RestController
public class pageHelperController {

    @Autowired
    private MemberPOMapper memberPOMapper;

    @GetMapping("/get/{pageNum}")
    public List<MemberPO> get(@PathVariable("pageNum") Integer pageNum){
        PageHelper.startPage(pageNum, 2);

        List<MemberPO> memberPOS = memberPOMapper.selectByExample(new MemberPOExample());

        PageInfo<MemberPO> memberPOPageInfo = new PageInfo<>(memberPOS);

        return memberPOPageInfo.getList();
    }

}
