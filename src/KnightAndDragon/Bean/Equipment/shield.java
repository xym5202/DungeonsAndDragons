package KnightAndDragon.Bean.Equipment;

import KnightAndDragon.Bean.Addition.Materials;
import KnightAndDragon.Bean.Addition.skill;

public class shield extends equipment {

    //盾牌种类
    private  String shieldKind;

    //盾牌材质
    private Materials shieldMaterials;

    //盾牌抵消物理伤害百分比
    private double shieldHarm;

    //盾牌抵消魔法伤害百分比
    private double shieldMagicHarm;

    //盾牌耐久度
    private volatile double shieldDurability;

    //盾牌影响行动力的百分比
    private double affectAction;

    public shield(){}

    public shield(String shieldKind, Materials shieldMaterials, double shieldHarm, double shieldMagicHarm, double shieldDurability, double affectAction, skill skills, Integer gold) {
        this.shieldKind = shieldKind;
        this.shieldMaterials = shieldMaterials;
        this.shieldHarm = shieldHarm;
        this.shieldMagicHarm = shieldMagicHarm;
        this.shieldDurability = shieldDurability;
        this.affectAction = affectAction;
        this.skills=skills;
        this.gold=gold;
    }

    public String getShieldKind() {
        return shieldKind;
    }

    public void setShieldKind(String shieldKind) {
        this.shieldKind = shieldKind;
    }

    public Materials getShieldMaterials() {
        return shieldMaterials;
    }

    public void setShieldMaterials(Materials shieldMaterials) {
        this.shieldMaterials = shieldMaterials;
    }

    public double getShieldHarm() {
        return shieldHarm;
    }

    public void setShieldHarm(double shieldHarm) {
        this.shieldHarm = shieldHarm;
    }

    public double getShieldMagicHarm() {
        return shieldMagicHarm;
    }

    public void setShieldMagicHarm(double shieldMagicHarm) {
        this.shieldMagicHarm = shieldMagicHarm;
    }

    public double getShieldDurability() {
        return shieldDurability;
    }

    public void setShieldDurability(double shieldDurability) {
        this.shieldDurability = shieldDurability;
    }

    public double getAffectAction() {
        return affectAction;
    }

    public void setAffectAction(double affectAction) {
        this.affectAction = affectAction;
    }

    @Override
    public String toString() {
        String str="名称："+shieldKind+"\t材质："+shieldMaterials.getMaterialsName()+"\t物理免伤："+shieldHarm+"\t魔法免伤"+shieldMagicHarm+"\t耐久："+shieldDurability+"\t减少行动力："+affectAction;
        return str;
    }
}
