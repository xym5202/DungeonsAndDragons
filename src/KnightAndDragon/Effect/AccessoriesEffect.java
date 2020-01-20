package KnightAndDragon.Effect;

import KnightAndDragon.Bean.Addition.Status;
import KnightAndDragon.Bean.Object.Knight;
import KnightAndDragon.util.RandomGetDouble;

import java.lang.reflect.Method;

public class AccessoriesEffect {

    static {
        accessoriesEffect = new AccessoriesEffect();
    }

    private static AccessoriesEffect accessoriesEffect;


    private AccessoriesEffect() {
    }

    public static AccessoriesEffect getInstance() {
        return accessoriesEffect;
    }


    //增加智力
    @Effect(startNum = "2001", endNum = "2005")
    public void increaseIntelligence(Knight knight, int level,boolean flag) {
        if (flag) {
            knight.setIntelligence(knight.getIntelligence() + 3 * level);
        }else {
            knight.setIntelligence(knight.getIntelligence()-3*level);
        }
    }

    //减少智力
    @Effect(startNum = "2005", endNum = "2010")
    public void decreaseIntelligence(Knight knight, int level,boolean flag) {
        if (flag){
            knight.setIntelligence((knight.getIntelligence() - 2 * level) >= 0 ? (knight.getIntelligence() - 2 * level) : 0);
        }else {
            knight.setIntelligence(knight.getIntelligence()+2*level);
        }

    }

    //增加力量
    @Effect(startNum = "2011", endNum = "2015")
    public void increasePower(Knight knight, int level,boolean flag) {
        if (flag) {
            knight.setPower(knight.getPower() + 3 * level);
        }else {
            knight.setPower(knight.getPower()-3*level);
        }
    }

    //减少力量
    @Effect(startNum = "2016", endNum = "2020")
    public void decreasePower(Knight knight, int level,boolean flag) {
        if (flag){
            knight.setPower((knight.getPower() - 2 * level) >= 0 ? (knight.getPower() - 2 * level) : 0);
        }else {
            knight.setPower(knight.getPower()+2*level);
        }
    }


    //增加敏捷
    @Effect(startNum = "2021", endNum = "2025")
    public void increaseAgility(Knight knight, int level,boolean flag) {
        if (flag) {
            knight.setAgility(knight.getAgility() + 3 * level);
        }else {
            knight.setAgility(knight.getAgility()-3*level);
        }
    }

    //减少敏捷
    @Effect(startNum = "2026", endNum = "2030")
    public void decreaseAgility(Knight knight, int level,boolean flag) {
        if (flag) {
            knight.setAgility((knight.getAgility() - 2 * level) >= 0 ? (knight.getAgility() - 2 * level) : 0);
        }else {
            knight.setAgility(knight.getAgility()+2*level);
        }
    }

    //增加攻击速度
    @Effect(startNum = "2031", endNum = "2035")
    public void increaseAttackSpeed(Knight knight, int level,boolean flag) {
        if (flag){
            knight.setIniAttackSpeed(knight.getIniAttackSpeed() * (1 - 0.1 * level));
            knight.setAttackSpeed(knight.getAttackSpeed() * (1 - 0.1 * level));
        }else {
            knight.setIniAttackSpeed(knight.getIniAttackSpeed()/(1-0.1*level));
            knight.setAttackSpeed(knight.getAttackSpeed() /(1 - 0.1 * level));
        }
    }

    //减少攻击速度
    @Effect(startNum = "2036", endNum = "2040")
    public void decreaseAttackSpeed(Knight knight, int level,boolean flag) {
        if (flag){
            knight.setIniAttackSpeed(knight.getIniAttackSpeed() * (1 + 0.08 * level));
            knight.setAttackSpeed(knight.getAttackSpeed() * (1 + 0.08 * level));
        }else {
            knight.setIniAttackSpeed(knight.getIniAttackSpeed()/(1+0.08*level));
            knight.setAttackSpeed(knight.getAttackSpeed()/(1+0.08*level));
        }
    }

