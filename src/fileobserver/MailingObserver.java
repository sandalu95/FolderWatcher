package fileobserver;

public class MailingObserver implements Observer{

    @Override
    public void notifyme(String filesDetails) {
        System.out.println("I'm mailing : "+filesDetails+"\n");     //Print the file changes as mailing
    }
}
