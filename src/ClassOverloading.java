import java.util.Scanner;
public class ClassOverloading {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean done = false;
        while(!done){
        System.out.println("How many hours?");
        int hr = sc.nextInt();
        System.out.println("How many minutes?");
        int min = sc.nextInt();
        if(TimeOfDay.chkLegality(hr,min)) {
            try {
                TimeOfDay now = new TimeOfDay(hr, min);
                System.out.println(now.getMhr() + ":" + now.getMmin());
                done=true;
              }
            catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
              }
         }
        else{System.out.println("Invalid time.");}
      }
    }
}
