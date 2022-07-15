package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.TotalSong;
import com.example.demo.Repository.TotalSongRepository;

@RestController
public class songListController {

	@Autowired
	TotalSongRepository totalSongRepository;
	
	@GetMapping("/allsong")
    public List<TotalSong> getAllSongs(){
		return totalSongRepository.findAll();		
	}
	
	@PostMapping("/save")
	public List<TotalSong> saveUserDetails(@RequestBody List<TotalSong> totalSong) throws Exception {
	return	totalSongRepository.saveAll(totalSong);
	}
	
	
	
}
