public class Leprechaun extends Monster {
    public Leprechaun(){
        super("Leprechaun", 4);
        super.setspecialAbility("Vanish");
        super.addMonsterItems(new Item("Pot Of Gold", 50));
    }
    @Override
    /* what the special ability does*/
    public void specialAbility() {
        
    }
    @Override
    /* what the item used does*/
    public void useItem() {
        
    }
    @Override
    public String getMonsterChoice(String userChoice){
        return throwRandom();
    }
    @Override
    public void fightDenied(Scan scan){
        
    }
    @Override
    public void steal(){

    }
}
