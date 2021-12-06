public class Dragon extends Monster {
    public Dragon(){
        super("Dragon", 20);
        super.setspecialAbility("Dragon' Breath");
        super.addMonsterItems(new Item("Dragon's Shield", 15, this));
    }
    @Override
    public void specialAbility() {
        
    }
    @Override
    public void useItem() {
        
    }
}
