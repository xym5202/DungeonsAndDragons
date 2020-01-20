package KnightAndDragon.action;

import KnightAndDragon.Bean.Equipment.equipment;
import KnightAndDragon.Bean.Items.*;
import KnightAndDragon.Bean.Object.Boss;
import KnightAndDragon.Bean.Object.Knight;
import KnightAndDragon.Bean.Object.enemy;
import KnightAndDragon.BeanList.*;
import KnightAndDragon.Effect.KnightBuffEffect;
import KnightAndDragon.util.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

public class Action {

    private static Double IniDistance=8.0;

    private static Double distance = 8.0;

    private static Integer n;

    private static Integer a;

    public static Double getDistance() {
        return distance;
    }

    public static void setDistance(Double distance) {
        Action.distance = distance;
    }

    public static Double getIniDistance() {
        return IniDistance;
    }

    public static Integer getN() {
        return n;
    }

    public static void setN(Integer n) {
        Action.n = n;
    }

    public static Integer getA() {
        return a;
    }

    public static void setA(Integer a) {
        Action.a = a;
    }

    //装备掉落
    public static equipment dropEquipment() {
        equipment equipment;
        double d = RandomGetDouble.randomDecimals();
        if (d < 0.3) {
            equipment = weaponFactory.createWeaponFactory();
        } else if (d < 0.8 && d >= 0.3) {
            equipment = ArmorFactory.createEquipmentFactory();
        } else {
            equipment = shieldFactory.createShieldEquipmentFactory();
        }
        return equipment;
    }

    //物品掉落
    public static Item dropItem() {
        Item item = Items.getItemsMap().get(RandomGetDouble.getInteger(Items.getItemsMap().size()));
        return item;
    }

    //获取掉落
    public static void getDrop() {
        if (RandomGetDouble.randomDecimals() <= 0.1) {
            equipment equipments = Action.dropEquipment();
            System.out.println("掉落装备，属性：\n" + equipments.toString());
            System.out.println("是否获取装备  \n1、获取\t2、丢弃\t3、任意键退出");
            int a = Utils.Scanner();
            switch (a) {
                case 1:
                    EquipmentBackpack.getInstance().putEquipment(equipments);
                    break;
                case 2:
                    System.out.println(equipments.getArmorsName() + "已丢弃");
                    break;
                default:
                    System.out.println("退出\n=================");
                    break;
            }
        } else if (RandomGetDouble.randomDecimals() <= 0.35 && RandomGetDouble.randomDecimals() > 0.1) {
            Item item = dropItem();
            if (item != null) {
                System.out.println("掉落物品\n" + item.toString());
                System.out.println("是否获取物品  \n1、获取\t2、丢弃\t3、任意键退出");
                int a = Utils.Scanner();
                switch (a) {
                    case 1:
                        Backpack.getInstance().putBackpack(item);
                        break;
                    case 2:
                        System.out.println(item.getItemName() + "已丢弃");
                        break;
                    default:
                        System.out.println("退出\n=================");
                        break;
                }
            }
        }
    }

    //判断敌人是否死亡
    public static enemy judgeEnemyDeath(enemy enemy) {
        if (enemy.getEnemyBlood() <= 0) {
            Knight knight = Knight.getInstance();
            knight.setKngihtExperience(knight.getKngihtExperience() + enemy.getExperience());
            System.out.println("获得经验"+enemy.getExperience());
            knight.setGold(knight.getGold()+enemy.getEnemyGolden());
            System.out.println("获得金币"+enemy.getEnemyGolden());
            knight.upLevel();
            enemyList.init();
            Action.setDistance(Action.getIniDistance());
            return null;
        } else {
            return enemy;
        }
    }

    //判断英雄是否死亡
    public static boolean judgeKnightDeath() {
        return Knight.getInstance().getBody() <= 0 || Knight.getInstance().getHead() <= 0;
    }

