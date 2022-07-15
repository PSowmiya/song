package com.example.demo.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;


import com.example.demo.Entity.music;

public interface SongService {

	ResponseEntity<List<music>> getAllSongs();

	ResponseEntity<List<music>> getSongs(String id);

	ResponseEntity<?> createNewSong(List<music> music);

	ResponseEntity<?> updateSong(music music);


}
