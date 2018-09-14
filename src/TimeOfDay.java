public class TimeOfDay {
    private int mhr;
    private int mmin;
    private int msec;
    private int mday;
    private int mmo;
    private int myr;

    public TimeOfDay(int myr, int mmo, int mday, int mhr, int mmin, int msec) {
        if(chkLegality(myr,mmo,mday,mhr,mmin,msec)==true){
            setMmin(mmin);
            setMhr(mhr);
            setMsec(msec);
            setMday(mday);
            setMmo(mmo);
            setMyr(myr);
        }
        else{throw new IllegalArgumentException("Invalid Time: "+mmo+"."+mday+"."+myr+" "+mhr+":"+mmin+":"+msec);}
    }

    public TimeOfDay(int myr, int mmo, int mday) {
        if(chkLegality(myr,mmo,mday)==true){
            setMday(mday);
            setMmo(mmo);
            setMyr(myr);
        }
        else{throw new IllegalArgumentException("Invalid Time: "+mmo+"."+mday+"."+myr);}
    }

    public TimeOfDay(int mhr, int mmin) {
        if(chkLegality(mhr,mmin)==true){
            setMday(mday);
            setMmo(mmo);
            setMyr(myr);
        }
        else{throw new IllegalArgumentException("Invalid Time: "+mmo+"."+mday+"."+myr);}
    }

    public int getMhr() {
        return mhr;
    }

    public int getMmin() {
        return mmin;
    }

    public int getMsec() {
        return msec;
    }

    public int getMday() {
        return mday;
    }

    public int getMmo() {
        return mmo;
    }

    public int getMyr() {
        return myr;
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

    public static boolean[] chkLegalityEx(int yr, int mo, int day, int hr, int min, int sec){
        boolean legal[] = new boolean[5];
        if(mo<0||mo>12){legal[0]=true;}
        if(day<0||day>31){legal[1]=true;}
        if(hr<0||hr>23){legal[2]=true;}
        if(min<0||min>59){legal[3]=true;}
        if(sec<0||sec>59){legal[4]=true;}
        return legal;
    }

    public static boolean[] chkLegalityEx(int yr, int mo, int day){
        boolean legal[] = new boolean[5];
        if(mo<0||mo>12){legal[0]=true;}
        if(day<0||day>31){legal[1]=true;}
        return legal;
    }

    public static boolean chkLegality(int yr, int mo, int day, int hr, int min, int sec){
        boolean chk[] = chkLegalityEx(yr,mo,day,hr,min,sec);
        boolean legality = true;
        for(int i=0;i<5;i++){
            if(chk[i]){
                legality=false;
            }
        }
        return legality;
    }

    public static boolean chkLegality(int yr, int mo, int day){
        boolean chk[] = chkLegalityEx(yr,mo,day);
        boolean legality = true;
        for(int i=0;i<5;i++){
            if(chk[i]){
                legality=false;
            }
        }
        return legality;
    }

    public static boolean chkLegality(int hr, int min){
        boolean chk[] = chkLegalityEx(2000,1,1,hr,min,0);
        boolean legality = true;
        for(int i=0;i<5;i++){
            if(chk[i]){
                legality=false;
            }
        }
        return legality;
    }

    public static String invalidParamString(boolean[] legality){
        String inv = "";
        if(legality[0]){inv=inv+"month ";}
        if(legality[1]){inv=inv+"day ";}
        if(legality[2]){inv=inv+"hour ";}
        if(legality[3]){inv=inv+"minute ";}
        if(legality[4]){inv=inv+"second ";}
        return inv;
    }
}
