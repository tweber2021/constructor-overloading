public class TimeOfDay {
    private int mhr;
    private int mmin;
    private int msec;
    private int mday;
    private int mmo;
    private int myr;

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

    public TimeOfDay(int myr, int mmo, int mday, int mhr, int mmin, int msec) {
        if(chkLegalityEx(myr,mmo,mday,mhr,mmin,msec)==true){
            set
            setMhr(mhr);
        }
        else{throw new IllegalArgumentException("Invalid Time: "+mmo+"."+mday+"."+myr+" "+mhr+":"+mmin+":"+msec);}
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

    public void setMday(int mday) {
        this.mday = mday;
    }

    public void setMmo(int mmo) {
        this.mmo = mmo;
    }

    public void setMyr(int myr) {
        this.myr = myr;
    }

    public void setMsec(int msec) {
        this.msec = msec;
    }

    public static boolean chkLegality(int hr, int min){
        if(hr<0||hr>23){return false;}
        if(min<0||min>59){return false;}
        return true;
    }

    public static boolean chkLegalityEx(int yr, int mo, int day, int hr, int min, int sec){
        if(yr<1970||yr>2037){return false;}
        if(mo<0||mo>12){return false;}
        if(day<0||day>31){return false;}
        if(hr<0||hr>23){return false;}
        if(min<0||min>59){return false;}
        if(sec<0||sec>59){return false;}
        return true;
    }
}
