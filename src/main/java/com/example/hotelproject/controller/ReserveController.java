package com.example.hotelproject.controller;

import com.example.hotelproject.entity.Hotel;
import com.example.hotelproject.entity.Reserve;
import com.example.hotelproject.repository.HotelRepository;
import com.example.hotelproject.repository.ReserveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hotels/{hotel_id}/reserves")
public class ReserveController  {
    @Autowired
    private ReserveRepository reserveRepository;

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("new")
    public String newReserve(@PathVariable Long hotel_id, Model model) {
        Hotel hotel = hotelRepository.findById(hotel_id).orElse(null);
        model.addAttribute("hotel", hotel);
        model.addAttribute("title", "New Reserve");
        return"reserve/new";

    }

    @PostMapping
    public String create(@PathVariable Long hotel_id, @ModelAttribute Reserve reserve) {
        Hotel hotel = hotelRepository.findById(hotel_id).orElse(null);
        reserve.setHotel(hotel); 
        reserveRepository.save(reserve);
        return "redirect:/hotels/{hotel_id}/reserves/" + reserve.getId();
    }

    @GetMapping("{id}")
    private String show(@PathVariable Long id, @PathVariable Long hotel_id, Model model ) {
        Hotel hotel = hotelRepository.findById(hotel_id).orElse(null);
        Reserve reserve = reserveRepository.findById(id).orElse(null);
        model.addAttribute("reserve", reserve);
        model.addAttribute("hotel", hotel);
        model.addAttribute("title", "Show Reserve");
        return "reserve/show";
    }
}