    //英雄攻击
    public static String knightAttack(Knight knight, enemy enemy) {
        String enemyDie = "敌人阵亡";
        for (int i = 0; i < (knight.getActionTime() / knight.getAttackSpeed() < 1 ? 1 : knight.getActionTime() / knight.getAttackSpeed()); i++) {
            enemy.getHarm(knight);
            enemy = Action.judgeEnemyDeath(enemy);
            if (enemy == null) {
                System.out.println(enemyDie);
                return enemyDie;
            }
        }
        return "英雄回合结束";
    }

    //敌人移动
    public static Double enemyMove(enemy enemy, Double distance) {
        distance = distance - enemy.getActionTime() > 0 ? distance - enemy.getActionTime() : enemy.getAttackRange();
        System.out.println("敌人前进了" + enemy.getActionTime() + ",离英雄还剩" + distance + "距离\n================");
        TimeSleep.timeSleep(500);
        return distance;
    }

    //敌人攻击
    public static String enemyAttack(Knight knight, enemy enemy) {
        String knightDie = "英雄阵亡";
        knight.getHarm(enemy);
        if (Action.judgeKnightDeath()) {
            Knight.knightDeath();
            return knightDie;
        }
        return "敌人回合结束";
    }

    //战斗
    public static String fight(Knight knight, enemy enemy) {
        String enemyDie = "敌人阵亡";
        String knightDie = "英雄阵亡";
        Integer suma = Knight.getLegRightSum() + Knight.getLegLeftSum();
        Integer b = knight.getLegLeft() + knight.getLegRight();
        double d = (double) b / suma;
        knight.setActionTime(d * knight.getIniActionTime());
        Integer sumb = Knight.getArmLeftSum() + Knight.getArmRightSum();
        Integer c = knight.getArmLeft() + knight.getArmRight();
        double d2 = (double) c / sumb;
        knight.setAttackSpeed((1 + (1 - d2)) * knight.getIniAttackSpeed());
        System.out.println("1.前进\t2.不动\t3.后退\t4.攻击\t任意键：自动攻击");
        int a = Utils.Scanner();
        switch (a) {
            case 1:
                distance = (distance - knight.getActionTime()) > 0 ? (distance - knight.getActionTime()) : knight.getAttackRange();
                System.out.println("英雄前进了" + knight.getActionTime() + ",离敌人还剩" + distance + "距离\n========================");
                if (enemy.getAttackRange() < distance) {
                    distance = enemyMove(enemy, distance);
                } else {
                    enemyAttack(knight, enemy);
                }
                break;
            case 2:
                System.out.println("英雄离敌人还剩" + distance + "距离\n========================");
                if (enemy.getAttackRange() < distance) {
                    distance = enemyMove(enemy, distance);
                } else {
                    enemyAttack(knight, enemy);
                }
                break;
            case 3:
                distance =((distance + knight.getActionTime()) <= Action.getIniDistance() ? distance + knight.getActionTime() : Action.getIniDistance());
                System.out.println("英雄后退了" + knight.getActionTime() + ",离敌人还剩" + distance + "距离\n========================");
                if (enemy.getAttackRange() < distance) {
                    distance = enemyMove(enemy, distance);
                } else {
                    enemyAttack(knight, enemy);
                }
                break;
            case 4:
                if (knight.getAttackRange() < distance) {
                    System.out.println("距离太远，敌人闪避了");
                    TimeSleep.timeSleep(1000);
                } else {
                    String string = knightAttack(knight, enemy);
                    if (string.equals(enemyDie)) {
                        return enemyDie;
                    }
                }
                if (enemy.getAttackRange() < distance) {
                    distance = enemyMove(enemy, distance);
                } else {
                    String string = enemyAttack(knight, enemy);
                    if (string.equals(knightDie)) {
                        return knightDie;
                    }
                }
                break;
            default:
                while (true) {
                    //判断双方距离英雄是否攻击
                    if (knight.getAttackRange() < distance) {
                        distance = distance - knight.getActionTime() > 0 ? distance - knight.getActionTime() : knight.getAttackRange();
                        System.out.println("英雄前进了" + knight.getActionTime() + ",离敌人还剩" + distance + "距离\n================");
                        TimeSleep.timeSleep(500);
                    } else {
                        //英雄攻击
                        for (int i = 0; i < (knight.getActionTime() / knight.getAttackSpeed() < 1 ? 1 : knight.getActionTime() / knight.getAttackSpeed()); i++) {
                            enemy.getHarm(knight);
                            TimeSleep.timeSleep(1000);
                            enemy = Action.judgeEnemyDeath(enemy);
                            if (enemy == null) {
                                System.out.println(enemyDie);
                                return enemyDie;
                            }
                        }
                    }
                    if (enemy.getAttackRange() < distance) {
                        distance = enemyMove(enemy, distance);
                    } else {
                        String str = enemyAttack(knight, enemy);
                        if (str.equals("英雄阵亡")) {
                            return str;
                        }
                    }
                }
        }
        return "回合结束";
    }

