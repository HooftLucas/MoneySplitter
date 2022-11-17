package Person;

public class Person {

    String Name;
    Boolean Betaald;
    double Bedrag;
    double Kosten;
    public Person(String Name, Boolean Betaald, double Bedrag, double Kosten){

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Boolean getBetaald() {
        return Betaald;
    }

    public void setBetaald(Boolean betaald) {
        Betaald = betaald;
    }

    public double getBedrag() {
        return Bedrag;
    }

    public void setBedrag(double bedrag) {
        Bedrag = bedrag;
    }

    public double getKosten() {
        return Kosten;
    }

    public void setKosten(double kosten) {
        Kosten = kosten;
    }
}
