package KnightAndDragon.action;

import KnightAndDragon.Bean.Equipment.equipment;
import KnightAndDragon.Bean.Equipment.shield;
import KnightAndDragon.Bean.Equipment.weapon;
import KnightAndDragon.Bean.Items.*;
import KnightAndDragon.Bean.Object.Boss;
import KnightAndDragon.Bean.Object.Knight;
import KnightAndDragon.Bean.Object.enemy;
import KnightAndDragon.BeanList.*;
import KnightAndDragon.Effect.Effect;
import KnightAndDragon.util.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

//随机事件
public class Event {

    private static Event event;

    private static Knight knight = Knight.getInstance();

    private static Integer a;

    private static List<String> list=new ArrayList<>();

    static {
        event = new Event();
    }

    private Event() {
    }

    public static Event getInstance() {
        return event;
    }

    public static Integer getA() {
        return a;
    }

    public static void setA(Integer a) {
        Event.a = a;
    }

    public static List<String> getList() {
        return list;
    }

    //工具方法
    //装备买卖工具方法
    public void buyAndSoltEquipment(List<equipment> equipments) {
        while (true) {
            System.out.println("1、买 2、卖  3、任意数字退出");
            StringBuffer sb = new StringBuffer();
            int i = 0;
            for (equipment equipment : equipments) {
                if (equipment instanceof weapon) {
                    weapon weapon = (weapon) equipment;
                    sb.append(i + "、" + weapon.getWeaponKind() + "\t耐久：" + weapon.getWeaponDurability() + "\t材料：" + weapon.getWeaponMaterials().getMaterialsName() + "\t攻击：" + weapon.getAttack() + "\t魔法攻击：" + weapon.getMagicAttack() + "\t售价：" + (weapon.getGold() * 3) + "\n");
                } else if (equipment instanceof shield) {
                    shield shield = (shield) equipment;
                    sb.append(i + "、" + shield.getShieldKind() + "\t耐久：" + shield.getShieldDurability() + "\t材料：" + shield.getShieldMaterials().getMaterialsName() + "\t物抗：" + shield.getShieldHarm() + "\t魔抗：" + shield.getShieldMagicHarm() + "\t影响：" + shield.getAffectAction() + "\t售价：" + (shield.getGold() * 3) + "\n");
                } else {
                    sb.append(i + "、" + equipment.getArmorsName() + "\t部位：" + equipment.getPartName() + "\t耐久：" + equipment.getDurability() + "\t材料：" + equipment.getArmorsMaterials().getMaterialsName() + "\t护甲：" + equipment.getArmors() + "\t魔抗：" + equipment.getMagicResistance() + "\t附魔：" + equipment.getSkills() + "\t售价：" + (equipment.getGold() * 3) + "\n");
                }
                i++;
            }
            int b = Utils.Scanner();
            switch (b) {
                case 1:
                    System.out.println(sb);
                    System.out.println("剩余金币：" + knight.getGold());
                    System.out.println("输入你想买装备的编号\t  -1返回上一层");
                    int number = Utils.Scanner();
                    if (number == -1) {
                        break;
                    }
                    if (number >= equipments.size()) {
                        System.out.println("装备编号不存在");
                        break;
                    } else {
                        if (knight.getGold() < equipments.get(number).getGold() * 2) {
                            System.out.println("金额不足");
                            break;
                        } else {
                            knight.setGold(knight.getGold() - equipments.get(number).getGold() * 2);
                            Knight.getEquipmentBackpack().putEquipment(equipments.get(number));
                            equipments.remove(number);
                        }
                    }
                    break;
                case 2:
                    EquipmentBackpack.getInstance().openEquipmentBackpack();
                    System.out.println("选择出售装备");
                    int c = Utils.Scanner();
                    if (c > 0 && c <= EquipmentBackpack.getEquipmentList().size()) {
                        //取出装备
                        equipment equipment = EquipmentBackpack.getInstance().getEquipment(c);
                        knight.setGold(knight.getGold() + equipment.getGold());
                        System.out.println("获得了" + equipment.getGold() + "金币");
                    } else {
                        System.out.println("编号不存在");
                        break;
                    }
                    break;
                default:
                    return;
            }
        }
    }

    //住店休息工具方法
    public void restInHotel() {
        int a = 0;
        int b = knight.getLevel() * 10;
        if (knight.getGold() - b >= 0) {
            a = knight.getGold() - b;
            knight.setGold(a);
            System.out.println("你失去" + b + "金币");
            System.out.println("zzz（恢复生命）");
            knight.setHead(Knight.getHeadSum());
            knight.setArmLeft(Knight.getArmLeftSum());
            knight.setArmRight(Knight.getArmRightSum());
            knight.setLegLeft(Knight.getLegLeftSum());
            knight.setLegRight(Knight.getLegRightSum());
            knight.setBody(Knight.getBodySum());
            TimeSleep.timeSleep(2000);
            System.out.println("一觉醒来\n===================================================");
        } else {
            System.out.println("金币不足");
        }
    }

