package model;

import java.util.ArrayList;

public class Album extends Product{
	
	private String artist;
	private int durationInMinutes;
	private MusicGenre genre;
	private MusicFormat format;
	private ArrayList<Song> songs;
	
	public String getArtist() {
		return artist;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public int getDurationInMinutes() {
		return durationInMinutes;
	}
	
	public void setDurationInMinutes(int durationInMinutes) throws Exception{
		if(durationInMinutes < 0) {
			this.durationInMinutes = 0;
			throw new Exception();
		}else {
			this.durationInMinutes = durationInMinutes;
		}
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
	
	public void addSong(Song song){
		songs.add(song);
	}
	
	public Song getSong(int index) throws IndexOutOfBoundsException{
		if(index < 0 || index > songs.size()) {
			throw new IndexOutOfBoundsException();
		}else {
			return songs.get(index);
		}
	}
	
}
