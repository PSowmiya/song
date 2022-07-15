package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.TotalSong;

@Repository
public interface TotalSongRepository extends JpaRepository<TotalSong, Integer>{

}
