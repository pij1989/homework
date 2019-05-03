package ru.pij.dimon.task22;

public class TimeInterval implements Comparable<TimeInterval>{
   private  int second;
   private  int minute;
   private int hour;
   private int commonSeconds;

    public TimeInterval(int hour, int minute, int second) {
        if ((hour<0 || hour>23) || (minute<0 || minute>59) || (second<0 || second>59)) throw new IllegalArgumentException("Error format of time. Hour must be in interval more then 0 less then 24, minutes and seconds must be in interval more then 0 less then 60");
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.commonSeconds = getCommonSeconds();
    }

    public TimeInterval(int commonSeconds) {
        this.commonSeconds = commonSeconds;
        convert(commonSeconds);
    }

    public int getCommonSeconds() {
        if(commonSeconds == 0){
            commonSeconds = second+60*(minute+hour*60);
        }
        return commonSeconds;
    }

    private void convert(int commonSeconds){
        second = commonSeconds%60;
        int m = (commonSeconds-second)/60;
        minute = m%60;
        hour = (m-minute)/60;
    }

    public int getSecond() {
        return second;
    }

    public int getMinute() {
        return minute;
    }

    public int getHour() {
        return hour;
    }

    @Override
    public int compareTo(TimeInterval o) {
        return commonSeconds - o.commonSeconds;
    }

    @Override
    public String toString() {
        String time;
        time = hour<10?"0"+hour+":":hour+":";
        time = minute<10?time+"0"+minute+":":time+minute+":";
        time = second<10?time+"0"+second:time+second;
        return "time interval: "+time;
    }
}
