package Person;


public class Person {

    String name;
    double amount;
    double cost;
    boolean participate;


    public Person(String name){
        this.name = name;
        this.amount = 0.0;
        this.cost = 0.0;
        this.participate = true;
    }

    public Person(Person person) {
        this.name = person.name;
        this.amount = person.amount;
        this.cost = person.cost;
        this.participate = person.participate;
    }

    public Person(String name, double amount, double cost) {
        this.name = name;
        this.amount = amount;
        this.cost = cost;
        this.participate = true;
    }

    public Person(String name, double amount, double cost,boolean participate) {
        this.name = name;
        this.amount = amount;
        this.cost = cost;
        this.participate = participate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean isParticipate() {
        return participate;
    }

    public void setParticipate(boolean participate) {
        this.participate = participate;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", amount=" + amount +
                ", cost=" + cost +
                ", part=" + participate;
    }
}
