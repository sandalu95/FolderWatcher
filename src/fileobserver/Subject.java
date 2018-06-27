package fileobserver;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers=new ArrayList<>();

    public void registerObserver(Observer ob){
        observers.add(ob);
    }
    public void removeObserver(Observer ob){
        observers.remove(ob);
    }
    public void notifyAllObservers(String filesDetails){

        for (Observer ob:observers) {
            ob.notifyme(filesDetails);
        }
    }
}
