package com.example.song.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.song.model.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Long>{

	List<Song> findByTitle(String title);

	List<Song> findByArtistName(String artistName);

}
