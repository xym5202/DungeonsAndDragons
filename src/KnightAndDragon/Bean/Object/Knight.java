package KnightAndDragon.Bean.Object;

import KnightAndDragon.Bean.Addition.Status;
import KnightAndDragon.Bean.Addition.skill;
import KnightAndDragon.Bean.Equipment.HeadArmors;
import KnightAndDragon.Bean.Equipment.equipment;
import KnightAndDragon.Bean.Items.AccessoriesBackPack;
import KnightAndDragon.Bean.Items.Backpack;
import KnightAndDragon.Bean.Items.EquipmentBackpack;
import KnightAndDragon.BeanList.Items;
import KnightAndDragon.BeanList.SkillList;
import KnightAndDragon.Effect.BuffEffect;
import KnightAndDragon.Effect.DeBuffEffect;
import KnightAndDragon.Effect.EquipmentEffect;
import KnightAndDragon.Effect.KnightBuffEffect;
import KnightAndDragon.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;

public class Knight {

    private static Knight knight;

    static {
        Knight.HeadSum = 80;
        Knight.armLeftSum = 100;
        Knight.armRightSum = 100;
        Knight.legLeftSum = 100;
        Knight.legRightSum = 100;
        Knight.bodySum = 150;
        Knight.iniAttackSpeed = 1;
        Knight.iniActionTime = 1;
        Knight.manaSum = 100;
        Knight.iniAttackRange = 1.0;
        Knight.backpack = Backpack.getInstance();
        Knight.equipmentBackpack = EquipmentBackpack.getInstance();
        Knight.accessoriesBackPack = AccessoriesBackPack.getInstance();
        knight = new Knight(Knight.HeadSum, Knight.armLeftSum, Knight.armRightSum, Knight.legLeftSum, Knight.legRightSum, Knight.bodySum, Knight.iniAttackSpeed, Knight.iniActionTime, Knight.manaSum, Knight.iniAttackRange);
    }

    private Knight(int head, int armLeft, int armRight, int legLeft, int legRight, int body, double attackSpeed, double actionTime, int mana, double attackRange) {
        this.Head = head;
        this.armLeft = armLeft;
        this.armRight = armRight;
        this.legLeft = legLeft;
        this.legRight = legRight;
        this.body = body;
        this.attackSpeed = attackSpeed;
        this.actionTime = actionTime;
        this.mana = mana;
        this.attackRange = attackRange;
    }


    public static Knight getInstance() {
        return knight;
    }

    //骑士姓名
    private String knightName;

    //属性：力量，影响物理攻击伤害attack
    private volatile int power=1;

    //属性：敏捷，影响攻击速度attackspeed
    private volatile int agility=1;

    //属性：智力，影响魔法攻击伤害
    private volatile int intelligence=1;

    //法力值总和
    private static volatile int manaSum;

    //法力值
    private volatile int mana;

    //属性：暴击几率
    private volatile double criticalStrike =0.05;

    //属性：闪避几率
    private volatile double dodge =0.05;

    //金币数量
    private volatile int gold = 20;

    //职业：骑士，剑士，法师，游侠
    private String profession;

    //头部血量总和
    private static int HeadSum;

    //头部目前血量
    private volatile int Head;

    //头部护甲
    private HeadArmors headArmors;

    //左胳膊总血量
    private static int armLeftSum;

    //左胳膊目前血量
    private volatile int armLeft;

    //左胳膊护甲
    private KnightAndDragon.Bean.Equipment.armLeftArmors armLeftArmors = null;

    //右胳膊总血量
    private static int armRightSum;

    //右胳膊目前血量
    private volatile int armRight;

    //右胳膊护甲
    private KnightAndDragon.Bean.Equipment.armRightArmors armRightArmors = null;

    //左腿部总血量
    private static int legLeftSum;

    //左腿目前血量
    private volatile int legLeft;

    //左腿部护甲
    private KnightAndDragon.Bean.Equipment.legLeftArmors legLeftArmors = null;

    //右腿部总血量
    private static int legRightSum;

    //右腿目前血量
    private volatile int legRight;

    //右腿护甲
    private KnightAndDragon.Bean.Equipment.legRightArmors legRightArmors = null;

    //身体总血量
    private static int bodySum;

    //身体目前血量
    private volatile int body;

    //身体护甲
    private KnightAndDragon.Bean.Equipment.bodyArmors bodyArmors = null;

    //护盾
    private KnightAndDragon.Bean.Equipment.shield shield = null;

    //武器
    private KnightAndDragon.Bean.Equipment.weapon weapon = null;

