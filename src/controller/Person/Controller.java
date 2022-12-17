package controller.Person;

public interface Controller {
    void addNameToDatabase(String name);
    void deleteNameFromDatabase(String name);
    void setPersonForTicket(int id, double Amount, double Cost, boolean participate);

    void NotifyObserver(String name, boolean addOrDel);
}
