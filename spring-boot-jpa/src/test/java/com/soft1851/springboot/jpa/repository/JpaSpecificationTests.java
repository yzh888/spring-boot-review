package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.service.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zh_yan
 * @ClassName JpaSpecificationTests
 * @Description TODO
 * @Date 2020/5/13
 * @Version 1.0
 **/
@SpringBootTest
public class JpaSpecificationTests {

//    @Resource
//    private UserDetailService userDetailService;
//    @Resource
//    private UserDetailRepository userDetailRepository;

//    @Test
//    public void testFindByCondition()  {
//        int page=0,size=10;
////        Sort sort = new Sort(Sort.Direction.DESC, "id");
//        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "id");
//        UserDetailParam param=new UserDetailParam();
//        param.setIntroduction("程序员");
//        param.setMinAge(10);
//        param.setMaxAge(30);
//        Page<UserDetail> page1=userDetailService.findByCondition(param,pageable);
//        for (UserDetail userDetail:page1){
//            System.out.println("userDetail: "+userDetail.toString());
//        }
//    }
//
//    @Test
//    public void testUserInfo()  {
//        List<UserInfo> userInfos=userDetailRepository.findUserInfo("钓鱼");
//        for (UserInfo userInfo:userInfos){
//            System.out.println("userInfo: "+userInfo.getUserName()+"-"+userInfo.getEmail()+"-"+userInfo.getHobby()+"-"+userInfo.getIntroduction());
//        }
//    }
}