import java.io.Serializable;
import java.util.Set;

public class Location implements Serializable{
//instance variables
    private String name;
    private int xIndex;
    private int yIndex;
    String aboutRoom;
    private Set<Item> items;
//constructors
    public Location (String currentPos, int y, int x,String about,Set<Item> inItems){
        name = currentPos;
        xIndex = x;
        yIndex = y;
        items = inItems;
        aboutRoom = about;
    }
//getter and setters
    public void addItem(Item item){
        items.add(item);
    }
    public void deleteItem(Item item){
        items.remove(item);
    }
    public String getName(){
        return name;
    }
    public void setName(String n) {
        name = n;
    }
    public int getXIndex() {
        return xIndex;
    }
    public int getYIndex() {
        return yIndex;
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

