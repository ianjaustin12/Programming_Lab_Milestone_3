import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    CampusLoc STARTING_POSITION = CampusLoc.Stag;

    private String grade;
    private String name;
    private Location location;
    private List<Item> items;
    private int score;

    public User() {
        this("bob","Sophomore");
    }

    public User(String name, String grade) {
        this.grade = grade;
        this.name = name;
        items = new ArrayList<>();
        location = new Location(STARTING_POSITION);
        score = 0;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }
    public void addScore(int s) {
        score = score + s;
    }
    public void loseScore(int s) {
        score = score + s;
    }

    public String whatDoIDo() {

        return "My name is " + this.name + " and I am a " + this.grade;
    }

    public Location getLocation() {
        return location;
    }

    public void showCurrentOptions() {
        System.out.println("From " + location.getCurrentPosition() + ", " + "the options are:");
        System.out.println("North: " + location.getOptionNorth());
        System.out.println("South: " + location.getOptionSouth());
        System.out.println("East: " + location.getOptionEast());
        System.out.println("West: " + location.getOptionWest());
    }

    public void processCommand(String command, ScoreableItems items, Scanner scan) {
        boolean isGoodCommand = false;
        while(!isGoodCommand){
            switch (command.toLowerCase()) {
                case "i":
                    this.showInstructions();
                    isGoodCommand = true;
                    break;
                case "bag":
                    this.showItems();
                    isGoodCommand = true;
                    break;
                case "items":
                    items.displayCurrentItems(location.getCurrentPosition());
                    isGoodCommand = true;
                    break;
                case "n": case "w": case "e": case "s":
                    this.move(command);
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

    private void showInstructions() {
        String instructions = "Instructions:\n";
        instructions += "- Type a direction to move (N/E/S/W)\n";
        instructions += "- Type 'items' to see the items available at your current location\n";
        instructions += "- Type <item's name> to get an item\n";
        instructions += "- Type 'bag' to see all your items\n";
        System.out.println(instructions);
    }

    private void move(String command) {
        Direction dir = null;
        switch (command.toLowerCase()) {
            case "n":
                dir = Direction.NORTH;
                location.handleMove(getCurrentPosition(), dir);
                break;
            case "e":
                dir = Direction.EAST;
                location.handleMove(getCurrentPosition(), dir);
                break;
            case "s":
                dir = Direction.SOUTH;
                location.handleMove(getCurrentPosition(), dir);
                break;
            case "w":
                dir = Direction.WEST;
                location.handleMove(getCurrentPosition(), dir);
                break;
        }

    }

    private void getItem(String itemName, ScoreableItems items) {
        Item itemGotten = items.getItem(itemName, location.getCurrentPosition());
        if (!(itemGotten == null)) {
            this.items.add(itemGotten);
            this.score += itemGotten.getScore();
        }
    }

    public CampusLoc getCurrentPosition() {
        return location.getCurrentPosition();
    }

    public void setCurrentPosition(CampusLoc area) {
        location.setCurrentPosition(area);
    }

    public CampusLoc getOptionNorth() {
        return location.getOptionNorth();
    }

    public void setOptionNorth(CampusLoc area) {
        location.setOptionNorth(area);
    }

    public CampusLoc getOptionSouth() {
        return location.getOptionSouth();
    }

    public void setOptionSouth(CampusLoc area) {
        location.setOptionSouth(area);
    }

    public CampusLoc getOptionEast() {
        return location.getOptionEast();
    }

    public void setOptionEast(CampusLoc area) {
        location.setOptionEast(area);
    }

    public CampusLoc getOptionWest() {
        return location.getOptionWest();
    }

    public void setOptionWest(CampusLoc area) {
        location.setOptionWest(area);
    }

    // to show all items that user has
    private void showItems() {
        System.out.println("Items: ");
        for (Item item : this.items) {
            System.out.println("- " + item.getName());
        }
        System.out.println();
    }



}



