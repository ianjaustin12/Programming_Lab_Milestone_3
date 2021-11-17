
import java.util.Scanner;

public class App {

    static ScoreableItems caveItems;

    public static void main(String[] args) {

        //default user
        User user1 = new User();
        String result = user1.whatDoIDo();
        System.out.println(result);


        System.out.println(" Welcome to Fairfield University ");
        System.out.println(" What would you like to do? ");

        User currentUser = user1;

        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println(" 1 for create user ");
            System.out.println(" 2 for display user ");
            System.out.println(" 3 explore Fairfield");

            String userChoice = s.nextLine();


            if (userChoice.equals("1")) {

                System.out.println("what's your user's name: ");
                String userName = s.nextLine();

                System.out.println("what's your user's grade: ");
                String userGrade = s.nextLine();


                currentUser = new User(userName, userGrade);
                System.out.println(" your user: " + currentUser.whatDoIDo());
                caveItems = new ScoreableItems();
                action(currentUser, caveItems);

                s.close();

            } else if (userChoice.equals("2")) {
                if (currentUser != user1)
                    System.out.println("I am " + currentUser.getName() + " and I am a " + currentUser.getGrade());
                else
                    System.out.println("I am " + user1.getName() + " and I am a " + user1.getGrade());
                caveItems = new ScoreableItems();
                action(currentUser, caveItems);


                s.close();

            } else if (userChoice.equals("3")) {
                while (true) {
                    System.out.println("What direction would you like to go? (East/West/North/South) or type 'Quit' to stop: ");
                    String locationChoice = s.nextLine();

                    Location loc = currentUser.getLocation();

                    System.out.println(loc.getCurrentPosition());

                    System.out.println(loc.getCurrentPosition());

                    if (locationChoice.equalsIgnoreCase("Help")) {
                        System.out.println("-------");
                        System.out.println(Help.getDirections());
                        System.out.println(Help.getPossibleDirections());
                        System.out.println("-------");
                    }

                    if (locationChoice.equalsIgnoreCase("Quit")) {
                        break;
                    }
                }
            }
        }
    }

    public static void action(User currentUser, ScoreableItems caveItems){

        Scanner userChoice = new Scanner(System.in);
        String command;
        int score = currentUser.getScore();
        while (score < 50) {
            currentUser.showCurrentOptions();
            System.out.println("");
            System.out.println("So what do you wanna do? (Or type 'i' to get instructions)");
            command = userChoice.nextLine();
            currentUser.processCommand(command, caveItems);
        }
            userChoice.close();
    }
}


