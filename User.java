import java.util.ArrayList;
import java.util.List;

public class User {
    CampusLoc STARTING_POSITION = CampusLoc.Stag;

    private String grade;
    private String name;
    private Location location;
    private List<Item> items;
    private int score;
    private int lives;

    public User() {
        this("bob","Sophomore");
    }

    public User(String name, String grade) {
        this.grade = grade;
        this.name = name;
        items = new ArrayList<>();
        location = new Location(STARTING_POSITION);
        score = 0;
        lives = 3;
    }
//getter and setter methods
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
        score = score - s;
    }
    public int getLives() {
        return lives;
    }
    public void setLives(int lives){
        this.lives = lives;
    }
    public void addLife() {
        lives++;
    }
    public void loseLife() {
        lives++;
    }
    public Location getLocation() {
        return location;
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
//prints the user
    public String whatDoIDo() {

        return "My name is " + this.name + " and I am a " + this.grade;
    }
//moves the user
    public void move(String command) {
        Direction dir = null;
        switch (command.toLowerCase()) {
            case "n":
                dir = Direction.NORTH;
                break;
            case "e":
                dir = Direction.EAST;
                break;
            case "s":
                dir = Direction.SOUTH;
                break;
            case "w":
                dir = Direction.WEST;
                break;
        }
        location.handleMove(getCurrentPosition(), dir);

    }
    
//to place item in items (inventory) 
    public void getItem(Item item){
        if (item != null){
            this.items.add(item);
            this.score += item.getScore();
            System.out.println("You have picked up " + item + " and now have " + score + " points.");
        }
    }
// to show all items that user has
    public void showItems() {
        System.out.println("Items: ");
        for (Item item : this.items) {
            System.out.println("- " + item.getName());
        }
        System.out.println();
    }
    
}



