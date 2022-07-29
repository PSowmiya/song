package com.example.song.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.song.model.Song;
import com.example.song.repository.SongRepository;
import com.example.song.service.SongService;

@Service
public class SongServiceImpl implements SongService {

	@Autowired
	SongRepository songRepository;

	@Override
	public ResponseEntity<?> createSong(List<Song> songs) {

		List<Song> saveList = new ArrayList<>();
		List<Song> pathList = new ArrayList<>();
		List<Song> titleList = new ArrayList<>();
		List<Song> artistNameList = new ArrayList<>();
		String message = "";

		try {

			pathList = songs.stream().filter(x -> x.getPath() == null).collect(Collectors.toList());
			titleList = songs.stream().filter(x -> x.getTitle() == null).collect(Collectors.toList());
			artistNameList = songs.stream().filter(x -> x.getArtistName() == null).collect(Collectors.toList());

			if (!pathList.isEmpty() || !titleList.isEmpty() || !artistNameList.isEmpty()) {

				message = "Some Data are empty in the " + songs.stream().filter(x -> x.getTitle() != null)
						.map(x -> x.getTitle()).collect(Collectors.toList()) + "List";
				return ResponseEntity.badRequest().body(message);
			} else {
				saveList = songRepository.saveAll(songs);
			}

			if (saveList != null && !saveList.isEmpty()) {

				message = "successfully saved  " + saveList.stream().filter(x -> x.getTitle() != null)
						.map(x -> x.getTitle()).collect(Collectors.toList()) + "Songs List";
				return ResponseEntity.status(HttpStatus.OK).body(message);
			} else {
				message = "failed to  save " + saveList.stream().filter(x -> x.getTitle() != null)
						.map(x -> x.getTitle()).collect(Collectors.toList()) + "Songs List";
				return ResponseEntity.badRequest().body(message);

			}

		} catch (Exception e) {
			message = "Could not upload the song: " + songs.stream().filter(x -> x.getTitle() != null)
					.map(x -> x.getTitle()).collect(Collectors.toList()) + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}

	@Override
	public ResponseEntity<List<Song>> getAllSongs() {

		try {
			List<Song> songList = songRepository.findAll().stream().filter(x -> x.getPath() != null)
					.collect(Collectors.toList());
			return ResponseEntity.ok(songList);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@Override
	public ResponseEntity<?> updateSong(List<Song> songs) {
		String message = "";
		List<Song> saveList = new ArrayList<>();
		List<Song> pathList = new ArrayList<>();
		List<Song> titleList = new ArrayList<>();
		List<Song> artistNameList = new ArrayList<>();

		try {

			pathList = songs.stream().filter(x -> x.getPath() == null).collect(Collectors.toList());
			titleList = songs.stream().filter(x -> x.getTitle() == null).collect(Collectors.toList());
			artistNameList = songs.stream().filter(x -> x.getArtistName() == null).collect(Collectors.toList());

			if (songs.stream().filter(x -> x.getId() == null).collect(Collectors.toList()).isEmpty()) {

				if (!pathList.isEmpty() || !titleList.isEmpty() || !artistNameList.isEmpty()) {

					message = "Some Data are empty in the " + songs.stream().filter(x -> x.getTitle() != null)
							.map(x -> x.getTitle()).collect(Collectors.toList()) + "List";
					return ResponseEntity.badRequest().body(message);

				} else {
					saveList = songRepository.saveAll(songs);
				}

				if (saveList != null && !saveList.isEmpty()) {

					message = "successfully updated  " + saveList.stream().filter(x -> x.getTitle() != null)
							.map(x -> x.getTitle()).collect(Collectors.toList()) + "Songs List";
					return ResponseEntity.status(HttpStatus.ACCEPTED).body(message);
				} else {
					message = "failed to  updated " + songs.stream().filter(x -> x.getTitle() != null)
							.map(x -> x.getTitle()).collect(Collectors.toList()) + "Songs List";
					return ResponseEntity.badRequest().body(message);

				}

			} else {
				message = "failed to  updated " + songs.stream().filter(x -> x.getTitle() != null)
						.map(x -> x.getTitle()).collect(Collectors.toList()) + "Songs List";
				return ResponseEntity.badRequest().body(message);

			}

		} catch (Exception e) {
			message = "Could not upload the song: " + songs.stream().filter(x -> x.getTitle() != null)
					.map(x -> x.getTitle()).collect(Collectors.toList()) + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}

	}

	@Override
	public ResponseEntity<?> deleteById(Long id) {
		// TODO Auto-generated method stub
	
		try {
			songRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Song Removed");

		} catch (Exception e) {
			
			return ResponseEntity.badRequest().body(e);
		}

	}

	@Override
	public ResponseEntity<List<Song>> getSongByArtist(String artistName) {

		try {
			List<Song> songList = songRepository.findByArtistName(artistName);
			return new ResponseEntity<List<Song>>(songList.stream().collect(Collectors.toList()), HttpStatus.FOUND);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public ResponseEntity<List<Song>> getSongBasedTitle(String title) {

		try {
			List<Song> songList = songRepository.findByTitle(title);
			return new ResponseEntity<List<Song>>(songList.stream().collect(Collectors.toList()), HttpStatus.FOUND);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

}
