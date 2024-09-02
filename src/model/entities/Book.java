package model.entities;

import java.util.ArrayList;
import java.util.List;

import model.entities.enums.Category;

public class Book {
	private String title;
	private String author;
	private int publicationYear;

	List<Category> listCategory = new ArrayList<>();

	public Book() {
	}

	public Book(String title, String author, int publicationYear) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public List<Category> getListCategory() {
		return listCategory;
	}

	public void addCategory(Category category) {
		listCategory.add(category);
	}

	public void removeCategory(Category category) {
		listCategory.remove(category);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Título:" + title);
		sb.append("\nAutor:" + author);
		sb.append("\nAno publicação:" + publicationYear);
		sb.append("\nGênero:");
		for(Category category : listCategory) {
			sb.append(category.toString().replace("_", " "));
			sb.append(", ");
		}
		return sb.toString();
	}
	
}
