public class MonsterFactory {
    final static int numberOfMonster = 1;
    //used to pick a monster 
    public static Monster pickAMonster(){
        int choice = (int)Math.ceil(Math.random()* numberOfMonster);
        Monster m = new Monster();
        switch(choice){
            case 1:
                m = new Monster();
                break;
            default:
                m = new Monster();
                break;
        }
        return m;  
    }
}
