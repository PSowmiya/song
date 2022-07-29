package com.example.song.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.song.model.Song;
import com.example.song.service.SongService;

@RestController("api")
public class SongController {

	@Autowired
	SongService songService;

	@PostMapping("/save/Songs")
	public ResponseEntity<?> saveSongs(@RequestBody List<Song> songs) {
		return songService.createSong(songs);
	}

	@GetMapping("/getAllSongs")
	public ResponseEntity<List<Song>> getAllSongs() {
		return songService.getAllSongs();
	}

	@PutMapping("/update/Songs")
	public ResponseEntity<?> updateSongs(@RequestBody List<Song> songs) {
	return songService.updateSong(songs);
	}
	
	@DeleteMapping("/delete/Songs/{id}")
	public ResponseEntity<?> deleteSongs(@PathVariable Long id){
		return songService.deleteById(id);
	}
	
	@GetMapping("/getSongByTitle/{title}")
	public ResponseEntity<List<Song>> getSongByTitle(@PathVariable String title) {
		return songService.getSongBasedTitle(title);
	}
	
	@GetMapping("/getSongByArtistName/{artistName}")
	public ResponseEntity<List<Song>> getSongByArtistName(@PathVariable String artistName) {
		return songService.getSongByArtist(artistName);
	}
	
}
