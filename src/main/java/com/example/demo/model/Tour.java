package com.example.demo.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("tour")
public class Tour {

    private String tour_id;
    private String tour_name;
    private String tour_url;
    private String tour_tel;
    private String tour_city_name;
    private String tour_addr1;
    private String tour_addr2;
    private String tour_zipcode;
    private String tour_locx;
    private String tour_locy;
    private String tour_desc;
    private String tour_babycarry;
    private String tour_animal_able;
    private String tour_age_able;
    private String tour_heritage1;
    private String tour_heritage2;
    private String tour_heritage3;
    private String tour_infocenter;
    private String tour_open_date;
    private String tour_parking;
    private String tour_dayoff;
    private String tour_usetime;
    private String tour_images;
    private String tour_image1;

    //search
	private String search_word;
	private String do_name;
	private String city_name;
    
	//page
	private int startRow;
    private int endRow;
    private int limit;
    
    
}
