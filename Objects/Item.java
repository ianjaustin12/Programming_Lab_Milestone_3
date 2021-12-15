package Objects;
public class Item{
    
    private String name;
    private int score;
    private int health;
    private int strength;
    
    public Item(String name, int score, int health, int strength) {
        this.name = name;
        this.score = score;
        this.health = health;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }
    @Override
    public String toString(){
        return name;
    }

}
