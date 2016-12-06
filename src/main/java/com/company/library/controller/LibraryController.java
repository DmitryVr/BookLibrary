package com.company.library.controller;

import com.company.library.model.Book;
import com.company.library.service.interfaces.AuthorService;
import com.company.library.service.interfaces.BookService;
import com.company.library.service.interfaces.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Library Controller
 *
 * атрибуты spring-сессии:
 * listBooks - список книг
 * listAuthors - список авторов
 * listGenres - список жанров
 * selectedBy - книги выбраны по id автора или жанра
 * selectedId - id жанра или автора
 */
@Controller
@SessionAttributes({"listBooks", "listAuthors", "listGenres", "selectedBy", "selectedId"})
public class LibraryController {

    @Autowired
    private AuthorService authorServiceImpl;

    @Autowired
    private GenreService genreServiceImpl;

    @Autowired
    private BookService bookServiceImpl;

    /**
     * listAuthors - список авторов
     * listGenres - список жанров
     * book - для добавления новой книги
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String mainPage(Model model) {
        model.addAttribute("listAuthors", authorServiceImpl.getAll());
        model.addAttribute("listGenres", genreServiceImpl.getAll());
        model.addAttribute("book", new Book());

        return "/content/user";
    }

    /**
     * список книг по id автора
     */
    @RequestMapping(value = "/getBooksByAuthorId/{id}", method = RequestMethod.GET)
    public String getBooksByAuthorId(@PathVariable("id") int id, Model model) {
        model.addAttribute("listBooks", authorServiceImpl.getById(id).getBooks());
        model.addAttribute("selectedId", id);
        model.addAttribute("selectedBy", "author");

        return "redirect:/user";
    }

    /**
     * список книг по id жанра
     */
    @RequestMapping(value = "/getBooksByGenreId/{id}", method = RequestMethod.GET)
    public String getBooksByGenreId(@PathVariable("id") int id, Model model) {
        model.addAttribute("listBooks", genreServiceImpl.getById(id).getBooks());
        model.addAttribute("selectedId", id);
        model.addAttribute("selectedBy", "genre");

        return "redirect:/user";
    }

    /**
     * удалить книгу по id
     */
    @RequestMapping(value = "/deleteBookById/{id}", method = RequestMethod.GET)
    public String deleteBookById(@PathVariable("id") int id,
                                 @ModelAttribute("selectedBy") String selectedBy,
                                 @ModelAttribute("selectedId") int selectedId,
                                 Model model) {
        bookServiceImpl.delete(id);

        if (selectedBy.equals("author")) {
            model.addAttribute("listBooks", authorServiceImpl.getById(selectedId).getBooks());
        }
        if (selectedBy.equals("genre")) {
            model.addAttribute("listBooks", genreServiceImpl.getById(selectedId).getBooks());
        }

        return "redirect:/user";
    }

    /**
     * редактировать существующую книгу или добавить новую
     */
    @RequestMapping(value = "/addOrUpdateBook", method = RequestMethod.POST)
    public String addOrUpdateBook(@ModelAttribute("book") Book book,
                                  @ModelAttribute("selectedBy") String selectedBy,
                                  @ModelAttribute("selectedId") int selectedId,
                                  Model model) {
        if(book.getId() == 0) {
            bookServiceImpl.add(book);
        } else {
            bookServiceImpl.update(book);
        }

        if (selectedBy.equals("author")) {
            model.addAttribute("listBooks", authorServiceImpl.getById(selectedId).getBooks());
        }
        if (selectedBy.equals("genre")) {
            model.addAttribute("listBooks", genreServiceImpl.getById(selectedId).getBooks());
        }

        return "redirect:/user";
    }

    /**
     * отправить на форму книгу для редактирования
     *
     * book - для редактирования существующей книги
     */
    @RequestMapping(value = "/updateBookById/{id}", method = RequestMethod.GET)
    public String updateBookById(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookServiceImpl.getById(id));

        return "/content/user";
    }
}
