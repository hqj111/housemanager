package com.house.manager.service;

import com.house.manager.entity.po.MemberPO;

import java.util.List;

/**

 * @Create 2020-01-17 8:04
 */
public interface MemberService {

    MemberPO login(String loginAcct);

    Integer getCountByLoginAcct(String loginAcct);

    void saveMember(MemberPO memberPO);

    void delete(Integer id);

    List<MemberPO> getAllMembers();

    void modify(MemberPO memberPO);
}
