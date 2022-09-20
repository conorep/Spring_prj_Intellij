package com.example.demo.controllers;

import com.example.demo.models.Candy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//rest api to serve data across http
//this makes our class a RESTful api controller
@RestController
public class APIController
{
    //normally don't want to add data
    //want to connect a web address with something on server
    //for practice, just adding data
    private List<Candy> candies = List.of(
            new Candy("Reeses Cup", 3.99),
            new Candy("Skittles", 1.99),
            new Candy("Twix", 2.99),
            new Candy("KitKat", 3.99),
            new Candy("Gummy Bears", 2.49),
            new Candy("Laffy Taffy", 3.19),
            new Candy("Kinder Buenos", 5.99)
    );

    //declaring endpoint. connect to this via server port 8081 to get candies (http://localhost:8081/candies)
    @GetMapping("candies")
    public List<Candy> getAllCandies()
    {
        return candies;
    }
}
