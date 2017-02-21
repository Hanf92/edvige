package com.dagasource.Controller;

import com.dagasource.InsertBook.Book;
import com.dagasource.InsertUser.*;
import com.dagasource.InsertBook.BookRepository;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * Created by fabio on 25/01/17.
 */

@RestController
@SpringBootApplication
public class Controller {

    private  BookRepository bookRepository;
    private  UserRepo userRepo;

    @Autowired
    public Controller(BookRepository bookRepository, UserRepo userRepo) {
        this.bookRepository = bookRepository;
        this.userRepo = userRepo;
    }


    @RequestMapping(value= "/addBook", method = RequestMethod.POST)
    public ResponseEntity<Book> addBook(@RequestParam("isbn") String isbn){
        try {
            Book book = new Book();
            book.setIsbn(isbn);
            Book saved = bookRepository.save(book);
            System.out.println(isbn);
            return ResponseEntity.ok().body(saved);
        }catch (Exception e){
            System.out.println("ATTENZIONE: " + e.getMessage());
        }
        return null;
    }

    @RequestMapping(value= "/addUser", method = RequestMethod.POST)
    public ResponseEntity<Users> addUser(@RequestBody String request){
        try {
            Users user = new Users();
            JsonObject jsonObject = null;

            jsonObject = new JsonParser().parse(request).getAsJsonObject();
            String cognome = jsonObject.get("cognome").getAsString();
            user.setCognome(cognome);
            String nome = jsonObject.get("nome").getAsString();
            user.setNome(nome);
            Users saved = userRepo.save(user);
            return ResponseEntity.ok().body(saved);

        }catch (Exception e){
            System.out.println("ATTENZIONE: " + e.getMessage());
        }
        return null;
    }

    @RequestMapping(value= "/getDataHome", method = RequestMethod.GET)
    public ResponseEntity<String> getDataHome(){
        try {

            String response = "{"+'\"'+"messaggio:123"+'\"';
            return ResponseEntity.ok().body(response);

        }catch (Exception e){
            System.out.println("ATTENZIONE: " + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Controller.class, args);
    }
}