    //技能列表
    private volatile List<skill> skillList = new ArrayList();

    //技能点
    private volatile int skillPoints = 0;

    //等级
    private volatile int level = 1;

    //经验值
    private volatile int kngihtExperience = 0;

    //攻击状态，分为两种，一种为攻击，状态0，一种为举盾防御，状态1;
    private int attackStatus = 0;

    //初始攻击间隔
    private static volatile double iniAttackSpeed = 1;

    //当前攻击间隔,影响攻击和防御的次数，计算公式：攻击/防御次数=行动时间/攻击间隔，所以行动时间越长，攻击间隔越短，次数越多
    //左/右胳膊的当前血量情况影响攻击间隔，血量越低，间隔越长
    private volatile double attackSpeed = 1;

    //初始攻击力，实际攻击力=初始攻击力+武器赋予的攻击力，攻击模式分为物理攻击和魔法攻击
    private volatile double attack = 2;

    //初始魔法攻击力，实际攻击力=初始魔法攻击力+武器赋予的魔法攻击力
    private volatile double magicAttack = 0;

    //初始行动时间
    private static volatile double iniActionTime = 1;

    //行动时间，影响攻击和防御的次数
    //左/右腿的当前血量影响行动时间，血量越低，时间越短
    private volatile double actionTime = 1;

    //初始化攻击范围
    private static volatile double iniAttackRange = 1;

    //攻击范围
    private volatile double attackRange;

    //英雄背包
    private static Backpack backpack;

    //英雄装备包
    private static EquipmentBackpack equipmentBackpack;

    //英雄饰品包
    private static AccessoriesBackPack accessoriesBackPack;

    public String getKnightName() {
        return knightName;
    }

