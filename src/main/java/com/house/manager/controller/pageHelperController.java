package com.house.manager.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.house.manager.entity.po.MemberPO;
import com.house.manager.entity.po.MemberPOExample;
import com.house.manager.mapper.MemberPOMapper;
import com.house.manager.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @Create 2020-01-22 1:55
 */
@Controller
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

    @PostMapping("/upload")
    public String uploadImage(@RequestParam(value = "file") List<MultipartFile> file, Model model){

        if(file.isEmpty()){
            return "file";
        }

        ArrayList<String> pathList = new ArrayList<>();

        for (MultipartFile multipartFile : file) {
            String imagePath = FileUploadUtil.saveFile(multipartFile);
            pathList.add(imagePath);
        }

        model.addAttribute("pathList", pathList);
        return "file";
    }
}
