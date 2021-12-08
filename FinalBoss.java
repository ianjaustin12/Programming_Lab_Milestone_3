public class FinalBoss extends Monster{
    
    public FinalBoss(){
        health = 250;
        dmg = 100;
        name = "Hades";
        attackStatement = "You are done for tiny creature";
    }
    
    @Override
    public void attack()
    {
        if(App.currentUser.hasItem("Golden Star"))
        {
            System.out.println("Since you had the Golden Star my attack didn't work!!!");
            App.currentUser.takeDamage(2);
        }
        else
        {
            App.currentUser.takeDamage(dmg);
        }
    }

    public void onDeath(){
        System.out.println("uuuruguruguggegegtggag");
        
    }

    public FinalBoss clone(){
        return new FinalBoss();
    }

}
