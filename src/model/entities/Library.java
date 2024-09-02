package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Library {
	List<Book> listBook = new ArrayList<>();

	public Library() {
	}

	public List<Book> getListBook() {
		return listBook;
	}

	public void addBook(Book book) {
		listBook.add(book);
	}

	public void removeBook(Book book) {
		listBook.remove(book);
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Lista de livros da biblioteca:\n");
		sb.append("------------------------------------\n");
		for (Book book : getListBook()) {
			sb.append(book);
			sb.append("\n");
			sb.append("------------------------------------\n");
		}
		return sb.toString();
	}
}
