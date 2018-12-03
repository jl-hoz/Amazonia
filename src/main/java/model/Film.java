package model;

/**
 * 
 * @author joseluis
 *
 */
public class Film extends Product{
	
	private String director;
	private int durationInMinutes;
	
	public String getDirector() {
		return director;
	}
	
	public void setDirector(String director) throws Exception {
		if(director.isEmpty()) {
			throw new Exception();
		}else {
			this.director = director;
		}
	}
	
	public int getDurationInMinutes(){
		return durationInMinutes;
	}
	
	public void setDurationInMinutes(int durationInMinutes) throws Exception {
		if(durationInMinutes < 0) {
			throw new Exception();
		}else {
			this.durationInMinutes = durationInMinutes;
		}
	}
	
}
