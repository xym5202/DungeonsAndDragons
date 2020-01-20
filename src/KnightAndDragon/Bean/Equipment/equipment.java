package KnightAndDragon.Bean.Equipment;

import KnightAndDragon.Bean.Addition.Materials;
import KnightAndDragon.Bean.Addition.skill;
import KnightAndDragon.Bean.Items.Item;

/**
 * 装备
 */
public class equipment extends Item {

    protected String partName;

    protected String ArmorsName;

    protected Materials ArmorsMaterials;

    protected double Armors;

    protected double MagicResistance;

    protected volatile double durability;

    protected skill skills;

    public String getPartName() {
        return partName;
    }

    public String getArmorsName() {
        return ArmorsName;
    }

    public void setArmorsName(String armorsName) {
        ArmorsName = armorsName;
    }

    public Materials getArmorsMaterials() {
        return ArmorsMaterials;
    }

    public void setArmorsMaterials(Materials armorsMaterials) {
        ArmorsMaterials = armorsMaterials;
    }

    public double getArmors() {
        return Armors;
    }

    public void setArmors(double armors) {
        Armors = armors;
    }

    public double getMagicResistance() {
        return MagicResistance;
    }

    public void setMagicResistance(double magicResistance) {
        MagicResistance = magicResistance;
    }

    public double getDurability() {
        return durability;
    }

    public void setDurability(double durability) {
        this.durability = durability;
    }

    public skill getSkills() {
        return skills;
    }

    public void setSkills(skill skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        String sb=  "部位名称：" + getPartName() +
                "\t 护甲名称：'" + getArmorsName() +
                "\t 材质：" + getArmorsMaterials().getMaterialsName() +
                "\t 护甲值：" + getArmors() +
                "\t 魔抗值：" + getMagicResistance() +
                "\t 耐久度：" + getDurability() +
                "\t 物品编号：" + getItemNumber()+
                "\t 售卖金币：" + getGold();
        if (this.getSkills()!=null){
            return sb+"\t 附魔："+getSkills().getSkillKind();
        }else {
            return sb;
        }
    }
}
