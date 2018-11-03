package br.usjt.arqsw18.pipoca.model.service;

public class FilmeTMDb {
	
	private String poster_path;
	private boolean adult;
	private String overview;
	private String release_date;
	private String title;
	private double popularity;
	private int[] genre_ids;


	public boolean isAdult() {
		return adult;
	}
	public void setAdult(boolean adult) {
		this.adult = adult;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPopularity() {
		return popularity;
	}
	public void setPopularity(double popularity) {
		this.popularity = popularity;
	}

	public String getPoster_path() {
		return poster_path;
	}
	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}
	public int[] getGenre_ids() {
		return genre_ids;
	}
	public void setGenre_ids(int[] genre_ids) {
		this.genre_ids = genre_ids;
	}
	@Override
	public String toString() {
		return "FilmeTMDb [posterPath=" + poster_path + ", adult=" + adult + ", overview=" + overview + ", release_date="
				+ release_date + ", title=" + title + ", popularity=" + popularity + ", genre_id=" + genre_ids + "]";
	}
	
}
