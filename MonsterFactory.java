public class MonsterFactory{
    final static int numberOfMonster = 1;
    //used to pick a monster 
    public static Monster pickAMonster(){
        int choice = (int)Math.ceil(Math.random()* 10);
        Monster m = new Monster();
        switch(choice){
            case 1: case 2: case 3: case 4: case 5: case 6: case 7:
                m = selectTierOneMonster();
                break;
            case 8: case 9:
                m = selectTierOneMonster();
                break;
            case 10: 
                m = selectTierThreeMonster();
                break;
            default:
                m = new Monster();
                break;
        }
        return m;  
    }
    public static Monster selectTierOneMonster(){
        Monster m = null;
        int rand = (int)Math.ceil(Math.random()* 3);
        switch(rand){
        case 1:
            m = new AbominableSnowman();
            break;
        case 2:
            m = new Gremlin();
            break;
        case 3:
            m = new Leprechaun();
            break;
        }
        return m;
        
    }
    public static Monster selectTierTwoMonster(){
        Monster m = null;
        int rand = (int)Math.ceil(Math.random()* 3);
        switch(rand){
        case 1:
            m = new Thief();
            break;
        case 2:
            m = new Ogre();
            break;
        case 3:
            m = new BoogeyMan();
            break;
        case 4:
            m = new Chuckie();
            break;
        case 5:
            m = new Dracula();
            break;
        }
        return m;
    }
    public static Monster selectTierThreeMonster(){
        Monster m = null;
        int rand = (int)Math.ceil(Math.random()* 3);
        switch(rand){
        case 1:
            m = new Dragon();
            break;
        case 2:
            m = new Giant();
            break;
        case 3:
            m = new ExpertRobber();
            break;
        }
        return m;
    }
    //boss Voldemort the Poltergeist
//called to see if there is a monster guarding the room
    public static void monsterInRoom(User currentUser, Scan scan){
    //50% chance of monster in the room
        if (Math.random() <= 0.5){
    //picks a monster to fight
            Monster m = MonsterFactory.pickAMonster();
    //display fight stats
            int worth = m.getpowerLevel()*5;
            System.out.println("A wild Monster has appeared");
            System.out.println("This monster has a power level of " + m.getpowerLevel() + " points");
            System.out.println("This fight is worth " + worth + " points");
    //asks user if they will fight    
            if (willFight(scan, m)){
        //fights user
                if(m.fight(currentUser, scan)){
            //does this if user won
                    System.out.println("You have won this fight and gotten " + worth + " points.");
                    currentUser.addScore(worth);
                    if (currentUser.getLives() < 3){
                        System.out.println("Your life count will now be reset to 3.");
                        currentUser.setLives(3);
                    }
                }
            //does this if user lost
                else{
                    System.out.println(m.getName() + " has won this fight and you have lost your lives");
                    currentUser.loseScore(worth);
                }
            }
        }
    }
//called to see if there is a monster guarding the item
//monster appears with percentage increase by 10% every 5 points on item
//true if fight won or no monster, false if fight lost
    public static boolean monsterProtectingItem(User currentUser, Scan scan, Item item){
        double scoreRatio = (((double) item.getScore())/5)/50;
        if (Math.random() <= scoreRatio){
    //picks a monster to fight
            Monster m = MonsterFactory.pickAMonster();
    //display fight stats
            System.out.println("A wild Monster has appeared to protect " + item);
            System.out.println("This monsters name is " + m.getName());
            System.out.println( m.getName()+" has a power level of " + m.getpowerLevel() + " points");
            System.out.println("This fight is worth the item");
            System.out.println("If "+currentUser.getName()+" wins they get the item.");
            System.out.println("If "+m.getName()+" wins they get the item.");
    //asks user if they will fight        
            if (willFight(scan, m)){
        //fights if user says yes
                if(m.fight(currentUser, scan)){
            //this if user won the fight
                    System.out.println("You have won this fight and gotten " + item);
                    return true;
                }
                else{
            //this if user lost the fight
                    System.out.println(m.getName() + " has won this fight and you have lost " + item);
                    return false;
                }
            }
        }
        return true;
    }
//final boss Fight
    public static boolean finalBoss(User currentUser, Scan scan){
        
        return true;
    }
//used to ask user if they would like to fight or not
//can make users regret not fighting certain monster
    public static boolean willFight(Scan scan, Monster m){
        System.out.println("Would You like to read the rules of Monster Fight Club before the fight?");
        if(scan.yesOrNo()){
            Help.fightRules();
        }
        System.out.println("Would You like to fight "+ m.getName() +" ?");
        if(scan.yesOrNo()){
            return true;
        }
        m.fightDenied(scan);
        return false;   
    }
}
