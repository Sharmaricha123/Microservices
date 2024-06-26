package com.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rating.entities.Rating;
import com.rating.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating)
	{
		Rating savedRating=ratingService.create(rating);
		return new ResponseEntity<Rating>(savedRating,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getRatings()
	{
		List<Rating> allRatings=ratingService.getRatings();
		return new ResponseEntity<List<Rating>>(allRatings,HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId)
	{
		List<Rating> allUserRatings=ratingService.getRatingByUserId(userId);
		return new ResponseEntity<List<Rating>>(allUserRatings,HttpStatus.OK);
		
	}
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable  String hotelId)
	{
		List<Rating> allHotelRatings=ratingService.getRatingByHotelId(hotelId);
		return new ResponseEntity<List<Rating>>(allHotelRatings,HttpStatus.OK);
		
	}
	
	

}
