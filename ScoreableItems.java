import java.util.Set;
import java.util.Iterator;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;

public class ScoreableItems {
    private final static String filepath = "items.bin";
    private Set<Item> items;

    public ScoreableItems() {
        items = new HashSet<Item>();
        init();
        //loadFromFile();
    }

    private void init() {
        items.add(new Item("Book", 5));
        items.add(new Item("Pencil", 5));
        items.add(new Item("Water", 10));
        items.add(new Item("Candy", 15));
        items.add(new Item("Ice Cream", 10));
        items.add(new Item("Spider", 10));
        items.add(new Item("Water", 15));
        items.add(new Item("Coffee", 20));

    }
    public void addItem(Item item){
        items.add(item);
    }
    public void removeItem(Item item){
        items.remove(item);
    }
    public Set<Item> getItems() {
        return items;
    }
    public void displayLocationCurrentItems(Location location) {
        Iterator<Item> it = items.iterator();
        System.out.println("Current available items here:");
        Item thisItem;
        while (it.hasNext()) {
            thisItem = it.next();
            if (thisItem.getLocation().equals(location)) {
                System.out.println("    " + thisItem.getName() + ", worth " + thisItem.getScore() + " point(s)");
            }
        }
    }
    

    public Item getItem(String name, Location location) {
        Item thisItem;
        Iterator<Item> it = items.iterator();
        while (it.hasNext()) {
            thisItem = it.next();
            if (thisItem.getName().equalsIgnoreCase(name)  && thisItem.getLocation().equals(location)) {
                System.out.println("Got the " + name + "!");
                it.remove();
                return thisItem;
            }
        }

        //in case not found the stuff after iterating
        System.out.println("Invalid item, please try again.");
        return null;
    }
//prints all of the items
    public void printItems(){
        Iterator<Item> it = items.iterator();
        System.out.println("Current available items here:");
        Item thisItem;
        while (it.hasNext()) {
            thisItem = it.next();
            System.out.println(thisItem);
        }
    }
//for serialization
    public void saveToFile(){
        try {
            ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(filepath));
            for(Item item: items)
                objectOut.writeObject(item);
            objectOut.close();
                 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void loadFromFile(){
        try{
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(filepath));
            while (true) {
                try{
                    Item item = (Item)input.readObject();
                    if(!items.contains(item))
                        items.add(item);
                }catch(EOFException ex){input.close();}
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
