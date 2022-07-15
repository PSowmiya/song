package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Entity.music;
import com.example.demo.Service.SongService;

@RestController
@RequestMapping("/api")
public class SongController {
	
	@Autowired
	private final SongService songService;

	public SongController( SongService songService) {
		super();
		this.songService = songService;
	}
	
	@GetMapping("retrive/allSongs")
	public ResponseEntity<List<music>> getAllSongs(){
		return   songService.getAllSongs();
	}

	@GetMapping("retrive/Song/{id}")
	public ResponseEntity<List<music>> getSongs(@PathVariable String id){
		return   songService.getSongs(id);
	}
	
	@PostMapping("added/songs")
	public ResponseEntity<?>  createSong(@RequestBody List<music> music){
		return songService.createNewSong(music);
		
	}
	
	@PutMapping("update/songs")
	public ResponseEntity<?>  updateSong(@RequestBody music music){
		return songService.updateSong(music);
		
	}
	
}
