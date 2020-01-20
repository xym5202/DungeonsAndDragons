package KnightAndDragon.util;

import KnightAndDragon.Bean.Items.Item;
import KnightAndDragon.BeanList.ArmorFactory;
import KnightAndDragon.BeanList.Items;
import KnightAndDragon.BeanList.MaterialsList;
import KnightAndDragon.BeanList.weaponFactory;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class CraftGuide {

    private static ConcurrentHashMap<List<Integer>,Object> concurrentHashMap;

    static {
        concurrentHashMap=new ConcurrentHashMap<>();
        InitWeaponCollection();
        InitEquipmentCollection();
        InitBookCollection();
        InitItemCollection();
        InitUseItemCollection();
    }

    public static ConcurrentHashMap<List<Integer>,Object> getConcurrentHashMap() {
        return concurrentHashMap;
    }

    //查询是否存在合成表
    public  static boolean findFromGuideMap(List<Integer> list){
        for (ConcurrentHashMap.Entry<List<Integer>, Object> map : concurrentHashMap.entrySet()) {
                if (list.equals(map.getKey())){
                    return true;
                }
        }
        return false;
    }

    //初始化武器合成表
    public static void InitWeaponCollection(){
        //剑
        concurrentHashMap.put(new ArrayList<Integer>(){{add(22);add(22);add(33);}}, weaponFactory.craftWeapon(MaterialsList.getMaterials().get(0),"剑"));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(23);add(23);add(33);}}, weaponFactory.craftWeapon(MaterialsList.getMaterials().get(1),"剑"));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(24);add(24);add(33);}}, weaponFactory.craftWeapon(MaterialsList.getMaterials().get(2),"剑"));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(25);add(25);add(33);}}, weaponFactory.craftWeapon(MaterialsList.getMaterials().get(3),"剑"));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(26);add(26);add(33);}}, weaponFactory.craftWeapon(MaterialsList.getMaterials().get(4),"剑"));
        //刀
        concurrentHashMap.put(new ArrayList<Integer>(){{add(22);add(22);add(34);}}, weaponFactory.craftWeapon(MaterialsList.getMaterials().get(0),"刀"));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(23);add(23);add(34);}}, weaponFactory.craftWeapon(MaterialsList.getMaterials().get(1),"刀"));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(24);add(24);add(34);}}, weaponFactory.craftWeapon(MaterialsList.getMaterials().get(2),"刀"));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(25);add(25);add(34);}}, weaponFactory.craftWeapon(MaterialsList.getMaterials().get(3),"刀"));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(26);add(26);add(34);}}, weaponFactory.craftWeapon(MaterialsList.getMaterials().get(4),"刀"));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(27);add(28);add(29);}}, weaponFactory.craftWeapon(MaterialsList.getGreateMaterials().get(0),"剑"));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(30);add(31);add(32);}}, weaponFactory.craftWeapon(MaterialsList.getGreateMaterials().get(1),"弓"));
    }

    //初始化装备合成表
    public static  void InitEquipmentCollection(){
        //木质
        concurrentHashMap.put(new ArrayList<Integer>(){{add(22);add(35);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(0),0.1));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(22);add(36);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(0),0.9));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(22);add(37);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(0),0.35));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(22);add(38);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(0),0.45));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(22);add(39);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(0),0.55));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(22);add(40);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(0),0.65));
        //石质
        concurrentHashMap.put(new ArrayList<Integer>(){{add(23);add(35);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(1),0.1));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(23);add(36);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(1),0.9));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(23);add(37);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(1),0.35));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(23);add(38);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(1),0.45));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(23);add(39);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(1),0.55));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(23);add(40);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(1),0.65));
        //铁质
        concurrentHashMap.put(new ArrayList<Integer>(){{add(24);add(35);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(2),0.1));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(24);add(36);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(2),0.9));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(24);add(37);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(2),0.35));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(24);add(38);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(2),0.45));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(24);add(39);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(2),0.55));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(24);add(40);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(2),0.65));
        //银质
        concurrentHashMap.put(new ArrayList<Integer>(){{add(25);add(35);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(3),0.1));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(25);add(36);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(3),0.9));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(25);add(37);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(3),0.35));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(25);add(38);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(3),0.45));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(25);add(39);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(3),0.55));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(25);add(40);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(3),0.65));
        //金质
        concurrentHashMap.put(new ArrayList<Integer>(){{add(26);add(35);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(4),0.1));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(26);add(36);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(4),0.9));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(26);add(37);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(4),0.35));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(26);add(38);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(4),0.45));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(26);add(39);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(4),0.55));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(26);add(40);}}, ArmorFactory.craftEquipment(MaterialsList.getMaterials().get(4),0.65));
    }

    //初始化附魔书合成表
    public static void InitBookCollection(){
        //合成力量书2-5级
        concurrentHashMap.put(new ArrayList<Integer>(){{add(41);add(41);}}, Items.getItemsMap().get(42));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(42);add(42);}}, Items.getItemsMap().get(43));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(43);add(43);}}, Items.getItemsMap().get(44));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(44);add(44);}}, Items.getItemsMap().get(45));
        //合成智力书2-5级
        concurrentHashMap.put(new ArrayList<Integer>(){{add(46);add(46);}}, Items.getItemsMap().get(47));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(47);add(47);}}, Items.getItemsMap().get(48));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(48);add(48);}}, Items.getItemsMap().get(49));
        concurrentHashMap.put(new ArrayList<Integer>(){{add(49);add(49);}}, Items.getItemsMap().get(50));
    }

    //初始化物品合成表
    public static void InitItemCollection(){
        //合成布
        concurrentHashMap.put(new ArrayList<Integer>(){{add(51);add(51);add(51);}}, Items.getItemsMap().get(52));
    }

    //初始化使用物品合成表
    public static void InitUseItemCollection(){
        //合成背包扩容器
        concurrentHashMap.put(new ArrayList<Integer>(){{add(52);add(52);add(52);}}, Items.getNomap().get(1001));
        //合成装备背包扩容器
        concurrentHashMap.put(new ArrayList<Integer>(){{add(52);add(52);}}, Items.getNomap().get(1002));
        //合成磨刀石
        concurrentHashMap.put(new ArrayList<Integer>(){{add(54);add(54);}}, Items.getNomap().get(1003));
        //合成力量之心
        concurrentHashMap.put(new ArrayList<Integer>(){{add(55);add(55);add(55);add(55);add(55);}}, Items.getNomap().get(1004));
        //合成智力之心
        concurrentHashMap.put(new ArrayList<Integer>(){{add(56);add(56);add(56);add(56);add(56);}}, Items.getNomap().get(1005));
        //合成敏捷之心
        concurrentHashMap.put(new ArrayList<Integer>(){{add(57);add(57);add(57);add(57);add(57);}}, Items.getNomap().get(1006));
        //合成生命之心
        concurrentHashMap.put(new ArrayList<Integer>(){{add(58);add(58);add(58);add(58);add(58);}}, Items.getNomap().get(1007));
        //合成攻速之心
        concurrentHashMap.put(new ArrayList<Integer>(){{add(59);add(59);add(59);add(59);add(59);}}, Items.getNomap().get(1008));
        //合成饰品包扩容器
        concurrentHashMap.put(new ArrayList<Integer>(){{add(52);add(52);add(52);add(52);}}, Items.getNomap().get(1009));
        //合成哥布林王的王冠
        concurrentHashMap.put(new ArrayList<Integer>(){{add(3001);add(3002);add(3003);}}, Items.getAccessoriesHashMap().get(3000));
    }

}
