import java.util.Iterator;
import java.util.Set;

public class App {

    static ScoreableItems caveItems;
    static User currentUser;
    static Scan scan;
    static Map map;

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
        caveItems = new ScoreableItems();
    //build the locations
        map = new Map();
        System.out.println(" Welcome to Fairfield University ");
    //create a scanner
        scan = new Scan();
    //create a user
        System.out.println("what's your user's name: ");
        String userName = scan.nextLine();
        System.out.println("what's your user's grade: ");
        String userGrade = scan.nextLine();
        currentUser = new User(userName, userGrade, map.getStartingLocation());
        System.out.println(" your user: " + currentUser.whatDoIDo());
    
    }

//main loop of the game
    public static void mainLoop(){
        while (currentUser.getScore() <= 50 && currentUser.getLives() >= 0) {
    //start a fight 50% chance
            MonsterFactory.monsterInRoom(currentUser, scan);
    //shows move options
            showCurrentOptions();
    //enacts the command
            processCommand();
        }
    }
//end game status 
    public static void endGame(){
    //if point cap reached go to final boss
        if(currentUser.getScore() >= 50){
            System.out.println("..................................Onto The Boss Battle............................");
            if (MonsterFactory.finalBoss(currentUser, scan, map)){
                System.out.println("Congratulations you have won this game!");
                System.out.println("..................................Game Over.......................................");
            }
            else
                System.out.println("The Boss has defeated you. Better Luck Next time.");
        }
    //if out of lives game lost.
        if(currentUser.getLives() <= 0 ){
            System.out.println("You have lost all of your lives and been eliminated.");
            System.out.println("..................................Game Over.......................................");
        }
    }
//processes a command from user  
    public static void processCommand() {
        boolean isMove = false;
        while(!isMove){
    //gets next command
            System.out.println("So what do you wanna do? (Or type 'i' to get instructions)");
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
    //location items
                case "items":
                    itemsCommand(caveItems);
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
    //quit the game
                case "quit":
                    System.out.print("This game is over.");
                    isMove = true;
                    System.exit(1);
    //admin capabilities
                case "admin":
                    admin(scan);
                    isMove = false;
                    break;
    //bad command
                default:
                    System.out.print("That command was bad please try again.");
                    command = scan.nextLine(); 
                    isMove = false;
                    break;  
            }

        }
    }
    public static void showCurrentOptions() {
        System.out.println("..................................Current Options.................................");
        System.out.println("From " + currentUser.getLocation().getName() + ", " + "the options are:");
        System.out.println("North: " + map.getNorthLocation(currentUser.getLocation()));
        System.out.println("South: " + map.getSouthLocation(currentUser.getLocation()));
        System.out.println("East: " + map.getEastLocation(currentUser.getLocation()));
        System.out.println("West: " + map.getWestLocation(currentUser.getLocation()));
        System.out.println("...................................End Current Options............................");
    }
    
//to show and pick up items in a room
    public static void itemsCommand(ScoreableItems items){
        System.out.println("...............................Begin Item Pickup..................................");
        //displays the items in the room
        currentUser.getLocation().displayCurrentItems();
        Set<Item> i = currentUser.getLocation().getItems();
        if(i != null && !i.isEmpty() && i.size() != 0){
            //gets yes or no from user
            System.out.println("Do you want to pick up an item? y/n");
            if (scan.yesOrNo()){
            //gets item choice from user
                System.out.println("What item do you want to pick up?");
                String item = scan.nextLine();
                try{
                    Item itemGotten = currentUser.getLocation().findItemByName(item);
                    //monster appears with percentage increase by 10% every 5 points on item
                    //true if fight won or no monster, false if fight lost
                    if (MonsterFactory.monsterProtectingItem(currentUser, scan, itemGotten)){
                        currentUser.getItemPrint(itemGotten);
                        currentUser.getLocation().deleteItem(itemGotten);
                }}
                catch(Exception e){}  
            }
        }
        else {
            System.out.println("Okay... Move on.");
        }
        System.out.println("...............................End Item Pickup....................................");
    }
//admin commands
    private static void admin(Scan scan){
        String input;
        System.out.println("...............................Welcome Admin......................................");
        while(true){
            System.out.println("What u wanna do? create/delete/save/print/leave/");
            input = scan.nextLine();
            if (input.equals("create")){
                System.out.println("What u wanna create? items/location");
                input = scan.nextLine();
                if (input.equals("location")){
                    createLocation(scan);
                }
                if (input.equals("items")){
                    createItem(scan);
                }
            }
            if (input.equals("delete")){
                System.out.println("What u wanna delete? items/location");
                input = scan.nextLine();
                if (input.equals("location")){
                    deleteLocation(scan);
                }
                if (input.equals("items")){
                    deleteItem(scan);
                }
            }
            if (input.equals("save")){
                System.out.println("What u wanna save? items/location");
                input = scan.nextLine();
                if (input.equals("location")){
                    map.saveToFile();
                }
                if (input.equals("items")){
                    caveItems.saveToFile();
                }
            }
            if (input.equals("print")){
                System.out.println("What u wanna print? items/location/map");
                input = scan.nextLine();
                if (input.equals("location")){
                    map.printMap();
                }
                if (input.equals("items")){
                    caveItems.printItems();
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
        }
        System.out.println("...............................Goodbye Admin......................................");
    }
    private static void deleteItem(Scan scan){
        Iterator<Item> it = caveItems.getItems().iterator();
        Item thisItem;
        while (it.hasNext()) {
            thisItem = it.next();
            System.out.println(thisItem + "?");
            if(scan.yesOrNo())
                caveItems.removeItem(thisItem);
        }
    }
    private static void deleteLocation(Scan scan){
        map.removeLocation(map.selectLocation(scan));
    }
    private static void createItem(Scan scan){
        System.out.println("...............................Create Item......................................");
        System.out.println("item name:");
        String name = scan.nextLine();
        System.out.println("item points:");
        int points = scan.getScanner().nextInt();
        caveItems.addItem(new Item(name, (int)points));
        Item item = new Item(name, (int)points);
        caveItems.addItem(item);
        System.out.println("Is this for a monster?");
        if(scan.yesOrNo()){

        }
        System.out.println("Is this for a location?");
        if(scan.yesOrNo()){
            
        }
        map.selectLocation(scan).addItem(item);
        System.out.println("...............................Item Created......................................");
       
    }
    private static void createLocation(Scan scan){
        System.out.println("...............................Create Location...................................");
        System.out.println("location name:");
        String name = scan.nextLine();
        System.out.println("location x:");
        int xIndex = scan.getScanner().nextInt();
        System.out.println("location y:");
        int yIndex = scan.getScanner().nextInt();
        System.out.println("do you want a caption?");
        String cap = null;
        if(scan.yesOrNo())
            cap = scan.nextLine();
        map.addLocation(new Location(name,xIndex, yIndex, cap,null));
        System.out.println("...............................Location Created..................................");
    }
       
}


