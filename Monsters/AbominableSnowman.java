package Monsters;


public class AbominableSnowman extends Monster{
    
    public AbominableSnowman(){
        health = 5;
        dmg = 2;
        name = "Abominable Snowman";
        attackStatement = "Stay frosty!!";
    }

    public void onDeath(){
        System.out.println("Abominable Snowman: BLAArarrgghhhg, I have died.");
        
    }

    public AbominableSnowman clone(){
        return new AbominableSnowman();
    }

}
