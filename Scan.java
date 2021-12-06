import java.util.Scanner;

public class Scan {

    Scanner scan;

    public Scan(){
        scan = new Scanner(System.in);
    }
    public Scanner getScanner(){
        return scan;
    }
    public String nextLine(){
        String s;
        while(true)
            try {
                s = scan.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Oops there was an error reading that. Can we try that again?");
                scan.next();
            } 
        return s.trim().toLowerCase();
    }
    //returns true if user says yes no if user says no
    public boolean yesOrNo(){
        while(true){
            String s = nextLine();
            if (s.equals("y") || s.equals("yes")){
                return true;
            }
            else if(s.equals("n") || s.equals("no")){
                return false;
            }
            else{
                //scan.next();
                System.out.println("THere was an error with your input. Please say \"y\" or \"yes\" for yes, or \"n\" or \"no\" for no");
            }
        }
    }
    public void close(){
        scan.close();
    }
}