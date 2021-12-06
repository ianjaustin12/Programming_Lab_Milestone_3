import java.util.Scanner;

public class Monster {
    
    private String name;
    private int powerLevel;
    private String specialAbility;

    public Monster(){
        this("Monster",1);
    }

    public Monster(String nam, int power){
        name = nam;
        powerLevel = power;
    }

    public void setName(String n){name = n;}
    public String getName(){return name;}
    public void setPowerLevel(int n){powerLevel = n;}
    public int getpowerLevel(){return powerLevel;}
    public void setspecialAbility(String n){specialAbility = n;}
    public String getspecialAbility(){return specialAbility;}

//returns true if user wins, false if monster wins
    public boolean fight(User currentUser, Scanner scan){
        int worth = powerLevel*10;
        System.out.println("A wild Monster has appeared");
        System.out.println("This fight is worth " + worth + " points");
        System.out.println("Would you like to fight? Answer with y/n");
        String fight = scan.nextLine();
        if (fight.equalsIgnoreCase("n")){
            return false;
        }
    //initalize variables 
        int userWins = 0;
        int monsterWins = 0;
    //runs this for each "battle"
        while(true){
            System.out.println("Please input a number 1 2 or 3");
    //get user input for battle
            int userChoice;
            try{
            userChoice = scan.nextInt();
            }
            catch(Exception ex){
                System.out.println("Integer expected of value 1, 2, or 3. Please input one of those values");
                continue;
            }
            String userChoiceToString;
    //checks and converts user choice to string then prints else restarts battle
            if (userChoice == 1||userChoice == 2||userChoice == 3){
                userChoiceToString = fightNumberToThrow(userChoice);
            }
            else{
                System.out.println("The input " + userChoice + " is invalid.");
                continue;
            }
            System.out.println();
            System.out.println("You have chosen to throw " + userChoiceToString);
    //gets the monster's choice
            int monsterChoice = getMonsterChoice(userChoice);
            String monsterChoiceToString = fightNumberToThrow(monsterChoice);
            System.out.println(name + "has chosen to throw " + monsterChoiceToString);
    //check tie
            if(userChoice == monsterChoice){
                System.out.println("User and "+ name +" choice were equal.");
                System.out.println("We have a tie. No Winner.");
                System.out.println("To the next battle!");
                System.out.println();
                continue;
            }   
    //battle
            if (battle(userChoice, monsterChoice)){
                System.out.println("The User has won this battle.");
                userWins++;
                System.out.println("User has won " + userWins + " battles");
            }
            else{
                System.out.println(name + " has won this battle.");
                monsterWins++;
                System.out.println(name + " has won " + monsterWins + " battles");
            }
    //check if user or monster won
            if (userWins >= 5 || monsterWins >= 5)
                break;
            System.out.println("No winner yet. Onto the next battle;");
        }
        if (userWins >= 5){
            System.out.println("You have won this fight and gotten " + worth + " points.");
            currentUser.addScore(worth);
            return true;
        }
        else if (monsterWins >= 5){
            System.out.println(name + " has won this fight and you have lost " + worth + " points.");
            currentUser.loseScore(worth);
            return false;
        }
        System.out.println("Something went wrong in the fight. Monster wins: " + monsterWins + "User Wins: " + userWins + "...my fault");
        return false;
    }
//this is 1 battle between monster and user 
//return true if user wins, false if monster wins
//*******can change the way they battle in subclasses using special ability
    public boolean battle(int userChoice, int monsterChoice){
        if (userChoice == 1 && monsterChoice == 2)
            return false;
        if (userChoice == 1 && monsterChoice == 3)
            return true;
        if (userChoice == 2 && monsterChoice == 1)
            return true;
        if (userChoice == 2 && monsterChoice == 3)
            return false;
        if (userChoice == 3 && monsterChoice == 1)
            return false;
        if (userChoice == 3 && monsterChoice == 2)
            return true;
    //this would break the code
        System.out.println("The battle code went wrong... my fault");
        return false;
    }
//to get a monsters choice
//********can change this depending on power level by subclass
    public int getMonsterChoice(int userChoice){
        return (int)Math.ceil(Math.random() * 3);
    }
//converts a choice by monster/user to the string 
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
        System.out.println("Welcome back to monster fight club!");
        System.out.println("Here's the rules of fight club.");
        System.out.println("You pick a number 1, 2 and 3.");
        System.out.println("The numbers mean 1=Rock, 2=Paper, 3=Scissors");
        System.out.println("Rock beats scissors, paper beat rock, and scissors beats paper");
        System.out.println("It is best of 9. Therefore you will play 9 games or until one of you win atleast 5 games.");
        System.out.println("Let the games begin");
    }
}
