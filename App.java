
import java.util.Scanner;

public class App {

    static ScoreableItems caveItems;

    public static void main(String[] args) {

        
        System.out.println(" Welcome to Fairfield University ");
        System.out.println(" What would you like to do? ");

        Scanner s = new Scanner(System.in);
        
        System.out.println("what's your user's name: ");
        String userName = s.nextLine();

        System.out.println("what's your user's grade: ");
        String userGrade = s.nextLine();

        User currentUser = new User(userName, userGrade);
        System.out.println(" your user: " + currentUser.whatDoIDo());
        caveItems = new ScoreableItems();
        
        action(currentUser, caveItems);
        
        s.close();
    }

    public static void action(User currentUser, ScoreableItems caveItems){
        Scanner userChoice = new Scanner(System.in);
        String command;
        int score = currentUser.getScore();
        while (score < 50) {
            currentUser.showCurrentOptions();
            System.out.println("");
    //start a fight 50% chance
            if (Math.random() <= 0.5){
                Monster m = MonsterFactory.pickAMonster();
                m.fight(currentUser);
            }
            System.out.println("So what do you wanna do? (Or type 'i' to get instructions)");
            command = userChoice.nextLine();
            currentUser.processCommand(command, caveItems);
        }
        userChoice.close();
    }

}


