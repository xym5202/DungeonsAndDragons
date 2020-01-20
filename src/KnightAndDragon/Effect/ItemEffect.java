package KnightAndDragon.Effect;

import KnightAndDragon.Bean.Items.AccessoriesBackPack;
import KnightAndDragon.Bean.Items.Backpack;
import KnightAndDragon.Bean.Items.EquipmentBackpack;
import KnightAndDragon.Bean.Object.Knight;

import java.util.Scanner;

public class ItemEffect {


    //效果编号
    private Integer effectNumber;

    //效果名称
    private String effectName;

    public ItemEffect(){}

    public ItemEffect(Integer effectNumber, String effectName) {
        this.effectNumber = effectNumber;
        this.effectName = effectName;
    }

    public Integer getEffectNumber() {
        return effectNumber;
    }

    public ItemEffect setEffectNumber(Integer effectNumber) {
        this.effectNumber = effectNumber;
        return this;
    }

    public String getEffectName() {
        return effectName;
    }

    public ItemEffect setEffectName(String effectName) {
        this.effectName = effectName;
        return this;
    }

    //背包扩容
    @Effect(startNum = "1")
    public static void dilatationBackpack() {
        Backpack.getInstance().dilatationBackpack();
    }

    //装备包扩容
    @Effect(startNum = "2")
    public static void dilatationEquipmentBackpack() {
        EquipmentBackpack.getInstance().dilatationBackpack();
    }

    //修复装备
    @Effect(startNum = "3")
    public static void repairEquipment() {
        System.out.println("选择装备");
        EquipmentBackpack.getInstance().openEquipmentBackpack();
        Scanner scanner = new Scanner(System.in);
        int b = scanner.nextInt();
        if (b > EquipmentBackpack.getEquipmentList().size()) {
            System.out.println("没有该序号");
            return;
        }
        double dur = EquipmentBackpack.getInstance().getEquipment(b - 1).getDurability() + 20;
        EquipmentBackpack.getInstance().getEquipment(b - 1).setDurability(dur);
    }

    //永久增加1点力量
    @Effect(startNum = "4")
    public static void increasePower() {
        Knight knight = Knight.getInstance();
        knight.setPower(knight.getPower() + 1);
    }

    //永久增加1点智力
    @Effect(startNum = "5")
    public static void increaseIntelligence() {
        Knight knight = Knight.getInstance();
        knight.setIntelligence(knight.getIntelligence() + 1);
    }

    //永久增加1点敏捷
    @Effect(startNum = "6")
    public static void increaseAgility() {
        Knight knight = Knight.getInstance();
        knight.setAgility(knight.getAgility() + 1);
    }

    //永久增加10点最大生命值
    @Effect(startNum = "7")
    public static void increaseBlood() {
        Knight.setHeadSum(Knight.getHeadSum() + 10);
        Knight.setArmLeftSum(Knight.getArmLeftSum() + 10);
        Knight.setArmRightSum(Knight.getArmRightSum() + 10);
        Knight.setLegLeftSum(Knight.getLegLeftSum() + 10);
        Knight.setLegRightSum(Knight.getLegRightSum() + 10);
        Knight.setBodySum(Knight.getBodySum() + 10);
    }

    //永久增加10%攻速
    @Effect(startNum = "8")
    public static void increaseAttackSpeed() {
        Knight knight = Knight.getInstance();
        knight.setIniAttackSpeed(knight.getIniAttackSpeed() * 0.9);
        knight.setAttackSpeed(knight.getAttackSpeed() * 0.9);
    }

    //扩容饰品包
    @Effect(startNum = "9")
    public static void dilatationAccessoriesBackpack(){
        AccessoriesBackPack accessoriesBackPack=AccessoriesBackPack.getInstance();
        accessoriesBackPack.dilatationABP();
    }

}
