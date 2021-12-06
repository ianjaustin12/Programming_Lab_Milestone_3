
import java.util.Scanner;

public class App {

    static ScoreableItems caveItems;
    static User currentUser;
    static Scanner scan;

    public static void main(String[] args) {
        initialize();
        
        mainLoop();
        
        endGame();

        scan.close();

        System.exit(0);
    }
//initializes needed variables for the game
    public static void initialize(){
        System.out.println(" Welcome to Fairfield University ");
        scan = new Scanner(System.in);
        
        System.out.println("what's your user's name: ");
        String userName = scan.nextLine();

        System.out.println("what's your user's grade: ");
        String userGrade = scan.nextLine();

        currentUser = new User(userName, userGrade);
        System.out.println(" your user: " + currentUser.whatDoIDo());
        caveItems = new ScoreableItems();
        
    }
//main loop
    public static void mainLoop(){
        String command;
        while (currentUser.getScore() > 50 && currentUser.getLives() < 0) {
    //start a fight 50% chance
            MonsterFactory.monsterInRoom(currentUser, scan);
    //shows move options
            showCurrentOptions();
            System.out.println("");
            System.out.println("So what do you wanna do? (Or type 'i' to get instructions)");
            command = scan.nextLine();
    //enacts the command
            processCommand(command);
        }
    }
//end game status 
    public static void endGame(){
        if(currentUser.getScore() > 50){
            System.out.println("Congratulations you have won this game!");
        }
        if(currentUser.getLives() < 0 ){
            System.out.println("You have lost all of your lives and been eliminated.");
        }
    }
//processes a command from user  
    public static void processCommand(String command) {
        boolean isGoodCommand = false;
        while(!isGoodCommand){
            switch (command.toLowerCase()) {
                case "i":
                    showInstructions();
                    isGoodCommand = true;
                    break;
                case "bag":
                    currentUser.showItems();
                    isGoodCommand = true;
                    break;
                case "items":
                    itemsCommand(caveItems, scan);
                    isGoodCommand = true;
                    break;
                case "n": case "w": case "e": case "s":
                    currentUser.move(command);
                    isGoodCommand = true;
                    break;
                case "help": 
                    System.out.println("-------");
                    System.out.println(Help.getDirections());
                    System.out.println(Help.getPossibleDirections());
                    System.out.println("-------");
                    isGoodCommand = true;
                    break;
                case "quit":
                    System.out.print("This game is over.");
                    isGoodCommand = true;
                    System.exit(0);
                default:
                    System.out.print("That command was bad please try again.");
                    command = scan.nextLine(); 
                    isGoodCommand = false;
                    break;  
            }

        }
    }
    public static void showCurrentOptions() {
        System.out.println("From " + currentUser.getLocation().getCurrentPosition() + ", " + "the options are:");
        System.out.println("North: " + currentUser.getLocation().getOptionNorth());
        System.out.println("South: " + currentUser.getLocation().getOptionSouth());
        System.out.println("East: " + currentUser.getLocation().getOptionEast());
        System.out.println("West: " + currentUser.getLocation().getOptionWest());
    }
    private static void showInstructions() {
        String instructions = "Instructions:\n";
        instructions += "- Type a direction to move (N/E/S/W)\n";
        instructions += "- Type 'items' to see the items available at your current location\n";
        instructions += "- Type <item's name> to get an item\n";
        instructions += "- Type 'bag' to see all your items\n";
        System.out.println(instructions);
    }
    //to parse through items command - for items in a room
    public static void itemsCommand(ScoreableItems items, Scanner scan){
        items.displayCurrentItems(currentUser.getLocation());
        System.out.println("Do you want to pick up an item? y/n");
        String itemPU = scan.nextLine().trim();
        if (itemPU.equalsIgnoreCase("y")){
            System.out.println("What item do you want to pick up?");
            itemPU = scan.nextLine().trim();
            Item itemGotten = items.getItem(itemPU, currentUser.getLocation());
            //monster appears with percentage increase by 10% ever 5 points on item
            //true if fight won or no monster, false if fight lost
            if (MonsterFactory.monsterProtectingItem(currentUser, scan, itemGotten)){
                currentUser.getItem(itemGotten);
            }  
        }
    }
    
}


