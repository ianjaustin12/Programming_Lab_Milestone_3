public class AbominableSnowman extends Monster {
    public AbominableSnowman(){
        super("AbominableSnowman", 5);
        super.setspecialAbility("Melt");
        super.addMonsterItems(new Item("Ice Pack", 1));
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
