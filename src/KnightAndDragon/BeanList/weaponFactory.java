package KnightAndDragon.BeanList;

import KnightAndDragon.Bean.Addition.Materials;
import KnightAndDragon.Bean.Equipment.weapon;
import KnightAndDragon.Bean.Object.Knight;
import KnightAndDragon.util.RandomGetDouble;

import java.util.ArrayList;
import java.util.List;

/**
 * 武器栏
 */
public class weaponFactory {

    //近战武器名称
    private static List<String> meleeWeaponNames;
    //远程武器名称
    private static List<String> RangeWeaponNames;
    //静态工厂，生产武器

    static {
        meleeWeaponNames = new ArrayList<>(10);
        meleeWeaponNames.add("剑");
        meleeWeaponNames.add("刀");
        meleeWeaponNames.add("矛");
        meleeWeaponNames.add("虎刺");

        RangeWeaponNames = new ArrayList<>(10);
        RangeWeaponNames.add("弓");
        RangeWeaponNames.add("弩");
        RangeWeaponNames.add("火枪");
        RangeWeaponNames.add("法杖");
    }

    //生成武器
    public static weapon createWeaponFactory() {
        weapon weapon1 = new weapon();
        Materials m = MaterialsList.getMaterials().get(RandomGetDouble.getList(MaterialsList.getMaterials()));
        //耐久度
        weapon1.setWeaponDurability(RandomGetDouble.getDoubleTwo());
        weapon1= weaponFactory.weaponAssignment(weapon1,m);
        //近战
        if (RandomGetDouble.randomDecimals()<=0.5){
            String weaponName=meleeWeaponNames.get(RandomGetDouble.getList(meleeWeaponNames));
            weapon1= weaponFactory.createMeeleWeapon(weapon1,weaponName);
        }
        //远程
        else {
            String weaponName=RangeWeaponNames.get(RandomGetDouble.getList(RangeWeaponNames));
            weapon1= weaponFactory.createRangeWeapon(weapon1,weaponName);
        }
        if (RandomGetDouble.randomDecimals()>=0.25&&RandomGetDouble.randomDecimals()<=0.5){
            weapon1.setSkills(SkillList.getEquipmentSkillLists().get(RandomGetDouble.getList(SkillList.getEquipmentSkillLists())));
        }
        return weapon1;
    }

    //武器属性赋值
    public  static weapon weaponAssignment(weapon weapon1, Materials m){
        Integer a = m.getMaterialsNumber();
        //材质
        weapon1.setWeaponMaterials(m);
        //攻击
        weapon1.setAttack(m.getMeterialsRigidity()/2+1);
        //魔法攻击
        weapon1.setMagicAttack(0);
        //金币
        weapon1.setGold((int)(m.getMeterialsRigidity()*10+m.getMeterialsWeight()));
        //材质为银或者黄金，额外的魔法攻击
        switch (a) {
            case 4:
                weapon1.setMagicAttack(weapon1.getMagicAttack() + 1);
                break;
            case 5:
                weapon1.setMagicAttack(weapon1.getMagicAttack() + 2);
                break;
            default:
                break;
        }
        return weapon1;
    }

    //创造近战武器
    public static weapon createMeeleWeapon(weapon weapon1, String weaponName){
         Knight knight=Knight.getInstance();
        //武器名称
        weapon1.setWeaponKind(weaponName);
        switch (weaponName){
            //力敏
            case "剑":
                weapon1.setAttackRange(0);
                weapon1.setAttack(weapon1.getAttack()*2+((knight.getPower())/10+knight.getAgility()/10+knight.getIntelligence()/30));
                weapon1.setItemNumber(301);
                break;
            //力大敏小
            case "刀":
                weapon1.setAttackRange(-0.2);
                weapon1.setAttack(weapon1.getAttack()*2+((knight.getPower()/7)+knight.getAgility()/15+knight.getIntelligence()/30));
                weapon1.setItemNumber(302);
                break;
            //敏大力小
            case "虎刺":
                weapon1.setAttackRange(-0.8);
                weapon1.setAttack(weapon1.getAttack()*2+((knight.getAgility()/7+knight.getPower()/15+knight.getIntelligence()/30)));
                weapon1.setItemNumber(303);
                break;
            //力智
            case "矛":
                weapon1.setAttackRange(0.8);
                weapon1.setAttack(weapon1.getAttack()*2+(knight.getIntelligence()/7+knight.getPower()/15+knight.getAgility()/30));
                weapon1.setItemNumber(304);
                break;
            default:
                break;
        }
        return weapon1;
    }

    //创造远程武器
    public  static weapon createRangeWeapon(weapon weapon1, String weaponName){
        Knight knight=Knight.getInstance();
        //武器名称
        weapon1.setWeaponKind(weaponName);
        switch (weaponName){
            //力敏
            case "弓":
                weapon1.setAttackRange(2.5);
                weapon1.setAttack(weapon1.getAttack()+(knight.getAgility()/10+knight.getPower()/10+knight.getIntelligence()/30));
                weapon1.setItemNumber(305);
                break;
                //敏大智小
            case "弩":
                weapon1.setAttackRange(3);
                weapon1.setAttack(weapon1.getAttack()+(knight.getPower()/7+knight.getAgility()/15+knight.getIntelligence()/30));
                weapon1.setItemNumber(306);
                break;
                //智敏
            case "火枪":
                weapon1.setAttackRange(3.5);
                weapon1.setAttack(weapon1.getAttack()+(knight.getAgility()/7+knight.getIntelligence()/15+knight.getPower()/30));
                weapon1.setItemNumber(307);
                break;
                //智
            case "法杖":
                weapon1.setAttackRange(3);
                weapon1.setAttack(weapon1.getAttack()+knight.getIntelligence()/40+knight.getAgility()/40+knight.getPower()/40);
                weapon1.setMagicAttack(weapon1.getAttack()+(knight.getIntelligence()/7+knight.getAgility()/15+knight.getPower()/30));
                weapon1.setItemNumber(308);
                break;
            default:
                break;
        }
        return weapon1;
    }


    //制造武器
    public static weapon craftWeapon(Materials materials, String weaponName){
        weapon weapon=new weapon();
        weapon.setWeaponDurability(100);
        weapon.setWeaponMaterials(materials);
        weapon= weaponFactory.weaponAssignment(weapon,materials);
        weapon= weaponFactory.createMeeleWeapon(weapon,weaponName);
        weapon= weaponFactory.createRangeWeapon(weapon,weaponName);
        return weapon;
    }
}
