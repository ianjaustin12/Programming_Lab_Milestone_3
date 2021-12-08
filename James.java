public class James extends Monster{
    
    public James(){
        health = 12;
        dmg = 1;
        name = "James";
        attackStatement = "Hello, I am James. I will kill you!";
    }

    public void onDeath(){
        System.out.println("aaahghghghghasdjsjjs");
        
    }

    public James clone(){
        return new James();
    }

}