    public void setKnightName(String knightName) {
        this.knightName = knightName;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public static int getManaSum() {
        return manaSum;
    }

    public static void setManaSum(int manaSum) {
        Knight.manaSum = manaSum;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public static Backpack getBackpack() {
        return backpack;
    }

    public static void setBackpack(Backpack backpack) {
        Knight.backpack = backpack;
    }

    public static int getHeadSum() {
        return HeadSum;
    }

    public static void setHeadSum(int headSum) {
        HeadSum = headSum;
    }

    public int getHead() {
        return Head;
    }

    public void setHead(int head) {
        Head = head;
    }

    public HeadArmors getHeadArmors() {
        return headArmors;
    }

    public void setHeadArmors(HeadArmors headArmors) {
        this.headArmors = headArmors;
    }

    public static int getArmLeftSum() {
        return armLeftSum;
    }

    public static void setArmLeftSum(int armLeftSum) {
        Knight.armLeftSum = armLeftSum;
    }

    public int getArmLeft() {
        return armLeft;
    }

    public void setArmLeft(int armLeft) {
        this.armLeft = armLeft;
    }

    public KnightAndDragon.Bean.Equipment.armLeftArmors getArmLeftArmors() {
        return armLeftArmors;
    }

    public void setArmLeftArmors(KnightAndDragon.Bean.Equipment.armLeftArmors armLeftArmors) {
        this.armLeftArmors = armLeftArmors;
    }

    public static int getArmRightSum() {
        return armRightSum;
    }

    public static void setArmRightSum(int armRightSum) {
        Knight.armRightSum = armRightSum;
    }

    public int getArmRight() {
        return armRight;
    }

    public void setArmRight(int armRight) {
        this.armRight = armRight;
    }

    public KnightAndDragon.Bean.Equipment.armRightArmors getArmRightArmors() {
        return armRightArmors;
    }

    public void setArmRightArmors(KnightAndDragon.Bean.Equipment.armRightArmors armRightArmors) {
        this.armRightArmors = armRightArmors;
    }

    public static int getLegLeftSum() {
        return legLeftSum;
    }

    public static void setLegLeftSum(int legLeftSum) {
        Knight.legLeftSum = legLeftSum;
    }

    public int getLegLeft() {
        return legLeft;
    }

    public void setLegLeft(int legLeft) {
        this.legLeft = legLeft;
    }

    public KnightAndDragon.Bean.Equipment.legLeftArmors getLegLeftArmors() {
        return legLeftArmors;
    }

    public void setLegLeftArmors(KnightAndDragon.Bean.Equipment.legLeftArmors legLeftArmors) {
        this.legLeftArmors = legLeftArmors;
    }

    public static int getLegRightSum() {
        return legRightSum;
    }

    public static void setLegRightSum(int legRightSum) {
        Knight.legRightSum = legRightSum;
    }

    public int getLegRight() {
        return legRight;
    }

    public void setLegRight(int legRight) {
        this.legRight = legRight;
    }

    public KnightAndDragon.Bean.Equipment.legRightArmors getLegRightArmors() {
        return legRightArmors;
    }

    public void setLegRightArmors(KnightAndDragon.Bean.Equipment.legRightArmors legRightArmors) {
        this.legRightArmors = legRightArmors;
    }

    public static int getBodySum() {
        return bodySum;
    }

    public static void setBodySum(int bodySum) {
        Knight.bodySum = bodySum;
    }

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public KnightAndDragon.Bean.Equipment.bodyArmors getBodyArmors() {
        return bodyArmors;
    }

    public void setBodyArmors(KnightAndDragon.Bean.Equipment.bodyArmors bodyArmors) {
        this.bodyArmors = bodyArmors;
    }

    public KnightAndDragon.Bean.Equipment.shield getShield() {
        return shield;
    }

    public void setShield(KnightAndDragon.Bean.Equipment.shield shield) {
        this.shield = shield;
    }

    public KnightAndDragon.Bean.Equipment.weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(KnightAndDragon.Bean.Equipment.weapon weapon) {
        this.weapon = weapon;
    }

    public List<skill> getSkillList() {
        return skillList;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getKngihtExperience() {
        return kngihtExperience;
    }

    public void setKngihtExperience(int kngihtExperience) {
        this.kngihtExperience = kngihtExperience;
    }

    public int getAttackStatus() {
        return attackStatus;
    }

    public void setAttackStatus(int attackStatus) {
        this.attackStatus = attackStatus;
    }

    public double getIniAttackSpeed() {
        return iniAttackSpeed;
    }

    public void setIniAttackSpeed(double iniAttackSpeed) {
        Knight.iniAttackSpeed = iniAttackSpeed;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
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

    public double getIniActionTime() {
        return iniActionTime;
    }

    public void setIniActionTime(double iniActionTime) {
        Knight.iniActionTime = iniActionTime;
    }

    public double getActionTime() {
        return actionTime;
    }

    public void setActionTime(double actionTime) {
        this.actionTime = actionTime;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public static double getIniAttackRange() {
        return iniAttackRange;
    }

    public static void setIniAttackRange(double iniAttackRange) {
        Knight.iniAttackRange = iniAttackRange;
    }

    public double getAttackRange() {
        return attackRange;
    }

    public Knight setAttackRange(double attackRange) {
        this.attackRange = attackRange;
        return this;
    }

    public static EquipmentBackpack getEquipmentBackpack() {
        return equipmentBackpack;
    }

    public static void setEquipmentBackpack(EquipmentBackpack equipmentBackpack) {
        Knight.equipmentBackpack = equipmentBackpack;
    }

    public Knight setSkillList(List<skill> skillList) {
        this.skillList = skillList;
        return this;
    }

    public static AccessoriesBackPack getAccessoriesBackPack() {
        return accessoriesBackPack;
    }

    public static void setAccessoriesBackPack(AccessoriesBackPack accessoriesBackPack) {
        Knight.accessoriesBackPack = accessoriesBackPack;
    }

    //攻击敌人，造成物理伤害
    public double attackEnemyByPhy() {
        if (this.getWeapon() != null) {
            double attackHarm = this.getAttack() + this.getPower() / 5 + this.getWeapon().getAttack() + this.getAgility() * 0.05;
            return attackHarm;
        } else {
            return this.getAttack() + this.getPower() / 5;
        }
    }

    //攻击敌人，造成魔法伤害
    public double attackEnemyByMagic() {
        if (this.getWeapon() != null) {
            double magicAttackHarm = this.getMagicAttack() + this.getIntelligence() / 5 + this.getWeapon().getMagicAttack() + this.getAgility() * 0.05;
            return magicAttackHarm;
        } else {
            return this.getMagicAttack() + this.getIntelligence() / 5;
        }
    }

    //造成的总伤害
    public double[] causeHarmToEnemy() {
        double harm[] = new double[]{
                this.attackEnemyByPhy(), this.attackEnemyByMagic()
        };
        if (this.getWeapon() != null) {
            //武器每次使用，降低0.05的耐久度
            this.getWeapon().setWeaponDurability(this.getWeapon().getWeaponDurability() - 0.05);
            //武器损坏
            if (this.getWeapon().getWeaponDurability() <= 0) {
                this.discardWeapon();
            }
        }
        return harm;
    }

    //使用技能
    public void useSkill(int a, enemy enemy) {
        if (a >= skillList.size()) {
            System.out.println("技能超出范围");
            return;
        }
        skill skill1 = skillList.get(a);
        if (this.getMana() - skill1.getReduceMana() < 0) {
            System.out.println("蓝量不足，无法释放");
            return;
        } else {
            this.setMana(this.getMana() - skill1.getReduceMana());
            KnightBuffEffect.setStatus(skill1.getStatus());
            KnightBuffEffect.setTime(skill1.getTime());
            KnightBuffEffect.setEnemy(enemy);
            KnightBuffEffect buffEffect = KnightBuffEffect.getInstance();
            ThreadPoolExecutor tpe = GetThread.getThreadInstance();
            tpe.execute(buffEffect);
        }

    }

    //卸下武器
    public void discardWeapon() {
        if (knight.getWeapon() != null) {
            //如果装备有附魔技能，需要取消附魔技能
            if (knight.getWeapon().getSkill() != null) {
                int statusFlag = knight.getWeapon().getSkill().getStatus().getStatusFlag();
                int level = knight.getWeapon().getSkill().getStatus().getStatusLevel();
                boolean flag = false;
                EquipmentEffect.getInstance().equip(statusFlag, level, flag);
            }
            //取消武器攻击范围
            knight.setAttackRange(Knight.getIniAttackRange());
            EquipmentBackpack.getInstance().putEquipment(knight.getWeapon());
        }
        knight.setWeapon(null);
    }

    //丢弃盾牌
    public void discardShield() {
        this.shield = null;
    }

    //丢弃护甲
    public void discardArmor() {
        System.out.println("输入丢弃的部位");
        System.out.println("1.头盔 2.左手 3.右手 4.左腿 5.右腿 6.身体 7.盾牌 8.取消任意键");
        Scanner scanner = new Scanner(System.in);
        int part = scanner.nextInt();
        switch (part) {
            case 1:
                this.headArmors = null;
                break;
            case 2:
                this.armLeftArmors = null;
                break;
            case 3:
                this.armRightArmors = null;
                break;
            case 4:
                this.legLeftArmors = null;
                break;
            case 5:
                this.legRightArmors = null;
                break;
            case 6:
                this.bodyArmors = null;
                break;
            case 7:
                discardShield();
            default:
                System.out.println("退出");
                break;
        }
    }

    //切换攻击/防御状态
    public void switchOverAttackStatus() {
        if (this.getShield() != null) {
            //持盾
            if (this.getAttackStatus() == 0) {
                this.setAttackStatus(1);
                System.out.println(this.getKnightName() + "举起盾牌");
                //缓慢状态
                DeBuffEffect.catchShield(Knight.getInstance());
            }
            //攻击
            else {
                //取消持盾
                this.setAttackStatus(0);
                System.out.println(this.getKnightName() + "放下盾牌");
                DeBuffEffect.cancelCatchShield(Knight.getInstance());
            }
        } else {
            System.out.println("没有装备盾牌，无法持盾");
            this.setAttackStatus(0);
        }


    }

    //判断盾牌是否还有耐久
    public void brokenShield() {
        if (this.getShield().getShieldDurability() <= 0) {
            DeBuffEffect.cancelCatchShield(Knight.getInstance());
            System.out.println("盾牌坏掉了");
            this.setAttackStatus(0);
            this.shield = null;
        }
    }

    //扣减盾牌耐久
    public void reduceShieldD(double harm) {
        this.getShield().setShieldDurability(this.getShield().getShieldDurability() - harm*0.05);
        brokenShield();
    }

    //受到攻击计算
    public int attackPart(int partBlood, equipment equipment1, enemy enemy) {
        double attack = enemy.getEnemyAttack() * RandomGetDouble.attackRandom();
        double magicharm = enemy.getEnemyMagicAttack() * RandomGetDouble.attackRandom();
        //身穿护甲
        if (equipment1 != null) {
            double attackHarm = (attack *(1- equipment1.getArmors()*0.02));
            double magicHarm = (magicharm*(1- equipment1.getArmors()*0.02));
            //敌人暴击
            if (RandomGetDouble.judgeTrue(enemy.getCriticalStrike())) {
                System.out.println("敌人暴击了----------");
                attackHarm = attackHarm * 1.5;
                magicHarm = magicHarm * 1.5;
            }
            //计算敌人造成的总伤害
            double Harm = attackHarm + magicHarm;
            //如果英雄在持盾状态下，盾牌抵消伤害，没有持盾的话继续执行
            if (this.getAttackStatus() == 1) {
                Harm = (attackHarm * (1 - this.getShield().getShieldHarm() / 40) + magicHarm * (1 - this.getShield().getShieldMagicHarm() / 40));
                //扣减盾牌耐久度
                reduceShieldD(Harm);
            }
            //计算英雄剩余血量
            double d = (double) partBlood - Harm;
            partBlood = (int) (d >= 0 ? d : 0);
            System.out.println("英雄受到：" + Harm + "伤害");
            //扣减护甲的耐久度
            equipment1.setDurability(equipment1.getDurability() - Harm);
            return partBlood;
        } else {
            //无护甲
            //如果敌人暴击了
            if (RandomGetDouble.judgeTrue(enemy.getCriticalStrike())) {
                System.out.println("敌人暴击了----------");
                attack = attack * 1.5;
                magicharm = magicharm * 1.5;
            }
            double Harm = attack + magicharm;
            if (this.getAttackStatus() == 1) {
                Harm = (attack * (1 - this.getShield().getShieldHarm() / 50) + magicharm * (1 - this.getShield().getShieldMagicHarm() / 50));
                reduceShieldD(Harm);
            }
            double d = (double) partBlood - Harm;
            partBlood = (int) (d >= 0 ? d : 0);
            System.out.println("英雄受到：" + Harm + "伤害");
            return partBlood;
        }
    }

    //受到伤害
    public void getHarm(enemy enemy) {
        //英雄闪避
        if (RandomGetDouble.judgeTrue(this.getDodge())) {
            System.out.println("英雄闪避了敌人的伤害");
            TimeSleep.timeSleep(1000);
        }
        //英雄没有闪避
        else {
            int attackPart = RandomGetDouble.attackPart();
            switch (attackPart) {
                case 1:
                    this.setHead(this.attackPart(this.getHead(), this.getHeadArmors(), enemy));
                    if (this.getHeadArmors() != null && this.getHeadArmors().getDurability() <= 0) {
                        this.setHeadArmors(null);
                    }
                    System.out.println("头部剩余血量：" + this.getHead());
                    System.out.println("==========================================================================");
                    TimeSleep.timeSleep(1000);
                    break;
                case 2:
                    this.setArmLeft(this.attackPart(this.getArmLeft(), this.getArmLeftArmors(), enemy));
                    if (this.getArmLeftArmors() != null && this.getArmLeftArmors().getDurability() <= 0) {
                        this.setArmLeftArmors(null);
                    }
                    System.out.println("左手剩余血量：" + this.getArmLeft());
                    System.out.println("==========================================================================");
                    TimeSleep.timeSleep(1000);
                    break;
                case 3:
                    this.setArmRight(this.attackPart(this.getArmRight(), this.getArmRightArmors(), enemy));
                    if (this.getArmRightArmors() != null && this.getArmRightArmors().getDurability() <= 0) {
                        this.setArmRightArmors(null);
                    }
                    System.out.println("右手剩余血量：" + this.getArmRight());
                    System.out.println("==========================================================================");
                    TimeSleep.timeSleep(1000);
                    break;
                case 4:
                    this.setLegLeft(this.attackPart(this.getLegLeft(), this.getLegLeftArmors(), enemy));
                    if (this.getLegLeftArmors() != null && this.getLegLeftArmors().getDurability() <= 0) {
                        this.setLegLeftArmors(null);
                    }
                    System.out.println("左腿剩余血量：" + this.getLegLeft());
                    System.out.println("==========================================================================");
                    TimeSleep.timeSleep(1000);
                    break;
                case 5:
                    this.setLegRight(this.attackPart(this.getLegRight(), this.getLegRightArmors(), enemy));
                    if (this.getLegRightArmors() != null && this.getLegRightArmors().getDurability() <= 0) {
                        this.setLegRightArmors(null);
                    }
                    System.out.println("右腿剩余血量：" + this.getLegRight());
                    System.out.println("==========================================================================");
                    TimeSleep.timeSleep(1000);
                    break;
                default:
                    this.setBody(this.attackPart(this.getBody(), this.getBodyArmors(), enemy));
                    if (this.getBodyArmors() != null && this.getBodyArmors().getDurability() <= 0) {
                        this.setBodyArmors(null);
                    }
                    System.out.println("身体剩余血量：" + this.getBody());
                    System.out.println("==========================================================================");
                    TimeSleep.timeSleep(1000);
                    break;
            }
            Integer suma = Knight.getLegRightSum() + Knight.getLegLeftSum();
            Integer b = this.getLegLeft() + this.getLegRight();
            double d = (double) b / suma;
            this.setActionTime(d * this.getIniActionTime());
            Integer sumb = Knight.getArmLeftSum() + Knight.getArmRightSum();
            Integer c = this.getArmLeft() + this.getArmRight();
            double d2 = (double) c / sumb;
            this.setAttackSpeed((1 + (1 - d2)) * this.getIniAttackSpeed());
            //附加状态，后台运行
            if (enemy.getSkill() != null) {
                if (RandomGetDouble.randomDecimals() <= 0.25) {
                    Status status = enemy.getSkill().getStatus();
                    if (!(status.getStatusName() == null && status.getStatusName().equals("") && status != null)) {
                        DeBuffEffect deBuffEffect = DeBuffEffect.getInstance();
                        DeBuffEffect.setSkills(enemy.getSkill());
                        DeBuffEffect.setEnemy(enemy);
                        ThreadPoolExecutor tpe = GetThread.getThreadInstance();
                        tpe.execute(deBuffEffect);
                    }
                }
            }
        }
    }

    //英雄死亡
    public static void knightDeath() {
        System.out.println("英雄死亡");
        TimeSleep.timeSleep(1000);
        System.out.println("Game Over");
        ThreadPoolExecutor tpe = GetThread.getThreadInstance();
        tpe.shutdownNow();
        Thread.interrupted();
    }

    //打印英雄的血量
    public void getKnightBlood() {
        System.out.println(this.Info(1));
        System.out.println("=================================================================================");
    }

    //获取骑士状态
    public String Info(int n) {
        switch (n) {
            case 1:
                String KinghtInfo = "===============================\n骑士姓名：" + getKnightName()
                        + "\n攻击力："+this.attackEnemyByPhy()
                        + "\t魔法攻击力："+this.attackEnemyByMagic()
                        + "\t攻击范围："+(this.getAttackRange()+(this.getWeapon()==null?0:this.getWeapon().getAttackRange()))
                        + "\n力量："+this.getPower()
                        + "\t敏捷："+this.getAgility()
                        + "\t智力："+this.getIntelligence()
                        + "\n头部血量：" + getHead() + "/" + getHeadSum()
                        + "\t左手血量：" + getArmLeft() + "/" + getArmLeftSum()
                        + "\t右手血量：" + getArmRight() + "/" + getArmRightSum()
                        + "\t左腿血量：" + getLegLeft() + "/" + getLegLeftSum()
                        + "\t右腿血量：" + getLegRight() + "/" + getLegRightSum()
                        + "\t身体血量：" + getBody() + "/" + getBodySum()
                        + "\n魔法值：" + this.getMana() + "/" +getManaSum()
                        + "\n经验值：" + this.getKngihtExperience()+"/"+(this.getLevel()*50)
                        + "\n技能点：" + this.getSkillPoints()
                        + "\n等级：" + this.getLevel()
                        + "\n职业：" + (this.getProfession() == null ? "无" : this.getProfession())
                        + "\n金币：" + this.getGold();
                return KinghtInfo;
            case 2:
                String Head = getHeadArmors() == null ? "头盔:无" : getHeadArmors().getArmorsName() + "\t耐久：" + getHeadArmors().getDurability() + "\t物理防御：" + getHeadArmors().getArmors() + "\t魔法防御：" + getHeadArmors().getMagicResistance() + "\t材质：" + getHeadArmors().getArmorsMaterials().getMaterialsName() + (getHeadArmors().getSkills()==null?"":"\t附魔："+getHeadArmors().getSkills().getSkillKind());
                String armLeft = getArmLeftArmors() == null ? "左臂:无" : getArmLeftArmors().getArmorsName() + "\t耐久：" + getArmLeftArmors().getDurability() + "\t物理防御：" + getArmLeftArmors().getArmors() + "\t魔法防御：" + getArmLeftArmors().getMagicResistance() + "\t材质：" + getArmLeftArmors().getArmorsMaterials().getMaterialsName()+ (getArmLeftArmors().getSkills()==null?"":"\t附魔："+getArmLeftArmors().getSkills().getSkillKind());
                String armRight = getArmRightArmors() == null ? "右臂:无" : getArmRightArmors().getArmorsName() + "\t耐久：" + getArmRightArmors().getDurability() + "\t物理防御：" + getArmRightArmors().getArmors() + "\t魔法防御：" + getArmRightArmors().getMagicResistance() + "\t材质：" + getArmRightArmors().getArmorsMaterials().getMaterialsName()+ (getArmRightArmors().getSkills()==null?"":"\t附魔："+getArmRightArmors().getSkills().getSkillKind());
                String legLeft = getLegLeftArmors() == null ? "左腿:无" : getLegLeftArmors().getArmorsName() + "\t耐久：" + getLegLeftArmors().getDurability() + "\t物理防御：" + getLegLeftArmors().getArmors() + "\t魔法防御：" + getLegLeftArmors().getMagicResistance() + "\t材质：" + getLegLeftArmors().getArmorsMaterials().getMaterialsName()+ (getLegLeftArmors().getSkills()==null?"":"\t附魔："+getLegLeftArmors().getSkills().getSkillKind());
                String legRight = getLegRightArmors() == null ? "右腿:无" : getLegRightArmors().getArmorsName() + "\t耐久：" + getLegRightArmors().getDurability() + "\t物理防御：" + getLegRightArmors().getArmors() + "\t魔法防御：" + getLegRightArmors().getMagicResistance() + "\t材质：" + getLegRightArmors().getArmorsMaterials().getMaterialsName()+ (getLegRightArmors().getSkills()==null?"":"\t附魔："+getLegRightArmors().getSkills().getSkillKind());
                String body = getBodyArmors() == null ? "身体:无" : "名称：" + getBodyArmors().getArmorsName() + "\t耐久：" + getBodyArmors().getDurability() + "\t物理防御：" + getBodyArmors().getArmors() + "\t魔法防御：" + getBodyArmors().getMagicResistance() + "\t材质：" + getBodyArmors().getArmorsMaterials().getMaterialsName()+ (getBodyArmors().getSkills()==null?"":"\t附魔："+getBodyArmors().getSkills().getSkillKind());
                String weapon = getWeapon() == null ? "武器:无" : "名称：" + getWeapon().getWeaponKind() + "\t耐久：" + getWeapon().getWeaponDurability() + "\t攻击力：" + getWeapon().getAttack() + "\t魔法力：" + getWeapon().getMagicAttack() + "\t材质：" + getWeapon().getWeaponMaterials().getMaterialsName()+ (getWeapon().getSkills()==null?"":"\t附魔："+getWeapon().getSkills().getSkillKind());
                String sheild = getShield() == null ? "盾牌:无" : "名称：" + getShield().getShieldKind() + "\t耐久：" + getShield().getShieldDurability() + "\t防御力：" + getShield().getShieldHarm() + "\t材质：" + getShield().getShieldMaterials().getMaterialsName();
                String equipmentInfo = "===============================\n" + Head + "\n" + armLeft + "\n" + armRight + "\n" + legLeft + "\n" + legRight + "\n" + body + "\n" + weapon + "\n" + sheild;
                return equipmentInfo;
            case 3:
                if (this.getSkillList() == null || this.getSkillList().size() == 0) {
                    return "===============================\n无";
                } else {
                    String skills = this.skillListToString();
                    System.out.println(skills);
                }
                return "";
            case 4:
                System.out.println("可用技能点："+knight.getSkillPoints());
                Knight knight = Knight.getInstance();
                List<skill> skills = null;
                SkillList skillList = SkillList.getInstance();
                if (knight.getLevel() <= 10) {
                    skills = skillList.toStringKnightSkills();
                } else if (knight.getLevel() <= 30 && knight.getLevel() > 10) {
                    skills = skillList.toStringKnightSkills();
                } else {
                    skills = skillList.toStringKnightSkills();
                }
                System.out.println("学习技能，输入编号\n");
                Integer a = Utils.Scanner();
                if (a == -1 || a >= skills.size()) {
                    return "该编号不存在";
                }
                if (skills.get(a) != null && knight.getSkillPoints() >= skills.get(a).getNeedPoint()) {
                    knight.getSkillList().add(skills.get(a));
                    knight.setSkillPoints(knight.getSkillPoints() - skills.get(a).getNeedPoint());
                    return skills.get(a).getSkillKind() + "学习成功";
                } else if (skills.get(a) != null && knight.getSkillPoints() < skills.get(a).getNeedPoint()) {
                    return "技能点不足";
                } else {
                    return "退出";
                }
            default:
                return "退出";
        }
    }

    //打印骑士状态
    public String getKnightInfo() {
        while (true) {
            System.out.println("\n英雄姓名:" + getKnightName() + "\n1.当前信息," + "\n2." + "装备信息" + "\n3." + "技能列表" + "\n4.技能升级" + "\n0.退出");
            int n = Utils.Scanner();
            System.out.println(this.Info(n) + "=====================================================");
            if (n == 0) {
                return "退出详情";
            }
        }
    }

    //骑士升级
    public void upLevel() {
        while (true) {
            if (this.getKngihtExperience() >= this.getLevel() * 50) {
                this.setKngihtExperience(this.getKngihtExperience() - this.getLevel() * 50);
                this.setLevel(this.getLevel() + 1);
                System.out.println("升级\n=================================================");
                Knight.setHeadSum(Knight.getHeadSum() + 5);
                knight.setHead(Knight.getHeadSum());
                Knight.setArmLeftSum(Knight.getArmLeftSum() + 5);
                knight.setArmLeft(Knight.getArmLeftSum());
                Knight.setArmRightSum(Knight.getArmRightSum() + 5);
                knight.setArmRight(Knight.getArmRightSum());
                Knight.setLegLeftSum(Knight.getLegLeftSum() + 5);
                knight.setLegLeft(Knight.getLegLeftSum());
                Knight.setLegRightSum(Knight.getLegRightSum() + 5);
                knight.setLegRight(Knight.getLegRightSum());
                Knight.setBodySum(Knight.getBodySum() + 5);
                knight.setBody(Knight.getBodySum());
                if (this.getLevel() % 2 == 0 || this.getLevel() == 1) {
                    this.setSkillPoints(this.getSkillPoints() + 1);
                }
                knight.setPower(knight.getPower() + 1);
                knight.setAgility(knight.getAgility() + 1);
                knight.setIntelligence(knight.getIntelligence() + 1);
                if (this.getProfession() == null || "".equals(this.getProfession())) {
                    if (this.getLevel() == 15) {
                        System.out.println("15级转职");
                        System.out.println("1.骑士\t2.剑士\t3.法师\t4.游侠");
                        Integer a = Utils.Scanner();
                        switch (a) {
                            case 1:
                                this.setProfession("骑士");
                                break;
                            case 2:
                                this.setProfession("剑士");
                                break;
                            case 3:
                                this.setProfession("法师");
                                break;
                            default:
                                this.setProfession("游侠");
                                break;
                        }
                    }
                } else if (this.getProfession() != null && "骑士".equals(this.getProfession())) {
                    Knight.setHeadSum(Knight.getHeadSum() + 5);
                    knight.setHead(Knight.getHeadSum());
                    Knight.setArmLeftSum(Knight.getArmLeftSum() + 5);
                    knight.setArmLeft(Knight.getArmLeftSum());
                    Knight.setArmRightSum(Knight.getArmRightSum() + 5);
                    knight.setArmRight(Knight.getArmRightSum());
                    Knight.setLegLeftSum(Knight.getLegLeftSum() + 5);
                    knight.setLegLeft(Knight.getLegLeftSum());
                    Knight.setLegRightSum(Knight.getLegRightSum() + 5);
                    knight.setLegRight(Knight.getLegRightSum());
                    Knight.setBodySum(Knight.getBodySum() + 5);
                    knight.setBody(Knight.getBodySum());
                } else if (this.getProfession() != null && "剑士".equals(this.getProfession())) {
                    knight.setPower(knight.getPower() + 2);
                } else if (this.getProfession() != null && "游侠".equals(this.getProfession())) {
                    knight.setAgility(knight.getAgility() + 2);
                } else if (this.getProfession() != null && "法师".equals(this.getProfession())) {
                    knight.setIntelligence(knight.getIntelligence() + 2);
                    Knight.setManaSum(Knight.getManaSum() + 5);
                }
                if (this.getLevel() % 2 == 0 ) {
                    this.setSkillPoints(this.getSkillPoints() + 1);
                    this.setIniAttackSpeed(this.getIniAttackSpeed()*((1-this.getAgility()*0.005)>0.95?1-this.getAgility()*0.005:0.95));
                }
            }else {
                break;
            }
        }
    }

    //花钱
    public void spendMoney(int gold) {
        Knight knight = Knight.getInstance();
        if (gold <= knight.getGold()) {
            knight.setGold(knight.getGold() - gold);
        } else {
            System.out.println("余额不足");
        }
    }

    //打印已学习技能
    public String skillListToString() {
        int count = 0;
        StringBuffer sb = new StringBuffer();
        for (skill skills : this.getSkillList()) {
            sb.append(count + "、" + skills.toString() + "\n");
            count++;
        }
        String str = String.valueOf(sb);
        return str;
    }

    //测试
    public static void main(String[] args) throws Exception {
        double d=Math.log(0.0);
        double b=Math.log(2.0);
      System.out.println(d+","+b+","+d/b);
    }
}
