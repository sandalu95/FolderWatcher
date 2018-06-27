package fileobserver;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String subscriber;                                                      //variable declaration for the subscriber's type
        String more;                                                            //variable declaration for adding more subscribers

        System.out.println("Whom do you need to add as subscribers ? : ");      //Allows to add subscribers on runtime
        System.out.println("Mailing  : a");
        System.out.println("Printing : b");
        System.out.println("Speaking : c");

        Scanner scanner=new Scanner(System.in);                                 //Scanner object created to get input

        ObserverFactory factory = new ObserverFactory();                        //ObserverFactory object created

        Subject subject=new Subject();                                          //Subject object created

        do{
            System.out.print("Add subscriber character : ");
            subscriber=scanner.next();                                          //Get the inputs for subscribers
            subject.registerObserver(factory.getObserver(subscriber));          //Get the observer objects which was added as subscribers and add to subscriber list in subject
            System.out.println("Need to add more..(y/n)");
            more=scanner.next();                                                //Get the input to check whether user need to add more/not
        }while(more.equals("y"));

        System.out.println("Enter the file path below : ");
        String path=scanner.next();                                             //Get the input for the path of directory


        while(true){
            Watcher watcher=new Watcher();                                      //Watcher object created
            String filesAffected[] = watcher.getFileAffected(path);             //Get the returned array of the files affected in directory
            String filesDetails = filesAffected[0] + "\n" + filesAffected[1];   //Converted to a string
            subject.notifyAllObservers(filesDetails);                           //Call notifyAllObservers in subject
        }

    }
}
