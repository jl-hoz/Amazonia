package model;

import java.util.Date;

public class Song extends Product{
	
	private String artist;
	private int durationInSeconds;
	private Date releaseDate;
	private MusicGenre genre;
	private MusicFormat format;
	
	public String getArtist() {
		return artist;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public int getDurationInSeconds(){
		return durationInSeconds;
	}
	
	public void setDurationInSeconds(int durationInSeconds) throws Exception{
		if(durationInSeconds < 0) {
			this.durationInSeconds = 0;
			throw new Exception();
		}else {
			this.durationInSeconds = durationInSeconds;
		}
	}
	
	public Date getReleaseDate() {
		return releaseDate;
	}
	
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public MusicGenre getGenre() {
		return genre;
	}
	
	public void setGenre(MusicGenre genre) {
		this.genre = genre;
	}
	
	public MusicFormat getFormat() {
		return format;
	}
	
	public void setFormat(MusicFormat format) {
		this.format = format;
	}
	
}
