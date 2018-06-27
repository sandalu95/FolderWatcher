package fileobserver;

public class SpeakingObserver implements Observer{

    @Override
    public void notifyme(String filesDetails) {
        System.out.println("I'm telling : "+filesDetails+"\n");
    }
}
