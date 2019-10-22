package ba.unsa.etf.rpr.tutorijal02;

public class Interval {

private double pocetnaTacka;
private double krajnjaTacka;
private boolean pripadaIntervalu1;
private boolean pripadaIntervalu2;

    public Interval(double pocetnaTacka, double krajnjaTacka, boolean pripadaIntervalu1, boolean pripadaIntervalu2) {
        if(pocetnaTacka>krajnjaTacka) throw  new IllegalArgumentException ("Parametar ne valja");
        this.pocetnaTacka = pocetnaTacka;
        this.krajnjaTacka = krajnjaTacka;
        this.pripadaIntervalu1 = pripadaIntervalu1;
        this.pripadaIntervalu2 = pripadaIntervalu2;
    }
    public Interval(){
        pocetnaTacka=krajnjaTacka=0;
        pripadaIntervalu1=pripadaIntervalu2=false;
    }
    boolean isNull(){
        if(this.pocetnaTacka==this.krajnjaTacka) return  true;
        return false;
    }
    boolean isIn(double tacka){
        if(tacka>=pocetnaTacka && tacka<=krajnjaTacka && pripadaIntervalu1==true && pripadaIntervalu2==true) return  true;
        if(tacka>=pocetnaTacka && tacka<krajnjaTacka && pripadaIntervalu1==true && pripadaIntervalu2==false) return  true;
        if(tacka>pocetnaTacka && tacka<=krajnjaTacka && pripadaIntervalu1==false && pripadaIntervalu2==true) return  true;
        if(tacka>pocetnaTacka && tacka<=krajnjaTacka && pripadaIntervalu1==false && pripadaIntervalu2==false) return  true;
        return false;
    }
    public static Interval intersect(Interval interval1, Interval interval2){
        Interval interval=new Interval();
        if(interval2.pocetnaTacka<=interval1.krajnjaTacka){
            interval.pocetnaTacka=interval2.pocetnaTacka;
            interval.pripadaIntervalu1=interval2.pripadaIntervalu1;
        }
        if(interval2.krajnjaTacka<=interval1.krajnjaTacka){
            interval.krajnjaTacka=interval2.krajnjaTacka;
            interval.pripadaIntervalu2=interval2.pripadaIntervalu2;
        }
        else if(interval1.krajnjaTacka<=interval2.krajnjaTacka){
            interval.krajnjaTacka=interval1.krajnjaTacka;
            interval.pripadaIntervalu2=interval1.pripadaIntervalu2;
        }
        return interval;
    }
    public Interval intersect(Interval interval1){
        Interval interval=new Interval();
        if(interval1.pocetnaTacka<=this.krajnjaTacka){
            interval.pocetnaTacka=interval1.pocetnaTacka;
            interval.pripadaIntervalu1=interval1.pripadaIntervalu1;
        }
        if(this.krajnjaTacka<=interval1.krajnjaTacka){
            interval.krajnjaTacka=this.krajnjaTacka;
            interval.pripadaIntervalu2=this.pripadaIntervalu2;
        }
        else if(interval1.krajnjaTacka<=this.krajnjaTacka){
            interval.krajnjaTacka=interval1.krajnjaTacka;
            interval.pripadaIntervalu2=interval1.pripadaIntervalu2;
        }
        return interval;
    }

    @Override
    public String toString() {
        if(pripadaIntervalu1==true && pripadaIntervalu2==true)
            return "["+pocetnaTacka +
                    "," + krajnjaTacka +
                    "]";
        if(pripadaIntervalu1==true && pripadaIntervalu2==false)
            return "["+pocetnaTacka +
                    "," + krajnjaTacka +
                    ")";
        if(pripadaIntervalu1==false && pripadaIntervalu2==true)
            return "("+pocetnaTacka +
                    "," + krajnjaTacka +
                    "]";
        if(pripadaIntervalu1==false && pripadaIntervalu2==false && pocetnaTacka!=0 && krajnjaTacka!=0)
            return "("+pocetnaTacka +
                    "," + krajnjaTacka +
                    ")";
        return "()";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Interval)) return false;
        Interval interval = (Interval) o;
        return Double.compare(interval.pocetnaTacka, pocetnaTacka) == 0 &&
                Double.compare(interval.krajnjaTacka, krajnjaTacka) == 0 &&
                pripadaIntervalu1 == interval.pripadaIntervalu1 &&
                pripadaIntervalu2 == interval.pripadaIntervalu2;
    }
}

