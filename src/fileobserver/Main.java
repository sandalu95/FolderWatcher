package fileobserver;

import java.util.Scanner;

public class Main {

    private static String more;

    public static void main(String[] args) {

        System.out.println("Whom do you need to add as subscribers : ");
        System.out.println("Mailing  : a");
        System.out.println("Printing : b");
        System.out.println("Speaking : c");

        Scanner scanner=new Scanner(System.in);
        String ob;
        int i=0;
        do {
            ob=scanner.next();
            ObserverFactory factory=new ObserverFactory(ob);
            System.out.println("Need to add more..(y/n)");
            String more=scanner.next();
            i++;
        }while(more=="y");



        Observer observer1=new MailingObserver();
        Observer observer2=new PrintingObserver();
        Observer observer3=new SpeakingObserver();

        Subject subject=new Subject();

        subject.registerObserver(observer1);
        subject.registerObserver(observer2);
        subject.registerObserver(observer3);

        System.out.println("Enter the file path below : ");
        String path=scanner.next();
        scanner.close();

        while(true){
            Watcher watcher=new Watcher();
            String filesAffected[] = watcher.getFileAffected(path);
            String filesDetails = filesAffected[0] + "\n" + filesAffected[1];
            subject.notifyAllObservers(filesDetails);
        }

    }
}
