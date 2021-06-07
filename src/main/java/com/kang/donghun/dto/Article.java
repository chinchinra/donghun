package com.kang.donghun.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@ToString
@RequiredArgsConstructor
@Getter
@Setter
public class Article {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long authorId;

    @Column
    private String author;

    @Column
    private String title;

    @Column(length= 100000000)
    private String content;

    @Column
    private LocalDateTime registerDate;

    @Column
    private LocalDateTime updateDate;

    public void update(String title , String content , LocalDateTime updateDate){

        this.content = content;
        this.title = title;
        this.updateDate = updateDate;

    }


}