    //增加移动速度
    @Effect(startNum = "2041", endNum = "2045")
    public void increaseActionSpeed(Knight knight, int level,boolean flag) {
        if (flag){
            knight.setIniActionTime(knight.getIniActionTime() * (level * 0.1 + 1));
            knight.setActionTime(knight.getActionTime() * (level * 0.1 + 1));
        }else {
            knight.setIniActionTime(knight.getIniActionTime()/(level*0.1+1));
            knight.setActionTime(knight.getActionTime()/(level*0.1+1));
        }
    }

    //减少移动速度
    @Effect(startNum = "2046", endNum = "2050")
    public void decreaseActionSpeed(Knight knight, int level,boolean flag) {
        if (flag){
            knight.setIniActionTime(knight.getIniActionTime() * (1 - level * 0.08));
            knight.setActionTime(knight.getActionTime() * (1 - level * 0.08));
        }else {
            knight.setIniActionTime(knight.getIniActionTime()/(1-level*0.08));
            knight.setActionTime(knight.getActionTime()/(1-level*0.08));
        }
    }

    //增加暴击 最大0.9
    @Effect(startNum = "2051", endNum = "2055")
    public void increaseCriticalStrike(Knight knight, int level,boolean flag) {
        if (flag){
            knight.setCriticalStrike((knight.getCriticalStrike() *(1+0.1 * level)) <= 0.9 ? (knight.getCriticalStrike() *(1+0.1 * level))  : 0.9);
        }else {
            knight.setCriticalStrike(knight.getCriticalStrike()/(1+0.1*level));
        }
    }

    //减少暴击 最低0
    @Effect(startNum = "2056", endNum = "2060")
    public void decreaseCriticalStrike(Knight knight, int level,boolean flag) {
        if (flag){
            knight.setCriticalStrike((knight.getCriticalStrike() *(1-0.08 * level)) >= 0 ? (knight.getCriticalStrike()*(1-0.08 * level)) : 0);
        }else {
            knight.setCriticalStrike(knight.getCriticalStrike()*(1+0.08*level));
        }
    }

    //增加闪避，最大0.3
    @Effect(startNum = "2061", endNum = "2065")
    public void increasedodge(Knight knight, int level,boolean flag) {
        if (flag){
            knight.setDodge((knight.getDodge() *(1+ 0.05 * level)) < 0.3 ? (knight.getDodge()  *(1+ 0.05 * level))  : 0.3);
        }else {
            knight.setDodge(knight.getDodge()*(1-0.05*level));
        }
    }

    //减少闪避，最低0
    @Effect(startNum = "2066", endNum = "2070")
    public void decreasedodge(Knight knight, int level,boolean flag) {
        if (flag){
            knight.setDodge((knight.getDodge() *(1+ 0.03 * level)) >= 0 ? (knight.getDodge()*(1+ 0.03 * level)) : 0);
        }else {
            knight.setDodge(knight.getDodge()*(1-0.03*level));
        }
    }


    //增加基础攻击力
    @Effect(startNum = "2071", endNum = "2075")
    public void increaseAttack(Knight knight, int level,boolean flag) {
        if (flag){
            knight.setAttack(knight.getAttack() * (1 + 0.2 * level));
        }else {
            knight.setAttack(knight.getAttack()/(1+0.2*level));
        }
    }

    //减少基础攻击力
    @Effect(startNum = "2076", endNum = "2080")
    public void decreaseAttack(Knight knight, int level,boolean flag) {
        if (flag){
            knight.setAttack(knight.getAttack() * (1 - 0.1 * level));
        }else {
            knight.setAttack(knight.getAttack()/(1-0.1*level));
        }
    }


    //增加基础魔法攻击力
    @Effect(startNum = "2081", endNum = "2085")
    public void increaseMagicAttack(Knight knight, int level,boolean flag) {
        if (flag){
            knight.setMagicAttack(knight.getMagicAttack() * (1 + 0.2 * level));
        }else {
            knight.setMagicAttack(knight.getMagicAttack()/(1+0.2*level));
        }
    }

    //减少基础魔法攻击力
    @Effect(startNum = "2086", endNum = "2090")
    public void decreaseMagicAttack(Knight knight, int level,boolean flag) {
        if (flag){
            knight.setMagicAttack(knight.getMagicAttack() * (1 - 0.1 * level));
        }else {
            knight.setMagicAttack(knight.getMagicAttack()/(1-0.1*level));
        }
    }

