import java.util.Set;
public class Monster extends User{
    
    private int powerLevel;
    private String specialAbility;

    public Monster(){
        this("Monster", 3);
    }

    public Monster(String nam, int power){
        super(nam);
        powerLevel = power;
        super.setLives(powerLevel);
    }
//get set methods for fields
    public void setName(String n){super.setName(n);}
    public String getName(){return super.getName();}
    public void setPowerLevel(int n){powerLevel = n;}
    public int getpowerLevel(){return powerLevel;}
    public void setspecialAbility(String n){specialAbility = n;}
    public String getspecialAbility(){return specialAbility;}
    public Set<Item> getItems(String n){return super.getItems();}
    public void addMonsterItems(Item item){super.addItem(item);}
    public void removeMonsterItems(Item item){super.loseItem(item);}

//returns true if user wins, false if monster wins
    public boolean fight(User currentUser, Scan scan){
        System.out.println("Welcome to monster fight club!");
    //runs this for each "battle"
        while(true){
            System.out.println("Please input rock, paper, or scissors or i to see the rules again.");
    //get user input for battle
            String userChoice = scan.nextLine();
    //parse command if false then it was not for battle
            if (!parseCommand(userChoice, currentUser)){
                continue;
            }
    //display choice
            System.out.println();
            System.out.println("You have chosen to " + userChoice);
    //gets the monster's choice
            String monsterChoice = getMonsterChoice(userChoice);
            if (!parseCommand(monsterChoice, this)){
                continue;
            }
            System.out.println(getName() + " has chosen to " + monsterChoice);          
    //battle
            if (battle(userChoice, monsterChoice, currentUser)){
                loseLife();  
            }
            else{
                currentUser.loseLife();
            }
            System.out.println(currentUser.getName() + " has " + currentUser.getLives() + " lives, and " + getName() + " has " + getLives()+ " lives");
    //check if user or monster won yet
            if (currentUser.getLives() <= 0|| getLives() <= 0)
                break;
            System.out.println("No winner yet. Onto the next battle. Must win 5 Battles");
            System.out.println();
        }
        //if user lost
        if (currentUser.getLives() <= 0){
            return false;
        }
        //if monster won
        else if (getLives() <= 0){
            return true;
        }
        System.out.println("Something went wrong in the fight. Monster lives: " + getLives() + "User lives: " + currentUser.getLives() + "...my fault");
        return false;
    }
    
//this is 1 battle between monster and user 
//return true if user wins, false if monster wins
    public boolean battle(String userChoice, String monsterChoice, User currentUser){
            boolean userWin = false;
        if(!checkTie(userChoice, monsterChoice)){
            if (userChoice.equals("rock") && monsterChoice.equals("paper"))
                userWin = false;
            else if (userChoice.equals("rock") && monsterChoice.equals("scissors"))
                userWin = true;
            else if (userChoice.equals("paper") && monsterChoice.equals("scissors"))
                userWin = false;
            else if (userChoice.equals("paper") && monsterChoice.equals("rock"))
                userWin = true;
            else if (userChoice.equals("scissors") && monsterChoice.equals("paper"))
                userWin = true;
            else  if (userChoice.equals("scissors") && monsterChoice.equals("rock"))
                userWin = false;

            if (userWin){
                System.out.println();
                System.out.println(currentUser.getName() + " has won this battle.");
                return true;
            }
            else{
                System.out.println();
                System.out.println(getName() + " has won this battle.");
                return false;
            }
        }
        addLife();
        return true;
    }

//parse command
    public boolean parseCommand(String command, User who){
    //rock, paper, scissors
        if ((command.equals("rock")||command.equals("paper")||command.equals("scissors"))){
            return true;
        }
    //i
        else if (command.equals("i")){
            Help.fightCommands();
            return false;
        }
    //i
        else if (command.equals("help")){
            Help.fightRules();
            return false;
        }
    //use <item>
        else if(command.startsWith("use")){
            command = command.substring(3);
            who.useItem(command);
            return false;
        }
        else if (command.startsWith("special ability")){
            who.specialAbility();
            return false;
        }

    //bad command
        System.out.println("The input " + command + " is invalid.");
        System.out.println("Expected value of \"rock\", \"paper\", or \"scissors\" or \"i\". Please input one of those values");
        return false;
    }

//checks if there is a tie between the user and monster
    public boolean checkTie(String userChoice, String monsterChoice){

        if(userChoice.equals(monsterChoice)){
            System.out.println();
            System.out.println("User and "+ getName() +" choices were equal.");
            System.out.println("We have a tie. No Winner!");
            System.out.println("To the next battle!");
            System.out.println();
            return true;
        } 
        return false;
    }
//gets a random pick of rock/paper/scissors for Monster 
    public String throwRandom(){
        int i = (int)Math.ceil(Math.random() * 3);
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

/* ---------------------------------methods  to override ---------------------------------------- */
//to get a monsters choice
//can change this depending on power level by subclass to use special ability and items
    public String getMonsterChoice(String userChoice){
        return throwRandom();
    }
//if a special ability is used then do this
//change by subclass     
    public void specialAbility(){

    }
//if an item is used then do this
//change by subclass     
    public void useItem(){

    }
//if user denies a fight with this monster
    public void fightDenied(Scan scan){
        
    }
//to steal items from user
    public void steal(){

    }
}
