package KnightAndDragon.Bean.Equipment;

import KnightAndDragon.Bean.Addition.Materials;
import KnightAndDragon.Bean.Addition.skill;

public class HeadArmors extends equipment {

    private  String partName="头";

    protected String ArmorsName;

    protected Materials ArmorsMaterials;

    protected double Armors;

    protected double MagicResistance;

    protected volatile double durability;

    private static int flag=1;

    public HeadArmors(){}

    public HeadArmors(String ArmorsName, Materials ArmorsMaterials, double Armors, double MagicResistance, double durability,skill skills,Integer gold) {
        this.ArmorsName = ArmorsName;
        this.ArmorsMaterials = ArmorsMaterials;
        this.Armors = Armors;
        this.MagicResistance = MagicResistance;
        this.durability = durability;
        this.skills=skills;
        this.gold=gold;
    }

    @Override
    public  String getPartName() {
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
