package fileobserver;

public class PrintingObserver implements Observer{

    @Override
    public void notifyme(String filesDetails) {
        System.out.println("I'm printing : "+filesDetails+"\n");
    }
}
