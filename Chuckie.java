public class Chuckie extends Monster {
    public Chuckie(){
        super("Chuckie", 10);
        super.setspecialAbility("Cackle");
        super.addMonsterItems(new Item("Knife", 8));
        super.addMonsterItems(new Item("Ginger Wig", 12));
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
