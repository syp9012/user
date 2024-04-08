package com.example.demo.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("notice")
public class Notice {

    private int no_no;
    private String no_subject;
    private String no_content;
    private int no_readcount;
    private Date no_date;
    private int no_level;
    private int no_ref;
    private int no_step;
    
    //페이징 처리
    private int startRow;
    private int endRow;
    private int limit;
    
    //검색처리(제목+내용)
    private String searchWord;

    
    
    
    
    
    
}