    //买卖物品工具类
    public void buyAndSellItem(List<Item> items) {
        while (true) {
            System.out.println("1.买\t2.卖\t3.-1退出");
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < items.size(); i++) {
                sb.append(i + "、" + items.get(i).getItemName() + "\t" + items.get(i).getIntroduce() + "\t" + items.get(i).getGold() * 3 + "\n");
            }
            String string = String.valueOf(sb);
            int a = Utils.Scanner();
            switch (a) {
                case 1:
                    System.out.println(string + "\n金币：" + knight.getGold() + "\n============================");
                    System.out.println("输入物品编号 -1退出");
                    int b = Utils.Scanner();
                    if (b == -1) {
                        break;
                    }
                    if (b > items.size()) {
                        System.out.println("编号不存在");
                        break;
                    } else {
                        Item item = items.get(b);
                        if (knight.getGold() < item.getGold() * 3) {
                            System.out.println("金币不足");
                            break;
                        } else {
                            Knight.getBackpack().putBackpack(item);
                            knight.setGold(knight.getGold() - item.getGold() * 3);
                            items.remove(b);
                            break;
                        }
                    }
                case 2:
                    Backpack.getInstance().openBackpack();
                    System.out.println("输入出售ID -1退出");
                    int num = Utils.Scanner();
                    if (num == -1) {
                        break;
                    }
                    for (ConcurrentHashMap.Entry<Item, Integer> entry : Backpack.getItems().entrySet()) {
                        if (num == entry.getKey().getItemNumber()) {
                            Backpack.getInstance().dropItemFromBackpack(num, 1);
                            knight.setGold(knight.getGold() + entry.getKey().getGold());
                            System.out.println("卖出" + entry.getKey().getItemName() + ",获得" + entry.getKey().getGold() + "金币");
                            return;
                        }
                    }
                    System.out.println("无此ID");
                    break;
                default:
                    return;
            }
        }
    }

    //买卖饰品工具类
    public void buyAndSoltAccessories(List<Accessories> accessories) {
        while (true) {
            System.out.println("1.买\t2.卖\t3.-1退出");
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < accessories.size(); i++) {
                sb.append(i + "、" + accessories.get(i).getItemName() + "\t" + accessories.get(i).getIntroduce() + "\t" + accessories.get(i).getGold() * 3 + "\n");
            }
            String string = String.valueOf(sb);
            int a = Utils.Scanner();
            switch (a) {
                case 1:
                    System.out.println(string + "\n金币：" + knight.getGold() + "\n============================");
                    System.out.println("输入物品编号 -1退出");
                    Scanner scanner1 = new Scanner(System.in);
                    int b = scanner1.nextInt();
                    if (b == -1) {
                        break;
                    }
                    if (b > accessories.size()) {
                        System.out.println("编号不存在");
                        break;
                    } else {
                        Item item = accessories.get(b);
                        if (knight.getGold() < item.getGold() * 3) {
                            System.out.println("金币不足");
                            break;
                        } else {
                            Knight.getAccessoriesBackPack().putAccessories(accessories.get(b));
                            knight.setGold(knight.getGold() - item.getGold() * 3);
                            accessories.remove(b);
                            break;
                        }
                    }
                case 2:
                    Backpack.getInstance().openBackpack();
                    System.out.println("输入出售ID -1退出");
                    Scanner scanner2 = new Scanner(System.in);
                    int num = scanner2.nextInt();
                    if (num == -1) {
                        break;
                    }
                    for (ConcurrentHashMap.Entry<Item, Integer> entry : Backpack.getItems().entrySet()) {
                        if (num == entry.getKey().getItemNumber()) {
                            AccessoriesBackPack.getInstance().dropAccessories(num);
                            knight.setGold(knight.getGold() + entry.getKey().getGold());
                            break;
                        }
                    }
                    System.out.println("无此ID");
                    break;
                default:
                    return;
            }
        }
    }

    //武器店货物
    public List<equipment> weapons() {
        List<KnightAndDragon.Bean.Equipment.equipment> weapons = new ArrayList<>(10);
        for (int i = 0; i < 6; i++) {
            weapon weapon = weaponFactory.createWeaponFactory();
            weapons.add(weapon);
        }
        return weapons;
    }

    //装备店货物
    public List<equipment> equipments() {
        List<equipment> equipments = new ArrayList<>(10);
        for (int i = 0; i < 6; i++) {
            equipment equipment = ArmorFactory.createEquipmentFactory();
            equipments.add(equipment);
        }
        return equipments;
    }

    //盾牌店货物
    public List<equipment> shields() {
        List<equipment> shields = new ArrayList<>(10);
        for (int i = 0; i < 6; i++) {
            shield shield = shieldFactory.createShieldEquipmentFactory();
            shields.add(shield);
        }
        return shields;
    }

    //杂货店货物
    public List<Item> itemss() {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            items.add(Items.getItemsMap().get(RandomGetDouble.getInteger(Items.getItemsMap().size())));
        }
        return items;
    }

    //饰品店货物
    public List<Accessories> accessories() {
        List<Accessories> accessories = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            accessories.add(Items.getAccessoriesHashMap().get(RandomGetDouble.getAccessories()));
        }
        return accessories;
    }

    //第二章遗迹
    // 第一关
    public void repicOne() {
        System.out.println("你打开了门，里面是一条漆黑的走廊，你小心翼翼的走了进去，来到第一个打大厅");
        System.out.println("大厅的对面有另一道石门，厅的中心有一个石盆，石盆附近有几个人类的尸体，看起来像几个死掉的冒险家，你慢慢的靠近了石盆，只见石盆的下面有字“通往光明的道路上不可避免的会出现牺牲”");
        System.out.println("石盆的底座上有三个孔，孔里的液体早已干涸，你隐约能看出其中一个孔上面有水的痕迹，其他两个看不清楚，看来打开石门的关键是要往石盆里灌满什么东西，只不过此时已经没有了选项");
        System.out.println("你思考了片刻，决定");
        System.out.println("1.观察附近的情况\t2.蛮力攻击石门\t3.离开遗迹");
        Integer b = Utils.Scanner();
        switch (b) {
            case 1:
                System.out.println("你仔细看了看附近人类的尸体，发现他们的身上带着一个喝了一半水的水壶，一个满的油壶，一把小刻刀，一个火把，你仔细想了想，决定往石盆里注入（解密题，输入你想注入的东西）");
                String str = Utils.StringScanner();
                if (str.contains("血")) {
                    System.out.println("你拿起小刻刀，把自己的胳膊划了一个小口，血液流进了石盆里");
                    System.out.println("双手失去10点生命");
                    knight.setArmRight((knight.getArmRight() - 10) >= 0 ? knight.getArmRight() - 10 : 0);
                    knight.setArmLeft((knight.getArmLeft() - 10) >= 0 ? knight.getArmLeft() - 10 : 0);
                    System.out.println("第一道门缓缓打开了");
                    this.repinTwo();
                } else {
                    System.out.println("地面上喷出了火焰，你被轰出了遗迹");
                    System.out.println("整体血量失去一半");
                    knight.setHead(knight.getHead() / 2);
                    knight.setArmRight(knight.getArmRight() / 2);
                    knight.setArmLeft(knight.getArmLeft() / 2);
                    knight.setLegRight(knight.getLegRight() / 2);
                    knight.setLegLeft(knight.getLegLeft() / 2);
                    knight.setBody(knight.getBody() / 2);
                }
                break;
            default:
                break;
        }
    }

    //第二关
    public void repinTwo() {
        System.out.println("你来到了第二个大厅，对面仍然是一道关闭的大门，这个大厅里面空荡荡的，只有5个人俑并排着站在一起");
        System.out.println("旁边的地上有一句话：生命的前后不在开头和结尾");
        System.out.println("1.攻击人俑\t2.观察四周\t3.离开");
        Integer a = Utils.Scanner();
        switch (a) {
            case 1:
                System.out.println("请输入攻击顺序，中间用#隔开，例如：1#2#3#4#5");
                String str = Utils.StringScanner();
                if (str.equals("3#2#4#1#5")) {
                    this.repicThree();
                } else {
                    System.out.println("周围的墙壁轰隆了一声，你下意识的去看门，发现没有打开，四周一股毒气扑面而来，你捂着鼻子狂奔出去，慌乱中，丢失了所有金币");
                    knight.setGold(0);
                    System.out.println("看来这个遗迹是不能进去了，你叹了口气，离开了这里");
                }
                break;
            case 2:
                System.out.println("你观察了一会，突然发现5个人俑裂开了，5个模糊的身影朝你扑来");
                for (int i = 0; i < 4; i++) {
                    enemy enemy = enemyList.createEnemyFactory(a);
                    Action.process(knight, enemy);
                }
                enemy enemy = Boss.getInstance().getEnemies().get(0);
                Action.process(knight, enemy);
                System.out.println("打败了5个人俑，对面的门开了");
                this.repicThree();
                break;
            default:
                break;
        }
    }

    //第三关
    public void repicThree() {
        System.out.println("第三个大厅金碧辉煌，中间有一个巨大的宝箱，你欣喜若狂，看来宝物就在这个地方");
        System.out.println("你跑上前去，突然旁边的墙壁动了一下，一个巨大的黑影打了过来");
        enemy enemy = Boss.getInstance().getEnemies().get(2);
        Action.process(knight, enemy);
        System.out.println("你打败了黑龙");
        knight.setGold(knight.getGold() + 100);
        System.out.println("获得100g");
        Backpack.getInstance().putBackpack(Items.getBossMap().get(RandomGetDouble.getInteger(3004,3006)));
        Backpack.getInstance().putBackpack(Items.getItemsMap().get(RandomGetDouble.getInteger(Items.getItemsMap().size())));
        AccessoriesBackPack.getInstance().putAccessories(Items.getAccessoriesHashMap().get(Items.getAccessoriesHashMap().size()));
        System.out.println("你离开了遗迹");
    }


    //第一章
    //一个女人
    @Effect(startNum = "101")
    public void aWoman() {
        System.out.println("“hi，小伙子”，森林前方的一个女人喊住了你");
        System.out.println("你停了下来，打量了一下眼前这个女人，只见她穿着沾满污渍的老旧的羊毛长裙，脸上的皱纹多的让你觉得发毛");
        System.out.println("“你看起来有急事要去做”，这个女人颤颤的说道，“我知道你要去哪，我这里有个东西能帮到你，不过你得花点钱才行”,你凭借着多年的丰富阅历，从她满脸褶皱的脸上发现到了一丝不易察觉的狡猾的微笑");
        System.out.println("1.掏钱  2.忽略她");
        int a = Utils.Scanner();
        switch (a) {
            case 1:
                if (knight.getGold() >= 30) {
                    System.out.println("你拿出了一袋钱，换了她一样东西");
                    knight.setGold(knight.getGold() - 30);
                    System.out.println("失去30块");
                    Accessories accessories = Items.getAccessoriesHashMap().get(RandomGetDouble.getAccessories());
                    Knight.getAccessoriesBackPack().putAccessories(accessories);
                    System.out.println("得到" + accessories.getItemName());
                } else {
                    enemy enemy = enemyList.createEnemyFactory(a);
                    System.out.println("“穷鬼，没钱还来打扰我，去死吧”");
                    Action.process(knight, enemy);
                }
                break;
            default:
                enemy enemy = enemyList.createEnemyFactory(a);
                System.out.println("拿钱来，别想跑");
                Action.process(knight, enemy);
                break;
        }
    }


    //哥布林哨兵
    @Effect(startNum = "102")
    public void Goblinsentry() {
        System.out.println("====================================");
        System.out.println("前面的森林里有动静");
        System.out.println("是一队哥布林哨兵");
        System.out.println("你决定");
        System.out.println("1.偷袭\t2.战斗\t3.偷偷离开");
        Integer a = Utils.Scanner();
        switch (a) {
            case 1:
                enemy enemy1 = enemyList.getEnemyOrcList().get(2);
                enemy enemy2 = enemyList.getEnemyOrcList().get(2);
                enemy enemy3 = enemyList.getEnemyOrcList().get(5);
                double d = RandomGetDouble.randomDecimals();
                if (d <= 0.5) {
                    System.out.println("偷袭成功");
                    enemy1.setEnemyBlood(0);
                    Action.judgeEnemyDeath(enemy1);
                    Action.getDrop();
                    enemy2.setEnemyBlood(0);
                    Action.judgeEnemyDeath(enemy2);
                    Action.getDrop();
                    enemy3.setEnemyBlood(0);
                    Action.judgeEnemyDeath(enemy3);
                    Action.getDrop();
                    Item item = Items.getIssueMap().get(4001);
                    System.out.println("你获得了" + item.getItemName());
                    Backpack.getInstance().putBackpack(item);
                } else {
                    System.out.println("偷袭失败，敌人被激怒了，暴击率+20%");
                    enemy1.setCriticalStrike(0.3);
                    Action.process(knight, enemy1);
                    enemy2.setCriticalStrike(0.3);
                    Action.process(knight, enemy2);
                    enemy3.setCriticalStrike(0.3);
                    Action.process(knight, enemy3);
                    Item item = Items.getIssueMap().get(4001);
                    System.out.println("你获得了" + item.getItemName());
                    Backpack.getInstance().putBackpack(item);
                }
                break;
            case 2:
                enemy enemy5 = enemyList.getEnemyOrcList().get(2);
                enemy enemy4 = enemyList.getEnemyOrcList().get(2);
                enemy enemy6 = enemyList.getEnemyOrcList().get(5);
                Action.process(knight, enemy5);
                Action.process(knight, enemy4);
                Action.process(knight, enemy6);
                Item item = Items.getIssueMap().get(4001);
                System.out.println("你发现哥布林的腰间挂着一把钥匙");
                Backpack.getInstance().putBackpack(item);
                break;
            default:
                break;
        }

    }


    //神秘的法师
    @Effect(startNum = "103")
    public void mysteriousMaster() {
        System.out.println("============================================");
        System.out.println("天色渐暗，高大的树木中间透出了微微的火光");
        System.out.println("你摸索着靠了过去，发现是个小木房子，貌似有人居住，你很奇怪，在满是哥布林的森林里，为什么还有人生活");
        System.out.println("看起来可以住，你心想着，打算今晚在这留宿一下");
        System.out.println("1.敲门\t2.离开");
        Integer a = Utils.Scanner();
        switch (a) {
            case 1:
                System.out.println("你敲了敲们，开门的是一个年迈的老先生，留着长长的白胡子，带着一副小圆框眼镜，头上还带着一顶奇怪的高脚帽");
                TimeSleep.timeSleep(500);
                System.out.println("你向他说明了来意，他点点头让你进来，你打量了房子的内部，里面有各种魔法书和魔法道具，看起来是个魔法师的房子");
                TimeSleep.timeSleep(500);
                System.out.println("“放心吧，我在附近设了结界，哥布林看不到这儿，这个森林虽然有点危险，但是确实很安静，不会打扰我研习魔法”，白胡子老先生说，“倒是你”，他看了我一眼说道“这么晚了怎么还会在这”");
                TimeSleep.timeSleep(500);
                System.out.println("我跟他说了一下我的情况，他沉默了一会，低头小声说了一句“看来是真的”，然后他抬起头看着我，说：“既然这样，我就帮你一下吧，你有什么需要我帮你的吗？”");
                TimeSleep.timeSleep(500);
                System.out.println("1.我想学习魔法\t2.我需要更多的技能\t3.我需要取掉身上的一件饰品\t4.只要留宿就好");
                Integer b = Utils.Scanner();
                switch (b) {
                    case 1:
                        System.out.println("白胡子给了你一瓶药水，你喝了下去，感觉魔法能力上升了");
                        System.out.println("魔法攻击力增高1点");
                        knight.setMagicAttack(knight.getMagicAttack() + 1);
                        break;
                    case 2:
                        System.out.println("白胡子朝你年了一句咒语，你觉得精神倍加");
                        System.out.println("加了一点技能点");
                        knight.setSkillPoints(knight.getSkillPoints() + 1);
                        break;
                    case 3:
                        AccessoriesBackPack accessoriesBackPack = AccessoriesBackPack.getInstance();
                        accessoriesBackPack.openAccessoriesBackPack();
                        System.out.println("==============================");
                        System.out.println("输入饰品编号");
                        Integer c = Utils.Scanner();
                        accessoriesBackPack.dropAccessories(c);
                        break;
                    default:
                        System.out.println("既然这样，那我送你一件东西吧");
                        Backpack.getInstance().putBackpack(Items.getItemsMap().get(RandomGetDouble.getInteger(Items.getItemsMap().size())));
                        break;
                }
                System.out.println("第二天，你向白胡子告了别，继续往北前进");
                break;
            default:
                break;
        }
        ;
    }


    //哥布林铁匠
    @Effect(startNum = "104")
    public void GoblinBlaksmith() {
        System.out.println("前面叮叮当当传来打铁的声音");
        System.out.println("你走上前一看，是个哥布林武器匠");
        System.out.println("要来看看吗");
        List<equipment> weapons = this.weapons();
        buyAndSoltEquipment(weapons);
    }


    //沉睡的哥布林王
    @Effect(startNum = "105")
    public void GoblinKing() {
        System.out.println("前方有一个正在沉睡的Goblin，看起来比一般的哥布林大很多");
        System.out.println("1.偷袭\t2.攻击\t3.偷偷离开");
        enemy enemy = Boss.getInstance().getEnemies().get(0);
        int a = Utils.Scanner();
        switch (a) {
            case 1:
                if (RandomGetDouble.randomDecimals() <= 0.5) {
                    System.out.println("偷袭失败，" + enemy.getEnemyName() + "暴击增加30%");
                    enemy.setCriticalStrike(enemy.getCriticalStrike() + 0.3);
                    Action.process(knight, enemy);
                    Item item = Items.getBossMap().get(RandomGetDouble.getGoblinKing());
                    Backpack.getInstance().putBackpack(item);
                } else {
                    System.out.println("偷袭成功," + enemy.getEnemyName() + "生命值减少一半");
                    enemy.setEnemyBlood(enemy.getEnemyBlood() / 2);
                    Action.process(knight, enemy);
                    Item item = Items.getBossMap().get(RandomGetDouble.getGoblinKing());
                    Backpack.getInstance().putBackpack(item);
                }
                break;
            case 2:
                Action.process(knight, enemy);
                Item item = Items.getBossMap().get(RandomGetDouble.getGoblinKing());
                Backpack.getInstance().putBackpack(item);
                break;
            default:
                break;
        }
    }

    //篝火
    @Effect(startNum = "106")
    public void bonfire() {
        System.out.println("前方有一篝火，看起来可以休息");
        System.out.println("1.休息\t2.继续前进");
        int a = Utils.Scanner();
        switch (a) {
            case 1:
                if (RandomGetDouble.randomDecimals() <= 0.5) {
                    System.out.println("zzz（恢复生命）");
                    knight.setHead(Knight.getHeadSum());
                    knight.setArmLeft(Knight.getArmLeftSum());
                    knight.setArmRight(Knight.getArmRightSum());
                    knight.setLegLeft(Knight.getLegLeftSum());
                    knight.setLegRight(Knight.getLegRightSum());
                    knight.setBody(Knight.getBodySum());
                    TimeSleep.timeSleep(2000);
                    System.out.println("一觉醒来\n===================================================");
                } else {
                    enemy enemy = enemyList.createEnemyFactory(a);
                    System.out.println("这是个陷阱,你被偷袭了");
                    Action.process(knight, enemy);
                }
                break;
            default:
                break;
        }
    }


    //洞穴
    @Effect(startNum = "107")
    public void ACave() {
        System.out.println("涉过一条小河，你来到了一座高山的山脚下");
        System.out.println("在灌木丛茂密的地方，你发现了一个洞穴，看起来好像很久没有人进过了");
        System.out.println("1.进去看看\t2.离开");
        int a = Utils.Scanner();
        switch (a) {
            case 1:
                if (RandomGetDouble.randomDecimals() < 0.2) {
                    System.out.println("有敌人！！");
                    enemy enemy = enemyList.createEnemyFactory(a);
                    Action.process(knight, enemy);
                } else {
                    System.out.println("你发现了一个宝箱");
                    Accessories item = Items.getAccessoriesHashMap().get(RandomGetDouble.getAccessories());
                    AccessoriesBackPack.getInstance().putAccessories(item);
                }
            default:
                break;
        }
    }

    //哥布林洞穴
    @Effect(startNum = "108")
    public void GoblinCave() {
        System.out.println("山爬到了一半，你突然听到附近有什么东西在说话");
        System.out.println("你停了下来，寻找着声音的来源");
        TimeSleep.timeSleep(500);
        System.out.println("拨开一片灌木，你发现前面有两个哥布林");
        System.out.println("1.偷袭\t2.战斗\t3.静悄悄的离开");
        Integer a = Utils.Scanner();
        switch (a) {
            case 1:
                enemy enemy1 = enemyList.getEnemyOrcList().get(2);
                enemy enemy2 = enemyList.getEnemyOrcList().get(5);
                double d = RandomGetDouble.randomDecimals();
                if (d < 0.5) {
                    System.out.println(enemy1.getEnemyName() + "偷袭成功");
                    enemy1.setEnemyBlood(0);
                    Action.judgeEnemyDeath(enemy1);
                    Action.getDrop();
                    System.out.println("=======================================\n" + enemy2.getEnemyName() + "发现了你");
                    Action.process(knight, enemy2);
                    System.out.println("=======================================\n打败了两个哥布林，你发现在他们身后，有一个一人大小的地洞");
                    GoblinKingdom();
                } else if (d >= 0.5 && d < 0.75) {
                    System.out.println("偷袭成功,地方阵亡");
                    enemy1.setEnemyBlood(0);
                    enemy2.setEnemyBlood(0);
                    Action.judgeEnemyDeath(enemy1);
                    Action.getDrop();
                    Action.judgeEnemyDeath(enemy2);
                    Action.getDrop();
                    System.out.println("=======================================\n打败了两个哥布林，你发现在他们身后，有一个一人大小的地洞");
                    GoblinKingdom();
                } else {
                    System.out.println("偷袭失败，敌人被激怒了，暴击率+20%");
                    enemy1.setCriticalStrike(0.3);
                    Action.process(knight, enemy1);
                    enemy2.setCriticalStrike(0.3);
                    Action.process(knight, enemy2);
                    GoblinKingdom();
                }
                break;
            case 2:
                enemy enemy3 = enemyList.getEnemyOrcList().get(2);
                enemy enemy4 = enemyList.getEnemyOrcList().get(5);
                Action.process(knight, enemy3);
                Action.process(knight, enemy4);
                GoblinKingdom();
                break;
            default:
                break;
        }

    }

    //哥布林洞穴剧本
    public void GoblinKingdom() {
        System.out.println("地洞门口有一个石头大门，上面有个哥布林形状的钥匙孔");
        if (!Backpack.findItem(4001)) {
            System.out.println("你没有哥布林的钥匙，只好离开了这里");
            return;
        }
        Backpack.getInstance().dropItemFromBackpack(4001, 1);
        System.out.println("你使用了哥布林的钥匙,进到了洞穴里面");
        for (int i = 0; i <= 3; i++) {
            if (i == 0) {
                System.out.println("前方出现三条岔路");
                System.out.println("1.往左走\t2.往右走\t3.往前走");
                Integer a = Utils.Scanner();
            }
            if (i == 1) {
                System.out.println("道路尽头有一间小屋");
                System.out.println("1.进去看看\t2.离开");
                Utils.Scanner();
            }
            if (i == 2) {
                System.out.println("前方好像有火光");
                System.out.println("1.靠近\t2.离开");
                Utils.Scanner();
            }
            if (i == 3) {
                System.out.println("洞穴似乎到尽头了，你加快了脚步，看看周围有什么");
            }
            Double d = RandomGetDouble.randomDecimals();
            if (d <= 0.1) {
                System.out.println("===========");
                System.out.println("遭遇敌人");
                enemy enemy = enemyList.getEnemyOrcList().get(2);
                Action.process(knight, enemy);
            } else if (d > 0.1 && d <= 0.2) {
                System.out.println("===========");
                System.out.println("遭遇敌人");
                enemy enemy = enemyList.getEnemyOrcList().get(5);
                Action.process(knight, enemy);
            } else if (d > 0.2 && d <= 0.5) {
                System.out.println("===========");
                System.out.println("得到宝物");
                Accessories item = Items.getAccessoriesHashMap().get(RandomGetDouble.getAccessories());
                AccessoriesBackPack.getInstance().putAccessories(item);
            } else if (d > 0.5 && d <= 0.75) {
                System.out.println("===========");
                System.out.println("遇见巡逻小队");
                List<enemy> enemies = new ArrayList<>();
                enemy enemy = enemyList.getEnemyOrcList().get(2);
                enemy enemy1 = enemyList.getEnemyOrcList().get(5);
                enemy enemy2 = enemyList.getEnemyOrcList().get(1);
                enemies.add(enemy);
                enemies.add(enemy1);
                enemies.add(enemy2);
                for (enemy enemy3 : enemies) {
                    Action.process(knight, enemy3);
                }
                TimeSleep.timeSleep(1000);
                System.out.println("你打败了巡逻小队，从他们身上发现了一样东西");
                TimeSleep.timeSleep(1000);
                Accessories item = Items.getAccessoriesHashMap().get(RandomGetDouble.getAccessories());
                AccessoriesBackPack.getInstance().putAccessories(item);
            } else if (d > 0.75 && d <= 0.9) {
                System.out.println("前方有篝火，可以好好休息一下（全体生命恢复20）");

            } else {
                TimeSleep.timeSleep(1000);
                System.out.println("什么事也没有发生\n==========================================");
                TimeSleep.timeSleep(1000);
            }
        }
        System.out.println("洞穴的尽头是一个大厅，四周挤满了哥布林，大厅的中央有一个巨大的黑影，头顶上戴着类似王冠的恭喜，你看着它，也能发现它正在盯着你\n=================================================");
        enemy enemy = Boss.getInstance().getEnemies().get(0);
        Action.process(knight, enemy);
        Item item = Items.getBossMap().get(RandomGetDouble.getGoblinKing());
        Item item1 = Items.getBossMap().get(RandomGetDouble.getGoblinKing());
        Backpack.getInstance().putBackpack(item);
        Backpack.getInstance().putBackpack(item1);
        System.out.println("哥布林王应声倒下，其他哥布林四散而逃");
        System.out.println("你顺着洞口继续往前走，阳光从前方的一个小洞透了进来，你走出了哥布林的洞穴");
    }

    //哥布林商人
    @Effect(startNum = "109")
    public void GoblinSaler() {
        System.out.println("你走在森林里，发现前面有一个哥布林，它是一个哥布林行脚商人，似乎对你没有任何敌意");
        System.out.println("来吧，先生，过来看看，我这可是上等的宝物");
        List<equipment> equipment = this.equipments();
        buyAndSoltEquipment(equipment);
    }

    //满月
    @Effect(startNum = "110")
    public void moonNight() {
        System.out.println("满月，是狼人捕食的夜晚");
        TimeSleep.timeSleep(500);
        System.out.println("你刚刚躺下，觉得附近有悉悉索索的声音");
        TimeSleep.timeSleep(500);
        System.out.println("还没等你反应过来，有东西扑了过来");
        knight.setBody((knight.getBody() - 10) >= 1 ? knight.getBody() - 10 : 1);
        System.out.println("受到偷袭，body血量-10");
        enemy enemy = enemyList.getEnemyDragonList().get(4);
        Action.process(knight, enemy);
    }

    //强盗和宝藏
    @Effect(startNum = "111")
    public void robberAndPrecious() {
        System.out.println("“把钱交出来”你的四周里蹦出来一伙强盗");
        System.out.println("你决定\n1.交钱(失去全部金币)\t2.伪装成另一伙强盗和谈\t3.战斗");
        List<enemy> enemies = new ArrayList<>();
        enemies.add(enemyList.getEnemyPersonList().get(2));
        enemies.add(enemyList.getEnemyPersonList().get(2));
        enemies.add(enemyList.getEnemyPersonList().get(2));
        enemies.add(enemyList.getEnemyPersonList().get(2));
        Integer a = Utils.Scanner();
        switch (a) {
            case 1:
                knight.setGold(0);
                System.out.println("失去全部金币");
                break;
            case 2:
                System.out.println("你谎称之前抢劫了一张藏宝图，里面有巨量的财富，藏宝图需要火焰烘烤才能看见里面的内容");
                System.out.println("于是强盗把你带到了他们的营地，你掏出了一张纸给他们去烘烤，然后偷偷观察附近的环境");
                System.out.println("1.偷袭\t2.战斗\t3.逃跑");
                Integer b = Utils.Scanner();
                if (b == 1) {
                    if (RandomGetDouble.randomDecimals() >= 0.5) {
                        System.out.println("偷袭成功");
                        System.out.println("强盗们被打死了");
                        System.out.println("你仔细翻找了强盗的营地，发现一个宝箱，打开宝箱获得100g");
                        knight.setGold(knight.getGold() + 100);
                    } else {
                        System.out.println("偷袭失败，敌人被惹怒了");
                        for (enemy e : enemies) {
                            e.setCriticalStrike(0.3);
                            e.setDodge(0.2);
                            Action.process(knight, e);
                        }
                        System.out.println("强盗们被打死了");
                        System.out.println("你仔细翻找了强盗的营地，发现一个宝箱，打开宝箱获得200g");
                        knight.setGold(knight.getGold() + 200);
                    }
                } else if (b == 2) {
                    for (enemy e : enemies) {
                        Action.process(knight, e);
                    }
                    System.out.println("强盗们被打死了");
                    System.out.println("你仔细翻找了强盗的营地，发现一个宝箱，打开宝箱获得200g");
                    knight.setGold(knight.getGold() + 200);
                } else {
                    if (RandomGetDouble.randomDecimals() >= 0.5) {
                        System.out.println("逃跑成功");
                    } else {
                        System.out.println("逃跑失败");
                        for (enemy e : enemies) {
                            e.setCriticalStrike(0.3);
                            e.setDodge(0.2);
                            Action.process(knight, e);
                        }
                    }
                }
                break;
            default:
                for (enemy e : enemies) {
                    Action.process(knight, e);
                }
                break;
        }

    }

    //第一段旅程结束
    public void oneEnd() {
        System.out.println("格尔里斯，被誉为人类的北方明珠");
        TimeSleep.timeSleep(500);
        System.out.println("因为距离矮人领地比较近，所以这里的贸易很发达，尤其是这里的矮人锻造品，很受人类的欢迎，这使得这座占地面积并不是很大的城市却每天都有着熙熙攘攘各色各样的人来到这里做交易");
        TimeSleep.timeSleep(500);
        System.out.println("虽然污染一直在扩散，但这边的人们似乎丝毫不在意");
        TimeSleep.timeSleep(500);
        System.out.println("你决定在这里打听一下女儿的下落");
        TimeSleep.timeSleep(500);
        //武器
        List<equipment> weapons = this.weapons();
        //装备
        List<equipment> equipments = this.equipments();
        //盾牌
        List<equipment> shields = this.shields();
        //杂物
        List<Item> items = this.itemss();
        while (true) {
            System.out.println("1.武器店\t2.装备店\t3.盾牌店\t4.杂货店\t5.旅店\t6.打听女儿的下落\t7.离开");
            Integer number = Utils.Scanner();
            switch (number) {
                case 1:
                    buyAndSoltEquipment(weapons);
                    break;
                case 2:
                    buyAndSoltEquipment(equipments);
                    break;
                case 3:
                    buyAndSoltEquipment(shields);
                    break;
                case 4:
                    buyAndSellItem(items);
                    break;
                case 5:
                    restInHotel();
                    break;
                case 6:
                    System.out.println("================================================================");
                    System.out.println("你不停的询问着每一个过路人，几乎所有人都说不知道，你沮丧的走进了酒馆，朝着酒保点了一杯酒，闷头喝了起来");
                    System.out.println("隐约间，你听到旁边桌上，有个人提到了萨尔莫斯，女孩等字眼");
                    TimeSleep.timeSleep(1000);
                    System.out.println("你一下子精神了起来，仔细听着他们的对话");
                    System.out.println("“你知道吧，就是西边的那过来的那个人”隔壁桌穿褐色袍子的一个人抿了一口酒，说道“听说他在黑暗之地，见到了一个人”");
                    System.out.println("“谁啊”，旁边的人问道");
                    TimeSleep.timeSleep(500);
                    System.out.println("“你听过一千年前的那个传说吗？就是那个当初奇洛亚大陆差点毁灭的传说”褐袍的人压低了声音说道，“传说有个人类与精灵的混血儿，从小就天赋异禀，可惜后来走上了邪恶的道路，他建立了暗影之国，大举入侵其他国家，利用他的黑暗力量操控着被他统治的人，当时整个奇洛亚大陆几乎都被他统治了，最后还是东边的一个公主牺牲生命封印了才拯救了奇洛亚大陆上的其他生命”");
                    TimeSleep.timeSleep(500);
                    System.out.println("“你说的是那个叫萨尔什么什么的魔王吗”，旁边的人惊讶道，“难道他又回来了！”");
                    System.out.println("“嘘，小声点”,然后他们再一次压低了声音，交头接耳的嘀咕着什么");
                    TimeSleep.timeSleep(500);
                    System.out.println("你听到这，实在忍不住了，放下手中的酒杯，大步走向褐袍人，还没等他反应过来，一把揪住了他的领子，让他把整个事情说清楚");
                    System.out.println("褐袍人吓了一跳，慌慌张张的说道具体他也不知道，他只是听其他人说的，听说最近萨尔莫斯派手下在大陆上寻找6-7岁的蓝瞳女孩，只要符合条件的女孩全部被抓走了");
                    TimeSleep.timeSleep(500);
                    System.out.println("你问他这些抓到什么地方去了，褐袍人结结巴巴的说最近在北方矮人的金矿镇有人看见过萨尔莫斯的爪牙们经常前往那里，其他的他就不知道了");
                    System.out.println("你松开了褐袍人的领子，金矿镇，看来有目标了");
                    System.out.println("想到这里，你背起背包，大步的离开了酒吧\n================================================================");
                    TimeSleep.timeSleep(500);
                    break;
                default:
                    return;
            }
        }
    }

    //第二章
    //渡河
    @Effect(startNum = "201")
    public void ferry() {
        System.out.println("前面是一条穿过森林的小河" + knight.getKnightName() + "走到了河边，你四处张望了一下，发现并没有桥可以让你过去，但是河面上有个小木筏，木筏上貌似有人，你决定\n1、喊船上的人，让他载你过去\t2、游过去\n3、观察水面");
        int a = Utils.Scanner();
        switch (a) {
            case 1:
                System.out.println("船划了过来，是个打渔的渔夫，把你带到河中央的时候，向你索要报酬");
                if (knight.getGold() - 10 * knight.getLevel() >= 0) {
                    knight.setGold(knight.getGold() - 10 * knight.getLevel() >= 0 ? knight.getGold() - 10 * knight.getLevel() : 0);
                } else {
                    System.out.println("你身上钱不够，被渔夫扔下了船，全体血量扣减一半");
                }
                break;
            case 2:
                System.out.println("游到河中央，碰到了暗流，你被暗流卷进去，砸到了头，头减少30点血量");
                knight.setHead(knight.getHead() - 30 >= 1 ? knight.getHead() - 30 : 1);
                break;
            default:
                enemy enemy = enemyList.createEnemyFactory(1);
                System.out.println("你犹豫了，碰到了巡逻的怪物" + enemy.getEnemyName());
                TimeSleep.timeSleep(500);
                Action.process(knight, enemy);
                break;
        }
    }

    //帮助农夫
    @Effect(startNum = "202")
    public void helpFarmers() {
        System.out.println("前方是一片农田，正是丰收的季节，有个农夫要赶在黑暗来临之前把忙做了一年的麦子给收掉，你决定\n1、帮助他\t2、无视他");
        int a = Utils.Scanner();
        switch (a) {
            case 1:
                Item item = Items.getItemsMap().get(RandomGetDouble.getInteger(Items.getItemsMap().size()));
                while (true) {
                    if (item != null) {
                        System.out.println("你和农夫很快收完了麦子，农夫为了感谢你，给了你" + item.getItemName());
                        Backpack.getInstance().putBackpack(item);
                        break;
                    } else {
                        item = Items.getItemsMap().get(RandomGetDouble.getInteger(Items.getItemsMap().size()));
                    }
                }
                break;
            default:
                break;
        }
    }

    //行脚商人
    @Effect(startNum = "203")
    public void equipmentSaler() {
        System.out.println("============================================");
        System.out.println("前面出现了一队武器行脚商人");
        System.out.println("要来看看嘛");
        List<equipment> weapons = this.weapons();
        System.out.println("1.过去看看\t2.无视");
        Integer b = Utils.Scanner();
        switch (b) {
            case 1:
                buyAndSoltEquipment(weapons);
                break;
            default:
                System.out.println("你摇了摇头，从他们身边走了过去");
                break;

        }
    }

    //遗迹
    @Effect(startNum = "204")
    public void relic() {
        System.out.println("在一棵高大的树木后面，有一片废墟");
        System.out.println("你靠了过去，发现是一片上古遗迹");
        System.out.println("遗迹里面有几个哥布林的尸体，看起来遗迹很危险，你决定");
        System.out.println("1.下去看看\t2.离开");
        Integer b = Utils.Scanner();
        switch (b) {
            case 1:
                System.out.println("下面有一道带锁的石门挡在了你的面前");
                System.out.println("1.用蛮力推开它\t2.用魔法破解它\t3.撬锁");
                Integer c = Utils.Scanner();
                switch (c) {
                    case 1:
                        if (knight.getPower() <= 5) {
                            System.out.println("力量不足");
                        } else {
                            this.repicOne();
                        }
                        break;
                    case 2:
                        if (knight.getIntelligence() <= 5) {
                            System.out.println("智力不足");
                        } else {
                            this.repicOne();
                        }
                        break;
                    default:
                        if (knight.getAgility() <= 5) {
                            System.out.println("敏捷不足");
                        } else {
                            this.repicOne();
                        }
                        break;
                }
                break;
            default:
                break;
        }
    }

    //矮人村庄
    @Effect(startNum = "205")
    public void aVillage() {
        System.out.println("======================================================");
        System.out.println("沿着一条小路拐过一个弯，前方出现了一个矮人的小村庄，看起来不是很大");
        System.out.println("你沿着路进到了村庄，村庄面积不大，却很热闹，村里有一个铁匠铺");
        List<equipment> equipment = this.equipments();
        while (true) {
            System.out.println("1.铁匠铺(装备买卖)\t2、旅馆(" + knight.getLevel() * 10 + "金币回满血)\t3、离开村庄");
            int a = Utils.Scanner();
            switch (a) {
                //武器店
                case 1:
                    System.out.println("你好，外乡人，来看看");
                    buyAndSoltEquipment(equipment);
                    break;
                case 2:
                    this.restInHotel();
                    break;
                default:
                    return;
            }
        }
    }

    //银矿镇
    @Effect(startNum = "206")
    public void sliverTown() {
       System.out.println("在通往金矿镇的路上，一座高耸入云的山挡住了你的去路，山脚下，有一座几乎被废弃了的矮人小镇--银矿镇");
       System.out.println("过去的银矿镇大量生产银矿，各地的人们来这采购各种银制品，繁荣程度丝毫不亚于格尔里斯，现在的银矿镇，除了镇长，几乎都只剩下老弱病残了");
       System.out.println("你抬头看了看这座雪山，觉得翻过去是不可能的了，看来只能找镇长问一问其他出路了");
       System.out.println("你找到镇长，跟他说明缘由之后，镇长眉头皱了皱，说道“路倒是有一条，过去银矿镇开采银矿的时候留下的矿洞，直通山的另一面，不过后来有条恶龙盘踞在了哪里，之后没人敢再进去过”");
       System.out.println("“除此之外，也没有其他的路了”");
       System.out.println("听完镇长的话，你咬了咬牙，时间紧迫，看来这个洞是非进不可了，你问清了矿洞的位置，开始朝矿洞走去。。");
    }

    //银矿镇恶龙
    @Effect(startNum = "207")
    public void fightToDragon(){
        TimeSleep.timeSleep(500);
        System.out.println("走了一段路之后，你来到了镇长所说的那个矿洞，里面漆黑一片，不时有尖锐的风声从里面传来，让人不寒而栗");
        TimeSleep.timeSleep(500);
        System.out.println("你掏出火把，摸了摸额头的冷汗，摸着矿道的墙壁，走了进去");
        TimeSleep.timeSleep(500);
        System.out.println("走了大概十分钟左右，除了火把的光亮，已经彻底看不见其他东西了，你咽了口唾沫，耳边传来叽叽的声音，直觉告诉你黑暗中有什么东西在盯着你，果然，还没等你反应过来，有东西就扑了过来");
        for (int i=0;i<=2;i++){
            enemy enemy=enemyList.getEnemyDragonList().get(3);
            Action.process(knight,enemy);
        }
        TimeSleep.timeSleep(1500);
        System.out.println("耳边的声音消失了，你来到了一个岔路口");
        System.out.println("1.走左边\t2.走右边");
        Integer a=Utils.Scanner();
        switch (a){
            case 2:
                System.out.println("你发现了一个废旧的手动矿车，看起来还能用，也许可以利用它加快速度");
                System.out.println("移动速度提高100%");
                knight.setIniActionTime(knight.getIniActionTime()*2);
                break;
            default:
                break;
        }
        System.out.println("乘着矿车前进了10分钟，你来到了一个巨大的深坑边缘，深坑的地步有一只巨大的黑龙，黑龙嗅到了你的气味，巨大的翅膀张了开，炽热的火焰朝你喷了过来，砸到了顶部的矿壁");
        TimeSleep.timeSleep(1500);
        System.out.println("出口就在龙的脚下，看来想出去的唯一出路，就是干掉这条黑龙了");
        enemy enemy= Boss.getInstance().getEnemies().get(3);
        Action.process(knight,enemy);
        Item item=Items.getBossMap().get(RandomGetDouble.getInteger(3004,3006));
        TimeSleep.timeSleep(1500);
        System.out.println("解决了这条龙，你加快了矿车的速度，远处的光点逐渐变大，一瞬间，你出了矿道");
        System.out.println("失去矿车，移动速度减少100%");
        System.out.println("前方的地平线上出现了一个大型城镇，一面巨大的旗子上印有金子的模样，金矿镇快要到了");
        knight.setIniActionTime(knight.getIniActionTime()/2);
        TimeSleep.timeSleep(1500);
    }

    //矮人商人
    @Effect(startNum = "208")
    public void thedwarfMerchants() {
        System.out.println("======================================================");
        System.out.println("在一个独木桥，你遇到了一个矮人族的游行商人");
        System.out.println("“来看看吧，先生，都是上好的货”");
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Item item = Items.getItemsMap().get(RandomGetDouble.getInteger(Items.getItemsMap().size()));
            if (item == null) {
                continue;
            }
            items.add(item);
        }
        buyAndSellItem(items);

    }

    //获取事件
    public static void runEvent() {
        Knight knight = Knight.getInstance();
        Integer num = a * 100;
        int count = 0;
        Class clz = Event.class;
        Method[] methods = clz.getMethods();
        for (Method method1 : methods) {
            if (method1.isAnnotationPresent(Effect.class)) {
                Effect effect = method1.getAnnotation(Effect.class);
                if (!(null == effect.startNum() || effect.startNum().equals(""))) {
                    if (effect.startNum().startsWith(a + "")) {
                        if (list.contains(effect.startNum())) {
                            try {
                                method1.invoke(Event.getInstance());
                                list.remove(effect.startNum());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    public static void InitEvent() {
        synchronized (Object.class) {
            Class clz = Event.class;
            Method[] methods = clz.getMethods();
            for (Method method1 : methods) {
                if (method1.isAnnotationPresent(Effect.class)) {
                    Effect effect = method1.getAnnotation(Effect.class);
                    if (!(null == effect.startNum() || effect.startNum().equals(""))) {
                        list.add(effect.startNum());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        InitClass initClass = InitClass.getInstance();
        initClass.InitClass();
        Event event = Event.getInstance();
        Event.setA(1);
        runEvent();

    }
}
