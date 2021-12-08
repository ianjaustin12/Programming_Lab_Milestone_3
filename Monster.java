
public abstract class Monster {

    //props
    protected int health;
    protected int dmg;
    protected String name;
    protected String attackStatement;

    //methods
    public void attack()
    {
        System.out.println("Ouch! I've been hit for " + dmg + " damage");
        App.currentUser.takeDamage(dmg);

    }

    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getStrength(){
        return dmg;
    }
    public void setStrength(int i){
        dmg = i;
    }
    public void takeDamage(int damage){
        System.out.println(name + ": Ouch! I've been hit for " + dmg + " damage!");
        health-=damage;
    }

    public abstract Monster clone();


    public abstract void onDeath(); //if monster's onDeath ability kills the player it might be the case that the player can still walk continue to the next room before dying
    
}
