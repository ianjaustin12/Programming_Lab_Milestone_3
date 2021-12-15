package Utils;
import java.util.Scanner;

public class Scan {

    private static Scanner theOneTrueScanner;

    public Scan(){
        if(theOneTrueScanner == null){
            theOneTrueScanner = new Scanner(System.in);
        }
    }


    public Scanner getScanner(){
        return theOneTrueScanner;
    }



}