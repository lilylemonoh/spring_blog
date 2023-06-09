package com.spring.blog.dto;
/*
 * 엔터티 클래스는 DB(전체) 테이블에 대응하는 자바 클래스이고, 데이터 전달을 위한 목적보다는
 * 정의를 위해서 쓰는 경우가 더 많습니다.
 * 따라서 실질적으로 역직렬화나 직렬화를 위한 로직에는 DTO(Date Transfer Object)라는 클래스를 만들고
 * 활용할 쿼리문에 맞춰서 멤버변수를 정의해서 사용합니다
 * */
import com.spring.blog.entity.Blog;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BlogUpdateDTO {
    // UPDATE 시 필요한 데이터는
    // 글쓴이, 글제목, 글본문, 글번호
    private long blogId;
    private String writer;
    private String blogTitle;
    private String blogContent;

    // 엔터티 데이터를 DTO로 변환해주기 위한 생성자
    // DTO가 엔터티의 하위개념이므로, DTO는 엔터티의 내부 구조를 알아야 작동할 수 있지만(->DTO에는 엔터티를 호출하는 코드가 있는데 엔터티에는 DTO와 관련된 로직이 아무것도 없다)
    // 엔터티는 DTO의 구조와 상관없이 작동해야 하므로, 엔터티를 DTO로 바꾸는 건 가능해야 하지만
    // 그 반대는 성립하지 않음.
    public BlogUpdateDTO(Blog blog){
        this.blogId = blog.getBlogId();
        this.writer = blog.getWriter();
        this.blogTitle = blog.getBlogTitle();
        this.blogContent = blog.getBlogContent();
    }

    // 이렇게 했어야 한다(본 코드에) 적용하진 않았음

}