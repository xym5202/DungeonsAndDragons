package KnightAndDragon.Effect;

import KnightAndDragon.Bean.Addition.Status;
import KnightAndDragon.Bean.Object.Knight;
import KnightAndDragon.util.TimeSleep;

import java.lang.reflect.Method;

public class BuffEffect  implements Runnable {

    static {
        buffEffect = new BuffEffect();
    }

    private static BuffEffect buffEffect;

    //持续时间
    private static volatile int time;

    //状态
    private static volatile Status status;


    private BuffEffect() {
    }

    public static BuffEffect getInstance() {
        return buffEffect;
    }

    public static Status getStatus() {
        return status;
    }

    public static void setStatus(Status status) {
        BuffEffect.status = status;
    }

    public int getTime() {
        return time;
    }

    public static void setTime(int time) {
        BuffEffect.time = time;
    }


    /**
     * 101-105.恢复状态
     *
     * @param knight
     */
    @Effect(startNum = "101",endNum = "105")
    public static void healing(Knight knight, int time, int flag, int level) {
            int count = time;
            int a = (int) (Math.random() * 6 + 1);
            switch (a) {
                case 1:
                    System.out.println(knight.getKnightName() + "恢复头部生命，持续"+time+"s");
                    while (count > 0) {
                        knight.setHead((knight.getHead() +  2*level )<= Knight.getHeadSum() ? knight.getHead() + 2*level: Knight.getHeadSum());

                        count--;
                        TimeSleep.timeSleep(1000);
                    }
                    break;
                case 2:
                    System.out.println(knight.getKnightName() + "恢复左臂生命，持续"+time+"s");
                    while (count > 0) {
                        knight.setArmLeft((knight.getArmLeft() + 2*level) <= Knight.getArmLeftSum() ? knight.getArmLeft() +2*level : Knight.getArmLeftSum());
                        count--;
                        TimeSleep.timeSleep(1000);
                    }
                    break;
                case 3:
                    System.out.println(knight.getKnightName() + "恢复右臂生命，持续"+time+"s");
                    while (count > 0) {
                        knight.setArmRight(knight.getArmRight() +  2*level <= Knight.getArmRightSum() ? knight.getArmRight() + 2*level  : Knight.getArmRightSum());
                        count--;
                        TimeSleep.timeSleep(1000);
                    }
                    break;
                case 4:
                    System.out.println(knight.getKnightName() + "恢复左腿生命，持续"+time+"s");
                    while (count > 0) {
                        knight.setLegLeft(knight.getLegLeft() +  2*level <= Knight.getLegLeftSum() ? knight.getLegLeft() + 2*level : Knight.getLegLeftSum());
                        count--;
                        TimeSleep.timeSleep(1000);
                    }
                    break;
                case 5:
                    System.out.println(knight.getKnightName() + "恢复右腿生命，持续"+time+"s");
                    while (count > 0) {
                        knight.setLegRight(knight.getLegRight() +  2*level <= Knight.getLegRightSum() ? knight.getLegRight() + 2*level : Knight.getLegRightSum());
                        count--;
                        TimeSleep.timeSleep(1000);
                    }
                    break;
                case 6:
                    System.out.println(knight.getKnightName() + "恢复身体生命，持续"+time+"s");
                    while (count > 0) {
                        knight.setBody(knight.getBody() +  2*level <= Knight.getBodySum() ? knight.getBody() + 2*level: Knight.getBodySum());
                        count--;
                        TimeSleep.timeSleep(1000);
                    }
                    break;

            }
    }

    /**
     * 106-108.治疗状态
     */
    @Effect(startNum = "106",endNum = "108")
    public static void cure(Knight knight, int time, int flag, int level) {
        System.out.println(knight.getKnightName() + "受到治疗,整体血量+"+(5*level+5));
        knight.setHead(knight.getHead() + 5 * level + 5 <= Knight.getHeadSum() ? knight.getHead() + 5 * level + 5 : Knight.getHeadSum());
        knight.setArmLeft(knight.getArmLeft() + 5 * level + 5 <= Knight.getArmLeftSum() ? knight.getArmLeft() + 5 * level + 5 : Knight.getArmLeftSum());
        knight.setArmRight(knight.getArmRight() + 5 * level + 5 <= Knight.getArmRightSum() ? knight.getArmRight() + 5 * level + 5 : Knight.getArmRightSum());
        knight.setLegLeft(knight.getLegLeft() + 5 * level + 5 <= Knight.getLegLeftSum() ? knight.getLegLeft() + 5 * level + 5 : Knight.getLegLeftSum());
        knight.setLegRight(knight.getLegRight() + 5 * level + 5 <= Knight.getLegRightSum() ? knight.getLegRight() + 5 * level + 5 : Knight.getLegRightSum());
        knight.setBody(knight.getBody() + 5 * level + 5 <= Knight.getBodySum() ? knight.getBody() + 5 * level + 5 : Knight.getBodySum());
        TimeSleep.timeSleep(1000);
    }

