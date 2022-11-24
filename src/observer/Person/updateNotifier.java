package observer.Person;

import java.util.Observable;
import java.util.Observer;

public class updateNotifier implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Person Database got updated");
    }
}
