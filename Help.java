
public class Help {

    public static void showInstructions(){
        System.out.println(".................................Game Instructions................................");
        System.out.println(getGameBasics());
        System.out.println(getShortCommandList());
        System.out.println("..................................End Instructions................................");
    }
    public static String getGameBasics() {

        return "We are here to help! You should move around the cavern to try and find items for points...\n" +
            "Be careful of monsters roaming about... they will appear when you enter rooms or pickup items\n" +
            "The premise of the game is too collect 50 points by defeating monsters and gathering items\n" +
            "Before the monsters take all of your lives...\n" + 
            "After you gain 50 points you must face the final boss. Keep this in mind as you travel\n" +
            "You will find items to help you along the way aswell. Such as shields, weapons and medkits.\n" +
            "Shields can be used to block one life to be lost in battle \n" + 
            "Medkits can be used to revive one life at any time \n" +
            "Weapons can be used as multiplyers for battle.\n" +
            "Such as if you have the sword of Griffindor which is worth 10 points, \n" +
            "You can \"use\" this in battle to take 10 lives from the monster \n" +
            "That is if you win the battle. Be careful weapons are hard to find and will be helpful for the final boss \n" ;

    }

    public static String getShortCommandList()
    {
        return "Your options to travel are: E, W, S, N... Standing for East, West, South, and North" +
        "Type help to see more available commands.";


    }
    public static void getHelp() {
        /*i, bag, items, quit, n, s, e, w help
        */
        String instructions = "In Game Commands:\n";
        instructions += "- NOTE: Case and spacing does not matter for any command. But please no spaces in the middle of commands\n";
        instructions += "- Type a direction to move (N/E/S/W)\n";
        instructions += "- Type 'items' to see the items available at your current location\n";
        instructions += "- After the prompt type the \"item's name\" to get an item\n";
        instructions += "- Type 'bag' to see all your items in your inventory\n";
        instructions += "- Type 'help' to see this help menu again\n";
        instructions += "- Type 'i' to see the in game instructions on how to play\n";
        instructions += "- Type 'quit' to stop the game. Progress will not be saved.\n";
        System.out.println(instructions);
    }
    //prints the fight rules
    public static void fightRules(){
        System.out.println("************************************* Rules of monster fight club ************************************");
        System.out.println("We do not talk about monster fight club.");
        System.out.println("You and the monster pick rock paper or scissors .");
        System.out.println("Rock beats scissors, paper beat rock, and scissors beats paper");
        System.out.println("If you lose your battle. You lose a life.");
        System.out.println("If you win your battle. The monster loses a life. Their life count equals their power level.");
        System.out.println("Once you enter a battle you may not leave.");
        System.out.println("Let the games begin");
        System.out.println("******************************************************************************************************");
    }
    //fight commands
    public static void fightCommands(){
        //rock, paper. scissor, use, special ability, i commands
        System.out.println("************************************* Monster Fight Club  Commands ***********************************");
        String instructions = "In Fight Commands:\n";
        instructions += "- NOTE: Case and spacing does not matter for any command. But please no spaces in the middle of commands\n";
        instructions += "- Type your decision to battle (\"rock\" \"paper\" or \"scissors\")\n";
        instructions += "- Type 'use' to see the items available to use in your bag\n";
        instructions += "- After the prompt type the \"item's name\" to use an item\n";
        instructions += "- Type 'special ability' to use your special ability if you have one.\n";
        instructions += "- Type 'help' to see the help menu on rules of the game\n";
        instructions += "- Type 'i' to see the mid fight commands\n";
        instructions += "- Type 'run' to run away from the fight... be careful it may cause consequences.\n";
    
        System.out.println(instructions);
        System.out.println("******************************************************************************************************");
    }

}
