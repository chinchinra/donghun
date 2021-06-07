package com.kang.donghun.service;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class PageN {

    private int pageNumber = 1;
//    private int prevPage;
//    private int nextPage;

    //    public void updatePage(int currentPage  , int prevPage , int nextPage){
//
//        this.currentPage = currentPage;
//        this.prevPage = prevPage;
//        this.nextPage = nextPage;
//
//    }
    public void nextPageNumber() {
        pageNumber++;
    }

    public void prevPageNumber() {
        pageNumber--;
    }
}
