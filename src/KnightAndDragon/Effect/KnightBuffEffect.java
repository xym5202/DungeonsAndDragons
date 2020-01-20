package KnightAndDragon.Effect;

import KnightAndDragon.Bean.Addition.Status;
import KnightAndDragon.Bean.Object.Knight;
import KnightAndDragon.Bean.Object.enemy;
import KnightAndDragon.util.TimeSleep;

import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantLock;

public class KnightBuffEffect implements Runnable {

    static {
        buffEffect = new KnightBuffEffect();
    }

    private static KnightBuffEffect buffEffect;

    //持续时间
    private static volatile int time;

    //状态
    private static volatile Status status;

    //敌人
    private static volatile enemy enemy;

    //敌人是否死亡
    private static volatile  boolean enemyDie=false;

    private KnightBuffEffect() {
    }

    public static KnightBuffEffect getInstance() {
        return buffEffect;
    }

    public static Status getStatus() {
        return status;
    }

    public static void setStatus(Status status) {
        KnightBuffEffect.status = status;
    }

    public int getTime() {
        return time;
    }

    public static void setTime(int time) {
        KnightBuffEffect.time = time;
    }

    public static KnightAndDragon.Bean.Object.enemy getEnemy() {
        return enemy;
    }

    public static void setEnemy(KnightAndDragon.Bean.Object.enemy enemy) {
        KnightBuffEffect.enemy = enemy;
    }

    public static boolean isEnemyDie() {
        return enemyDie;
    }

    public static void setEnemyDie(boolean enemyDie) {
        KnightBuffEffect.enemyDie = enemyDie;
    }

    /**
     * 201 恢复术
     * @param knight
     */
    @Effect(startNum = "201",endNum = "201")
    public static void healing(Knight knight,enemy enemy, int time, int flag) {
            int count = time;
            int a = (int) (Math.random() * 6 + 1);
            switch (a) {
                case 1:
                    System.out.println(knight.getKnightName() + "恢复头部生命，持续"+time+"s");
                    while (count > 0) {
                        knight.setHead((int)(knight.getHead() +  Math.log(knight.getIntelligence())/Math.log(2.0)<= Knight.getHeadSum() ? knight.getHead() +  Math.log((double)knight.getIntelligence())/Math.log(2.0): Knight.getHeadSum()));

                        count--;
                        TimeSleep.timeSleep(1000);
                    }
                    break;
                case 2:
                    System.out.println(knight.getKnightName() + "恢复左臂生命，持续"+time+"s");
                    while (count > 0) {
                        knight.setArmLeft((int)(knight.getArmLeft() +Math.log(knight.getIntelligence())/Math.log(2.0) <= Knight.getArmLeftSum() ? knight.getArmLeft() + Math.log((double)knight.getIntelligence())/Math.log(2.0) : Knight.getArmLeftSum()));
                        count--;
                        TimeSleep.timeSleep(1000);
                    }
                    break;
                case 3:
                    System.out.println(knight.getKnightName() + "恢复右臂生命，持续"+time+"s");
                    while (count > 0) {
                        knight.setArmRight((int) (knight.getArmRight() +  Math.log(knight.getIntelligence())/Math.log(2.0) <= Knight.getArmRightSum() ? knight.getArmRight() + Math.log((double)knight.getIntelligence())/Math.log(2.0) : Knight.getArmRightSum()));
                        count--;
                        TimeSleep.timeSleep(1000);
                    }
                    break;
                case 4:
                    System.out.println(knight.getKnightName() + "恢复左腿生命，持续"+time+"s");
                    while (count > 0) {
                        knight.setLegLeft((int)(knight.getLegLeft() +  Math.log((knight.getIntelligence())/Math.log(2.0) <= Knight.getLegLeftSum() ? knight.getLegLeft() + Math.log((double)knight.getIntelligence())/Math.log(2.0): Knight.getLegLeftSum())));
                        count--;
                        TimeSleep.timeSleep(1000);
                    }
                    break;
                case 5:
                    System.out.println(knight.getKnightName() + "恢复右腿生命，持续"+time+"s");
                    while (count > 0) {
                        knight.setLegRight((int)(knight.getLegRight() +  Math.log(knight.getIntelligence())/Math.log(2.0) <= Knight.getLegRightSum() ? knight.getLegRight() + Math.log((double)knight.getIntelligence())/Math.log(2.0) : Knight.getLegRightSum()));
                        count--;
                        TimeSleep.timeSleep(1000);
                    }
                    break;
                case 6:
                    System.out.println(knight.getKnightName() + "恢复身体生命，持续"+time+"s");
                    while (count > 0) {
                        knight.setBody((int) (knight.getBody() +  Math.log(knight.getIntelligence())/Math.log(2.0) <= Knight.getBodySum() ? knight.getBody() + Math.log((double)knight.getIntelligence())/Math.log(2.0): Knight.getBodySum()));
                        count--;
                        TimeSleep.timeSleep(1000);
                    }
                    break;

            }
    }

