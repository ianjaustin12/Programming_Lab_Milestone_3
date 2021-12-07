public class Leprechaun extends Monster {
    public Leprechaun(){
        super("Leprechaun", 4);
        super.setspecialAbility("Vanish");
        super.addMonsterItems(new Item("Pot Of Gold", 50));
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
