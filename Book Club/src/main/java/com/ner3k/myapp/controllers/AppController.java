package com.ner3k.myapp.controllers;
import com.ner3k.myapp.models.Book;
import com.ner3k.myapp.models.LoginUser;
import com.ner3k.myapp.models.User;
import com.ner3k.myapp.services.BookService;
import com.ner3k.myapp.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController {

    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public  String index(Model model,HttpSession session) {
        if(session.getAttribute("loggedUser")!=null){
            return  "redirect:/books";
        }
        else{
            model.addAttribute("newUser", new User());
            model.addAttribute("newLogin", new LoginUser());
            return "logreg.jsp";
        }

    }
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin")LoginUser loginUser, BindingResult result, Model model, HttpSession session){
        User loggedUser = userService.login(loginUser, result);
        if(result.hasErrors()){
            model.addAttribute("newUser", new User());
            return "logreg.jsp";
        }
        else{
            session.setAttribute("loggedUser", loggedUser.getUsername());
            session.setAttribute("loggedUserId", loggedUser.getId());
            return "redirect:/";
        }
    }
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser")User newUser, BindingResult result, Model model, HttpSession session){
        User loggedUser = userService.register(newUser, result);
        if(result.hasErrors()){
            model.addAttribute("newLogin", new LoginUser());
            return "logreg.jsp";
        }
        else{
            session.setAttribute("loggedUser", loggedUser.getUsername());
            System.out.println( loggedUser.getId());
            session.setAttribute("loggedUserId", loggedUser.getId());
            return "redirect:/";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.setAttribute("loggedUser",null);
        session.setAttribute("loggedUserId",null);
        return "redirect:/";

    }
    @GetMapping("/books")
    public String mainPage(Model model,HttpSession session){
        if(session.getAttribute("loggedUser")==null){
            return  "redirect:/";
        }
        model.addAttribute("allBooks",bookService.getAllBooks());
        return "home.jsp";
    }
    @GetMapping("/addBook")
    public String addBook(@ModelAttribute("book") Book book){

        return "addBook.jsp";
    }
    @PostMapping("/addBook")
    public String addBookAction(@Valid @ModelAttribute("book") Book book,BindingResult result,HttpSession session){
        if(result.hasErrors()){
            return "addBook.jsp";
        }
        else {
            User loggeduser = userService.getUserById((Long) session.getAttribute("loggedUserId"));
            book.setPostedBy(loggeduser);
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
    @GetMapping("/books/{id}")
    public String displayBook(@PathVariable("id")Long id ,Model model){
        Book book = bookService.findBookById(id);
        model.addAttribute("book",book);
        return "displayBook.jsp";
    }
    @GetMapping("/books/{id}/edit")
    public String editBook(Model model,@PathVariable("id") Long id,HttpSession session){
        Book book = bookService.findBookById(id);
        if(book.getPostedBy().getId().equals(session.getAttribute("loggedUserId"))){
            model.addAttribute("book",book);
        return "editBook.jsp";}
        else {
            return "redirect:/books";
        }
    }
    @PutMapping("/books/{id}/edit")
    public String editBookAction(@Valid @ModelAttribute("book") Book book,BindingResult result,@PathVariable("id") Long id,HttpSession session){
        if(result.hasErrors()){
            return "editBook.jsp";
        }
        else {
            User loggeduser = userService.getUserById((Long) session.getAttribute("loggedUserId"));
            book.setPostedBy(loggeduser);
            bookService.createBook(book);
            return "redirect:/books/"+id;
        }
    }
    @GetMapping("/books/{id}/delete")
    public String deleteBook(@PathVariable("id") Long id,HttpSession session){
        Book book = bookService.findBookById(id);

        if(book.getPostedBy().getId().equals(session.getAttribute("loggedUserId"))){
            bookService.deleteBook(id);
        }
        return "redirect:/books";

    }
}
