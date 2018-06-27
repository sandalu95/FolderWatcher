package fileobserver;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers=new ArrayList<>();

    public void registerObserver(Observer ob){
        observers.add(ob);                                  //Add subscribers to the list
    }
    public void removeObserver(Observer ob){
        observers.remove(ob);                               //Remover subscribers from the list
    }
    public void notifyAllObservers(String filesDetails){
        for (Observer ob:observers) {
            ob.notifyme(filesDetails);                      //notify the subscribers
        }
    }
}
