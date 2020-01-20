package KnightAndDragon.Bean.Items;

import KnightAndDragon.Bean.Equipment.*;
import KnightAndDragon.Bean.Object.Knight;
import KnightAndDragon.BeanList.Items;
import KnightAndDragon.BeanList.weaponFactory;
import KnightAndDragon.Effect.DeBuffEffect;
import KnightAndDragon.Effect.EquipmentEffect;
import KnightAndDragon.action.Action;
import KnightAndDragon.util.InitClass;
import KnightAndDragon.util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EquipmentBackpack extends Item {

    private static List<equipment> equipmentList;

    private static EquipmentBackpack equipmentBackpack;

    private static Integer capacity = 5;

    static {
        equipmentList = new ArrayList<>();
        equipmentBackpack = new EquipmentBackpack();
    }

    private EquipmentBackpack() {
    }

    public static List<equipment> getEquipmentList() {
        return equipmentList;
    }

    public static Integer getCapacity() {
        return capacity;
    }

    public static void setCapacity(Integer capacity) {
        EquipmentBackpack.capacity = capacity;
    }

    public static EquipmentBackpack getInstance() {
        return equipmentBackpack;
    }

    //放入装备
    public void putEquipment(equipment equipment1) {
        if (equipmentList.size() < capacity) {
            equipmentList.add(equipment1);
            System.out.println("获得:"+equipment1);
        } else {
            System.out.println("装备背包容量不足，是否要替换装备 \n1、是\t2、否\t3、任意键退出");
            int a = Utils.Scanner();
            switch (a) {
                case 1:
                    System.out.println("选择要替换的装备：");
                    equipmentBackpack.openEquipmentBackpack();
                    Scanner scanner1 = new Scanner(System.in);
                    int b = scanner1.nextInt();
                    equipmentList.remove(b - 1);
                    equipmentBackpack.putEquipment(equipment1);
                    break;
                case 2:
                    break;
                default:
                    System.out.println("退出\n==================");
                    break;
            }
        }
    }

    //取出装备
    public equipment getEquipment(int index) {
        if (index <= equipmentList.size()&&index>0) {
            equipment equipment2 = equipmentList.get(index - 1);
            equipmentList.remove(index - 1);
            return equipment2;
        } else {
            System.out.println("没有该序号的装备");
            return null;
        }
    }

    //背包扩容
    public void dilatationBackpack() {
        EquipmentBackpack.capacity += 2;
    }

    //打开背包
    public void openEquipmentBackpack() {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 1;
        for (equipment e :
                equipmentList) {
            stringBuffer.append(i + "、" + e.toString() + "\n");
            i++;
        }
        String str = String.valueOf(stringBuffer);
        if (str.equals("")) {
            str = "无\n================================================================";
        } else {
            str = str + "\n================================================================";
        }
        System.out.println(str);
    }

    //丢弃装备
    public void dropEquipment() {
        System.out.println("请输入要丢弃装备的序号");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        if (index <= equipmentList.size()) {
            equipmentList.remove(index - 1);
        } else {
            System.out.println("无此编号的装备");
        }
    }

    //更换装备
    public void exchangeEquipment() {
        System.out.println("选择要更换的装备：(-1为将装备的武器放进包中 -2退出) ");
        equipmentBackpack.openEquipmentBackpack();
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        if (index > equipmentList.size()) {
            System.out.println("没有该序号");
            return;
        }
        Knight knight = Knight.getInstance();
        if (index == -1) {
            knight.discardWeapon();
            return;
        }
        if (index == -2) {
            return;
        }
        equipment equipment1 = equipmentBackpack.getEquipment(index);
        //换头
        if (equipment1 instanceof HeadArmors) {
            if (knight.getHeadArmors() != null) {
                this.putEquipment(knight.getHeadArmors());
            }
            knight.setHeadArmors((HeadArmors) equipment1);
        }
        //换左臂
        else if (equipment1 instanceof armLeftArmors) {
            if (knight.getArmLeftArmors() != null) {
                this.putEquipment(knight.getArmLeftArmors());
            }
            knight.setArmLeftArmors((armLeftArmors) equipment1);
        }
        //换右臂
        else if (equipment1 instanceof armRightArmors) {
            if (knight.getArmRightArmors() != null) {
                this.putEquipment(knight.getArmRightArmors());
            }
            knight.setArmRightArmors((armRightArmors) equipment1);
        }
        //换左腿
        else if (equipment1 instanceof legLeftArmors) {
            if (knight.getLegLeftArmors() != null) {
                this.putEquipment(knight.getLegLeftArmors());
            }
            knight.setLegLeftArmors((legLeftArmors) equipment1);
        }
        //换右腿
        else if (equipment1 instanceof legRightArmors) {
            if (knight.getLegRightArmors() != null) {
                this.putEquipment(knight.getLegRightArmors());
            }
            knight.setLegRightArmors((legRightArmors) equipment1);
        }
        //换身体
        else if (equipment1 instanceof bodyArmors) {
            if (knight.getBodyArmors() != null) {
                this.putEquipment(knight.getBodyArmors());
            }
            knight.setBodyArmors((bodyArmors) equipment1);
        } else if (equipment1 instanceof shield) {
            if (knight.getShield() != null) {
                this.putEquipment(knight.getShield());
                DeBuffEffect.cancelCatchShield(knight);
            }
            knight.setShield((shield) equipment1);
            DeBuffEffect.catchShield(knight);
        } else if (equipment1 instanceof weapon) {
            //卸下武器
            knight.discardWeapon();
            //装备新的武器
            knight.setWeapon((weapon) equipment1);
            knight.setAttackRange(Knight.getIniAttackRange() + knight.getWeapon().getAttackRange());
            if (knight.getWeapon().getSkill() != null) {
                int statusFlag = knight.getWeapon().getSkill().getStatus().getStatusFlag();
                int level = knight.getWeapon().getSkill().getStatus().getStatusLevel();
                boolean flag = true;
                EquipmentEffect.getInstance().equip(statusFlag, level, flag);
            }
        }
    }

}