    //增加最大法力值
    @Effect(startNum = "2091", endNum = "2095")
    public void increaseMana(Knight knight, int level,boolean flag) {
        if (flag){
            knight.setMana(knight.getMana() + 20 * level);
        }else {
            knight.setMana(knight.getMana()-20*level);
        }
    }

    //减少最大法力值
    @Effect(startNum = "2096", endNum = "2100")
    public void decreaseMana(Knight knight, int level,boolean flag) {
        if (flag){
            knight.setMana((knight.getMana() - 10 * level) >= 50 ? (knight.getMana() - 15 * level) : 50);
        }else {
            knight.setMana(knight.getMana()+10*level);
        }
    }

    //随机增加某个部位的血量
    @Effect(startNum = "2101", endNum = "2105")
    public void increaseBloodSum(Knight knight, int level,boolean flag) {
        int a = RandomGetDouble.attackPart();
        switch (a) {
            case 1:
                this.increaseHeadSum(knight, level,flag);
                break;
            case 2:
                this.increaseArmLeftSum(knight, level,flag);
                break;
            case 3:
                this.increaseArmRightSum(knight, level,flag);
                break;
            case 4:
                this.increaseLegLeftSum(knight, level,flag);
                break;
            case 5:
                this.increaseLegRightSum(knight, level,flag);
                break;
            default:
                this.increaseBodySum(knight, level,flag);
                break;
        }
    }

    //随机减少某个部位的血量,最低初始血量的一半
    @Effect(startNum = "2106", endNum = "2110")
    public void decreaseBloodSum(Knight knight, int level,boolean flag) {
        int a = RandomGetDouble.attackPart();
        switch (a) {
            case 1:
                if (flag){
                    Knight.setHeadSum((Knight.getHeadSum() - 10 * level) >= 40 ? (Knight.getHeadSum() - 10 * level) : 40);
                    if (knight.getHead() > Knight.getHeadSum()) {
                        knight.setHead(Knight.getHeadSum());
                    }
                }else {
                    Knight.setHeadSum(Knight.getHeadSum()+10*level);
                }
                break;
            case 2:
                if (flag){
                    Knight.setArmLeftSum((Knight.getArmLeftSum() - 10 * level) >= 50 ? (Knight.getArmLeftSum() - 10 * level) : 50);
                    if (knight.getArmLeft() > Knight.getArmLeftSum()) {
                        knight.setArmLeft(Knight.getArmLeftSum());
                    }
                }else {
                    Knight.setArmLeftSum(Knight.getArmLeftSum()+10*level);
                }
                break;
            case 3:
                if (flag){
                    Knight.setArmRightSum((Knight.getArmRightSum() - 10 * level) >= 50 ? (Knight.getArmRightSum() - 10 * level) : 50);
                    if (knight.getArmRight() > Knight.getArmRightSum()) {
                        knight.setArmRight(Knight.getArmRightSum());
                    }
                }else {
                    Knight.setArmRightSum(Knight.getArmRightSum()+10*level);
                }
                break;
            case 4:
                if (flag) {
                    Knight.setLegLeftSum((Knight.getLegLeftSum() - 10 * level) >= 50 ? (Knight.getLegLeftSum() - 10 * level) : 50);
                    if (knight.getLegLeft() > Knight.getLegLeftSum()) {
                        knight.setLegLeft(Knight.getLegLeftSum());
                    }
                }else {
                    Knight.setLegLeftSum(Knight.getLegLeftSum()+10*level);
                }
                break;
            case 5:
                if (flag) {
                    Knight.setLegRightSum((Knight.getLegRightSum() - 10 * level) >= 50 ? (Knight.getLegRightSum() - 10 * level) : 50);
                    if (knight.getLegRight() > Knight.getLegRightSum()) {
                        knight.setLegRight(Knight.getLegRightSum());
                    }
                }else {
                    Knight.setLegRightSum(Knight.getLegRightSum()+10*level);
                }
                break;
            default:
                if (flag) {
                    Knight.setBodySum((Knight.getBodySum() - 10 * level) >= 80 ? (Knight.getBodySum() - 10 * level) : 80);
                    if (knight.getBody() > Knight.getBodySum()) {
                        knight.setBody(Knight.getBodySum());
                    }
                }else {
                    Knight.setBodySum(Knight.getBodySum()+10*level);
                }
                break;
        }
    }

