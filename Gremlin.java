public class Gremlin extends Monster {
    public Gremlin(){
        super("Gremlin", 5);
        super.setspecialAbility("Eats After Midnight");
        super.addMonsterItems(new Item("Hat", 1));
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
