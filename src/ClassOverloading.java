import java.util.Scanner;
public class ClassOverloading {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("How many hours?");
        int hr = sc.nextInt();
        System.out.println("How many minutes?");
        int min = sc.nextInt();
        TimeOfDay now = new TimeOfDay(hr,min);
        if(TimeOfDay.chkLegality(now.getMhr(),now.getMmin())){System.out.println(now.getMhr()+":"+now.getMmin());}
        else{System.out.println("This time is invalid.");}
    }
}
