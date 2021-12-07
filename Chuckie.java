public class Chuckie extends Monster {
    public Chuckie(){
        super("Chuckie", 10);
        super.setspecialAbility("Cackle");
        super.addMonsterItems(new Item("Knife", 8));
        super.addMonsterItems(new Item("Ginger Wig", 12));
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
