package model.application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Book;
import model.entities.Library;
import model.entities.enums.Category;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Library library = new Library();
		try {
			System.out.println("\t\tSistema de Cadastro de livros:");
			System.out.print("Quantos livros serão cadastrados: ");
			int resp = sc.nextInt();
			sc.nextLine(); // Limpar o buffer do scanner
			for (int i = 1; i <= resp; i++) {
				System.out.print("Título do " + i + "° livro:");
				String title = sc.nextLine();
				System.out.print("Nome do autor: ");
				String author = sc.nextLine();
				System.out.print("Ano de publicação: ");
				int yearPublication = sc.nextInt();
				sc.nextLine(); // Limpar o buffer do scanner
				Book book = new Book(title, author, yearPublication);
				saveCategories(book, sc);
				library.addBook(book);
			}
			System.out.println("Livros devidamente preenchidos!");
		} catch (InputMismatchException e) {
			System.out.println("Erro: Dados inválidos fornecidos. Por favor, insira um número inteiro.");
		} finally {
			sc.close();
		}
		System.out.println("\n\n");
		System.out.println(library);
	}

	public static void showCategories(Book book, Scanner sc) {
		System.out.println(
				"===================================================================================================");
		System.out.println("\t\t\tGêneros disponíveis:");
		int cont = 0;
		for (Category category : Category.values()) {
			cont++;
			String categoryStr = category.toString().replace("_", " ");
			System.out.printf("%-30s", categoryStr);
			if (cont % 5 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	public static void saveCategories(Book book, Scanner sc) {
		showCategories(book, sc);
		char resp = 'n';
		boolean validInput;
		do {
			validInput = true;
			try {
				System.out.println("Qual o gênero do livro " + book.getTitle()
						+ " (digite o nome exatamente como mostrado acima): ");
				String categoryStr = sc.nextLine();
				Category category = Category.valueOf(categoryStr.replace(" ", "_").toUpperCase());
				book.addCategory(category);
			} catch (IllegalArgumentException e) {
				System.out.println("Categoria inválida fornecida. Por favor, escolha um gênero válido.");
				validInput = false;
				continue; // Volta para o início do loop
			}
			System.out.println("Há mais alguma categoria do livro (s/n)? ");
			resp = sc.nextLine().toLowerCase().charAt(0);

			if (resp != 's' && resp != 'n') {
				System.out.println("Entrada inválida. Por favor, digite 's' para sim ou 'n' para não.");
				validInput = false;
			}
		} while (!validInput || resp != 'n');
	}

}
