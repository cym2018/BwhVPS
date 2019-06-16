package xyz.cym2018.Tools;

import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Time_Cal {
    enum time{Year,Month,Day,Hour,Minute,Second}
    @SuppressLint("SimpleDateFormat")
    // 获取String格式时间
    public static String getSTime(time type,Long lNumber){
        Long lTime=System.currentTimeMillis()+lNumber;
        switch (type){
            case Year:
                return new SimpleDateFormat("yyyy").format(lTime);
            case Month:
                return new SimpleDateFormat("MM").format(lTime);
            case Day:
                return new SimpleDateFormat("dd").format(lTime);
            case Hour:
                return new SimpleDateFormat("HH").format(lTime);
            case Minute:
                return new SimpleDateFormat("mm").format(lTime);
            case Second:
                return new SimpleDateFormat("ss").format(lTime);
        }
        return "0";
    }
    // 获取int格式时间
    public static int getITime(time type,Long lNumber){
        return Integer.parseInt(getSTime(type,lNumber));
    }
    // 获取当前时间戳
    public static long getNowLongTime(){
        return System.currentTimeMillis();
    }
    // 获取下一个时间戳
    public static long getNextLongTime(int hour, int minutes, int second){
        Calendar calendar=Calendar.getInstance();
        calendar.set(getITime(time.Year, (long) 0),getITime(time.Month, (long) 0)- 1,getITime(time.Day, (long) 0),hour,minutes,second);
        if(getNowLongTime()>calendar.getTimeInMillis()){
            return calendar.getTimeInMillis()+24*60*60*1000;
        }
        return calendar.getTimeInMillis();
    }
    // 获取当前String格式时间
    @SuppressLint("SimpleDateFormat")
    public static String getNowStringTime(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis());
    }
    // 获取下一个String格式wec时间
    @SuppressLint("SimpleDateFormat")
    public static String getNextStringTime(int hour, int minutes, int second){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(getNextLongTime(hour, minutes, second));
    }
    // 获取明天日期
    public static String getNextDate(){
        return getSTime(time.Year, (long) (24*60*60*1000))+"-"+getSTime(time.Month, (long) (24*60*60*1000))+"-"+(getSTime(time.Day, (long) (24*60*60*1000)));
    }
    // 获取String时间
    public static String getStringDate(long longTime){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(longTime);
    }
}
