package com.example.demo.services;

import com.example.demo.models.Candy;
import org.springframework.stereotype.Service;

import java.util.List;

// tell spring to register our service as a Spring bean
@Service
public class CandyService
{
    private List<Candy> candies = List.of(
            new Candy("Reeses Cup", 3.99),
            new Candy("Skittles", 1.99),
            new Candy("Twix", 2.99),
            new Candy("KitKat", 3.99),
            new Candy("Gummy Bears", 2.49),
            new Candy("Laffy Taffy", 3.19),
            new Candy("Kinder Buenos", 5.99)
    );

    //return all candy
    public List<Candy> getAllCandy()
    {
        return candies;
    }

    //return all candy more than 2.50
    public List<Candy> getExpensiveCandy()
    {
        return candies
                .stream()
                .filter(candy -> candy.getCost() >= 2.50)
                .toList();
    }

    public List<Candy> getMoreExpensiveThan(double minCost)
    {
        return candies
                .stream()
                .filter(candy -> candy.getCost() >= minCost)
                .toList();
    }

    public Candy getFavorite()
    {
        return candies.get(0);
    }

}
