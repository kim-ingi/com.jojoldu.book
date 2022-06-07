package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public Long getId() {
        return this.id;
    }

    // @Entity
    // 테이블과 링크 될 클래스임을 나타냅니다
    // 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭합니다
    // eg) SalesManager.java -> sales_manager table
    // Setter 메소드 만들지 않음. 클래스 인스턴스값이 언제 어디서 변해야하는지 코드상 명확하게 구분이 어려움
    // eg) 잘못 사용
    // public class Order{
    // public void setStatus(boolean status) { this.status = status; }}
    // public void 주문서비스_취소이벤트(){order.setStatus(false);}
    // eg) 올바른 사용
    // public class Order{
    // public void cancelOrder() { this.status = false; }}
    // public void 주문서비스_취소이벤트(){order.cancelOrder();}
    // * Setter가 없는 경우 기본적으로는 생성자를 통해 최종값 채운 후 DB 삽입.
    //   값 변경이 필요한 경우 해당 이벤트에 맞는 public 메소드를 호출하여 변경
    // Builder클래스 > 생성자랑 유사하지만 지금 채워야 할 필드가 무엇인지 명확히 지정 가능

    // @Id
    // 해당 테이블의 PK(Primary key)필드를 나타냅니다
    // PK는 Long타입의 Auto_increment를 추천(bigint)
    
    // @GeneratedValue
    // PK의 생성 규칙을 나타냅니다
    // 스프링 부트 2.0에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가 됩니다
    // 스프링부트 2.0버전과 1.5버전 차이 https://jojoldu.tistory.com/295
    
    // @Column
    // 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 됨
    // 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용
    // 문자열의 경우 VARCHAR(255)가 기본값, 사이즈를 500으로 늘리고 싶거나 타입을 TEXT로 변경하는 등의 경우 사용
}
