package fileobserver;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Date;
import static java.nio.file.StandardWatchEventKinds.*;

public class Watcher {

    public String[] getFileAffected(String path){

        String details[]=new String[2];                                                                        //Declared a string array to get the last modified date and changed file info

        try {
            WatchService watchService
                    = FileSystems.getDefault().newWatchService();                                              //Create Watchservice object
            File dir = new File(path);
            Path p = dir.toPath();                                                                             //Convert the file to a path
            WatchKey key;
            key=p.register(                                                                                    //Register the path with watch service
                    watchService,
                    StandardWatchEventKinds.ENTRY_CREATE,                                                      //Define the kind of events have to be observed
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);

            details[0]="The directory was last modified on : "+new Date(dir.lastModified()).toString();        //Get the last modified date of the directory

            key = watchService.take();                                                                         //To block till an event occur
                for (WatchEvent<?> event : key.pollEvents()) {                                                 //Check the changes in the directory
                    WatchEvent.Kind<?> kind = event.kind();                                                    //Get the type of change occured

                    if(kind == OVERFLOW){                                                                      //When a lost or discarded event occured
                        continue;
                    }
                    if(kind == ENTRY_CREATE){                                                                  //When a new entry is made
                    }
                    if(kind == ENTRY_MODIFY){                                                                  //When an existing entry modified
                        details[1]="File/Folder in the directory modified : "+event.context().toString();
                    }
                    if(kind == ENTRY_DELETE){                                                                  //When an existing entry deleted
                        details[1]="File/Folder Deleted from the directory : "+event.context().toString();
                    }
                }

        }

        catch (IOException e) {                                                                                //Handle the IOException
            e.printStackTrace();
        }

        catch (InterruptedException e) {                                                                       //Handle the InterruptedException
            e.printStackTrace();
        }
        return details;                                                                                        //Return the details of changes
    }
}
