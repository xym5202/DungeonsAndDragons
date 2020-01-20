package KnightAndDragon.Bean.Items;

import KnightAndDragon.Bean.Addition.Status;
import KnightAndDragon.Bean.Equipment.equipment;
import KnightAndDragon.Bean.Equipment.weapon;
import KnightAndDragon.Bean.Object.Knight;
import KnightAndDragon.Effect.BuffEffect;
import KnightAndDragon.util.GetThread;
import KnightAndDragon.util.TimeSleep;
import KnightAndDragon.util.Utils;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

public class Backpack extends Item {

    static {
        Backpack.capacity = 25;
        items = new ConcurrentHashMap<>(Backpack.capacity);
        backpack = new Backpack();
    }

    private static Backpack backpack;
    //背包容量
    private static Integer capacity;

    //item，物品数量
    private static ConcurrentHashMap<Item, Integer> items;

    private Backpack() {
    }

    public static Backpack getInstance() {
        return backpack;
    }

    public static ConcurrentHashMap<Item,Integer> getItems() {
        return items;
    }

    //放入背包
    public void putBackpack(Item item) {
        if (items.size() < Backpack.capacity) {
            System.out.println("获得："+item.getItemName());
            if (items.get(item) != null) {
                items.put(item, items.get(item) + 1);
            } else {
                items.put(item, 1);
            }
        } else {
            System.out.println("背包容量不足，无法拾取" + item.getItemName());
            System.out.println("替换物品\n1、是\t2、否\t3、任意键退出");
            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            switch (a) {
                case 1:
                    openBackpack();
                    System.out.println("替换物品ID");
                    Scanner scanner1 = new Scanner(System.in);
                    int b = scanner1.nextInt();
                    dropItemFromBackpack(b);
            }
        }
    }

    //移除物品
    public void getFromBackpack(Item item) {
        if (items.get(item) != null) {
            int a = items.get(item) - 1;
            if (a <= 0) {
                items.remove(item);
            } else {
                items.put(item, a);
            }
        } else {
            System.out.println("查无此物品");
        }
    }

    //查看背包
    public void openBackpack() {
        StringBuffer sb = new StringBuffer();
        String str;
        for (ConcurrentHashMap.Entry<Item, Integer> a : items.entrySet()) {
            Item item = a.getKey();
            sb.append("ID:" + item.getItemNumber() + "、" + item.toString() + "->数量:" + a.getValue() + "\n");
        }
        str = String.valueOf(sb);
        if (str.equals("")) {
            str = "无\n=============================================================";
        } else {
            str = String.valueOf(sb) + "=============================================================";
        }
        System.out.println(str);
    }

    //丢掉物品
    public void dropItemFromBackpack(int ID, Integer num) {
        Backpack backpack = Backpack.getInstance();
        for (ConcurrentHashMap.Entry<Item, Integer> a : items.entrySet()) {
            Item item = a.getKey();
            Integer nums = a.getValue();
            if (ID == item.getItemNumber()) {
                if (num <= nums) {
                    for (int i = 0; i < num; i++) {
                        backpack.getFromBackpack(item);
                    }
                } else {
                    items.remove(item);
                }
            }
        }
    }

    //丢掉物品全部
    public void dropItemFromBackpack(int ID) {
        Backpack backpack = Backpack.getInstance();
        for (ConcurrentHashMap.Entry<Item, Integer> a : items.entrySet()) {
            Item item = a.getKey();
            if (ID == item.getItemNumber()) {
                items.remove(item);
            } else {
                System.out.println("查无此物品");
            }
        }
    }

    //查询ID是否在背包里
    public static boolean findItem(int ID) {
        for (ConcurrentHashMap.Entry<Item, Integer> a : items.entrySet()) {
            Item item = a.getKey();
            if (ID != 0 && ID == item.getItemNumber()) {
                return true;
            }
        }
        return false;
    }

    //背包随等级扩容，每次扩容10
    public void dilatationBackpack() {
        Backpack.capacity += 5;
    }

    //使用物品
    public void useItems(int ID) {
        for (ConcurrentHashMap.Entry<Item, Integer> a : items.entrySet()) {
            Item item = a.getKey();
            if (ID == item.getItemNumber()) {
                if (item instanceof CanUse) {
                    //使用药水
                    if (item instanceof Liquid) {
                        Status status = item.getStatus();
                        BuffEffect buffEffect = BuffEffect.getInstance();
                        BuffEffect.setStatus(status);
                        BuffEffect.setTime(item.time);
                        try {
                            Thread thread = new Thread(buffEffect);
                            thread.setDaemon(true);
                            ThreadPoolExecutor tpe = GetThread.getThreadInstance();
                            tpe.execute(thread);
                            System.out.println(item.getItemName() + "使用成功");
                            this.getFromBackpack(item);
                            TimeSleep.timeSleep(1000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    //使用书
                    else if (item instanceof Book){
                        Knight knight=Knight.getInstance();
                        System.out.println("选择附魔武器");
                        EquipmentBackpack.getInstance().openEquipmentBackpack();
                        Integer b= Utils.Scanner();
                        if (b>EquipmentBackpack.getEquipmentList().size()){
                            System.out.println("没有该序号");
                            return;
                        }else {
                            equipment equipment=EquipmentBackpack.getInstance().getEquipment(b);
                            if (!(equipment instanceof weapon)){
                                System.out.println(equipment.getArmorsName()+"不属于武器");
                            }else {
                                Book book=(Book) item;
                                if ( equipment!=null) {
                                    ((weapon) equipment).setSkill(book.getSkills());
                                    EquipmentBackpack.getInstance().putEquipment(equipment);
                                    this.getFromBackpack(book);
                                }
                            }
                        }
                    }
                    //使用物品
                    else if (item instanceof UseItem){
                        UseItem useItem=(UseItem)item;
                        useItem.useItem(useItem.getEffect());
                        this.getFromBackpack(item);
                    }
                } else {
                    System.out.println("此物品不可使用");
                }
            }
        }
    }

}
