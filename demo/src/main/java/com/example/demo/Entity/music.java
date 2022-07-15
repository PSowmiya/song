package com.example.demo.Entity;



import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "song")
public class music {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "creationTime")
	private LocalTime  creationTime;

	@Column(name = "songTitle")
	private String songTitle;

	@Column(name = "songDuration")
	private String songDuration;

	@Column(name = "kidRecomended")
	private boolean kidRecomended;

	@Column(name = "fileName")
	private String fileName;
	
	@Column(name = "fileFormate")
	private String fileFormate;
	
//	@DateTimeFormat(pattern = "dd-MM-yyyy")
//	@Column(name = "creationDate")
//	private Date  creationDate;
	
	@Column(name = "creationDate")
	private String  creationDate;
	
	@Column(name="artist")
	private String artist;
	
	@Column(name="url")
	private String url;

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSongTitle() {
		return songTitle;
	}

	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}




	public LocalTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalTime creationTime) {
		this.creationTime = creationTime;
	}

	public String getSongDuration() {
		return songDuration;
	}

	public void setSongDuration(String songDuration) {
		this.songDuration = songDuration;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public boolean isKidRecomended() {
		return kidRecomended;
	}

	public void setKidRecomended(boolean kidRecomended) {
		this.kidRecomended = kidRecomended;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileFormate() {
		return fileFormate;
	}

	public void setFileFormate(String fileFormate) {
		this.fileFormate = fileFormate;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "music [id=" + id + ", creationTime=" + creationTime + ", songTitle=" + songTitle + ", songDuration="
				+ songDuration + ", kidRecomended=" + kidRecomended + ", fileName=" + fileName + ", fileFormate="
				+ fileFormate + ", creationDate=" + creationDate + "]";
	}

	
	
}
