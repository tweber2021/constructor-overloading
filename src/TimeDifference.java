import java.util.*;
import java.time.*;

public class TimeDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("- Time A -");
        TimeOfDay A = promptTime(sc);
        System.out.println("- Time B -");
        TimeOfDay B = promptTime(sc);
        System.out.println("There are "+timeDiff(A,B)+" seconds between times A and B.");
        TimeOfDay X = msConvert(timeDiff(A,B));
        System.out.println("Time between Time A and Time B:\n");
        System.out.println(X.getMyr()+" years");
        System.out.println(X.getMmo()+" months");
        System.out.println(X.getMday()+" days");
        System.out.println(X.getMhr()+" hours");
        System.out.println(X.getMmin()+" minutes");
        System.out.println(X.getMsec()+" seconds");
        sc.close();
    }

    // ------------------------------------------------------------------------------------------------------- //

    static int in(String prompt, Scanner sc) { // fetches an integer based on a prompt
        System.out.print("Enter the "+prompt+". ");
        int s = sc.nextInt();
        return s;
    }

    static TimeOfDay promptTime(Scanner sc){
        boolean input = false;
        TimeOfDay X = null;
        while (!input) {
            int tyr = in("year",sc);
            int tmo = in("month",sc);
            int tday = in("day",sc);
            int thr = in("hour (military)",sc);
            int tmin = in("minute",sc);
            int tsec = in("second",sc);
            if(TimeOfDay.chkLegalityEx(tyr,tmo,tday,thr,tmin,tsec)){
                X = new TimeOfDay(tyr,tmo,tday,thr,tmin,tsec);
                input=true;
            }
            else{System.err.println("Invalid Time. Try again.");}
        }
        return X;
    }

    static long timeDiff(TimeOfDay A, TimeOfDay B){
        long result;
        LocalDateTime DateA = LocalDateTime.of(A.getMyr(),A.getMmo(),A.getMday(),A.getMhr(),A.getMmin(),A.getMsec());
        long Am = DateA.toEpochSecond(ZoneOffset.UTC);
        LocalDateTime DateB = LocalDateTime.of(B.getMyr(),B.getMmo(),B.getMday(),B.getMhr(),B.getMmin(),B.getMsec());
        long Bm = DateB.toEpochSecond(ZoneOffset.UTC);
        result = (Math.abs(Am-Bm));
        return result;
    }

    /*
    static TimeOfDay msConvert0(long timestamp){
        LocalDateTime D = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), TimeZone.getDefault().toZoneId());
        TimeOfDay result = new TimeOfDay((D.getYear()-1969),D.getMonthValue()-12,D.getDayOfMonth()-31,D.getHour()-19,D.getMinute(),D.getSecond());
        return result;
    }
    */

    static TimeOfDay msConvert(long timestamp){
        long remainder=timestamp; // for classification purposes

        int yr=(int)(Math.floor((double)(remainder/31536000)));
        remainder = remainder % 31536000;
        int mo=(int)(Math.floor((double)(remainder/2592000)));
        remainder = remainder % 2592000;
        int day=(int)(Math.floor((double)(remainder/86400)));
        remainder = remainder % 86400;
        int hr=(int)(Math.floor((double)(remainder/3600)));
        remainder = remainder % 3600;
        int min=(int)(Math.floor((double)(remainder/60)));
        remainder = remainder % 60;
        TimeOfDay result = new TimeOfDay(yr,mo,day,hr,min,(int)(remainder));

        return result;
    }
}