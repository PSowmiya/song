package com.example.song.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.song.model.Song;

public interface SongService {

	ResponseEntity<?> createSong(List<Song> songs);

	ResponseEntity<List<Song>> getAllSongs();

	ResponseEntity<?> updateSong(List<Song> songs);

	ResponseEntity<?> deleteById(Long id);

	ResponseEntity<List<Song>> getSongByArtist(String artistName);

	ResponseEntity<List<Song>> getSongBasedTitle(String title);

}
