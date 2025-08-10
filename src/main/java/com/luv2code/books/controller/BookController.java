package com.luv2code.books.controller;

import com.luv2code.books.entity.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final List<Book> books = new ArrayList<>();

    public BookController() {
        initializeBooks();
    }

    private void initializeBooks() {
        books.addAll(List.of(
                new Book("Author one", "Title one", "science"),
                new Book("Author two", "Title two", "history"),
                new Book("Author three", "Title three", "physics"),
                new Book("Author four", "Title four", "chemistry"),
                new Book("Author four", "Title four", "math"),
                new Book("Author four", "Title four", "math"),
                new Book("Author four", "Title four", "math")
        ));
    }

    @GetMapping
    public List<Book> getBooks(@RequestParam(required = false) String category) {

        if (category == null) {
            return books;
        }
        List<Book> filterBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                filterBooks.add(book);
            }
        }
        return filterBooks;
    }
     @PostMapping("/create")
    public void createBook(@RequestBody Book newBook) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(newBook.getTitle())) {
                return;
            }
        }
        books.add(newBook);
    }


    @GetMapping("/{title}")
    public Book getBookByTitle(@PathVariable String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }



    @PutMapping("/{title}")
    public void updateBook(@PathVariable String title, @RequestBody Book updateBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equalsIgnoreCase(title)) {
                books.set(i, updateBook);
                return;
            }
        }
    }

    @DeleteMapping("/{title}")
    public void deleteBook(@PathVariable String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

}
