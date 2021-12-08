public class  Giant extends Monster{
    
    public Giant(){
        health = 4;
        dmg = 4;
        name = "Giant";
        attackStatement = "Me Smash you";
    }

    public void onDeath(){
        System.out.println("hmhmemhmhelg *falls on you*");
        App.currentUser.takeDamage(2);
        
    }

    public Giant clone(){
        return new Giant();
    }

}
