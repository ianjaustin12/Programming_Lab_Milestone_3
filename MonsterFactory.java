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

//called to see if there is a monster guarding the room
    public static void monsterInRoom(User currentUser, Scan scan){
    //50% chance of monster in the room
        Monster m = checkRoomForMonster(currentUser);
        if (Math.random() <= 0.5 || m != null){
    //picks a monster to fight
            if(m == null)
                m = MonsterFactory.pickAMonster();
    //display fight stats
            int worth = m.getpowerLevel()*5;
            System.out.println("A wild Monster has appeared");
            System.out.println("This monsters name is " + m.getName());
            System.out.println(m.getName() + " has a power level of " + m.getpowerLevel() + " points");
            System.out.println("This fight is worth " + worth + " points");
    //asks user if they will fight    
            if (willFight(scan, m, currentUser)){
        //fights user
                String fightOutput = m.fight(currentUser, scan);
                if(fightOutput.equals("user")){
            //does this if user won
                    System.out.println("You have won this fight and gotten " + worth + " points.");
                    currentUser.addScore(worth);
                    if (currentUser.getLives() < 3){
                        System.out.println("Your life count will now be reset to 3.");
                        currentUser.setLives(3);
                    }
                }
            //does this if user lost
                else if(fightOutput.equals("monster")){
                    System.out.println(m.getName() + " has won this fight and you have lost your lives");
                    currentUser.loseScore(worth);
                }
                else if (fightOutput.equals("user run")){
                    System.out.println(currentUser.getName() + " has run away. They will be punished.");
                    m.fightDenied(scan, currentUser);
                }
                else if (fightOutput.equals("monster run")){
                    System.out.println(m.getName() + " has run away. Seems like you got lucky.");
                    if (currentUser.getLives() < 3){
                        System.out.println("Your life count will now be reset to 3.");
                        currentUser.setLives(3);
                    }
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
            if (willFight(scan, m, currentUser)){
        
                String fightOutput = m.fight(currentUser, scan);
                if(fightOutput.equals("user")){
            //does this if user won
                    System.out.println("You have won this fight and gotten " + item);
                    if (currentUser.getLives() < 3){
                        System.out.println("Your life count will now be reset to 3.");
                        currentUser.setLives(3);
                    }
                    return true;
                }
            //does this if user lost
                else if(fightOutput.equals("monster")){
                    System.out.println(m.getName() + " has won this fight and you have lost " + item);
                    return false;
                }
                else if (fightOutput.equals("user run")){
                    System.out.println(currentUser.getName() + " has run away. They will be punished.");
                    m.fightDenied(scan, currentUser);
                    return false;
                }
                else if (fightOutput.equals("monster run")){
                    System.out.println(m.getName() + " has run away. Seems like you lost this item.");
                    if (currentUser.getLives() < 3){
                        System.out.println("Your life count will now be reset to 3.");
                        currentUser.setLives(3);
                    }
                    return false;
                }
            }
        }
        return true;
    }
//final boss Fight
    public static boolean finalBoss(User currentUser, Scan scan, Map map){
        System.out.println("Welcome to... FINAL MONSTER FIGHT CLUB!");
        Monster m = new FinalBoss();
        currentUser.move("finalBoss", map);
        System.out.println("Are you ready to fight the boss?");
        if(scan.yesOrNo())
            System.out.println("Good thats what we like to hear");
        else
            System.out.println("Well that Sucks for you!");
        System.out.println("LETS GET READY TO RUMBLEEEE");
        System.out.println("By the way you both have 100 lives... Good luck.");
        currentUser.setLives(100);
        String ret = m.fight(currentUser, scan);
        if (ret.equals("user"))
            return true;
        else if (ret.equals("monster"))
            return false;
        else if (ret.equals("user run")){
                System.out.println(currentUser.getName() + " has run away. Death to them.");
                currentUser.setLives(0);
                return false;
            }
        else if (ret.equals("monster run")){
            System.out.println(m.getName() + " has run away. You are unstoppable!");
            return true;
        }
        return false;
    }

//used to ask user if they would like to fight or not
//can make users regret not fighting certain monster
    public static boolean willFight(Scan scan, Monster m, User currentUser){
        System.out.println("Would You like to read the rules of Monster Fight Club before the fight?");
        if(scan.yesOrNo()){
            Help.fightRules();
        }
        System.out.println("Would You like to fight "+ m.getName() +" ?");
        if(scan.yesOrNo()){
            return true;
        }
        m.fightDenied(scan, currentUser);
        return false;   
    }
//returns a monster if user is in specific room otherwise null
    public static Monster checkRoomForMonster(User user){
        Location loc = user.getLocation();
        switch (loc.getName()){
            case "Armory": case "Mosh Pit":
                return selectTierTwoMonster();
            case "The Ring": case "Underground Stream":
                return selectTierThreeMonster();
            case"The Arena": case "The Bunkers":
                return selectTierOneMonster();
            case "Treasure Room":
                return new Dragon();
            case "finalBoss":
                return new FinalBoss();
        }
        return null;
    }
}
