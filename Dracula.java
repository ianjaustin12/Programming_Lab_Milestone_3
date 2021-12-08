public class Dracula extends Monster{
    
    public Dracula(){
        health = 4;
        dmg = 4;
        name = "Dracula";
        attackStatement = "I'm going to suck your blood!!!!!!!!";
    }

    public void onDeath(){
        System.out.println("blehhehehehehe");
        
    }

    public Dracula clone(){
        return new Dracula();
    }

}
