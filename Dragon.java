public class Dragon extends Monster {
    public Dragon(){
        super("Dragon", 30);
        super.setspecialAbility("Dragon's Breath");
        super.addMonsterItems(new Item("Dragon's Shield", 15));
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
