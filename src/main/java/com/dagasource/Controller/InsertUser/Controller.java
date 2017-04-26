package com.dagasource.Controller.InsertUser;

import com.dagasource.Controller.InsertUser.Entity.*;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by fabio on 25/01/17.
 */

@RestController
@CrossOrigin
@SpringBootApplication
public class Controller {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepo userRepo;

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
            String citta = jsonObject.get("citta").getAsString();
            user.setCitta(citta);
            String email = jsonObject.get("email").getAsString();
            user.setEmail(email);
            Users saved = userRepo.save(user);
            log.info("User saved");
            return ResponseEntity.ok().body(saved);

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ATTENZIONE: " + e.getMessage());
            log.info(e.getMessage());
            return new ResponseEntity<Users>(HttpStatus.BAD_REQUEST);
        }

    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Controller.class, args);
    }
}
