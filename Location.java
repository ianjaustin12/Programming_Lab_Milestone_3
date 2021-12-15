import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Location implements Serializable{
//instance variables
    private String name;
    private int xIndex;
    private int yIndex;
    private String aboutRoom;
    private Set<Item> items;
    private Monster monster;
//constructors
    public Location (String nameOfLocation, int y, int x,String locationDescription, Item itemInLocation){
        if (nameOfLocation != null)
            name = nameOfLocation;
        else
            name = "";
        this.monster = MonsterFactory.getRandomMonster();
        xIndex = x;
        yIndex = y;
        items = new HashSet<>();
        if (itemInLocation != null)
                items.add(itemInLocation);
        if (locationDescription != null)
            aboutRoom = locationDescription;
        else  
            aboutRoom = "";
    }
//getter and setters

    public String getName(){
        return name;
    }
    public void setName(String n) {
        name = n;
    }
    public int getXIndex() {
        return xIndex;
    }
    public void setXIndex(int xIndex) {
        this.xIndex = xIndex;
    }
    public int getYIndex() {
        return yIndex;
    }
    public void setYIndex(int yIndex) {
        this.yIndex = yIndex;
    }
    public Set<Item> getItems() {
        return items;
    }
    public void addItem(Item item) {
        items.add(item);
    }
    public void removeItem(Item item) {
        items.remove(item);
    }
    public Monster getMonster(){
        return monster;
    }
    public void setMonster(Monster monster){
        this.monster = monster;
    }
    public Item getItem(Item item){
        Iterator<Item> it = items.iterator();
        if(it.hasNext()){
            if(it.next()== item)
                return item;
        }
        return null;
    }
    public Item getItemByString(String item){
        Iterator<Item> it = items.iterator();
        if(it.hasNext()){
            Item itemit = it.next();
            if(itemit.getName().equalsIgnoreCase(item))
                return itemit;
        }
        return null;
    }
    public void printItems(){
        Iterator<Item> it = items.iterator();
        if(it.hasNext()){
            Item itemit = it.next();
            System.out.println("Item : " + itemit);   
        }
        else
        {System.out.println("Those are all the items.");}
    }
    
//print methods
    public void printOnEnter(){
        System.out.println("................................Entering New Room.................................");
        System.out.println("Welcome to " + name);
        System.out.println(aboutRoom);
        System.out.println("..................................................................................");
        System.out.println();
    }
    
    @Override
    public String toString(){
        return name;
    }
}

