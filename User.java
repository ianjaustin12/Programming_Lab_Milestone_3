import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class User {
    private String grade;
    private String name;
    private Location previousLocation;
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
    public void getItemNoPrint(Item item) {
        if (items.contains(item)){
            items.add(item);
            score += item.getScore();
        }
    }
    public Location getPreviousLocation() {
        return previousLocation;
    }
    public void setPreviousLocation(Location previousLocation) {
        this.previousLocation = previousLocation;
    }
    //to place item in items (inventory) 
    public void getItemPrint(Item item){
        if (item != null){
            this.items.add(item);
            this.score += item.getScore();
            System.out.println("You have picked up " + item + " and now have " + score + " points.");
            System.out.println("..................................................................................");
            System.out.println();
        }
    }
    public void loseItem(Item item) {
        if (!items.contains(item)){
            items.remove(item);
            score -= item.getScore();
        }
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
            previousLocation = location;
            location = loc;
            location.printOnEnter();
        }
        else
            System.out.println("Whoopsies you cant go there.");
    }
    
    public void move(Location loc){
        previousLocation = location;
        location = loc;
        location.printOnEnter();
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
    public Item findItemByName(String name){
        Item thisItem = null;
        Iterator<Item> it = items.iterator();
        while (it.hasNext()) {
            thisItem = it.next();
            try{
            if(thisItem.getName().equals(name))
                return thisItem;
            }catch(Exception e){}
        }
        return null;
    }
    //to use an item in battle
    public void useItem(Scan scan, User user, Item item){
        System.out.println(getName() + " uses " + item.getName());
        System.out.println(user.getName() + " loses"+ item.getScore() +" lives.");
        user.setLives(user.getLives()-item.getScore());
    }

    //to use an special ability in battle
    public void specialAbility(Scan scan, User user){

    }
//to steal items from monster
    public void steal(User user){
        Set<Item>items = user.getItems();
        int rand = (int)Math.ceil(Math.random()* items.size());
        int count = 0;
        Item thisItem = null;
        Iterator<Item> it = items.iterator();
        while (it.hasNext()) {
            count++;
            thisItem = it.next();
            if(rand == count){
                break;
            }
        }
        if(thisItem != null){
            System.out.println(getName() + " has stolen " + thisItem.getName() + " from "+ user + "!");
            user.loseItem(thisItem);
            getItemPrint(thisItem);
        }
    }
    
}



