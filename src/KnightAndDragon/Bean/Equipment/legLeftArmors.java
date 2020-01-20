package KnightAndDragon.Bean.Equipment;

import KnightAndDragon.Bean.Addition.Materials;
import KnightAndDragon.Bean.Addition.skill;

public class legLeftArmors extends equipment {

    private String partName = "左腿";

    private String ArmorsName;

    private Materials ArmorsMaterials;

    private double Armors;

    private double MagicResistance;

    private volatile double durability;

    private int flag = 4;

    public legLeftArmors(){}

    public legLeftArmors(String armorsName, Materials armorsMaterials, double armors, double magicResistance, double durability, skill skills, Integer gold) {
        ArmorsName = armorsName;
        ArmorsMaterials = armorsMaterials;
        Armors = armors;
        MagicResistance = magicResistance;
        this.durability = durability;
        this.skills=skills;
        this.gold=gold;
    }

    @Override
    public String getPartName() {
        return partName;
    }

    @Override
    public String getArmorsName() {
        return ArmorsName;
    }

    @Override
    public void setArmorsName(String armorsName) {
        ArmorsName = armorsName;
    }

    @Override
    public Materials getArmorsMaterials() {
        return ArmorsMaterials;
    }

    @Override
    public void setArmorsMaterials(Materials armorsMaterials) {
        ArmorsMaterials = armorsMaterials;
    }

    @Override
    public double getArmors() {
        return Armors;
    }

    @Override
    public void setArmors(double armors) {
        Armors = armors;
    }

    @Override
    public double getMagicResistance() {
        return MagicResistance;
    }

    @Override
    public void setMagicResistance(double magicResistance) {
        MagicResistance = magicResistance;
    }

    @Override
    public double getDurability() {
        return durability;
    }

    @Override
    public void setDurability(double durability) {
        this.durability = durability;
    }

    public int getFlag() {
        return flag;
    }

}
