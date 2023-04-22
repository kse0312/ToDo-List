package com.example.todo.ToDoList.Domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
// Lombok 어노테이션
// https://velog.io/@leyuri/Spring-boot-JPA-%EC%96%B4%EB%85%B8%ED%85%8C%EC%9D%B4%EC%85%98-Entity-Table-Column-Id-Lombok
public class ToDoEntity {
    @Id
    // 기본키로 설정한다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // https://gmlwjd9405.github.io/2019/08/12/primary-key-mapping.html
    // 데이터를 저장할 때 해당 속성에 따로 값을 셋팅하지 않아도 1씩 자동으로 증가
    // strategy는 고유 번호를 생성하는 옵션
    // GenerationType.IDENTITY는 해당 컬럼만의 독립적인 시퀀스를 생성하여 번호를 증가시킬 때 사용한다.
    private Integer id;

    @Column(length=200)
    // Column의 세부 설정을 위해 사용
    // varchar의 길이를 조정합니다. 기본값으로 255가 입력
    private String content;

    @Column(nullable = false)
    private Boolean completed;
}
