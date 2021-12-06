public class Ogre extends Monster {
    public Ogre(){
        super("Ogre", 10);
        super.setspecialAbility("Punch");
        super.addMonsterItems(new Item("Large Shoes", 1));
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
