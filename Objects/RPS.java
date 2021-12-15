package Objects;
import java.util.ArrayList;

public enum RPS {
    ROCK, PAPER, SCISSORS;

    public final static RPS[] POSSIBLE_CHOICES = {ROCK, PAPER, SCISSORS};

    public static RPS getRandomChoice(){
        return POSSIBLE_CHOICES[(int) (3 * Math.random())];
    }


    public static RPS getRandomChoice(RPS otherThanThisOne){
        ArrayList<RPS> otherChoices = new ArrayList<RPS>();
        for(RPS choice : POSSIBLE_CHOICES){
            if(!choice.equals(otherThanThisOne)){
                otherChoices.add(choice);
            }
        }
        return otherChoices.get((int) (2 * Math.random()));
    }

    public static boolean playerIsWinner(RPS playerChoice, RPS monsterChoice){
        
        if(playerChoice.equals(ROCK)){
            return monsterChoice.equals(SCISSORS);
        }
        if(playerChoice.equals(PAPER)){
            return monsterChoice.equals(ROCK);
        }
        if(playerChoice.equals(SCISSORS)){
            return monsterChoice.equals(PAPER);
        }
        return false;
        
    }

    public static RPS getBetterChoice(RPS choice){
        if(choice.equals(ROCK))
            return PAPER;
        if(choice.equals(PAPER))
            return SCISSORS;
        if(choice.equals(SCISSORS))
            return ROCK;
        return null;
    }

    public static RPS parseRPS(String s){
        if(s.equals("rock"))
            return ROCK;
        if(s.equals("paper"))
            return PAPER;
        if(s.equals("scissors"))
            return SCISSORS;
        return null;
    }

    public String toString(){
        if (this.equals(ROCK)){
            return "rock";
        }
        if (this.equals(PAPER)){
            return "paper";
        }
        if (this.equals(SCISSORS)){
            return "scissors";
        }
        return null;
    }

}

