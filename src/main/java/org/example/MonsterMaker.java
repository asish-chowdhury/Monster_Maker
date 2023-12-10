package org.example;
import java.lang.reflect.Field;
import java.util.Random;
import java.util.Scanner;

class Monster{
    private String eyeColor;
    private String featherColor;
    private String magicalAbility;
    private int strenth;
    private int durability;
    private String weakness;
    private int aggressionLevel;

    public Monster(String eyeColor, String featherColor, String magicalAbility, int strenth, int durability, String weakness, int aggressionLevel) {
        this.eyeColor = eyeColor;
        this.featherColor = featherColor;
        this.magicalAbility = magicalAbility;
        this.strenth = strenth;
        this.durability = durability;
        this.weakness = weakness;
        this.aggressionLevel = aggressionLevel;
    }
    public void displayTraits(){
        System.out.println("Monster Traits:");
        System.out.println("Eye Color :"+eyeColor);
        System.out.println("Feather Color :"+ featherColor);
        System.out.println("Magical Ability :"+magicalAbility);
        System.out.println("Strength :"+strenth);
        System.out.println("Durability :"+durability);
        System.out.println("Weakness :"+weakness);
        System.out.println("Aggress Level :"+aggressionLevel);
    }
    public static Monster createBabyMonster(Monster parent1, Monster parent2){
        Field[] fields = Monster.class.getDeclaredFields();
        Random random = new Random();
        Monster babyMonster = new Monster(
                random.nextBoolean()?parent1.eyeColor : parent2.eyeColor,
                random.nextBoolean()?parent1.featherColor : parent2.featherColor,
                random.nextBoolean()?parent1.magicalAbility : parent2.magicalAbility,
                random.nextBoolean()?parent1.strenth : parent2.strenth,
                random.nextBoolean()?parent1.durability : parent2.durability,
                random.nextBoolean()?parent1.weakness : parent2.weakness,
                random.nextBoolean()?parent1.aggressionLevel : parent2.aggressionLevel
        );
        return babyMonster;
    }
}
public class MonsterMaker{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create Monster 1:");
        Monster monster1 = createMonster(scanner);

        System.out.println("Create Monster 2:");
        Monster monster2 = createMonster(scanner);

        System.out.println("\nMonster 1 Traits :");
        monster1.displayTraits();

        System.out.println("\nMonster 2 Traits :");
        monster2.displayTraits();

        Monster babyMonster = Monster.createBabyMonster(monster1,monster2);

        System.out.println("\nBaby Monster Traits :");
        babyMonster.displayTraits();
    }
    private static Monster createMonster(Scanner scanner){
        System.out.println("Eye Color :");
        String eyeColor = scanner.nextLine();

        System.out.println("Feather Color :");
        String featherColor = scanner.nextLine();

        System.out.println("Magical Ability :");
        String magicalAbility = scanner.nextLine();

        System.out.println("Weakness :");
        String weakness = scanner.nextLine();

        System.out.println("Strength :");
        int strength = scanner.nextInt();

        System.out.println("Durability :");
        int durablity = scanner.nextInt();


        System.out.println("Aggression Level :");
        int aggressionLevel = scanner.nextInt();
        scanner.nextLine();
        return new Monster(eyeColor,featherColor,magicalAbility,strength,durablity,weakness,aggressionLevel);
    }
}