package Objects;
import Monsters.FinalBoss;
import Monsters.Monster;
import Utils.App;
import Utils.Help;
import Utils.MonsterFactory;

public class Encounter {

    private User player;
    private int playerStrength;
    private Location location;
    private Monster monster;
    private boolean userWon;
    public boolean getUserWon(){return userWon;}
    public Encounter() {

        player = App.currentUser;
        playerStrength = player.getStrength();
        location = player.getLocation();
        if (location.getMonster() == null)
            monster = MonsterFactory.getRandomMonster(this);
        else
            monster = location.getMonster();

        displayInitialEncounterText();
        while (bothParticipantsAreAlive()) {
            runEncounterRound();
        }
        runFinalEncounterEvents();

    }

    private void displayInitialEncounterText() {
        System.out.println("..................................Encounter.................................");
        System.out.println("You have challenged the " + monster.getName() + "!");

        System.out.println("Would you like to see the Rules of Monster Fight Club? 'yes' or 'no' ");
        String ans = "";
        
        while(!ans.equals("yes") && !ans.equals("no")){
            ans = App.scan.nextLine();
            if(ans.equals("yes")){
                Help.fightRules();
                break;
            }
            else if(ans.equals("no")){
                break;
            }
            System.out.println("Sorry, I don't understand. Please enter 'yes' or 'no' ");
        }

    }

    private boolean bothParticipantsAreAlive() {
        return monster.getHealth() > 0 && player.getLives() > 0;
    }

    private void runEncounterRound(){
        //>:^) 
        System.out.println("You have " + player.getLives() + " health and " + playerStrength + " strength");
        System.out.println(monster.getName() + " has " + monster.getHealth() + " health and " + monster.getStrength() + " strength");

        Help.fightCommands();

        String command = "";
        boolean commandIsValid = false;
        while(!commandIsValid){
            command = App.scan.nextLine();
            switch (command){
                case "rock" : case "paper" : case "scissors" :
                    runRPSEvent(command);
                    commandIsValid = true;
                    break;
                case "help" :
                    Help.getHelp();
                    commandIsValid = true;
                    break;
                case "use":
                    System.out.println("Which item?");
                    String getItem  = App.scan.nextLine(); 
                    Item item = player.getItemByString(getItem);
                    App.currentUser.useItem(item);
                    commandIsValid = true;
                    break;
                case "admin kill":
                    monster.setHealth(0);
                    commandIsValid = true;
                    break;
                default : 
                    System.out.println("Sorry, I don't understand. Please enter a recognizable command.");
            }
        }  
    }

    private void runRPSEvent(String command){
        RPS playerChoice = RPS.parseRPS(command);
        RPS monsterChoice = RPS.getRandomChoice(playerChoice);

        System.out.println("..................................Rock, Paper, Scissors.................................");
        System.out.println("You played " + playerChoice);
        System.out.println(monster.getName() + " played " + monsterChoice);
        if(RPS.playerIsWinner(playerChoice, monsterChoice)){
            System.out.println("You win this round!");
            monster.takeDamage(player.getStrength());
        }
        else{
            System.out.println("You lose this round!");
            if(player.hasItemByType("shield")){
                Item shield = player.getItemByType("shield");
                System.out.println("Do you wish to block with " + shield.getName());
                while(true){
                    String input =  App.scan.nextLine().trim();
                    if(input.equalsIgnoreCase("yes")){
                        System.out.println("No damage taken. phew.");
                        player.loseItem(shield);
                        break;
                    }
                    else if(input.equalsIgnoreCase("no")){
                        monster.attack();
                        break;
                    }
                    else{
                        System.out.println("Must input a yes or no");
                    }
                }
            }
            else{
                monster.attack();
            }
            
        }
        System.out.println(".................................. End Rock, Paper, Scissors.................................");

    } 

    private void runFinalEncounterEvents() {

        userWon = player.getLives() > 0;

        if (userWon) {
            monster.onDeath();
            System.out.println("Congratulations! You have defeated the " + monster.getName() + "!\n");
            location.setMonster(null);
        } else {
            System.out.println("You have been defeated by the " + monster.getName() + "!");
        }

        System.out.println("..................................End Encounter.................................");

        if (!userWon) {
            if(monster instanceof FinalBoss)
                System.exit(0);
        }

    }

}
