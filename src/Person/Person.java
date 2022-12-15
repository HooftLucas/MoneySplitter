package Person;


public class Person {

    String Name;
    int IDCode;
    double Amount;
    double Cost;




    public Person(String Name, int IDCode ){
        this.Name = Name;
        this.IDCode = IDCode;
        this.Amount = 0.0;
        this.Cost = 0.0;
    }

    public Person(Person person) {
        this.Name = person.Name;
        this.Amount = person.Amount;
        this.Cost = person.Cost;
    }

    public int getIDCode() {
        return IDCode;
    }

    public void setIDCode(int IDCode) {
        this.IDCode = IDCode;
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
