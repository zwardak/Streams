/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.guildskilltracker;

import java.util.Arrays;
import java.util.List;
/**
 *
 * @author zakariawardak
 */
public class GuildSkillTracker {

    public static void main(String[] args) {
        Adventurer arin = new Adventurer("Arin", 24, "Warrior", 800.0,
                Arrays.asList(Skill.SWORDSMANSHIP, Skill.HORSEMANSHIP));

        Adventurer lyra = new Adventurer("Lyra", 30, "Wizard", 1500.0,
                Arrays.asList(Skill.HEALING, Skill.NECROMANCY,
                        Skill.RUNECRAFTING, Skill.MEMECRAFTING));

        Adventurer finn = new Adventurer("Finn", 20, "Rogue", 500.0,
                Arrays.asList(Skill.ARCHERY, Skill.THIEVERY, Skill.STEALTH));

        Adventurer mira = new Adventurer("Mira", 28, "Warrior", 1000.0,
                Arrays.asList(Skill.SWORDSMANSHIP, Skill.BLACKSMITHING));

        Guild silverGuild = new Guild("Silver Guild", Arrays.asList(arin, lyra));
        Guild goldenGuild = new Guild("Golden Guild", Arrays.asList(finn, mira));
        List<Guild> guilds = Arrays.asList(silverGuild, goldenGuild);

        System.out.println("1. Adventurers with SWORDSMANSHIP:");
        GuildProcessor.filterBySkill(guilds, Skill.SWORDSMANSHIP)
                .forEach(System.out::println);

        System.out.println("\n2. Adventurers grouped by role:");
        GuildProcessor.groupByRole(guilds);

        System.out.println("\n3. Adventurer with the most skills:");
        System.out.println(GuildProcessor.findMostSkilled(guilds));

        System.out.println("\n4. Guilds ranked by average age (ascending):");
        GuildProcessor.rankByAveAge(guilds).forEach(guild -> {
            double averageAge = guild.getAdventurers().stream()
                    .mapToInt(Adventurer::getAge)
                    .average()
                    .orElse(0.0);
            System.out.printf("%s - Average age: %.2f%n",
                    guild.getName(), averageAge);
        });

        System.out.println("\n5. Adventurer count for each skill:");
        GuildProcessor.countAdventurersBySkill(guilds);

        System.out.println("\n6. Adventurers after the 20% bonus gold event:");
        GuildProcessor.bonusGoldEvent(guilds);
    }
}
