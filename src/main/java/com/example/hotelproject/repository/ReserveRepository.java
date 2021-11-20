package com.example.hotelproject.repository;

import java.util.List;

import com.example.hotelproject.entity.Reserve;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Long> {
    List<Reserve> findByHotelId(Long hotel_id);
}