package ru.pij.dimon.task21;

public final class Test {
    public static float testString(String[]arrayString){
        String resultText = "";
        long time1 = System.nanoTime();
        for (String s:arrayString){
            resultText  = resultText+s+" ";
        }
        long time2 = System.nanoTime();
        return (float) Math.round((((float)(time2-time1)/1000000)*100))/100;
    }

    public static float testStringBuilder(String[]arrayString){
        StringBuilder stringBuilder = new StringBuilder();
        long time1 = System.nanoTime();
        for (String s:arrayString){
            stringBuilder.append(s);
            stringBuilder.append(" ");
        }
        long time2 = System.nanoTime();
        return (float) Math.round((((float)(time2-time1)/1000000)*1000))/1000;
    }

    public static float testStringBuffer(String[]arrayString){
        StringBuffer stringBuffer = new StringBuffer();
        long time1 = System.nanoTime();
        for (String s:arrayString){
            stringBuffer.append(s);
            stringBuffer.append(" ");
        }
        long time2 = System.nanoTime();
        return (float) Math.round((((float)(time2-time1)/1000000)*1000))/1000;
    }
}
