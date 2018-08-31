import java.util.Scanner;
public class ClassOverloading {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("How many hours?");
        int hr = sc.nextInt();
        System.out.println("How many minutes?");
        try {
            int min = sc.nextInt();
            TimeOfDay now = new TimeOfDay(hr, min);
            System.out.println(now.getMhr() + ":" + now.getMmin());
        }
        catch(IllegalArgumentException e){
            System.err.println(e.getMessage());
        }
    }
}
