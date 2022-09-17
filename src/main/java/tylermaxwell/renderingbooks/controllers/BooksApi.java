package tylermaxwell.renderingbooks.controllers;

import org.springframework.web.bind.annotation.*;
import tylermaxwell.renderingbooks.models.Book;
import tylermaxwell.renderingbooks.services.BookService;

import java.util.List;

@RestController
public class BooksApi {
    private final BookService bookService;
    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }

    // CREATE
    @RequestMapping(value = "/api/books", method = RequestMethod.POST)
    public Book create(@RequestParam(value = "title") String title,
                       @RequestParam(value = "description") String desc,
                       @RequestParam(value = "language") String lang,
                       @RequestParam(value = "pages") Integer pages){
        Book book = new Book(title, desc, lang, pages);
        return bookService.createBook(book);
    }

    // READ ALL
    @RequestMapping("/api/books")
    public List<Book> index(){
        return bookService.allBooks();
    }

    // UPDATE
    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.PUT)
    public Book update(@PathVariable("id") Long id,
                       @RequestParam(value = "title") String title,
                       @RequestParam(value = "description") String desc,
                       @RequestParam(value = "language") String lang,
                       @RequestParam(value = "pages") Integer pages){
        Book book = new Book(title, desc, lang, pages);
        book.setId(id);
        book = bookService.updateBook(book);
        return book;
    }

    // DELETE
    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id){
        bookService.deleteBook(id);
    }
}
