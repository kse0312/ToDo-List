package com.example.todo.ToDoList;

import com.example.todo.ToDoList.Domain.ToDo;
import com.example.todo.ToDoList.Repository.ToDoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ToDoListApplicationTests {

	@Autowired
	//@Autowired : 속성에 객체를 주입하는 방식
	private ToDoRepository toDoRepository;

	@Test
	void TestJpa(){
		ToDo todo1 = new ToDo();

		todo1.setContents("밥먹기");
		todo1.setCompleted(Boolean.TRUE);
		this.toDoRepository.save(todo1);

		ToDo todo2 = new ToDo();

		todo2.setContents("공부하기");
		todo2.setCompleted(Boolean.TRUE);
		this.toDoRepository.save(todo2);

		System.out.println(this.toDoRepository.count());
		this.toDoRepository.deleteAll();
		System.out.println(this.toDoRepository.count());
	}


}
