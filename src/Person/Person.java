package Person;

public class Person {

    String Name;
    Boolean Paid;
    double Amount;
    double Cost;


    public Person(String Name, Boolean Paid, double Amount, double Cost){
    this.Name = Name;
    this.Paid = Paid;
    this.Amount = Amount;
    this.Cost = Cost;
    }
    public Person(String Name){
        this.Name = Name;
        this.Paid = Boolean.FALSE;
        this.Amount = 0.0;
        this.Cost = 0.0;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Boolean getPaid() {
        return Paid;
    }

    public void setPaid(Boolean paid) {
        Paid = paid;
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


    @Override
    public String toString() {
        return "Name='" + Name + '\'' +
                ", Paid=" + Paid +
                ", Amount=" + Amount +
                ", Cost=" + Cost;
    }
}
