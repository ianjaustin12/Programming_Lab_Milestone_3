import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
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
        if (currentPos != null)
            name = currentPos;
        else
            name = "";
        xIndex = x;
        yIndex = y;
        if (inItems != null)
            items = inItems;
        else
            items = new HashSet<Item>();
        if (about != null)
            aboutRoom = about;
        else  
            aboutRoom = "";
    }
//getter and setters
    public void addItem(Item item){
        items.add(item);
        item.setLocation(this);
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
    public Set<Item> getItems() {
        return items;
    }
    public void setItems(Set<Item> items) {
        this.items = items;
    }
    public Item findItemByName(String name){
        Item thisItem = null;
        Iterator<Item> it = items.iterator();
        while (it.hasNext()) {
            thisItem = it.next();
            try{
            if(thisItem.getName().equalsIgnoreCase(name))
                return thisItem;
            }catch(Exception e){}
        }
        System.out.println("Could not find the referenced item.");
        return null;
    }
//print methods
    public void printOnEnter(){
        System.out.println("................................Entering New Room.................................");
        System.out.println("Welcome to " + name);
        System.out.println(aboutRoom);
        System.out.println("..................................................................................");
        System.out.println();
    }
    public void displayCurrentItems() {
        Iterator<Item> it = getItems().iterator();
        System.out.println("Current available items here:");
        Item thisItem;
        try{
        while (it.hasNext()) {
            thisItem = it.next();
            if (thisItem.getLocation().equals(this)) {
                System.out.println("    " + thisItem.getName() + ", worth " + thisItem.getScore() + " point(s)");
            }
        }
        }catch(Exception e){}
        if(getItems() == null || getItems().isEmpty() || getItems().size() == 0)
                System.out.println("No items here.");
    }
    
    @Override
    public String toString(){
        return name;
    }
}

