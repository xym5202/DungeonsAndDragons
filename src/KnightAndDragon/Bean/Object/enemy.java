package KnightAndDragon.Bean.Object;

import KnightAndDragon.util.RandomGetDouble;
import KnightAndDragon.util.TimeSleep;

public class enemy {
    //敌人种类
    private String enemyKind;
    //敌人名称
    private String enemyName;
    //敌人血量
    private double enemyBlood;
    //敌人攻击力
    private double enemyAttack;
    //敌人魔法攻击力
    private double enemyMagicAttack;
    //敌人护甲
    private double enemyArmor;
    //敌人魔抗
    private double enemyMagicResistance;
    //敌人攻击间隔
    private double attackSpeed;
    //敌人行动时长
    private double actionTime;
    //敌人攻击范围
    private double attackRange;
    //敌人携带的技能
    private KnightAndDragon.Bean.Addition.skill skill;
    //敌人经验值
    private int experience;
    //敌人掉落金币
    private int enemyGolden;
    //敌人暴击几率
    private double criticalStrike;
    //敌人闪避几率
    private double dodge;

    public enemy() {
    };

    public enemy(String enemyKind, String enemyName, double enemyBlood, double enemyAttack, double enemyMagicAttack, double enemyArmor, double enemyMagicResistance, double attackSpeed, double actionTime, int experience, int enemyGolden, double criticalStrike, double dodge,double attackRange) {
        this.enemyKind = enemyKind;
        this.enemyName = enemyName;
        this.enemyBlood = enemyBlood;
        this.enemyAttack = enemyAttack;
        this.enemyMagicAttack = enemyMagicAttack;
        this.enemyArmor = enemyArmor;
        this.enemyMagicResistance = enemyMagicResistance;
        this.attackSpeed = attackSpeed;
        this.actionTime = actionTime;
        this.experience = experience;
        this.enemyGolden = enemyGolden;
        this.criticalStrike = criticalStrike;
        this.dodge = dodge;
        this.attackRange=attackRange;
    }

    public enemy(String enemyKind, String enemyName, double enemyBlood, double enemyAttack, double enemyMagicAttack, double enemyArmor, double enemyMagicResistance, double attackSpeed, double actionTime, int experience, int enemyGolden, double criticalStrike, double dodge,double attackRange,KnightAndDragon.Bean.Addition.skill skill) {
        this.enemyKind = enemyKind;
        this.enemyName = enemyName;
        this.enemyBlood = enemyBlood;
        this.enemyAttack = enemyAttack;
        this.enemyMagicAttack = enemyMagicAttack;
        this.enemyArmor = enemyArmor;
        this.enemyMagicResistance = enemyMagicResistance;
        this.attackSpeed = attackSpeed;
        this.actionTime = actionTime;
        this.experience = experience;
        this.enemyGolden = enemyGolden;
        this.criticalStrike = criticalStrike;
        this.dodge = dodge;
        this.attackRange=attackRange;
        this.skill=skill;
    }

    public String getEnemyKind() {
        return enemyKind;
    }

    public void setEnemyKind(String enemyKind) {
        this.enemyKind = enemyKind;
    }

    public double getEnemyAttack() {
        return enemyAttack;
    }

    public void setEnemyAttack(double enemyAttack) {
        this.enemyAttack = enemyAttack;
    }

    public double getEnemyArmor() {
        return enemyArmor;
    }

    public void setEnemyArmor(double enemyArmor) {
        this.enemyArmor = enemyArmor;
    }

    public double getEnemyMagicResistance() {
        return enemyMagicResistance;
    }

    public void setEnemyMagicResistance(double enemyMagicResistance) {
        this.enemyMagicResistance = enemyMagicResistance;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public double getActionTime() {
        return actionTime;
    }

    public void setActionTime(double actionTime) {
        this.actionTime = actionTime;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public KnightAndDragon.Bean.Addition.skill getSkill() {
        return skill;
    }

    public void setSkill(KnightAndDragon.Bean.Addition.skill skill) {
        this.skill = skill;
    }

    public double getEnemyMagicAttack() {
        return enemyMagicAttack;
    }

    public void setEnemyMagicAttack(double enemyMagicAttack) {
        this.enemyMagicAttack = enemyMagicAttack;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public double getEnemyBlood() {
        return enemyBlood;
    }

    public void setEnemyBlood(double enemyBlood) {
        this.enemyBlood = enemyBlood;
    }

    public int getEnemyGolden() {
        return enemyGolden;
    }

    public void setEnemyGolden(int enemyGolden) {
        this.enemyGolden = enemyGolden;
    }

    public double getCriticalStrike() {
        return criticalStrike;
    }

    public void setCriticalStrike(double criticalStrike) {
        this.criticalStrike = criticalStrike;
    }

    public double getDodge() {
        return dodge;
    }

    public void setDodge(double dodge) {
        this.dodge = dodge;
    }

    public double getAttackRange() {
        return attackRange;
    }

    public enemy setAttackRange(double attackRange) {
        this.attackRange = attackRange;
        return this;
    }

    //敌人受到伤害
    public void getHarm(Knight knight){
        //敌人闪避了伤害
        if (RandomGetDouble.judgeTrue(this.getDodge())){
            System.out.println(this.getEnemyName()+"闪避了英雄的伤害");
        }
        //敌人没有闪避伤害
        else {
            double[] harm=knight.causeHarmToEnemy();
            double a=harm[0]*(1-this.getEnemyArmor()*0.01);
            double m=harm[1]*(1-this.getEnemyMagicResistance()*0.01);
            //判断英雄是否暴击
            if (RandomGetDouble.judgeTrue(knight.getCriticalStrike())) {
                System.out.println("英雄暴击了");
                a=a*1.5;
                m=m*1.5;
            }
            double harmSum=(a+m)*RandomGetDouble.attackRandom();
            this.setEnemyBlood(this.getEnemyBlood()-harmSum);
            System.out.println("敌人还剩" + (this.getEnemyBlood()<0?0:this.getEnemyBlood()) + "血量");
        }
    };



}