    //逃跑
    public static boolean escape(Knight knight, enemy enemy) {
        if (knight.getActionTime() > enemy.getActionTime() && RandomGetDouble.toMeetTheEnemy() <= 5) {
            return true;
        } else if (knight.getActionTime() > enemy.getActionTime() && RandomGetDouble.toMeetTheEnemy() >= 5) {
            System.out.println("逃跑失败");
            TimeSleep.timeSleep(1000);
            Action.fight(knight, enemy);
            return false;
        } else {
            System.out.println("速度太慢，无法逃跑");
            TimeSleep.timeSleep(1000);
            Action.fight(knight, enemy);
            return false;
        }
    }

    //战斗进程
    public static void process(Knight knight, enemy enemy) {
        System.out.println("遇到了" + enemy.getEnemyName());
        HealSpirit healSpirit = HealSpirit.getInstance();
        HealSpirit.setFlag(true);
        ThreadPoolExecutor tpe = GetThread.getThreadInstance();
        tpe.execute(healSpirit);
        while (true) {
            System.out.println("1.战斗\t2.战斗切换攻击/防御状态\t3.逃跑\t4.使用技能\t5.使用背包\t6.使用装备包");
            int b = Utils.Scanner();
            switch (b) {
                case 1:
                    String str = Action.fight(knight, enemy);
                    if (str.equals("敌人阵亡") || str == "敌人阵亡") {
                        Action.getDrop();
                        HealSpirit.setFlag(false);
                        return;
                    } else if (str.equals("英雄阵亡") || str == "英雄阵亡") {
                        HealSpirit.setFlag(false);
                        return;
                    }
                    break;
                case 2:
                    knight.switchOverAttackStatus();
                    String string = Action.fight(knight, enemy);
                    if (string.equals("敌人阵亡") || string == "敌人阵亡") {
                        Action.getDrop();
                        HealSpirit.setFlag(false);
                        return;
                    } else if (string.equals("英雄阵亡") || string == "英雄阵亡") {
                        HealSpirit.setFlag(false);
                        return;
                    }
                    break;
                case 3:
                    if (Action.escape(knight, enemy)) {
                        HealSpirit.setFlag(false);
                        return;
                    }
                    break;
                case 4:
                    System.out.println("-1:退出\n1.选择要使用的技能：");
                    System.out.println(knight.skillListToString());
                    System.out.println();
                    Scanner scanner = new Scanner(System.in);
                    int a= Utils.Scanner();
                    if (a == -1) {
                        break;
                    }
                    knight.useSkill(a,enemy);
                    TimeSleep.timeSleep(1000);
                    if (KnightBuffEffect.isEnemyDie() == true) {
                        String enemyDie="敌人阵亡";
                        enemy = Action.judgeEnemyDeath(enemy);
                        if (enemy == null) {
                            System.out.println(enemyDie);
                            KnightBuffEffect.setEnemyDie(false);
                            return;
                        }
                    }
                    if (enemy.getAttackRange() < distance) {
                        distance = enemyMove(enemy, distance);
                    } else {
                        enemyAttack(knight, enemy);
                    }
                    break;
                case 5:
                    openBackpack();
                    break;
                case 6:
                    openEquipmentBackpack();
                    break;
                default:
                    System.out.println("敬请期待");
                    break;
            }
        }
    }

