import java.util.Set;
import java.util.Iterator;
import java.util.HashSet;

public class ScoreableItems {
    private Set<Item> items;

    public ScoreableItems() {
        items = new HashSet<Item>();
        init();
    }

    private void init() {
        items.add(new Item("Book", 8, "Quad"));
        items.add(new Item("Pencil", 8, "MainGate"));
        items.add(new Item("Water", 10, "Stag"));
        items.add(new Item("Candy", 15, "Tully"));
        items.add(new Item("Ice Cream", 10, "Quad"));
        items.add(new Item("Spider", 10, "MainGate"));
        items.add(new Item("Water", 11, "MainGate"));
        items.add(new Item("Coffee", 20, "Quad"));
    }

    public void displayCurrentItems(CampusLoc location) {
        Iterator<Item> it = items.iterator();
        System.out.println("Current available items here:");
        Item thisItem;
        while (it.hasNext()) {
            thisItem = it.next();
            if (thisItem.getLocation().equals(location.toString())) {
                System.out.println("    " + thisItem.getName() + ", worth " + thisItem.getScore() + " point(s)");
            }
        }
    }

    public Item getItem(String name, CampusLoc location) {
        Item thisItem;
        Iterator<Item> it = items.iterator();
        while (it.hasNext()) {
            thisItem = it.next();
            if (thisItem.getName().equalsIgnoreCase(name)  && thisItem.getLocation().equals(location.toString())) {
                System.out.println("Got the " + name + "!");
                it.remove();
                return thisItem;
            }
        }

        //in case not found the stuff after iterating
        System.out.println("Invalid command, please try again.");
        return null;
    }

}
