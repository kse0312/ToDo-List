package com.example.todo.ToDoList.Service;


import com.example.todo.ToDoList.Domain.ToDoEntity;
import com.example.todo.ToDoList.Repository.ToDoRepository;
import jakarta.transaction.Transactional;
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
    @Transactional
    /*
        데이터베이스 트랜잭션은 데이터베이스 관리 시스템 또는 유사한 시스템에서 상호작용의 단위
        @Transactional은 클래스나 메서드에 붙여줄 경우, 해당 범위 내 메서드가 트랜잭션이 되도록 보장해준다.
        선언적 트랜잭션이라고도 하는데, 직접 객체를 만들 필요 없이 선언만으로도 관리를 용이하게 해주기 때문.
        특히나 SpringBoot에서는 선언적 트랜잭션에 필요한 여러 설정이 이미 되어있는 탓에, 더 쉽게 사용할 수 있다.
     */
    public void deleteList(Integer id) {
        ToDoEntity toDoEntity = toDoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 아이템이 없습니다. id=" + id));

        this.toDoRepository.delete(toDoEntity);
    }
    @Transactional
    public void updateList(Integer id, String content) {
        ToDoEntity toDoEntity = toDoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 아이템이 없습니다. id=" + id));

        toDoEntity.setContents(content);
        this.toDoRepository.save(toDoEntity);
    }
}