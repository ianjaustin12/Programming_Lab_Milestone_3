import java.util.Iterator;

public class FinalBoss extends Monster {
    public FinalBoss(){
        super("Voldemort the Poltergeist", 100);
        super.setspecialAbility("AVADA KADAVARA!");
        super.addMonsterItems(new Item("Ghost Magic", 7));
        super.addMonsterItems(new Item("Shred spell", 14));
        super.addMonsterItems(new Item("Stun spell", 2));
        super.addMonsterItems(new Item("HR Meeting", 5));
        super.addMonsterItems(new Item("Government Funding", 15));
        super.addMonsterItems(new Item("Overdue Taxes",100));
        super.addMonsterItems(new Item("Late for Work", 25));
        super.addMonsterItems(new Item("Watch", 15));

    }
    @Override
    //parse command
    public boolean parseCommand(String command, User who, Scan scan, User notWho){
        //rock, paper, scissors
            if ((command.equals("rock")||command.equals("paper")||command.equals("scissors"))){
                return true;
            }
        //i
            else if (command.equals("i")){
                Help.fightCommands();
                return false;
            }
        //i
            else if (command.equals("help")){
                Help.fightRules();
                return false;
            }
        //use <item>
            else if(command.startsWith("use")){
                command = command.substring(3);
                Item item = who.findItemByName(command);
                who.useItem(scan, notWho, item);
                return true;
            }
            else if (command.startsWith("special ability")){
                who.specialAbility(scan, notWho);
                return true;
            }
              
        //bad command
            System.out.println("The input " + command + " is invalid.");
            System.out.println("Expected value of \"rock\", \"paper\", or \"scissors\" or \"i\". Please input one of those values");
            return false;
        }
    @Override
    /* what the special ability does*/
    public void specialAbility(Scan scan, User user) {
        System.out.println(getName() + " uses " + getspecialAbility());
        System.out.println(user.getName() + " loses 50 lives.");
        user.setLives(user.getLives()-50);
    }
    @Override
    /* what the item used does*/
    public void useItem(Scan scan, User user, Item item){
        System.out.println(getName() + " uses " + item.getName());
        System.out.println(user.getName() + " loses"+ item.getScore() +" lives.");
        user.setLives(user.getLives()-item.getScore());
    }
    @Override
    public String getMonsterChoice(String userChoice){
        double rand = Math.random();
        if(rand <= 0.05)
            return "special ability";
        if(rand >= 0.05 && rand <= 0.5){
            int randItem = (int)Math.ceil(Math.random()*getItems().size());
            int count=0;
            Item item = null;
            Iterator<Item> it = getItems().iterator();
            while(it.hasNext()){
                count++;
                item = it.next();
                if(count == randItem)
                    break;
            }
            return "use " + item;
        }
        return throwRandom();
    }
    @Override
    public void steal(User user){

    }
}
