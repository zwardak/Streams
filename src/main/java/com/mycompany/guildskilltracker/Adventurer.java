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
public class Adventurer implements Comparable<Adventurer> 
{
    private String name = "";
    private int age = 0;
    private String role = "";
    private double goldEarned =0.0;
    private List <Skill>skills= new ArrayList<>();
    
public Adventurer(String name, int age, String role, double goldEarned, 
                    List<Skill>skills)
{
    this.name= name;
    this.age= age;
    this.role= role;
    this.goldEarned= goldEarned;
    this.skills= new ArrayList<>(skills);
}

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRole() {
        return role;
    }

    public double getGoldEarned() {
        return goldEarned;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setGoldEarned(double goldEarned) {
        this.goldEarned = goldEarned;
    }
    

    @Override
    public String toString() {
        return "Adventurer Name: " +name+
                " Age: "+age+
                " Role: "+role
                +" Earned Gold: "+goldEarned
                +" Skill: "+skills;
    }
    
   

    @Override 
    public int compareTo (Adventurer other)
    {
        return Integer.compare(this.skills.size(),other.skills.size()); 
    }

    
}
