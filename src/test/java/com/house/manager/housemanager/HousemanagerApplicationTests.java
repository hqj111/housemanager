package com.house.manager.housemanager;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.house.manager.entity.po.MemberPO;
import com.house.manager.entity.po.MemberPOExample;
import com.house.manager.mapper.MemberPOMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.lang.reflect.Member;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class HousemanagerApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private MemberPOMapper memberPOMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void testmysql() throws SQLException {

        MemberPO memberPO = memberPOMapper.selectByPrimaryKey(1);

        System.out.println(memberPO.getUsername());

    }

    @Test
    public void testPagehelper(){
        PageHelper.startPage(0, 3);
        List<MemberPO> memberPOList = memberPOMapper.selectByExample(new MemberPOExample());
        PageInfo<MemberPO> memberPOPageInfo = new PageInfo<>(memberPOList);
        System.out.println(memberPOPageInfo);
    }
}
