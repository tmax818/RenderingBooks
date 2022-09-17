package tylermaxwell.renderingbooks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import tylermaxwell.renderingbooks.models.Book;
import tylermaxwell.renderingbooks.services.BookService;

@Controller
public class BookController {

    // use dependency injection to have access to our service
    @Autowired
    BookService bookService;

    @GetMapping("/books/{bookId}")
    public String index(@PathVariable("bookId") Long bookId, Model model){
        System.out.println(bookId);
        Book book = bookService.findBook(bookId);
        model.addAttribute("book", book);
        System.out.println(book.getTitle());
        return "index.jsp";
    }
}
