public class Gremlin extends Monster {
    public Gremlin(){
        super("Gremlin", 5);
        super.setspecialAbility("Eats After Midnight");
        super.addMonsterItems(new Item("Hat", 1));
    }
    @Override
    /* what the special ability does*/
    public void specialAbility(Scan scan, User user) {
        
    }
    @Override
    /* what the item used does*/
    public void useItem(Scan scan, User user, Item item) {
        
    }
    @Override
    public String getMonsterChoice(String userChoice){
        return throwRandom();
    }
    @Override
    public void fightDenied(Scan scan, User user){
        
    }
    @Override
    public void steal(User user){

    }
}
