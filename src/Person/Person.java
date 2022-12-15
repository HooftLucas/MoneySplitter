package Person;


public class Person {

    String Name;
    double Amount;
    double Cost;
    boolean doPay;




    public Person(String Name){
        this.Name = Name;
        this.Amount = 0.0;
        this.Cost = 0.0;
        this.doPay = true;
    }

    public Person(Person person) {
        this.Name = person.Name;
        this.Amount = person.Amount;
        this.Cost = person.Cost;
        this.doPay = person.doPay;
    }

    public Person(String Name, double Amount, double Cost,boolean doPay) {
        this.Name = Name;
        this.Amount = Amount;
        this.Cost = Cost;
        this.doPay = doPay;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public double getCost() {
        return Cost;
    }

    public void setCost(double cost) {
        Cost = cost;
    }

    public boolean isDoPay() {
        return doPay;
    }

    public void setDoPay(boolean doPay) {
        this.doPay = doPay;
    }

    @Override
    public String toString() {
        return "Name='" + Name + '\'' +
                ", Amount=" + Amount +
                ", Cost=" + Cost +
                ", doPay=" + doPay;
    }
}
