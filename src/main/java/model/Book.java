package model;

/**
 * 
 * @author joseluis
 *
 */
public class Book extends Product{
	
	private int numberOfPages;
	private String author;
	private LiteraryGenre literaryGenre;
	private Format format;
	private String iSBM;
		
	private enum LiteraryGenre{
		SCIENCE_FICTION, ROMANTIC, DRAMA, COMEDY, TRAGEDY, HISTORY, ARTS
	}
	
	private enum Format{
		EBOOK, HARDCOVER, PAPERBACK, AUDIOBOOK
	}
	
	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) throws Exception{
		if(numberOfPages < 0) {
			throw new Exception();
		}else {
			this.numberOfPages = numberOfPages;
		}
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LiteraryGenre getLiteraryGenre() {
		return literaryGenre;
	}

	public void setLiteraryGenre(LiteraryGenre literaryGenre) {
		this.literaryGenre = literaryGenre;
	}
	
	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	public String getISBN() {
		return iSBM;
	}

	public void setISBN(String iSBN) throws Exception{
		if(iSBN.length() < 0 || iSBN.length() > 13) {
			throw new Exception();
		}else {
			this.iSBM = iSBN;
		}
	}
	
}
