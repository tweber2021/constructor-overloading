public class TimeOfDay {
    private int mhr;
    private int mmin;

    public TimeOfDay(int mhr) {
        if(chkLegality(mhr,0)==true){
            this.mhr=mhr;
            this.mmin=0;
        }
        else{throw new IllegalArgumentException("Invalid hour: "+mhr);}
    }

    public TimeOfDay(int mhr, int mmin) {
        if(chkLegality(mhr,0)==true){
            setMhr(mhr);
        }
        else{throw new IllegalArgumentException("Invalid hour: "+mhr);}
        if(chkLegality(0,mmin)==true){
            setMmin(mmin);
        }
        else{throw new IllegalArgumentException("Invalid minute: "+mmin);}
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

    public void setMhr(int mhr) {
        this.mhr = mhr;
    }

    public void setMmin(int mmin) {
        this.mmin = mmin;
    }

    public static boolean chkLegality(int hr, int min){
        if(hr<0||hr>23){return false;}
        if(min<0||min>59){return false;}
        return true;
    }
}
