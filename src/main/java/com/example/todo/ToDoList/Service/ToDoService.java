package com.example.todo.ToDoList.Service;


import com.example.todo.ToDoList.Domain.ToDoEntity;
import com.example.todo.ToDoList.Repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//대규모의 스프링부트 프로젝트는 레포지토리를 직접 사용이 아닌 서비스를 통하여 사용한다.
//서비스는 데이터 처리를 위해 작성하는 클래스
@RequiredArgsConstructor
@Service
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public List<ToDoEntity> getList(){
        return this.toDoRepository.findAll();
    }

    public void createList(String contents){
        ToDoEntity toDoEntity = new ToDoEntity();
        toDoEntity.setContents(contents);
        toDoEntity.setCompleted(false);
        this.toDoRepository.save(toDoEntity);
    }
}