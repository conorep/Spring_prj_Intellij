package com.example.demo.models;

public class Candy
{
    private String type;
    private double cost;

    public String getType()
    {
        return type;
    }

    public double getCost()
    {
        return cost;
    }

    public Candy(String type, double cost)
    {
        this.type = type;
        this.cost = cost;
    }

    @Override
    public String toString()
    {
        return "Candy{" +
                "type='" + type + '\'' +
                ", cost=" + cost +
                '}';
    }
}
