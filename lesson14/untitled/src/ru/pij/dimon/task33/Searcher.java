package ru.pij.dimon.task33;

public class Searcher implements Runnable {


    private String pathName;
    private Buffer buffer;

    public Searcher(String pathName, Buffer buffer) {
        this.pathName = pathName;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.searchFileAndDirectory(pathName);
    }

}
