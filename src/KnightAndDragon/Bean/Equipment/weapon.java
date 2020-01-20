package KnightAndDragon.Bean.Equipment;

import KnightAndDragon.Bean.Addition.Materials;
import KnightAndDragon.Bean.Addition.skill;

public class weapon extends equipment {

    //武器种类
    private String weaponKind;
    //武器材料
    private Materials weaponMaterials;
    //武器物理攻击伤害
    private double attack;
    //武器魔法攻击伤害
    private double magicAttack;
    //武器耐久度
    private volatile double weaponDurability;
    //武器攻击范围
    private double attackRange;
    //武器附魔带技能
    private skill skill;

    public  weapon(){}

    public double getWeaponDurability() {
        return weaponDurability;
    }

    public void setWeaponDurability(double weaponDurability) {
        this.weaponDurability = weaponDurability;
    }

    public String getWeaponKind() {
        return weaponKind;
    }

    public void setWeaponKind(String weaponKind) {
        this.weaponKind = weaponKind;
    }

    public Materials getWeaponMaterials() {
        return weaponMaterials;
    }

    public void setWeaponMaterials(Materials weaponMaterials) {
        this.weaponMaterials = weaponMaterials;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getMagicAttack() {
        return magicAttack;
    }

    public void setMagicAttack(double magicAttack) {
        this.magicAttack = magicAttack;
    }

    public KnightAndDragon.Bean.Addition.skill getSkill() {
        return skill;
    }

    public weapon setSkill(KnightAndDragon.Bean.Addition.skill skill) {
        this.skill = skill;
        return this;
    }

    public double getAttackRange() {
        return attackRange;
    }

    public weapon setAttackRange(double attackRange) {
        this.attackRange = attackRange;
        return this;
    }

    @Override
    public String toString() {
        String string="武器种类："+weaponKind+"\t材料："+weaponMaterials.getMaterialsName()+"\t物理伤害："+attack+"\t魔法伤害："+magicAttack+"\t耐久度："+weaponDurability+"\t攻击范围："+attackRange+"\t金币："+gold;
        if (this.skill!=null){
            string +="\t附魔："+skill.getSkillKind()+"("+skill.getStatus().getStatusName()+")";
        }
        return string;
    }
}
