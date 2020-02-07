package com.house.manager.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.house.manager.entity.po.MaintenancePO;
import com.house.manager.entity.po.MaintenancePOCustom;
import com.house.manager.entity.po.MemberPO;
import com.house.manager.service.MaintainService;
import com.house.manager.util.HouseConstant;
import com.house.manager.util.HouseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Create 2020-02-07 7:54
 */
@Controller
public class MaintainController {

    @Autowired
    private MaintainService maintainService;

    @RequestMapping("/maintain/delete/{id}")
    public String deleteMember(@PathVariable("id") Integer id, Model model) {
        //非空判断
        if (id == null) {
            model.addAttribute("errorMsg", HouseConstant.MESSAGE_ID_INVALID);
            return "redirect:/backup/maintain/manage/1";
        }
        //删除
        try {
            maintainService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", HouseConstant.MESSAGE_ERROR_INTERNAL);
            return "redirect:/backup/maintain/manage/1";
        }

        return "redirect:/backup/member/manage/1";
    }

    @PostMapping("/maintain/modify")
    public String modifyMaintain(MaintenancePO maintenancePO, Model model){

        if(maintenancePO == null){
            model.addAttribute("errorMsg", HouseConstant.MESSAGE_INPUT_INVALID);
            return "redirect:/backup/maintain/manage/1";
        }

        try {
            maintainService.modify(maintenancePO);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", HouseConstant.MESSAGE_ERROR_INTERNAL);
            return "redirect:/backup/maintain/manage/1";
        }

        return "redirect:/backup/maintain/manage/1";
    }

    @RequestMapping("/backup/maintain/manage/{pageNum}")
    public String getMaintainByPageNum(@PathVariable("pageNum") Integer pageNum, Model model){

        if(pageNum == null || pageNum == 0){
            pageNum = 1;
        }

        PageHelper.startPage(pageNum, 3);
        List<MaintenancePOCustom> allMaintains = maintainService.getAllMaintains();

        if (!HouseUtils.collectionEffectiveCheck(allMaintains)) {
            model.addAttribute("errorMsg", HouseConstant.MESSAGE_DATA_EMPTY);
            return "redirect:/go/to/index";
        }

        PageInfo<MaintenancePOCustom> maintenancePOPageInfo = new PageInfo<>(allMaintains);

        model.addAttribute("maintains", maintenancePOPageInfo);
        model.addAttribute("activeId", pageNum);

        return "maintain-manager";
    }
}