    //使用物品
    public static void openBackpack() {
        Backpack backpack = Backpack.getInstance();
        backpack.openBackpack();
        System.out.println("1.使用物品  2.丢弃物品  3.合成  4.任意数字键返回");
        int i = Utils.Scanner();
        switch (i) {
            case 1:
                System.out.println("请输入使用物品的ID");
                int a = Utils.Scanner();
                backpack.useItems(a);
                break;
            case 2:
                System.out.println("请输入丢弃物品的ID");
                int b = Utils.Scanner();
                System.out.println("请输入丢弃物品的数量");
                int n = Utils.Scanner();
                backpack.dropItemFromBackpack(b, n);
                break;
            case 3:
                Action.compound();
                break;
            default:
                System.out.println("退出\n===================");
                break;
        }

    }

    //打开装备包
    public static void openEquipmentBackpack() {
        EquipmentBackpack equipmentBackpack = EquipmentBackpack.getInstance();
        System.out.println("1.更换装备  2.丢弃装备  3.任意键退出");
        int a = Utils.Scanner();
        switch (a) {
            case 1:
                EquipmentBackpack.getInstance().exchangeEquipment();
                break;
            case 2:
                EquipmentBackpack.getInstance().dropEquipment();
                break;
            default:
                System.out.println("退出\n===================");
                break;
        }

    }

    //打开饰品包
    public static void openAccessoriesBackPack() {
        AccessoriesBackPack accessoriesBackPack = AccessoriesBackPack.getInstance();
        accessoriesBackPack.openAccessoriesBackPack();
    }

    //物品合成
    public static void compound() {
        System.out.println("输入要合成的物品ID，以#键隔开，最多输入3个数字");
        Scanner scanner4 = new Scanner(System.in);
        String in = scanner4.next();
        String[] ins = in.split("#");
        List<Integer> list = new ArrayList<>();
        Integer num;
        for (String str : ins) {
            num = Integer.valueOf(str);
            if (num > 0) {
                list.add(num);
            }
        }
        //判断背包里是否有该物品
        for (int i = 0; i <= list.size() - 1; i++) {
            if (list.get(i) != 0 && !Backpack.findItem(list.get(i))) {
                System.out.println("背包没有ID为" + list.get(i) + "的物品");
                return;
            }
        }
        Collections.sort(list);
        if (CraftGuide.findFromGuideMap(list)) {
            //扣除背包物品
            for (int i = 0; i <= list.size() - 1; i++) {
                Backpack.getInstance().dropItemFromBackpack(list.get(i), 1);
            }
            //获取合成表物品
            Item item = (Item) CraftGuide.getConcurrentHashMap().get(list);
            if (item instanceof equipment) {
                equipment equipment = (equipment) item;
                System.out.println("合成" + equipment.getItemName() + "成功");
                EquipmentBackpack.getInstance().putEquipment(equipment);
            } else if (item instanceof Accessories) {
                Accessories accessories = (Accessories) item;
                System.out.println("合成" + accessories.getItemName() + "成功");
                AccessoriesBackPack.getInstance().putAccessories(accessories);
            } else {
                System.out.println("合成" + item.getItemName() + "成功");
                Backpack.getInstance().putBackpack(item);
            }
        } else {
            System.out.println("没有该物品的合成");
        }
    }

