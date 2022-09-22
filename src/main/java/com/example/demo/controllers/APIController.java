package com.example.demo.controllers;

import com.example.demo.models.Candy;
import com.example.demo.services.CandyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//rest api to serve data across http
//this makes our class a RESTful api controller
// tell spring to register our rest controller as a Spring bean

/**
 * APIController class.
 * @author Conor O
 * @version 1
 */
@RestController
public class APIController
{
    // the service is injected by the ApplicationContext spring container
    // DI: dependency injection
    // this class is dependent on service
    private CandyService service;

    /**
     * Constructor for service
     * @param service CandyService class
     */
    public APIController(CandyService service)
    {
        this.service = service;
    }

    // declaring endpoint.
    // connect to this via server port 8081 to get candies (http://localhost:8081/candies)
    /**
     * Path to return all candies.
     * @return list of candies
     */
    @GetMapping("candies")
    public List<Candy> getAllCandies()
    {
        return service.getAllCandy();
    }

    // localhost:8081/candies/expensive
    /**
     * Path for getting all candies with cost >= 2.50
     * @return list of candies
     */
    @GetMapping("candies/expensive")
    public List<Candy> getExpensiveCandy()
    {
        return service.getExpensiveCandy();
    }

    /**
     * Get favorite candy path.
     * @return favorite candy
     */
    @GetMapping("candies/favorite")
    public Candy getFavoriteCandy()
    {
        return service.getFavorite();
    }

    // localhost:8081/morethan/{price}
    /**
     * Path to get all candies >= price.
     * @param price double price of candy
     * @return json of all candies with price >= parameter
     */
    @GetMapping("candies/morethan/{price}")
    public List<Candy> getMoreThan(@PathVariable double price)
    {
        return service.getMoreExpensiveThan(price);
    }

    @Override
    public String toString()
    {
        return "APIController{" +
                "service=" + service +
                '}';
    }
}
