public class Item {
    private String name;    ///write name and score as const??
    private int score;
    private String location;
    private Monster monster;
    private User user;

    public Item(String name, int score, String location) {
        this.name = name;
        this.score = score;
        this.location = location;
    }
    public Item(String name, int score, Monster m) {
        this.name = name;
        this.score = score;
        this.monster = m;
    }
    public Item(String name, int score, User u) {
        this.name = name;
        this.score = score;
        this.user = u;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public Monster getMonster() {
        return monster;
    }
    public void setMonster(Monster monster) {
        this.monster = monster;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public String toString(){
        return name;
    }
}
