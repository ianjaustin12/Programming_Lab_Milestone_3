package Objects;
import java.util.ArrayList;
import java.util.Set;

import Utils.App;

public class User {
    private String grade;
    private String name;
    private Location previousLocation;
    private Location location;
    private ArrayList<Item> items;
    private int score;
    private int strength;
    private int lives;
    
 
    public User() {
        this("bob");
    }
    public User(String name){
        this.name = name;
        items = new ArrayList<Item>();
    }
    public User(String name, String grade, Location STARTING_POSITION) {
        this.grade = grade;
        this.name = name;
        items = new ArrayList<Item>();
        location = STARTING_POSITION;
        strength = 1;
        score = 3;
        lives = 10;
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

    public void pickUpItem(String i){
        Location loc = App.currentUser.getLocation();
        Item item = loc.getItemByString(i);
        if (item != null){
            items.add(item);
            this.items.add(item);
            this.score += item.getScore();
            this.lives += item.getHealth();
            this.strength += item.getStrength();
            System.out.println("You have picked up " + item.getName());
            System.out.println("You now have " + score + " points.");
            System.out.println("You now have " + lives + " lives.");
            System.out.println("You now have " + strength + " points.");
            System.out.println();
            loc.removeItem(item);
        }
    }
    public void pickUpItem(Item item){
        Location loc = App.currentUser.getLocation();
        if (item != null){
            items.add(item);
            this.items.add(item);
            this.score += item.getScore();
            this.lives += item.getHealth();
            this.strength += item.getStrength();
            System.out.println("You have picked up " + item.getName());
            System.out.println("You now have " + score + " points.");
            System.out.println("You now have " + lives + " lives.");
            System.out.println("You now have " + strength + " points.");
            System.out.println("..................................................................................");
            System.out.println();
            loc.removeItem(item);
        }
    }
    public void getItem(){
        System.out.println("...............................Begin Item Pickup..................................");;
        Set<Item> i = location.getItems();
        if(i != null && !i.isEmpty() && i.size() != 0){
            //gets yes or no from user
            System.out.println("Do you want to pick up an item? yes/no");
            boolean pickedUp = true;
            while(pickedUp){
                String input =  App.scan.nextLine();
            if (input.equals("yes")){
            //gets item choice from user
                while(true){
                    System.out.println("What item do you want to pick up?");
                    String item = App.scan.nextLine();
                    try{
                        Item itemGotten = location.getItemByString(item);
                        //monster appears with percentage increase by 10% every 5 points on item
                        //true if fight won or no monster, false if fight lost
                        if (itemGotten.getStrength()/50 > Math.random()){
                            Encounter e = new Encounter();
                            if(!e.getUserWon()){
                                pickUpItem(item);
                                location.removeItem(itemGotten);
                                pickedUp = false;
                                break;
                            }
                        }
                        else{
                            pickUpItem(item);
                            location.removeItem(itemGotten);
                            pickedUp = false;
                            break;
                        }
                    }
                    catch(Exception e){
                        System.out.println("Item not understood. Please try again.");
                    }  
                }
            }
            else if(input.equals("no")){pickedUp = false;}
            else{
                System.out.println("please say yes or no");
            }
        }}
        else {
            System.out.println("There is no items here.");
        }
        System.out.println("...............................End Item Pickup....................................");
    }

    public boolean hasItemByType(String name)
    {
        for(Item i : items)
        {
            if(i.getName().toLowerCase().contains(name.trim().toLowerCase())) return true;
        }
        return false;
    }
    public Item getItemByType(String name)
    {
        for(Item i : items)
        {
            if(i.getName().toLowerCase().contains(name.trim().toLowerCase())) return i;
        }
        return null;
    }
    public boolean hasItem(String itemName)
    {
        for(Item i : items)
        {
            if(i.getName().toLowerCase().equals(name.trim().toLowerCase())) return true;
        }
        return false;
    }

    
    public int getScore() {
        return score;
    }
    public void addScore(int s) {
        score = score + s;
        strength = score *3;
    }
    public void loseScore(int s) {
        score = score - s;
        strength = score *3;
    }
    public int getLives() {
        return lives;
    }
    public void setLives(int lives){
        this.lives = lives;
    }
    public ArrayList<Item> getItems() {
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
    public void takeDamage(int damage){
        lives -= damage;
    }
    public Location getLocation() {
        return location;
    }
    public int getStrength() {
        return strength;
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
        if(loc != null && loc.getName() != "empty"){
            previousLocation = location;
            location = loc;
            if(Math.random()>0.5){
                Encounter e = new Encounter();
                if(!e.getUserWon()){
                    location = previousLocation;
                }
            }
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
    public Item getItemByString(String STRitem){
        for (Item item : items) {
            if(item.getName().equalsIgnoreCase(STRitem.trim()))
                return item;
        }
        System.out.println("Item not found");
        return null;
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
    public void useItem(Item item){
        if(item.getName().toLowerCase().contains("sword")){
            strength += item.getStrength();
            loseItem(item);
        }
        else if(item.getName().toLowerCase().contains("medkit")){
            lives += item.getStrength();
            loseItem(item);
        }
        else if(item.getName().toLowerCase().contains("armor")){
            lives += item.getStrength();
            loseItem(item);
        }
        else if(item.getName().toLowerCase().contains("map")){
            App.map.printMap();
            loseItem(item);
        }
        else if(item.getName().toLowerCase().equals("bone")){
            strength += 100000000;
            lives += 100000000;
            loseItem(item);
        }
        else {
            System.out.println(item.getName() + " cant be used.");
        }
        
    }
    
}



