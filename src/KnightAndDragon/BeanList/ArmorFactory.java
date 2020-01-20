package KnightAndDragon.BeanList;

import KnightAndDragon.Bean.Addition.Materials;
import KnightAndDragon.Bean.Equipment.*;
import KnightAndDragon.util.RandomGetDouble;

public class ArmorFactory {

    //静态工厂，生产防具
    public static equipment createEquipmentFactory() {
        double d = RandomGetDouble.randomDecimals();
        equipment equipment1=new equipment();
        Materials m=MaterialsList.getMaterials().get(RandomGetDouble.getList(MaterialsList.getMaterials()));
        equipment1= ArmorFactory.createEquipmentPart(equipment1,d,m);
        return equipment1;
    }

    public static equipment createEquipment(equipment equipment, Materials m){
            equipment.setArmorsMaterials(m);
            equipment.setArmors(m.getMeterialsRigidity()*2);
            equipment.setMagicResistance(m.getMeterialsRigidity()*0.5);
            equipment.setDurability(RandomGetDouble.getDoubleTwo());
            equipment.setGold(m.getMeterialsRigidity()*5);
            if (RandomGetDouble.randomDecimals()>=0.25&&RandomGetDouble.randomDecimals()<=0.5){
                equipment.setSkills(SkillList.getEquipmentSkillLists().get(RandomGetDouble.getList(SkillList.getEquipmentSkillLists())));
            }
            int a=equipment.getArmorsMaterials().getMaterialsNumber();
            switch (a){
                case 4:
                    equipment.setMagicResistance(equipment.getMagicResistance()+2);
                    break;
                case 5:
                    equipment.setMagicResistance(equipment.getMagicResistance()+5);
                    break;
                default:
                    break;
            }
            return equipment;
    }

    //随机生成某个部位的装备
    public static equipment createEquipmentPart(equipment equipment, double d, Materials m){
        if (d<=0.3){
            equipment=new HeadArmors();
            equipment.setArmorsName("头盔");
            equipment.setItemNumber(351);
            ArmorFactory.createEquipment(equipment,m);
        }else if (d>0.3&&d<=0.4){
            equipment=new armLeftArmors();
            equipment.setArmorsName("左臂");
            equipment.setItemNumber(352);
            ArmorFactory.createEquipment(equipment,m);
        }else if (d>0.4&&d<=0.5){
            equipment=new armRightArmors();
            equipment.setArmorsName("右臂");
            equipment.setItemNumber(353);
            ArmorFactory.createEquipment(equipment,m);
        }else if (d>0.5&&d<=0.6){
            equipment=new legLeftArmors();
            equipment.setArmorsName("左腿");
            equipment.setItemNumber(354);
            ArmorFactory.createEquipment(equipment,m);
        }else if (d>0.6&&d<=0.7){
            equipment=new legRightArmors();
            equipment.setArmorsName("右腿");
            equipment.setItemNumber(355);
            ArmorFactory.createEquipment(equipment,m);
        }else {
            equipment=new bodyArmors();
            equipment.setArmorsName("盔甲");
            equipment.setItemNumber(356);
            ArmorFactory.createEquipment(equipment,m);
        }
        return equipment;
    }

    //制造装备
    public static equipment craftEquipment(Materials materials, double d){
        equipment equipment=new equipment();
        equipment= ArmorFactory.createEquipmentPart(equipment,d,materials);
        return equipment;
    }

    public static void main(String[] args) {
        equipment equipment= ArmorFactory.createEquipmentFactory();
        System.out.println(equipment.toString());
    }
}