    //Boss关
    public static void comeToEnd(int a) {
        if (a == 1) {
            System.out.println("========================================");
            System.out.println("走出森林，在前面不远处的的地平线上出现了一座城市，那是人类北方最靠近边境的一座城市--格尔里斯城，那是前往北方矮人国度的必经之地，你知道那个黑衣人如果前往矮人国度的话必须要经过这，想到这里，你加快了自己的脚步");
            System.out.println("在离城市不远的地方，你隐约看到一个一身黑的家伙，黑衣人！！但是在他旁边没有见到你的女儿，你下意识的飞奔了过去，那个黑衣人也注意到了你，转身就朝森林跑去，可惜的是，他的速度太慢了，你两步便追上了他");
            enemy enemy = Boss.getInstance().getEnemies().get(1);
            Knight knight = Knight.getInstance();
            Action.process(knight, enemy);
            System.out.println("你打败了黑衣人，怒吼着问道女儿的下落，只见他哼哼了两声，说道“你的女儿已经献祭给萨尔莫斯魔王了，已经来不及了，哈哈哈..”说完，便喷出了一口黑色的血，你发现不妙，赶紧捏开他的嘴，结果慢了一步，他服下了口中的毒药自尽了");
            System.out.println("你沮丧的看着北方，看来只能进城问问女儿的下落了");
            Event event = Event.getInstance();
            event.oneEnd();
        }else if (a==2){
            System.out.println("========================================");
            System.out.println("昔日矮人族的金矿镇，是整个奇亚洛大路上最富有的城镇，每天都有无数的金子从城镇运往世界各地");
            System.out.println("但当你踏上这片土地的时候，感觉到了一丝异样，城镇里面稀稀落落的人表情紧张的的走在街上，周围的店铺门窗紧闭，好像在防备着什么");
            System.out.println("你走进了这个城镇唯一还在营业的一家酒馆里");
            //TODO
        }
    }

    //运行选项
    public static String running(Knight knight){
        while (true) {
            if (Action.judgeKnightDeath()) {
                return "Game Over";
            }
            System.out.println("1:前进 2.打开信息栏 3.打开背包 4.打开装备包 5.打开饰品包");
            int choose = Utils.Scanner();
            if (choose == 1) {
                if (RandomGetDouble.toMeetTheEnemy() <= 5) {
                    enemy enemy = enemyList.createEnemyFactory(a);
                    TimeSleep.timeSleep(500);
                    Action.process(knight, enemy);
                    n -= RandomGetDouble.toMeetTheEnemy();
                    if (n <= 0) {
                        Action.comeToEnd(a);
                    } else {
                        System.out.println("距离路程结束还剩" + n);
                        System.out.println("=================================================");
                    }
                } else {
                    if (RandomGetDouble.randomDecimals() < 0.5) {
                        int road=RandomGetDouble.toMeetTheEnemy();
                        n -= road;
                        if (n <= 0) {
                            Action.comeToEnd(a);
                            return "";
                        } else {
                            System.out.println("前进了"+road);
                            System.out.println("距离路程结束还剩" + n);
                            System.out.println("=================================================");
                        }
                    } else {
                        Event.setA(a);
                        Event.runEvent();
                    }
                }
            } else if (choose == 2) {
                knight.getKnightInfo();
            } else if (choose == 3) {
                openBackpack();
            } else if (choose == 4) {
                openEquipmentBackpack();
            } else if (choose == 5) {
                openAccessoriesBackPack();
            } else {
                System.out.println("敬请期待");
            }
        }
    }


    //运行过程
    public static String start() {
        Knight knight = Knight.getInstance();
        if (a == 1) {
            Info.getInstance().InfoOne();
            System.out.println("请给你的英雄起一个名字");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
            knight.setKnightName(name);
        }else if (a==2){
            Info.getInstance().InfoTwo();
        }
        Action.setN(a*100);
        String string=Action.running(knight);
        return string;
    }

}