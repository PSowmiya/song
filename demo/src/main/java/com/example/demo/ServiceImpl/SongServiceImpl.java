package com.example.demo.ServiceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.TotalSong;
import com.example.demo.Entity.music;
import com.example.demo.Repository.TotalSongRepository;
import com.example.demo.Repository.songRepository;
import com.example.demo.Service.SongService;

@Service
public class SongServiceImpl implements SongService {

	@Autowired
	private final songRepository songRepository;

	@Autowired
	private final TotalSongRepository totalSongRepository;

	public SongServiceImpl(songRepository songRepository, TotalSongRepository totalSongRepository) {
		super();
		this.songRepository = songRepository;
		this.totalSongRepository = totalSongRepository;
	}

	@Override
	public ResponseEntity<List<music>> getAllSongs() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(songRepository.findAll());
	}

	@Override
	public ResponseEntity<List<music>> getSongs(String title) {
		// TODO Auto-generated method stub

		List<music> title1 = songRepository.getBySongTitle(title);
		List<music> artist = songRepository.getByArtist(title);
		if (title1.size() > 0) {
			return ResponseEntity.ok(title1);
		} else if (artist.size() > 0) {
			return ResponseEntity.ok(artist);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	public ResponseEntity<?> createNewSong(List<music> music) {
		// TODO Auto-generated method stub
		List<music> savingList = new ArrayList<>();
		Set<String> errorList = new HashSet<>();
		Set<String> successList = new HashSet<>();

		String message = "";
		try {
			for (music itr : music) {

				long existTitle = songRepository.countBySongTitleAndArtist(itr.getSongTitle(), itr.getArtist());

				if (existTitle >= 1) {
					message = "song or title already exist : " + itr.getFileName();
					return ResponseEntity.badRequest().body(message);
				} else {
					
						itr.setUrl(itr.getUrl());
						successList.add(itr.getFileName());
						savingList.add(itr);

				}
			}

			if (savingList != null && !savingList.isEmpty()) {
				songRepository.saveAll(savingList);

				message = "Uploaded the song successfully: " + successList;
				return ResponseEntity.status(HttpStatus.OK).body(message);
			}
			if (errorList != null && !errorList.isEmpty()) {
				message = "song not exist : " + errorList;
				return ResponseEntity.badRequest().body(message);
			}
		} catch (Exception e) {
			message = "Could not upload the song: " + errorList.addAll(successList) + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
		return null;

	}

	@Override
	public ResponseEntity<?> updateSong(music music) {
		String message = "";
		long existTitle = songRepository.countBySongTitleAndArtist(music.getSongTitle(), music.getArtist());

		if (existTitle <= 0) {
			message = "song not exist : " + music.getFileName();
			return ResponseEntity.badRequest().body(message);
		}

		try {

				music.setUrl(music.getUrl());
				songRepository.save(music);

				message = "Update successfully: " + music.getFileName();
				return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "Could not update the song: " + music.getFileName() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}

}
