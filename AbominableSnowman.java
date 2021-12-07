public class AbominableSnowman extends Monster {
    public AbominableSnowman(){
        super("Abominable Snowman", 5);
        super.setspecialAbility("Melt");
        super.addMonsterItems(new Item("Ice Pack", 1));
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
