public class Thief extends Monster {
    public Thief(){
        super("Thief", 15);
        super.setspecialAbility("Run");
        super.addMonsterItems(new Item("Exetendo Bag", 5));
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
        System.out.println(getName() + " takes 2 items for you skipping the battle :(");
        int count = 0;
        while(count++ <= 2)
            steal(user);
    }
}
