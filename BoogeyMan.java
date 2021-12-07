public class BoogeyMan extends Monster {
    public BoogeyMan(){
        super("BoogeyMan", 7);
        super.setspecialAbility("Shadow Attack");
        super.addMonsterItems(new Item("Dream Inhibitor", 7));
        super.addMonsterItems(new Item("Dreams in o'bottle", 15));
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
