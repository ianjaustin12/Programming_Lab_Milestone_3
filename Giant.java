public class Giant extends Monster {
    public Giant(){
        super("Giant", 35);
        super.setspecialAbility("Giant's Stomp");
        super.addMonsterItems(new Item("Giant's Club", 10));
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
