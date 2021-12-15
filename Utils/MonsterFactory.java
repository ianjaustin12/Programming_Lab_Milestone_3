package Utils;
import Monsters.AbominableSnowman;
import Monsters.Dracula;
import Monsters.Giant;
import Monsters.James;
import Monsters.Monster;
import Objects.Encounter;

public class MonsterFactory {

    private static final Monster[] POSSIBLE_MONSTERS = 
    { 
        new AbominableSnowman(),
        new Dracula(),
        new Giant(),
        new James(), 
        null,
        null,
        null,
        null
    }; 
        
    public static Monster getRandomMonster() {
        int rand = (int) (POSSIBLE_MONSTERS.length * Math.random());
        if (POSSIBLE_MONSTERS[rand] != null) {
            return POSSIBLE_MONSTERS[rand].clone();
        } else {
            return null;
        }
    }
    public static Monster getRandomMonster(Encounter e) {
        while(true){
            int rand = (int) (POSSIBLE_MONSTERS.length * Math.random());
            if (POSSIBLE_MONSTERS[rand] != null) {
                return POSSIBLE_MONSTERS[rand].clone();
            } 
        }
    }
}
