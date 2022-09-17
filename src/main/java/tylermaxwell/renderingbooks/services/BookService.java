package tylermaxwell.renderingbooks.services;

import org.springframework.stereotype.Service;
import tylermaxwell.renderingbooks.models.Book;
import tylermaxwell.renderingbooks.repositories.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    // injecting the book repository as a dependency
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    //CREATE: create a book
    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    //READ ALL: returns all the books
    public List<Book> allBooks(){
        return bookRepository.findAll();
    }

    //READ ONE: retrieve one book
    public Book findBook(Long id){
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }
    // UPDATE
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    // DELETE
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
