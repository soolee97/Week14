package com.crud.myapp.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
    @Autowired
    BoardServiceImpl boardService ;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String boardlist(Model model){
        // 목록 보기
        model.addAttribute("list", boardService.getBoardList()) ;
        System.out.println("Show List in the screen.");
        return "list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPost(){
        // 추가 폼
        return "addpostform";
    }

    @RequestMapping(value = "/addok", method = RequestMethod.POST)
    public String addPostOk(BoardVO vo){
        // 추가된 데이터 저장
        int i = boardService.insertBoard(vo) ;
        if(i==0) System.out.println("Failed");
        else System.out.println("Success!!");

        return "redirect:list" ;
    }

    @RequestMapping(value = "/editform/{id}", method = RequestMethod.GET)
    public String editPost(@PathVariable("id") int id, Model model){
        BoardVO boardVO = boardService.getBoard(id);
        model.addAttribute("u", boardVO) ;
        return "editform" ;
    }

    @RequestMapping(value = "/editok", method = RequestMethod.POST)
    public String editPostOk(BoardVO vo){
        // 추가된 데이터 저장
        int i = boardService.updateBoard(vo) ;
        if(i==0) System.out.println("Failed to edit");
        else System.out.println("Success to edit!!");

        return "redirect:list" ;
    }

    @RequestMapping(value = "/deleteok/{id}", method = RequestMethod.GET)
    public String deletePostOk(@PathVariable("id") int id){
        if(boardService.deleteBoard(id) == 0) System.out.println("Failed to delete");
        else System.out.println("Success to delete!!!");
        return "redirect:../list" ;
    }

}
