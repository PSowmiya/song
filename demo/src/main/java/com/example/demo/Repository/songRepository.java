package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.music;

@Repository
public interface songRepository extends JpaRepository<music, Integer>{

	List<music> getBySongTitle(String title);
	
	boolean existsSongCountByFileNameEquals(String fileName);
	
	boolean existsSongTitleCountBySongTitleEquals(String songTitle);
	
	List<music> getByArtist(String artist);

	long countBySongTitleAndArtist(String songTitle, String artist);


}
