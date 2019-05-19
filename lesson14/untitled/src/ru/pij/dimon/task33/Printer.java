package ru.pij.dimon.task33;

import java.io.File;
import java.util.Iterator;
import java.util.List;

public class Printer implements Runnable {

    private Buffer buffer;
    private List<File> files;

    public Printer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
            while (true) {
                files = buffer.getListOfFileAndDirectory();
                if (files != null){
                    print(files);
                } else {
                    return;
                }
            }
    }

    private void print(List<File> list) {
        if(list == null || list.size() == 0){
            return;
        }
        if(list.get(0).isDirectory()){
            System.out.println("Directories: ");
        }else {
            System.out.println("Files: ");
        }
        Iterator<File> iterator = list.iterator();
        File file;
        while (iterator.hasNext()){
            file =iterator.next();
            if(file != null){
                System.out.println(file.getName());
            }
        }
        System.out.println();
    }
}
