package com.pf7.smdb.controller;

import com.pf7.smdb.base.AbstractLogComponent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello Main <br><br> " +
                "Choose one of the following : <br><br>" +
                "1.GetDirectorById... <br><br>" +
                "2.GetMovieById... <br><br>" +
                "3.GetActorById... <br><br>" +
                "4.GetFilmById... <br><br>";

    }


}
