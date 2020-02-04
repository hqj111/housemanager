package com.house.manager.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**

 * @Create 2020-01-15 1:08
 */
@RestController
public class hello {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
