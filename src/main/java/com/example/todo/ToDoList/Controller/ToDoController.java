package com.example.todo.ToDoList.Controller;

import com.example.todo.ToDoList.Domain.ToDo;
import com.example.todo.ToDoList.Service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
//@RequiredArgsConstructors는 ToDoRepository 속성을 포함하는 생성자를 자동으로 생성하는 것.
@Controller
//@Controller - 컨트롤러
//@RequestMapping("/todo") - url과 hello 맵핑
//@ResponseBody - toDo 메서드의 응답 결과가 문자열 그 자체라는 것을 알려줌
public class ToDoController {
    private final ToDoService toDoService;
    @RequestMapping("/todo")
    public String todolist(Model model){
        List<ToDo> toDoList = this.toDoService.getList();
        // "toDoEntityList"라는 이름으로 데이터를 Model 객체에 저장
        model.addAttribute("toDoList",toDoList);
        //내가 출력할 템플릿 이름
        return "todolist";
    }
    @PostMapping("/todo/create")
    public String todoCreate(@RequestParam String contents){
        toDoService.createList(contents);
        // 다시 원래 화면으로 리다이렉트
        return "redirect:/todo";
    }
    @DeleteMapping("/todo/delete/{id}")
    public String todoDelete(@PathVariable Long id){
        toDoService.deleteList(id);
        return "redirect:/todo";
    }

    @PutMapping("/todo/update/{id}")
    public String todoUpdate(@RequestBody String content, @PathVariable Long id){
        toDoService.updateList(id, content);
        return "redirect:/todo";
    }
    @RequestMapping("/")
    public String root(){
        return "redirect:/todo";
    }
}
