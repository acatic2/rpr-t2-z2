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
        if(tacka>=pocetnaTacka && tacka<=krajnjaTacka) return  true;
        return false;
    }
    public Interval intersect(Interval interval1, Interval interval2){
        
    }
}
