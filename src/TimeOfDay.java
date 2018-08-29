public class TimeOfDay {
    private int mhr;
    private int mmin;

    public TimeOfDay(int mhr) {
        if(chkLegality(mhr,0)==true){
            this.mhr=mhr;
            this.mmin=0;
        }
        else{System.err.println("Invalid minute.");}
    }

    public TimeOfDay(int mhr, int mmin) {
        if(chkLegality(mhr,mmin)==true){
            this.mhr = mhr;
            this.mmin = mmin;
        }
        else{System.err.println("Invalid time.");}
    }

    public TimeOfDay() {
        this(0,0); // already legal
    }

    public int getMhr() {
        return mhr;
    }

    public int getMmin() {
        return mmin;
    }

    public static boolean chkLegality(int hr, int min){
        if(hr<0||hr>23){return false;}
        if(min<0||min>59){return false;}
        return true;
    }
}
