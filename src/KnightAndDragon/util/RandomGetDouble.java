package KnightAndDragon.util;

import KnightAndDragon.Bean.Items.Item;
import KnightAndDragon.BeanList.Items;
import KnightAndDragon.BeanList.enemyList;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

public class RandomGetDouble {

    public static double getDoubleTwo(){
        double a=Math.random()*100;
        BigDecimal b   =   new   BigDecimal(a);
        double   d   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        return d;
    }

    //人型，兽型攻击间隔时长
    public static double getAttackSpeed(){
        double a=Math.random();
        BigDecimal b   =   new   BigDecimal(a);
        double   d   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        return d;
    }

    //龙型攻击间隔时长
    public static double getDragonAttackSpeed(){
        double a=Math.random()*2;
        BigDecimal b   =   new   BigDecimal(a);
        double  d   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        return d;
    }

    //怪物行动时长
    public static double getActionTime(){
        double a=Math.random();
        BigDecimal b   =   new   BigDecimal(a);
        double   d   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        return d;
    }
    //攻击英雄部位
    public  static  int attackPart(){
        return (int)(Math.random()*6+1);
    }

    //随机集合
    public static  int getList(List list){
        return (int)(Math.random()*list.size());
    }

    //随机1-a的整数
    public static int getInteger(Integer a){
        return (int)(Math.random()*a+1);
    }

    //随机a-b的整数
    public static int getInteger(Integer a,Integer b){
        if (a<=b) {
            double d =  Math.random();
            int c = (int) (d * (b - a + 1) + a);
            return c;
        }else {
            int e=a;
            a=b;
            b=e;
            double d =  Math.random();
            int c = (int) (d * (b - a + 1) + a);
            return c;
        }
    }

    //随机状态持续时间
    public static int getStatusTime(){
        return  (int)(Math.random()*5+1);
    }

    //随机刷怪类型
    public static int getEnemyListNums(){
        Class clz=enemyList.class;
        Field[] fields=clz.getDeclaredFields();
        return (int)(Math.random()*fields.length+1);
    }

    //遇到敌人的几率
    public static int toMeetTheEnemy(){
        return (int)(Math.random()*10+1);
    }

    //小于1的小数随机
    public static double randomDecimals(){
        return Math.random();
    }


    //判断0-1产生的随机数是否小于Decimals
    public  static  boolean judgeTrue(double Decimals){
        double a =Math.random();
        return a>0&&a<=Decimals;
    }

    //判断是否掉落物品
    public static boolean judgeDrop(){
        double a=Math.random();
        return a>=0.25&&a<=0.5;
    };


    //随机掉落物品
    public static Item dropItem(){
        int a= Items.getItemsMap().size();
        return Items.getItemsMap().get(RandomGetDouble.getInteger(a));
    }

    //随机英雄与敌人之间的距离3-10
    public static Double distanceEnemyAndKinght(){
        return RandomGetDouble.getDoubleTwo()/100*7+3;

    }

    //随机每次攻击的浮动范围0.8-1.2
    public  static Double attackRandom(){
        return RandomGetDouble.randomDecimals()*0.4+0.8;
    }

    //随机得到饰品
    public static Integer getAccessories(){
    return  2000+RandomGetDouble.getInteger(Items.getAccessoriesHashMap().size()-1);
    }

    //随机哥布林王的王冠掉落
    public static Integer getGoblinKing(){
        return 3000+RandomGetDouble.getInteger(3);
    }


    //随机事件
    public static Integer getEvent(int a,int b){
        return a+RandomGetDouble.getInteger(b);
    }

    public static void main(String[] args) {
        InitClass initClass=InitClass.getInstance();
        initClass.InitClass();
        for (int i=0;i<=1000;i++) {
            System.out.println(RandomGetDouble.getInteger(0, 8));
        }
    }
}
