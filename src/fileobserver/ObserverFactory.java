package fileobserver;

public class ObserverFactory {
    public ObserverFactory(String ob){
        ObserverFactory factory;
        switch (ob){
            case "a":
                factory=new ObserverFactory("a");
                break;
            case "b":
                factory=new ObserverFactory("b");
                break;
            case "c":
                factory=new ObserverFactory("c");
                break;
        }
    }
}
