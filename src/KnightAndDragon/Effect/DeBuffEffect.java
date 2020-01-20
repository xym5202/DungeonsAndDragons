package KnightAndDragon.Effect;

import KnightAndDragon.Bean.Addition.skill;
import KnightAndDragon.Bean.Object.Knight;
import KnightAndDragon.util.TimeSleep;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 敌人技能
 */
public class DeBuffEffect  implements Runnable {

    static {
        map = new ConcurrentHashMap<>();
        deBuffEffect = new DeBuffEffect();
    }

    private static DeBuffEffect deBuffEffect;

    private static KnightAndDragon.Bean.Object.enemy enemy;

    //受到技能
    private static skill skills;

    //英雄负面状态集合
    private static Map<Integer, Boolean> map;

    private DeBuffEffect() {
        map.put(1, false);
        map.put(2, false);
        map.put(3, false);
        map.put(4, false);
        map.put(5, false);
        map.put(6, false);
        map.put(7, false);
        map.put(8, false);
        map.put(9, false);
        map.put(10, false);
        map.put(11, false);
    }

    public static DeBuffEffect getInstance() {
        return deBuffEffect;
    }

    public static skill getSkills() {
        return skills;
    }

    public static void setSkills(skill skills) {
        DeBuffEffect.skills = skills;
    }

    public static KnightAndDragon.Bean.Object.enemy getEnemy() {
        return enemy;
    }

    public static void setEnemy(KnightAndDragon.Bean.Object.enemy enemy) {
        DeBuffEffect.enemy = enemy;
    }

    /**
     * 1.虚弱状态
     */
    public static void weakness(Knight knight, int time, int flag, int level) {
        synchronized (map) {
            map.put(flag, true);
            System.out.println(knight.getKnightName() + "被虚弱了，Kinght的当前的攻击力为:" + knight.getAttack() + ",持续" + time + "s");
            System.out.println();
            int count = time;
            double attack = knight.getAttack();
            knight.setAttack(knight.getAttack() * (0.3 + 0.1 * level));
            while (count > 0) {
                count--;
                TimeSleep.timeSleep(1000);
            }
            knight.setAttack(attack);
            map.put(flag, false);
        }
    }

    /**
     * 2.沉默状态
     */
    public static void silence(Knight knight, int time, int flag, int level) {
        synchronized (map) {
            map.put(flag, true);
            int count = time + level;
            System.out.println(knight.getKnightName() + "沉默了，持续" + count + "s");
            List list = knight.getSkillList();
            knight.setSkillList(new ArrayList());
            while (count > 0) {
                count--;
                TimeSleep.timeSleep(1000);
            }
            knight.setSkillList(list);
            map.put(flag, false);
        }
    }

    /**
     * 3.中毒状态
     */
    public static void poison(Knight knight, int time, int flag, int level) {
        synchronized (map) {
            map.put(flag, true);
            System.out.println(knight.getKnightName() + "中毒了，身体血量每秒扣" + level + "滴血，持续" + time + "s,最低1点血");
            int count = time;
            while (count > 0) {
                int a=knight.getBody()-level;
                knight.setBody(a >= 1 ? a: 1);
                count--;
            }
            TimeSleep.timeSleep(1000);
        }
        map.put(flag, false);
    }

    /**
     * 4.麻痹状态
     */
    public static void lethargic(Knight knight, int time, int flag, int level) {
        synchronized (map) {
            map.put(flag, true);
            System.out.println(knight.getKnightName() + "麻痹了，Kinght的攻击速度为:" + knight.getAttackSpeed() + ",持续" + time + "s");
            int count = time;
            knight.setIniAttackSpeed(knight.getIniAttackSpeed() * (0.5 + 1 * level));
            while (count > 0) {
                count--;
                TimeSleep.timeSleep(1000);
            }
            knight.setIniAttackSpeed(knight.getIniAttackSpeed() / (0.5 + 1 * level));
        }
        map.put(flag, false);
    }

