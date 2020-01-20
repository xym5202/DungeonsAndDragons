package KnightAndDragon.action;

import KnightAndDragon.Bean.Object.Knight;
import KnightAndDragon.util.TimeSleep;

public class Info {

    static { info=new Info();
    }

    private static Info info;

    private Info(){}

    public static Info getInstance(){
        return info;
    }

    //第一章背景信息
    public void InfoOne(){
        System.out.println("很久很久以前,有一座名叫奇亚洛的大陆，上面生活着各种各样的种群，有人类，精灵，矮人，瓦斯塔亚人等等，他们和谐的生活在一起");
        TimeSleep.timeSleep(1000);
        System.out.println("有一天，西方的一股强大的黑暗力量突然笼罩了这个世界，并向其他方向扩散开来，被黑暗感染的动物都会变的异常愤怒，盲目的攻击其他人");
        TimeSleep.timeSleep(1000);
        System.out.println("首先被黑暗吞噬的是西方的人类世界，大批幸存的居民们带上自己的行李，被迫踏上里离乡的旅程");
        TimeSleep.timeSleep(1500);
        System.out.println("在浩浩荡荡迁徙的人群中，有一名英雄和他的女儿走丢了，有人说看到他的女儿被一个穿着黑色斗篷的人带走了，沿着河岸向北方去了，而北边，正是矮人们的领地");
        TimeSleep.timeSleep(1500);
        System.out.println("于是，英雄扔掉了沉重的装备，加快速度，孤身一人前往北方，寻找自己的女儿");
        TimeSleep.timeSleep(2000);
        System.out.println("==================================\n第一章 哥布林之森");
        TimeSleep.timeSleep(1500);
        System.out.println("一直往北走，一大片森林矗立在眼前，这片森林生意盎然，确实哥布林的领地，虽然危险，但也是往北的必经之路，英雄咬了咬牙，走了进去。。。");
        TimeSleep.timeSleep(3000);
    }

    //第二章背景信息
    public void InfoTwo(){
        Knight knight=Knight.getInstance();
        System.out.println("离开格尔里斯，就进入到了矮人的领地");
        System.out.println("金矿镇，离这里还有200里的路程，我的女儿已经被带走一周了，不知道还能不能赶得上");
        System.out.println("想到这里，你皱了皱眉头，加快了脚步");
    }






}
