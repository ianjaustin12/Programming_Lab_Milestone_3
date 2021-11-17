import java.util.ArrayList;
import java.util.List;

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

    public void processCommand(String command, ScoreableItems items) {
        switch (command.toLowerCase()) {
            case "i":
                this.showInstructions();
                break;
            case "bag":
                this.showItems();
                break;
            case "items":
                items.displayCurrentItems(location.getCurrentPosition());
                break;
            case "n": case "w": case "e": case "s":
                this.move(command, items);
                break;
            default:
                String item = command;
                this.getItem(item, items);
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

    private void move(String command, ScoreableItems items) {
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



