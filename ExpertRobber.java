public class ExpertRobber extends Monster {
    public ExpertRobber(){
        super("Expert Robber", 35);
        super.setspecialAbility("Disappear");
        super.addMonsterItems(new Item("Invisibility Cloak", 15));
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
        System.out.println(getName() + " takes all your items for you skipping the battle");
        System.out.println(getName() + " laughs: mWHAHAHAHAHAHAHHA");
        while(!user.getItems().isEmpty())
            steal(user);
    }
}
