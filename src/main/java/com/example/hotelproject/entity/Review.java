package com.example.hotelproject.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private Long rating;
    private double ratingAverage;
    private String body;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Long getRating() {
        return rating;
    }
    
    public void setRating(Long rating) {
        this.rating = rating;
    }

    public double getRatingAverage() {
        return ratingAverage;
    }

    public void setRatingAverage(double ratingAverage, List<Review> reviews, Review review){
        int size = reviews.size();
        double total = 0;
        for (Long rating = (long) 0; rating > size; rating++){
            total += review.getRating();
        }

        ratingAverage = total/size;
    }
    

    public String getBody() {
        return body;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setBody(String body) {
        this.body = body;
    }    
    

}