    //增加头部生命最大值
    public void increaseHeadSum(Knight knight, int level,boolean flag) {
        if (flag){
            Knight.setHeadSum(Knight.getHeadSum() + 20 * level);
        }else {
            Knight.setHeadSum(Knight.getHeadSum()-20*level);
        }
    }

    //增加左手生命最大值
    public void increaseArmLeftSum(Knight knight, int level,boolean flag) {
        if (flag){
            Knight.setArmLeftSum(Knight.getArmLeftSum() + 20 * level);
        }else {
            Knight.setArmLeftSum(Knight.getArmLeftSum()-20*level);
        }
    }

    //增加右手生命最大值
    public void increaseArmRightSum(Knight knight, int level,boolean flag) {
        if (flag){
            Knight.setArmRightSum(Knight.getArmRightSum() + 20 * level);
        }else {
            Knight.setArmRightSum(Knight.getArmRightSum()-20*level);
        }
    }

    //增加左腿生命最大值
    public void increaseLegLeftSum(Knight knight, int level,boolean flag) {
        if (flag){
            Knight.setLegLeftSum(Knight.getLegLeftSum() + 20 * level);
        }else {
            Knight.setLegLeftSum(Knight.getLegLeftSum()-20*level);
        }
    }

    //增加右腿生命最大值
    public void increaseLegRightSum(Knight knight, int level,boolean flag) {
        if (flag){
            Knight.setLegRightSum(Knight.getLegRightSum() + 20 * level);
        }else {
            Knight.setLegRightSum(Knight.getLegRightSum()-20*level);
        }
    }

    //增加身体最大生命值
    public void increaseBodySum(Knight knight, int level,boolean flag) {
        if (flag){
            Knight.setBodySum(Knight.getBodySum() + 20 * level);
        }else {
            Knight.setBodySum(Knight.getBodySum()-20*level);
        }
    }

    //哥布林王的王冠：整体增加15点最大生命值，增加5点基础攻击力
    @Effect(startNum = "3000", endNum = "3000")
    public void goblinDiadema(Knight knight,int level ,boolean flag){
        if (flag){
            Knight.setBodySum(Knight.getBodySum()+15);
            Knight.setHeadSum(Knight.getHeadSum()+15);
            Knight.setLegLeftSum(Knight.getLegLeftSum()+15);
            Knight.setLegRightSum(Knight.getLegRightSum()+15);
            Knight.setArmLeftSum(Knight.getArmLeftSum()+15);
            Knight.setArmRightSum(Knight.getArmRightSum()+15);
            knight.setAttack(knight.getAttack()+5);
        }else {
            Knight.setBodySum(Knight.getBodySum()-15);
            Knight.setHeadSum(Knight.getHeadSum()-15);
            Knight.setLegLeftSum(Knight.getLegLeftSum()-15);
            Knight.setLegRightSum(Knight.getLegRightSum()-15);
            Knight.setArmLeftSum(Knight.getArmLeftSum()-15);
            Knight.setArmRightSum(Knight.getArmRightSum()-15);
            knight.setAttack(knight.getAttack()-5);
        }
    }


    //饰品状态
    public void giveKinghtStatus(Integer num,Status status,boolean flag) {
        Knight knight = Knight.getInstance();
        Class clz=AccessoriesEffect.class;
        Method[] methods=clz.getMethods();
        for (Method method:methods){
            if (method.isAnnotationPresent(Effect.class)){
                Effect effect=method.getAnnotation(Effect.class);
                if(!((null==effect.startNum()||effect.startNum().equals(""))&&(null==effect.endNum()||effect.endNum().equals("")))){
                    Integer startNum=Integer.parseInt(effect.startNum());
                    Integer endNum=Integer.parseInt(effect.endNum());
                    if (num>=startNum&&num<=endNum){
                        try {
                            method.invoke(accessoriesEffect,knight,status.getStatusLevel(),flag);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
