package com.example.todo.ToDoList.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@Controller - 컨트롤러
//@RequestMapping("/todo") - url과 hello 맵핑
//@ResponseBody - toDo 메서드의 응답 결과가 문자열 그 자체라는 것을 알려줌
public class ToDoController {
    @RequestMapping("todo")
    @ResponseBody
    public String toDo(){
        return "todo";
    }
}
