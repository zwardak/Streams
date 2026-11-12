/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.guildskilltracker;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.Map;

/**
 *
 * @author zakariawardak
 */
public class GuildProcessor 
{
  public static List <Adventurer> filterBySkill(List<Guild> guilds,Skill skill)
  {
      return guilds.stream()
              .flatMap(guild -> guild.getAdventurers().stream())
              .filter(adventurer->adventurer.getSkills().contains (skill))
              .collect(Collectors.toList());
  }
  
 public static void groupByRole(List<Guild> guilds)
{
    Map<String, List<Adventurer>> groups = guilds.stream()
            .flatMap(guild -> guild.getAdventurers().stream())
            .collect(Collectors.groupingBy(Adventurer::getRole));

    groups.forEach((role, adventurers) -> {
        System.out.println("Role: " + role);

        adventurers.forEach(System.out::println);
    });
}
 
public static Adventurer findMostSkilled(List<Guild> guilds)
{
    return guilds.stream()
            .flatMap(guild -> guild.getAdventurers().stream())
            .max(Comparator.comparingInt(
                    adventurer -> adventurer.getSkills().size()))
            .orElse(null);
}

public static List <Guild> rankByAveAge(List<Guild> guilds)
{
    return guilds.stream()
            .sorted()
            .collect(Collectors.toList());
}


public static void countAdventurersBySkill(List<Guild> guilds)
{
    Map<String, Long> skillCounts = guilds.stream()
            .flatMap(guild -> guild.getAdventurers().stream())
            .flatMap(adventurer -> adventurer.getSkills().stream().distinct())
            .collect(Collectors.groupingBy(
                    skill -> skill.name(),
                    Collectors.counting()
            ));

    skillCounts.forEach((skill, count) ->
            System.out.println(skill + ": " + count));
}

public static void bonusGoldEvent(List<Guild> guilds)
{
    // Give a 20% bonus to eligible adventurers
    guilds.stream()
            .flatMap(guild -> guild.getAdventurers().stream())
            .filter(adventurer -> adventurer.getGoldEarned() < 1000)
            .forEach(adventurer ->
                    adventurer.setGoldEarned(
                            adventurer.getGoldEarned() * 1.20));

    
    guilds.stream()
            .flatMap(guild -> guild.getAdventurers().stream())
            .forEach(System.out::println);
}



  
}
