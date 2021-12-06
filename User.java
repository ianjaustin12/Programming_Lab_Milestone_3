import java.util.HashSet;
import java.util.Set;

public class User {
    private String grade;
    private String name;
    private Location location;
    private Set<Item> items;
    private int score;
    private int lives;
    String specialAbility;

    public User() {
        this("bob");
    }
    public User(String name){
        this.name = name;
        items = new HashSet<Item>();
    }
    public User(String name, String grade, Location STARTING_POSITION) {
        this.grade = grade;
        this.name = name;
        items = new HashSet<Item>();
        location = STARTING_POSITION;
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
    public Set<Item> getItems() {
        return items;
    }
    public void addItem(Item item) {
        if (items.contains(item))
            items.add(item);
    }
    public void loseItem(Item item) {
        if (!items.contains(item))
            items.remove(item);
    }
    public void addLife() {
        lives++;
    }
    public void loseLife() {
        lives--;
    }
    public Location getLocation() {
        return location;
    }
    
    
//prints the user
    public String whatDoIDo() {

        return "My name is " + this.name + " and I am a " + this.grade;
    }
//moves the user
    public void move(String command, Map map) {
        Location loc = null;
        switch (command.toLowerCase()) {
            case "n":
                loc = map.getNorthLocation(location);
                break;
            case "e":
                loc = map.getEastLocation(location);
                break;
            case "s":
                loc = map.getSouthLocation(location);
                break;
            case "w":
                loc = map.getWestLocation(location);;
                break;
        }
        if(loc != null){
            location = loc;
            location.printOnEnter();
        }
        else
            System.out.println("Whoopsies you cant go there.");
    }
    
//to place item in items (inventory) 
    public void getItem(Item item){
        if (item != null){
            this.items.add(item);
            this.score += item.getScore();
            System.out.println("You have picked up " + item + " and now have " + score + " points.");
            System.out.println("..................................................................................");
            System.out.println();
        }
    }
// to show all items that user has
    public void showItems() {
        System.out.println("..................................................................................");
        System.out.println("Items: ");
        for (Item item : this.items) {
            System.out.println("- " + item.getName());
        }
        System.out.println("..................................................................................");
        System.out.println();
    }
//to use an item in battle
    public void useItem(String item){

    }
    //to use an special ability in battle
    public void specialAbility(){

    }
    //to steal items from user
    public void steal(){

    }
    
}



