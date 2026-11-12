/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.guildskilltracker;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author zakariawardak
 */
public class Guild implements Comparable <Guild>
{
    private String name = "";
    private List <Adventurer> adventurers= new ArrayList<>();
    
    public Guild (String name, List<Adventurer>adventurers)
    {
        this.name = name;
        this.adventurers = new ArrayList<>(adventurers);
    }

    public String getName() {
        return name;
    }

    public List<Adventurer> getAdventurers() {
        return adventurers;
    }
    @Override
    public int compareTo(Guild other)
    {
        double average1 = this.adventurers.stream()
                .mapToInt(Adventurer::getAge)
                .average()
                .orElse(0.0);
        double average2 = other.adventurers.stream()
                .mapToInt(Adventurer::getAge)
                .average()
                .orElse(0.0);
        return Double.compare(average1,average2);
    }
    @Override 
    public String toString ()
    {
        return "Name: "+name;
               
    }
    
}
