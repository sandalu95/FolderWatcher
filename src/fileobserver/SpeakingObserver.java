package fileobserver;

public class SpeakingObserver implements Observer{

    @Override
    public void notifyme(String filesDetails) {
        System.out.println("I'm speaking : "+filesDetails+"\n");     //Print the file changes as speaking
    }
}
