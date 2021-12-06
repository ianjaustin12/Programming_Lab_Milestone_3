public class ExpertRobber extends Monster {
    public ExpertRobber(){
        super("Expert Robber", 35);
        super.setspecialAbility("Disappear");
        super.addMonsterItems(new Item("Invisibility Cloak", 15));
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
