package com.house.manager.service.impl;

import com.house.manager.entity.po.MemberPO;
import com.house.manager.entity.po.MemberPOExample;
import com.house.manager.mapper.MemberPOMapper;
import com.house.manager.service.MemberService;
import com.house.manager.util.HouseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**

 * @Create 2020-01-17 8:05
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberPOMapper memberPOMapper;


    @Override
    public MemberPO login(String loginAcct) {

        MemberPOExample memberPOExample = new MemberPOExample();
        memberPOExample.createCriteria().andLoginacctEqualTo(loginAcct);
        List<MemberPO> memberPOList = memberPOMapper.selectByExample(memberPOExample);
        if (!HouseUtils.collectionEffectiveCheck(memberPOList)){
            return null;
        }
        return memberPOList.get(0);

    }

    @Override
    public Integer getCountByLoginAcct(String loginAcct) {
        MemberPOExample memberPOExample = new MemberPOExample();
        memberPOExample.createCriteria().andLoginacctEqualTo(loginAcct);

        return memberPOMapper.countByExample(memberPOExample);
    }

    @Override
    public void saveMember(MemberPO memberPO) {
        memberPO.setTypeId(1);
        memberPOMapper.insert(memberPO);
    }

    @Override
    public void delete(Integer id) {
        memberPOMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<MemberPO> getAllMembers() {
        MemberPOExample memberPOExample = new MemberPOExample();
        memberPOExample.createCriteria().andTypeIdNotEqualTo(2);
        return memberPOMapper.selectByExample(memberPOExample);
    }

    @Override
    public void modify(MemberPO memberPO) {
        memberPO.setTypeId(1);
        memberPOMapper.updateByPrimaryKey(memberPO);
    }
}
