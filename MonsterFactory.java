import java.util.Scanner;

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
    //called to see if there is a monster guarding the room
    public static void monsterInRoom(User currentUser, Scanner scan){
        if (Math.random() <= 0.5){
            Monster m = MonsterFactory.pickAMonster();
            int worth = m.getpowerLevel()*5;
            System.out.println("A wild Monster has appeared");
            System.out.println("This monster has a power level of " + m.getpowerLevel() + " points");
            System.out.println("This fight is worth " + worth + " points");
            while(true){
                System.out.println("Would you like to fight? Answer with y/n");
                String fight = scan.nextLine();
                fight = fight.trim().toLowerCase();
                if (fight.equalsIgnoreCase("y")){
                    if(m.fight(currentUser, scan)){
                        System.out.println("You have won this fight and gotten " + worth + " points.");
                        currentUser.addScore(worth);
                        if (currentUser.getLives() < 3){
                            System.out.println("Your life count will now be reset to 3.");
                            currentUser.setLives(3);
                        }
                    }
                    else{
                        System.out.println(m.getName() + " has won this fight and you have lost your lives");
                        currentUser.loseScore(worth);
                    }
                }
                else if(fight.equalsIgnoreCase("n")){
                    System.out.println("Continue On Then Traveler.");
                    continue;
                }
                else if (fight.equalsIgnoreCase("i")){
                    m.fightRules();
                }
            }
        }
    }
    //called to see if there is a monster guarding the item
    public static boolean monsterProtectingItem(User currentUser, Scanner scan, Item item){
        //monster appears with percentage increase by 10% ever 5 points on item
        double scoreRatio = (((double) item.getScore())/5)/50;
        if (Math.random() <= scoreRatio){
            Monster m = MonsterFactory.pickAMonster();
            System.out.println("A wild Monster has appeared to protect " + item);
            System.out.println("This monsters name is " + m.getName());
            System.out.println( m.getName()+" has a power level of " + m.getpowerLevel() + " points");
            System.out.println("This fight is worth the item");
            System.out.println("If "+currentUser.getName()+" wins they get the item.");
            System.out.println("If "+m.getName()+" wins they get the item.");
            while(true){
                System.out.println("Would you like to fight? Answer with y/n");
                String fight = scan.nextLine();
                fight = fight.trim().toLowerCase();
                if (fight.equalsIgnoreCase("y")){
                    if(m.fight(currentUser, scan)){
                        System.out.println("You have won this fight and gotten " + item);
                        return true;
                    }
                    else{
                        System.out.println(m.getName() + " has won this fight and you have lost " + item);
                        return false;
                    }
                }
                else if(fight.equalsIgnoreCase("n")){
                    System.out.println("Continue On Then Traveler.");
                    continue;
                }
                else if (fight.equalsIgnoreCase("i")){
                    m.fightRules();
                }
            }
        }
        return true;
    }
}
