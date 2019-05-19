package ru.pij.dimon.task33;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Buffer {

    private int capasityBuffer = 5;

    private List<List<File>> buffer = new ArrayList<>(capasityBuffer);
    private List<Thread> threadList = new ArrayList<>();

    public void searchFileAndDirectory(String pathName) {
        List<File> filesList = new ArrayList<>();
        List<File> directoryList = new ArrayList<>();
        File file = new File(pathName);
        File[] files = file.listFiles();
        if (files == null) {
//            System.out.println("Error");
            return;
        }
        for (File file1 : files) {
            if (file1 != null) {
                if (file1.isDirectory()) {
                    directoryList.add(file1);
                } else {
                    filesList.add(file1);
                }
            }
        }
        synchronized (this) {
            try {
                threadList.add(Thread.currentThread());
                while (buffer.size() == capasityBuffer) {
//                    System.out.println("Buffer is full. " + Thread.currentThread().getName() + " is waiting");
                    this.wait();
                }
                buffer.add(directoryList);
                buffer.add(filesList);
                threadList.remove(Thread.currentThread());
                notifyAll();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public List<File> getListOfFileAndDirectory() {
        List<File> filesList = null;
        synchronized (this) {
            try {
                while (buffer.size() == 0) {
                    if(threadList.size() != 0){
//                        System.out.println("Buffer is empty. " + Thread.currentThread().getName() + " is waiting");
                        this.wait();
                    } else{
                        Thread.sleep(2000);
                        if(threadList.size() != 0){
//                            System.out.println("Buffer is empty. " + Thread.currentThread().getName() + " is waiting");
                            this.wait();
                        }else {
                            System.out.println("Buffer is empty and all searcher is closed. " + Thread.currentThread().getName()+ " is finishing");
                            return  null;
                        }
                    }
                }
                filesList = buffer.remove(0);
                notifyAll();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return  filesList;
        }

    }
}