    /**
     * 痊愈状态
     *
     * @param knight
     * @param time
     * @param flag
     * @param level
     */
    @Effect(startNum = "109",endNum = "109")
    public static void recovery(Knight knight, int time, int flag, int level) {
        System.out.println(knight.getKnightName() + "痊愈");
        knight.setHead(Knight.getHeadSum());
        knight.setArmLeft(Knight.getArmLeftSum());
        knight.setArmRight(Knight.getArmRightSum());
        knight.setLegLeft(Knight.getLegLeftSum());
        knight.setLegRight(Knight.getLegRightSum());
        knight.setBody(Knight.getBodySum());
        TimeSleep.timeSleep(1000);
    }

    /**
     * 110-112.力量状态
     */
    @Effect(startNum = "110",endNum = "112")
    public static void power(Knight knight, int time, int flag, int level) {
        synchronized (status) {
            System.out.println(knight.getKnightName() + "增加了" + 5* level + "点力量，持续"+time+"s");
            int count = time;
            int power = knight.getPower();
            knight.setPower(knight.getPower() + 5 * level);
            while (count > 0) {
                count--;
                TimeSleep.timeSleep(1000);
            }
            knight.setPower(power);
        }
    }


    /**
     * 113-115.回蓝状态
     */
    @Effect(startNum = "113",endNum = "115")
    public static void spirit(Knight knight, int time, int flag, int level) {
        System.out.println(knight.getKnightName() + "恢复了" + 30 * level);
        knight.setMana(knight.getMana() + 30 * level <= Knight.getManaSum() ? knight.getMana() + 30 * level : Knight.getManaSum());
    }

    /**
     * 116-118.魔力状态
     */
    @Effect(startNum = "116",endNum = "118")
    public static void Intelligence(Knight knight, int time, int flag, int level) {
        synchronized (status) {
            System.out.println(knight.getKnightName() + "增加了" + 5 * level + "点智力，持续"+time+"s");
            int count = time;
            int intelligence = knight.getIntelligence();
            knight.setIntelligence(knight.getIntelligence() + 5 * level);
            while (count > 0) {
                count--;
                TimeSleep.timeSleep(1000);
            }
            knight.setIntelligence(intelligence);
        }
    }

    /**
     * 119-121.敏捷状态
     */
    @Effect(startNum = "119",endNum = "121")
    public static void Agility(Knight knight, int time, int flag, int level) {
        synchronized (status) {
            System.out.println(knight.getKnightName() + "增加了" + 5 * level + "点敏捷，持续"+time+"s");
            int count = time;
            int Agility = knight.getAgility();
            knight.setAgility(Agility+5*level);
            while (count > 0) {
                count--;
                TimeSleep.timeSleep(1000);
            }
            knight.setAgility(Agility);
        }
    }


    @Override
    public void run() {
        Knight knight = Knight.getInstance();
        int a = BuffEffect.getStatus().getStatusFlag();
        Class clz=BuffEffect.class;
        Method[] methods=clz.getMethods();
        for (Method method:methods){
            if (method.isAnnotationPresent(Effect.class)){
                Effect effect=method.getAnnotation(Effect.class);
                if(!((null==effect.startNum()||effect.startNum().equals(""))&&(null==effect.endNum()||effect.endNum().equals("")))){
                    Integer startNum=Integer.parseInt(effect.startNum());
                    Integer endNum=Integer.parseInt(effect.endNum());
                    if (a>=startNum&&a<=endNum){
                        try {
                            method.invoke(BuffEffect.getInstance(),knight,time,a,BuffEffect.getStatus().getStatusLevel());
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
