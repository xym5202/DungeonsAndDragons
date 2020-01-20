package KnightAndDragon.util;

public class TimeSleep {
    //时间间隔
    public static void timeSleep(int time){
        try {
            Thread.sleep(time);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
