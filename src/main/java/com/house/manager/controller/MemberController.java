package com.house.manager.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.house.manager.entity.po.MemberPO;
import com.house.manager.entity.po.MemberPOExample;
import com.house.manager.entity.vo.MemberLoginVo;
import com.house.manager.entity.vo.MemberRegisterVO;
import com.house.manager.service.MemberService;
import com.house.manager.util.HouseConstant;
import com.house.manager.util.HouseUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

/**
 * @Create 2020-01-17 8:15
 */
@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/member/add")
    public String addMember(MemberPO memberPO, Model model){

        if(memberPO == null){
            model.addAttribute("errorMsg", HouseConstant.MESSAGE_INPUT_INVALID);
            return "redirect:/backup/member/manage/1";
        }

        try {
            memberService.saveMember(memberPO);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", HouseConstant.MESSAGE_ERROR_INTERNAL);
        }

        return "redirect:/backup/member/manage/1";
    }

    @PostMapping("/member/modify")
    public String modifyMember(MemberPO memberPO, Model model){

        if(memberPO == null){
            model.addAttribute("errorMsg", HouseConstant.MESSAGE_INPUT_INVALID);
            return "member-manager";
        }

        try {
            memberService.modify(memberPO);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", HouseConstant.MESSAGE_ERROR_INTERNAL);
            return "member-manager";
        }

        return "member-manager";
    }

    @RequestMapping("/member/delete/{id}")
    public String deleteMember(@PathVariable("id") Integer id, Model model) {
        //非空判断
        if (id == null) {
            model.addAttribute("errorMsg", HouseConstant.MESSAGE_ID_INVALID);
            return "member-manager";
        }
        //删除
        try {
            memberService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", HouseConstant.MESSAGE_ERROR_INTERNAL);
            return "member-manager";
        }

        return "member-manager";
    }

    @RequestMapping("/backup/member/manage/{pageNum}")
    public String getMembersByPageNum(@PathVariable("pageNum")Integer pageNum, Model model) {

        if(pageNum == null || pageNum == 0){
            pageNum = 1;
        }



        PageHelper.startPage(pageNum, 3);

        //需要放在中间才行
        List<MemberPO> allMembers = memberService.getAllMembers();

        if (!HouseUtils.collectionEffectiveCheck(allMembers)) {
            model.addAttribute("errorMsg", HouseConstant.MESSAGE_DATA_EMPTY);
            return "index";
        }

        PageInfo<MemberPO> memberPOPageInfo = new PageInfo<>(allMembers);

//        allMembers = memberPOPageInfo.getList();

        model.addAttribute("members", memberPOPageInfo);
        model.addAttribute("activeId", pageNum);

        return "member-manager";

    }

    @PostMapping("/member/register")
    public String register(MemberRegisterVO memberRegisterVO, Model model) {
        //判断memberRegisterVO是否有效
        if (memberRegisterVO == null) {
            model.addAttribute("errorMsg", HouseConstant.MESSAGE_INPUT_INVALID);
            return "member-register";
        }

        //判断loginAcct是否已存在
        String loginAcct = memberRegisterVO.getLoginacct();
        Integer countByLoginAcct = memberService.getCountByLoginAcct(loginAcct);
        if (countByLoginAcct == 1) {
            model.addAttribute("errorMsg", HouseConstant.MESSAGE_REGISTER_LOGINACCT_ALREADY_EXIST);
            return "member-register";
        }

        //若不存在进行存取
        //1.VO ==》 PO
        MemberPO memberPO = new MemberPO();
        BeanUtils.copyProperties(memberRegisterVO, memberPO);
        memberPO.setTypeId(1);
        memberPO.setUsername(memberRegisterVO.getLoginacct());
        memberPO.setIsvalid(1);

        //判断注册是否成功
        try {
            memberService.saveMember(memberPO);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMsg", HouseConstant.MESSAGE_ERROR_INTERNAL);
            return "member-register";
        }

        //成功则返回登录页面，并提示注册成功
        model.addAttribute("registerResult", HouseConstant.MESSAGE_REGISTER_SUCCESS);
        return "member-login";
    }

    @RequestMapping("/member/logout")
    public String logout(HttpSession session) {
//        System.out.println("session:" + session.getAttribute("memberPO"));
        session.invalidate();
//        System.out.println("已删除session！");
        return "redirect:/go/to/login";
    }

    @PostMapping("/member/login")
    public String login(MemberLoginVo memberLoginVo, Model model, HttpSession session) {

        if (memberLoginVo == null) {
            model.addAttribute("errorMsg", HouseConstant.MESSAGE_INPUT_INVALID);
            return "member-login";
        }

        String loginAcct = memberLoginVo.getLoginacct();
        MemberPO memberPOFromSql = memberService.login(loginAcct);

//        System.out.println(memberPOFromSql);
        if (memberPOFromSql == null) {
            model.addAttribute("errorMsg", HouseConstant.MESSAGE_LOGIN_FAILED);
            return "member-login";
        }

        if (memberPOFromSql.getIsvalid() == 0) {
            model.addAttribute("errorMsg", HouseConstant.MESSAGE_MEMBER_DO_NOT_BE_USE);
            return "member-login";
        }

        if (!Objects.equals(memberPOFromSql.getUserpswd(), memberLoginVo.getUserpswd())) {
            model.addAttribute("errorMsg", HouseConstant.MESSAGE_LOGIN_FAILED);
            return "member-login";
        }

        session.setAttribute("memberPO", memberPOFromSql);
        model.addAttribute("successMsg", HouseConstant.MESSAGE_LOGIN_SUCCESS);
        return "redirect:/backup/go/to/index";
    }
}
