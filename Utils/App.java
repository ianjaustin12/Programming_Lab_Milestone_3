package Utils;
import java.util.Scanner;

import Objects.Encounter;
import Objects.Location;
import Objects.Map;
import Objects.User;

public class App {

    //static ScoreableItems caveItems;
    public static User currentUser;
    public static Scanner scan;
    public static Map map;
    

    public static void main(String[] args) {
        init();
        
        mainLoop();
        
        endGame();

        scan.close();

        System.exit(0);
    }
//initializes needed variables for the game
    public static void init(){
    //build the items
        //caveItems = new ScoreableItems();
    //build the locations
        map = new Map();
        System.out.println(" Welcome to Fairfield University ");
    //create a scanner
        scan = (new Scan()).getScanner();
    //create a user
        System.out.println("what's your user's name: ");
        String userName = scan.nextLine();
        System.out.println("what's your user's grade: ");
        String userGrade = scan.nextLine();
        currentUser = new User(userName, userGrade, map.getStartingLocation());
        System.out.println(" your user: " + currentUser.whatDoIDo());
    
    }

    public static boolean yesOrNo()
    {
        while(true)
        {
            String s = scan.nextLine();
            if(s.equals("n") || s.equals("no"))
            {
                return false;
            }
            if(s.equals("y") || s.equals("yes"))
            {
                return true;
            }
            System.out.println("I didn't understand that, your response should be y, yes, n, or no.");
        }

    }

//main loop of the game
    public static void mainLoop(){
        while (currentUser.getScore() <= 50 && currentUser.getLives() > 0) {

            Location currentLocation = currentUser.getLocation();
            if(currentLocation.getMonster() != null){
                System.out.println("\n" + currentLocation.getName() + " contains a " + currentLocation.getMonster().getName() + "!");
            }
            
        //enacts command
            processCommand();
        }
    }
//end game status 
    public static void endGame(){
        //player-win condition needs to be implemented
    }
//processes a command from user  
    public static void processCommand() {
        boolean isMove = false;
        while(!isMove){
    //gets next command
            System.out.println("So what do you wanna do? (Or type 'help' to get help)");
            String command = scan.nextLine();
            switch (command.toLowerCase()) {
    //instructions
                case "i":
                    Help.showInstructions();
                    isMove = false;
                    break;
    //user items
                case "bag":
                    currentUser.showItems();
                    isMove = false;
                    break;
    //look around
                case "look":
                    currentUser.getLocation().printItems();
                    isMove = false;
                    break;
                case "pick up":
                    currentUser.getItem();
                    isMove = false;
                    break;
    //enter encounter
                case "fight":
                    enterEncounter();
                    isMove = false;
                    break;
    //move in direction
                case "n": case "w": case "e": case "s":
                    currentUser.move(command, map);
                    isMove = true;
                    break;
    //get help
                case "help": 
                    Help.getHelp();
                    isMove = false;
                    break;
                // case "use":
                //     System.out.println("Which item?");
                //     String getItem  = App.scan.nextLine(); 
                //     Item item = currentUser.getItemByString(getItem);
                //     App.currentUser.useItem(item);
                //     break;
                case "admin":
                    admin();
                    break;
    //quit the game
                case "quit":
                    System.out.print("This game is over.");
                    isMove = true;
                    System.exit(1);
    //bad command
                default:
                    System.out.println("That command was bad please try again.");
                    command = scan.nextLine(); 
                    isMove = false;
                    break;  
            }
        }
        //shows move options
        showCurrentOptions();
    }
    public static void showCurrentOptions() {
        System.out.println("..................................Current Options.................................");
        System.out.println("From " + currentUser.getLocation().getName() + ", " + "the options are:");
        System.out.println("Move North: " + map.getNorthLocation(currentUser.getLocation()));
        System.out.println("Move South: " + map.getSouthLocation(currentUser.getLocation()));
        System.out.println("Move East: " + map.getEastLocation(currentUser.getLocation()));
        System.out.println("Move West: " + map.getWestLocation(currentUser.getLocation()));
        if(currentUser.getLocation().getName().equals("start")){
            currentUser.getLocation().printItems();
        }
        if(currentUser.getLocation().getMonster() != null){
            System.out.println("Fight " + currentUser.getLocation().getMonster().getName());
        }
        System.out.println("...................................End Current Options............................");
    }
//admin commands
private static void admin(){
    String input;
    System.out.println("...............................Welcome Admin......................................");
    while(true){
        System.out.println("What u wanna do? save/print/leave/go to/win/get item");
        input = scan.nextLine();
        if (input.equals("print")){
            System.out.println("What u wanna print? items/location/map");
            input = scan.nextLine();
            if (input.equals("location")){
                map.printMap();
            }
            if (input.equals("map")){
                map.printMap();
            }

        }
        if (input.equals("leave")){
            break;
        }
        if (input.startsWith("go to")){
            String locName = input.substring(5).trim();
            System.out.println("trying to move to " + locName);
            try{
                currentUser.move(map.findByName(locName));
            }catch(Exception e){}
        }
        if (input.equals("win")){
            currentUser.addScore(50);
        }
        if (input.equals("get item")){
            currentUser.getItem();
        }
    }
    System.out.println("...............................Goodbye Admin......................................");
}
    public static void enterEncounter(){
        if(currentUser.getLocation().getMonster() != null){
            new Encounter();
        }
        else{
            System.out.println("There is no monster to fight here.");
        }
    }
    
}