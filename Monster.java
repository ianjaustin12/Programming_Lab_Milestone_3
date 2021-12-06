import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class Monster {
    
    private String name;
    private int powerLevel;
    private String specialAbility;
    private List<Item> monsterItems;

    public Monster(){
        this("Monster", 3);
    }

    public Monster(String nam, int power){
        name = nam;
        powerLevel = power;
        monsterItems = new ArrayList<>();
    }
//get set methods for fields
    public void setName(String n){name = n;}
    public String getName(){return name;}
    public void setPowerLevel(int n){powerLevel = n;}
    public int getpowerLevel(){return powerLevel;}
    public void setspecialAbility(String n){specialAbility = n;}
    public String getspecialAbility(){return specialAbility;}
    public List<Item> getMonsterItems(String n){return monsterItems;}
    public void addMonsterItems(Item i){
        if(!monsterItems.contains(i))
            monsterItems.add(i);
    }
    public void removeMonsterItems(Item i){
        if(monsterItems.contains(i))
            monsterItems.remove(i);
    }

//returns true if user wins, false if monster wins
    public boolean fight(User currentUser, Scanner scan){
        System.out.println("Welcome back to monster fight club!");
    //initalize variables 
        int monsterLives = powerLevel;
    //asks to know the rules
    while(true){
        System.out.println("Would you like a remind on the rules of monster fight club? y/n");
            String howToPlay = scan.nextLine();
            if (howToPlay.equalsIgnoreCase("y")){
                fightRules();
                break;
            }
            else if (howToPlay.equalsIgnoreCase("n")){
                System.out.println("Good luck.");
                break;
            }
            else{
                System.out.println("Please input either y or n");
            }
    }
    //runs this for each "battle"
        while(true){
            System.out.println("Please input rock, paper, or scissors or i to see the rules again.");
    //get user input for battle
            String userChoice;
            userChoice = scan.nextLine();
    //checks user input for validity
            if (!(userChoice.equals("rock")||userChoice.equals("paper")||userChoice.equals("paper"))){
                System.out.println("The input " + userChoice + " is invalid.");
                System.out.println("Expected value of \"rock\", \"paper\", or \"scissors\" or \"i\". Please input one of those values");
                continue;
            }
    //checks for rules
            if (userChoice.equals("i")){
                fightRules();
                continue;
            }
    //display choice
            System.out.println();
            System.out.println("You have chosen to throw " + userChoice);
    //gets the monster's choice
            String monsterChoice = getMonsterChoice(userChoice);
            System.out.println(name + " has chosen to throw " + monsterChoice);
    //if monster used special ability
            if (monsterChoice.equals(specialAbility)){
                specialAbility();
                continue;
            }
    //if monster used item
            if(monsterChoice.substring(0,4).equals("item")){
                useItem();
                continue;
            }
    //check tie
            if(userChoice.equals(monsterChoice)){
                System.out.println();
                System.out.println(currentUser.getName() + " and "+ name +" choices were equal.");
                System.out.println("We have a tie. No Winner!");
                System.out.println("To the next battle!");
                System.out.println();
                continue;
            }   
    //battle
            if (battle(userChoice, monsterChoice)){
                System.out.println();
                System.out.println(currentUser.getName() + " has won this battle.");
                monsterLives--;  
            }
            else{
                System.out.println();
                System.out.println(name + " has won this battle.");
                currentUser.loseLife();
            }
            System.out.println(currentUser.getName() + " has " + currentUser.getLives() + " lives, and " + name + " has " + monsterLives+ " lives");
    //check if user or monster won yet
            if (currentUser.getLives() <= 0|| monsterLives <= 0)
                break;
            System.out.println("No winner yet. Onto the next battle. Must win 5 Battles");
            System.out.println();
        }
        if (currentUser.getLives() <= 0){
            return true;
        }
        else if (monsterLives <= 0){
            return false;
        }
        System.out.println("Something went wrong in the fight. Monster lives: " + monsterLives + "User lives: " + currentUser.getLives() + "...my fault");
        return false;
    }
//this is 1 battle between monster and user 
//return true if user wins, false if monster wins
    public boolean battle(String userChoice, String monsterChoice){
        userChoice = userChoice.trim().toLowerCase();
        monsterChoice = monsterChoice.trim().toLowerCase();
            if (userChoice.equals("rock") && monsterChoice.equals("paper"))
                return false;
            if (userChoice.equals("rock") && monsterChoice.equals("scissors"))
                return true;
            if (userChoice.equals("paper") && monsterChoice.equals("scissors"))
                return false;
            if (userChoice.equals("paper") && monsterChoice.equals("rock"))
                return true;
            if (userChoice.equals("scissors") && monsterChoice.equals("paper"))
                return true;
            if (userChoice.equals("scissors") && monsterChoice.equals("rock"))
                return false;
    //this would break the code
        System.out.println("The battle code went wrong... my fault");
        return false;
    }
//to get a monsters choice
//can change this depending on power level by subclass to use special ability and items
    public String getMonsterChoice(String userChoice){
        return fightNumberToThrow((int)Math.ceil(Math.random() * 3));
    }
//if a special ability is used then do this
//change by subclass     
    public void specialAbility(){

    }
//if an item is used then do this
//change by subclass     
    public void useItem(){

    }
//converts a choice by monster to the string 
    public String fightNumberToThrow(int i){
        switch (i){
            case 1:
                return "rock";
            case 2:
                return "paper";
            case 3:
                return "scissors";
        }
        return "Bad Case. Not 1,2 or 3.";
    }
//prints the fight rules
    public void fightRules(){
        System.out.println("************************************* Rules of monster fight club ************************************");
        System.out.println("We do not talk about monster fight club.");
        System.out.println("You and the monster pick rock paper or scissors .");
        System.out.println("Rock beats scissors, paper beat rock, and scissors beats paper");
        System.out.println("If you lose your battle. You lose a life.");
        System.out.println("If you win your battle. The monster loses a life. Their life count equals their power level.");
        System.out.println("Once you enter a battle you may not leave.");
        System.out.println("Let the games begin");
        System.out.println("******************************************************************************************************");
    }
}