    /**
     * 5.迟缓状态
     *
     * @param knight
     */
    public static void slow(Knight knight, int time, int flag, int level) {
        synchronized (map) {
            map.put(flag, true);
            System.out.println(knight.getIniActionTime() + "迟缓了，Kinght的行动力为:" + knight.getIniActionTime() + ",持续" + time + "s");
            int count = time;
            knight.setIniActionTime(knight.getIniActionTime()* (1- 0.1 * level));
            while (count > 0) {
                count--;
                TimeSleep.timeSleep(1000);
            }
            knight.setIniActionTime(knight.getIniActionTime()/ (1- 0.1 * level));
            map.put(flag, false);
        }
    }

    /**
     * 6.灼烧状态
     *
     * @param knight
     */
    public static void firing(Knight knight, int time, int flag, int level) {
        synchronized (map) {
            map.put(flag, true);
            System.out.println(knight.getKnightName() + "燃烧了,持续" + time + "s,每秒受到" + level + "点伤害");
            int count = time;
            int a = (int) (Math.random() * 5 + 1);
            while (count > 0) {
                switch (a) {
                    case 1:
                        if (knight.getHead() >= level) {
                            knight.setHead(knight.getHead() - level);
                        } else {
                            Knight.knightDeath();
                        }
                        break;
                    case 2:
                        knight.setArmLeft((knight.getArmLeft() - level) >= 1 ? knight.getArmLeft() - level : 1);
                        break;
                    case 3:
                        if (knight.getArmRight() >= level) {
                            knight.setArmRight(knight.getArmRight() - level >= 1 ? knight.getArmRight() - level : 1);
                        }
                        break;
                    case 4:
                        if (knight.getLegLeft() >= level) {
                            knight.setLegLeft(knight.getLegLeft() - level >= 1 ? knight.getLegLeft() - level : 1);
                        }
                        break;
                    case 5:
                        if (knight.getLegRight() >= level) {
                            knight.setLegRight(knight.getLegRight() - level >= 1 ? knight.getLegRight() - level : 1);
                        }
                        break;
                }
                count--;
                TimeSleep.timeSleep(1000);
            }
            map.put(flag, false);
        }
    }

    /**
     * 7.治疗状态
     *
     * @param enemy
     */
    public static void healEnemySelf(KnightAndDragon.Bean.Object.enemy enemy, int level) {
        System.out.println(enemy.getEnemyName() + "使用了治疗术一级,恢复了" + 0.5*enemy.getEnemyMagicAttack() + "血量");
        enemy.setEnemyBlood(enemy.getEnemyBlood() +0.5*enemy.getEnemyMagicAttack());
    }


    /**
     * 持盾状态
     *
     * @param knight
     */
    public static void catchShield(Knight knight) {
        //降低移速
        knight.setIniActionTime(knight.getIniActionTime() * knight.getShield().getAffectAction());
    }

    /**
     * 取消持盾状态
     *
     * @param knight
     */
    public static void cancelCatchShield(Knight knight) {
        //恢复移速
        knight.setIniActionTime(knight.getIniActionTime()/knight.getShield().getAffectAction());
    }


    @Override
    public void run() {
        Knight knight = Knight.getInstance();
        int a = DeBuffEffect.getSkills().getStatus().getStatusFlag();
        int time = DeBuffEffect.getSkills().getTime();
        int level = DeBuffEffect.getSkills().getStatus().getStatusLevel();
        switch (a) {
            case 1:
                if (!map.get(a)) {
                    DeBuffEffect.weakness(knight, time, a, level);
                }
                break;
            case 2:
                if (!map.get(a)) {
                    DeBuffEffect.silence(knight, time, a, level);
                }
                break;
            case 3:
                if (!map.get(a)) {
                    DeBuffEffect.poison(knight, time, a, level);
                }
                break;
            case 4:
                if (!map.get(a)) {
                    DeBuffEffect.lethargic(knight, time, a, level);
                }
                break;
            case 5:
                if (!map.get(a)) {
                    DeBuffEffect.slow(knight, time, a, level);
                }
                break;
            case 6:
                if (!map.get(a)) {
                    DeBuffEffect.firing(knight, time, a, level);
                }
                break;
            case 7:
                if (!map.get(a)) {
                    DeBuffEffect.healEnemySelf(enemy, level);
                }
                break;
            default:
                break;
        }
    }

}
