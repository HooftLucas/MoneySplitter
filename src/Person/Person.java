package Person;

import diffTicket.Ticket;

public class Person {

    String Name;
    double Amount;
    double Cost;


    public Person(String Name, double Amount, double Cost){
    this.Name = Name;
    this.Amount = Amount;
    this.Cost = Cost;
    }

    public Person(String Name){
        this.Name = Name;
        this.Amount = 0.0;
        this.Cost = 0.0;
    }

    public Person(Person person) {
        this.Name = person.Name;
        this.Amount = person.Amount;
        this.Cost = person.Cost;
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


    @Override
    public String toString() {
        return "Name='" + Name + '\'' +
                ", Amount=" + Amount +
                ", Cost=" + Cost;
    }
}
