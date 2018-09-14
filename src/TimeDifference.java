import java.util.*;
import java.time.*;

public class TimeDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Date-Time Calculator (Counting leap years and the like)\n");

        System.out.println("a. Year, Month, Day, Hour, Minute, Second");
        System.out.println("b. Year, Month, Day\n");
        System.out.print("Which configuration of time would you like to use? ");
        boolean param = inBool(sc);

        System.out.println("- Time A -");
        TimeOfDay A = promptTime(sc,param);
        System.out.println("- Time B -");
        TimeOfDay B = promptTime(sc,param);
        System.out.println();
        // System.out.println("There are "+timeDiff(A,B)+" seconds between times A and B.");
        TimeOfDay X = msConvert(timeDiff(A,B));
        System.out.println("Time between Time A and Time B:");
        System.out.print(X.getMyr()+" years, ");
        System.out.print(X.getMmo()+" months, ");
        System.out.print(X.getMday()+" days, ");
        System.out.print(X.getMhr()+" hours, ");
        System.out.print(X.getMmin()+" minutes, ");
        System.out.print(X.getMsec()+" seconds.");
        sc.close();
    }

    // ------------------------------------------------------------------------------------------------------- //

    static int in(String prompt, Scanner sc) { // fetches an integer based on a prompt
        System.out.print("Enter the "+prompt+". ");
        int s = sc.nextInt();
        return s;
    }

    static boolean inBool(Scanner sc) { // fetches a boolean value based on letter; a = 0, b = 1
        String chr = sc.next();
        boolean b;
        if(chr.equals("a")){b=false;}
        else if(chr.equals("b")){b=true;}
        else{throw new IllegalArgumentException("Inputted character is '"+chr+"', not 'a' or 'b'.");}
        return b;
    }

    static TimeOfDay promptTime(Scanner sc,boolean param){
        boolean input = false;
        TimeOfDay X = null;
        while(!input){
            int tyr = in("year",sc);
            int tmo = in("month",sc);
            int tday = in("day",sc);
            int thr=0;
            int tmin=0;
            int tsec=0;
            if(!param) {
                thr = in("hour (military)", sc);
                tmin = in("minute", sc);
                tsec = in("second", sc);
            }
            if(param){
                if(TimeOfDay.chkLegality(tyr,tmo,tday,thr,tmin,tsec)){
                    X = new TimeOfDay(tyr,tmo,tday,thr,tmin,tsec);
                    input=true;
                }
                else{
                    System.err.println("Invalid Parameters: "+TimeOfDay.invalidParamString(TimeOfDay.chkLegalityEx(tyr,tmo,tday,thr,tmin,tsec)));
                }
            }
            else {
                if (TimeOfDay.chkLegality(tyr, tmo, tday)) {
                    X = new TimeOfDay(tyr, tmo, tday);
                    input = true;
                } else {
                    System.err.println("Invalid Parameters: "+TimeOfDay.invalidParamString(TimeOfDay.chkLegalityEx(tyr,tmo,tday,thr,tmin,tsec)));
                }
            }
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