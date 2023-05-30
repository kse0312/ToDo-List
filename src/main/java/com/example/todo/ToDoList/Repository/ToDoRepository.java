package com.example.todo.ToDoList.Repository;

import com.example.todo.ToDoList.Domain.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;


// <이 인터페이스를 사용하는 Entity 이름, Entity의 ID 유형>
public interface ToDoRepository extends JpaRepository<ToDo,Long> {

}
