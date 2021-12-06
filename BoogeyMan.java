public class BoogeyMan extends Monster {
    public BoogeyMan(){
        super("BoogeyMan", 7);
        super.setspecialAbility("Shadow Attack");
        super.addMonsterItems(new Item("Dream Inhibitor", 7));
        super.addMonsterItems(new Item("Dreams in o'bottle", 15));
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