    /**
     * 202 治愈术
     */
    @Effect(startNum = "202",endNum = "202")
    public static void cure(Knight knight, enemy enemy,int time, int flag) {
        System.out.println(knight.getKnightName() + "受到治疗,整体血量+"+(knight.getIntelligence()/5+5));
        knight.setHead(knight.getHead() + knight.getIntelligence()/5+5 <= Knight.getHeadSum() ? knight.getHead() + knight.getIntelligence()/5+5: Knight.getHeadSum());
        knight.setArmLeft(knight.getArmLeft() + knight.getIntelligence()/5+5 <= Knight.getArmLeftSum() ? knight.getArmLeft() + knight.getIntelligence()/5+5 : Knight.getArmLeftSum());
        knight.setArmRight(knight.getArmRight() + knight.getIntelligence()/5+5<= Knight.getArmRightSum() ? knight.getArmRight() +knight.getIntelligence()/5+5 : Knight.getArmRightSum());
        knight.setLegLeft(knight.getLegLeft() + knight.getIntelligence()/5+5 <= Knight.getLegLeftSum() ? knight.getLegLeft() +knight.getIntelligence()/5+5 : Knight.getLegLeftSum());
        knight.setLegRight(knight.getLegRight() + knight.getIntelligence()/5+5 <= Knight.getLegRightSum() ? knight.getLegRight() + knight.getIntelligence()/5+5: Knight.getLegRightSum());
        knight.setBody(knight.getBody() + knight.getIntelligence()/5+5 <= Knight.getBodySum() ? knight.getBody() + knight.getIntelligence()/5+5 : Knight.getBodySum());
        TimeSleep.timeSleep(1000);
    }

//    /**
//     * 203 痊愈状态
//     *
//     * @param knight
//     * @param time
//     * @param flag
//     */
//    @Effect(startNum = "203",endNum = "203")
//    public static void recovery(Knight knight,enemy enemy, int time, int flag) {
//        System.out.println(knight.getKnightName() +"受到治疗,整体血量+"+(knight.getIntelligence()+10));
//        knight.setHead(knight.getHead() + knight.getIntelligence()+10 <= Knight.getHeadSum() ? knight.getHead() + knight.getIntelligence()+10: Knight.getHeadSum());
//        knight.setArmLeft(knight.getArmLeft() + knight.getIntelligence()+10 <= Knight.getArmLeftSum() ? knight.getArmLeft() + knight.getIntelligence()+10 : Knight.getArmLeftSum());
//        knight.setArmRight(knight.getArmRight() + knight.getIntelligence()+10<= Knight.getArmRightSum() ? knight.getArmRight() +knight.getIntelligence()+10 : Knight.getArmRightSum());
//        knight.setLegLeft(knight.getLegLeft() + knight.getIntelligence() +10<= Knight.getLegLeftSum() ? knight.getLegLeft() +knight.getIntelligence()+10 : Knight.getLegLeftSum());
//        knight.setLegRight(knight.getLegRight() + knight.getIntelligence()+10 <= Knight.getLegRightSum() ? knight.getLegRight() + knight.getIntelligence()+10: Knight.getLegRightSum());
//        knight.setBody(knight.getBody() + knight.getIntelligence() +10<= Knight.getBodySum() ? knight.getBody() + knight.getIntelligence()+10 : Knight.getBodySum());
//        TimeSleep.timeSleep(1000);
//    }

    /**
     * 203火球术
     */
    @Effect(startNum = "203",endNum = "203")
    public static void fire(Knight knight, enemy enemy,int time, int flag) {
            enemy.setEnemyBlood(enemy.getEnemyBlood()-(knight.getIntelligence()/5+3));
            System.out.println(enemy.getEnemyName()+"受到"+(knight.getIntelligence()/5+3)+"点伤害"+",还剩"+(enemy.getEnemyBlood()>=0?enemy.getEnemyBlood():0));
            //敌人死亡
        if (enemy.getEnemyBlood()<=0){
            KnightBuffEffect.setEnemyDie(true);
        }
    }

    /**
     * 203冰冻术
     */
    @Effect(startNum = "204",endNum = "204")
    public static void frozen(Knight knight, enemy enemy,int time, int flag) {
        enemy.setEnemyBlood(enemy.getEnemyBlood()-(knight.getIntelligence()/6+10));
        System.out.println(enemy.getEnemyName()+"被减速，"+"受到"+(knight.getIntelligence()/6+10)+"点伤害"+",还剩"+(enemy.getEnemyBlood()>=0?enemy.getEnemyBlood():0));
        //敌人死亡
        if (enemy.getEnemyBlood()<=0){
            KnightBuffEffect.setEnemyDie(true);
            return;
        }
        //线程安全应该已解决
        synchronized (enemy) {
            enemy.setActionTime(enemy.getActionTime() * 0.8);
            for (int i = 0; i < time; i++) {
                TimeSleep.timeSleep(1000);
                if (enemy.getEnemyBlood()<=0){
                    KnightBuffEffect.setEnemyDie(true);
                    return;
                }
            }
            if (enemy.getEnemyBlood()<=0){
                KnightBuffEffect.setEnemyDie(true);
                return;
            }else {
                System.out.println("huisusudu");
                enemy.setActionTime(enemy.getActionTime() / 0.8);
            }
        }

    }

    @Effect(startNum = "205")
    public static void bleed(Knight knight, enemy enemy,int time, int flag){
        double harm=knight.getIntelligence()*0.01;
        System.out.println(enemy.getEnemyName()+"流血了，每1s造成"+harm+"点伤害，持续5s，最低1点血");
        for (int i=1;i<=time;i++){
            TimeSleep.timeSleep(1000);
            enemy.setEnemyBlood(enemy.getEnemyBlood()-harm>=1?enemy.getEnemyBlood()-harm:1);
        }
    }


    @Override
    public void run() {
        Knight knight = Knight.getInstance();
        int a = KnightBuffEffect.getStatus().getStatusFlag();
        Class clz=KnightBuffEffect.class;
        Method[] methods=clz.getMethods();
        for (Method method:methods){
            if (method.isAnnotationPresent(Effect.class)){
                Effect effect=method.getAnnotation(Effect.class);
                if(!(null==effect.startNum()||effect.startNum().equals(""))){
                    Integer startNum=Integer.parseInt(effect.startNum());
                    if (a==startNum){
                        try {
                            method.invoke(KnightBuffEffect.getInstance(),knight,enemy,time,a);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
