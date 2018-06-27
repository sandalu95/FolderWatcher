package fileobserver;

public class ObserverFactory {
    Observer observer;

    public Observer getObserver(String ob){
        switch (ob){                                    //To check the ob parameter and create relevant observer object
            case "a":
                observer=new MailingObserver();
                break;
            case "b":
                observer=new PrintingObserver();
                break;
            case "c":
                observer=new SpeakingObserver();
                break;
        }
        return this.observer;                           //Return the object of observer
    }
}
