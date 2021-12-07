public class Dracula extends Monster {
    public Dracula(){
        super("Dracula", 10);
        super.setspecialAbility("Run");
        super.addMonsterItems(new Item("Exetendo Bag", 5));
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
