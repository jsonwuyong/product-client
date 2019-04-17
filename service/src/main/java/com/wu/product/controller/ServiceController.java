package com.wu.product.controller;
/**
 * Created by sunny
 * 2019/4/13.
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author
 * @create 2019-04-13 19:30
 **/
@RestController
public class ServiceController {

    @GetMapping("/msg")
    public String msg(){
        return  "this is product msg 2";
    }



}
