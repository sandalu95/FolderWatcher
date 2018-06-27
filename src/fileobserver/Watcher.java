package fileobserver;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Date;
import static java.nio.file.StandardWatchEventKinds.*;

public class Watcher {

    public String[] getFileAffected(String path){

        String details[]=new String[2];

        try {
            WatchService watchService
                    = FileSystems.getDefault().newWatchService();
            File dir = new File(path);
            Path p = dir.toPath();
            WatchKey key;
            key=p.register(
                    watchService,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);

            details[0]="The directory was last modified on : "+new Date(dir.lastModified()).toString();

            key = watchService.take();
                for (WatchEvent<?> keyevent : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = keyevent.kind();
                    WatchEvent<Path> event = (WatchEvent<Path>) keyevent;
                    if(kind == OVERFLOW){
                        continue;
                    }
                    if(kind == ENTRY_CREATE){
                        details[1]="New File/Folder Created in the directory : "+event.context().toString();
                    }
                    if(kind == ENTRY_MODIFY){
                        details[1]="File/Folder in the directory was modified : "+event.context().toString();
                    }
                    if(kind == ENTRY_DELETE){
                        details[1]="File/Folder was Deleted from the directory : "+event.context().toString();
                    }
                }

        }

        catch (IOException e) {
            e.printStackTrace();
        }

        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return details;
    }
}
