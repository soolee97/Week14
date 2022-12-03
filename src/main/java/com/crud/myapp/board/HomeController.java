package com.crud.myapp.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //annotation
public class HomeController {
    @RequestMapping("/") // 주소에 대한 요청
    public String home(){ return "/index" ; } // 그리고 처리할 함수

}