package com.example.song;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.example.song.model.Song;
import com.example.song.serviceimpl.SongServiceImpl;

@SpringBootTest
class SongApplicationTests {

	@Autowired
	SongServiceImpl songServiceImpl;

	@Test
	public void saveSongSuccess() {

		List<Song> songsList = new ArrayList<>();

		Song song = new Song();

		song.setArtistName("A");
		song.setDate("20/3/98");
		song.setPath("http:localhost:8080");
		song.setTime(LocalTime.now());
		song.setTitle("testtile");

		songsList.add(song);
		String expectedSuccess = "successfully saved  " + songsList.stream().filter(x -> x.getTitle() != null)
				.map(x -> x.getTitle()).collect(Collectors.toList()) + "Songs List";
		ResponseEntity<?> output = songServiceImpl.createSong(songsList);

		assertEquals(expectedSuccess, output.getBody());

	}

	@Test
	public void savedSongFailure() {

		List<Song> songsList = new ArrayList<>();

		Song song = new Song();

		song.setArtistName("A");
		song.setDate("20/3/98");
		song.setTime(LocalTime.now());
		song.setTitle("testtile");

		songsList.add(song);
		String expected = "Some Data are empty in the " + songsList.stream().filter(x -> x.getTitle() != null)
				.map(x -> x.getTitle()).collect(Collectors.toList()) + "List";
		ResponseEntity<?> output = songServiceImpl.createSong(songsList);

		assertEquals(expected, output.getBody());

	}

	@Test
	public void updatedSong() {

		List<Song> songsList = new ArrayList<>();

		Song song = new Song();

		song.setId(1l);
		song.setArtistName("Anirudh Ravichander");
		song.setDate("20/3/98");
		song.setPath("http:localhost:8080");
		song.setTime(LocalTime.now());
		song.setTitle("testtile");

		songsList.add(song);
		String expected = "successfully updated  " + songsList.stream().filter(x -> x.getTitle() != null)
				.map(x -> x.getTitle()).collect(Collectors.toList()) + "Songs List";
		ResponseEntity<?> output = songServiceImpl.updateSong(songsList);

		assertEquals(expected, output.getBody());

	}

	@Test
	public void deleteSong() {
		String expected = "Song Removed";
		Long id = 1l;
		ResponseEntity<?> output = songServiceImpl.deleteById(id);

		assertEquals(expected, output.getBody());
	}

	@Test
	public void getAllSongs() {

		ResponseEntity<?> output = songServiceImpl.getAllSongs();

		assertNotNull(output.getBody());

	}

	@Test
	public void getSongByTitle() {

		String title = "testtitle";

		ResponseEntity<?> output = songServiceImpl.getSongBasedTitle(title);

		assertNotNull(output.getBody());

	}

	@Test
	public void getSongByArtistname() {

		String artistName = "testtitle";

		ResponseEntity<?> output = songServiceImpl.getSongByArtist(artistName);

		assertNotNull(output.getBody());

	}

}
