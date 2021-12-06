public class Thief extends Monster {
    public Thief(){
        super("Thief", 15);
        super.setspecialAbility("Run");
        super.addMonsterItems(new Item("Exetendo Bag", 5));
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
