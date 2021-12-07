import java.io.Serializable;

public class Item implements Serializable{
    private String name;    
    private int score;
    private Location location;
    
    public Item(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
public Location getLocation(){
    return location;
}
public void setLocation(Location location) {
    this.location = location;
}
    @Override
    public String toString(){
        return "name = " + name + " score = " + score;
    }
}
