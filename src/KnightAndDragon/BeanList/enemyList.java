package KnightAndDragon.BeanList;

import KnightAndDragon.Bean.Object.Knight;
import KnightAndDragon.Bean.Object.enemy;
import KnightAndDragon.util.RandomGetDouble;

import java.awt.peer.ListPeer;
import java.util.ArrayList;
import java.util.List;

public class enemyList {

    //生成低等敌人
    private static List<enemy> enemyCreatLowerList = new ArrayList<>(50);
    //生成中等敌人
    private static List<enemy> enemyCreatMediumList = new ArrayList<>(10);
    //生成高等敌人
    private static List<enemy> enemyCreatHigherList = new ArrayList<>(10);
    //人型
    private static List<enemy> enemyPersonList = new ArrayList<>(30);
    //兽型
    private static List<enemy> enemyOrcList = new ArrayList<>(30);
    //龙型
    private static List<enemy> enemyDragonList = new ArrayList<>(30);

    public static List<enemy> getEnemyCreatLowerList() {
        InitLowerList();
        return enemyCreatLowerList;
    }

    public static void setEnemyCreatLowerList(List<enemy> enemyCreatLowerList) {
        enemyList.enemyCreatLowerList = enemyCreatLowerList;
    }

    public static List<enemy> getEnemyCreatMediumList() {
        return enemyCreatMediumList;
    }

    public static void setEnemyCreatMediumList(List<enemy> enemyCreatMediumList) {
        enemyList.enemyCreatMediumList = enemyCreatMediumList;
    }

    public static List<enemy> getEnemyCreatHigherList() {
        return enemyCreatHigherList;
    }

    public static void setEnemyCreatHigherList(List<enemy> enemyCreatHigherList) {
        enemyList.enemyCreatHigherList = enemyCreatHigherList;
    }

    public static List<enemy> getEnemyPersonList() {
        InitPersonEnemy(enemyPersonList);
        return enemyPersonList;
    }

    public static void setEnemyPersonList(List<enemy> enemyPersonList) {
        enemyList.enemyPersonList = enemyPersonList;
    }

    public static List<enemy> getEnemyOrcList() {
        InitOrcEnemy(enemyOrcList);
        return enemyOrcList;
    }

    public static void setEnemyOrcList(List<enemy> enemyOrcList) {
        enemyList.enemyOrcList = enemyOrcList;
    }

    public static List<enemy> getEnemyDragonList() {
        InitMonsterEnemy(enemyDragonList);
        return enemyDragonList;
    }

    public static void setEnemyDragonList(List<enemy> enemyDragonList) {
        enemyList.enemyDragonList = enemyDragonList;
    }

    //初始化生成怪物队列
    public static void init() {
        InitLowerList();
        InitPersonEnemy(enemyPersonList);
        InitOrcEnemy(enemyOrcList);
        InitMonsterEnemy(enemyDragonList);
    }

    public static void InitPersonEnemy(List<enemy> enemyPersonList) {
        enemyPersonList.clear();
        //人型怪
        enemyPersonList.add(new enemy("人型", "逃犯", Knight.getBodySum() / 30 + Knight.getHeadSum() / 30, Knight.getInstance().getLevel() / 5 + 1, Knight.getInstance().getLevel() * 0.1, Knight.getInstance().getPower() * 0.5 + Knight.getInstance().getLevel() / 6, Knight.getInstance().getIntelligence() * 0.2, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 5, 3, 0.1, 0.05, 1));
        enemyPersonList.add(new enemy("人型", "混混", Knight.getBodySum() / 20 + Knight.getHeadSum() / 25, Knight.getInstance().getLevel() / 5 + 3, Knight.getInstance().getLevel() * 0.1, Knight.getInstance().getPower() * 0.7 + Knight.getInstance().getLevel() / 6, Knight.getInstance().getIntelligence() * 0.2, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 8, 5, 0.1, 0.05, 1));
        enemyPersonList.add(new enemy("人型", "强盗", Knight.getBodySum() / 15 + Knight.getHeadSum() / 25 + Knight.getArmLeftSum() / 10 + Knight.getArmRightSum() / 10, Knight.getInstance().getLevel() / 5 + Knight.getInstance().getPower() /15  + 1, Knight.getInstance().getLevel() * 0.2, Knight.getInstance().getPower() /15 + Knight.getInstance().getLevel() / 3, Knight.getInstance().getIntelligence() /30 + Knight.getInstance().getLevel() / 3, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 15, 8, 0.1, 0.1, 1.2));
        enemyPersonList.add(new enemy("人型", "流浪法师", Knight.getBodySum() / 30 + Knight.getHeadSum() / 25 + Knight.getArmLeftSum() / 30 + Knight.getArmRightSum() / 30, Knight.getInstance().getLevel() * 0.3, Knight.getInstance().getLevel() /20 + 4, Knight.getInstance().getPower() /15 + Knight.getInstance().getLevel() * 0.3, Knight.getInstance().getIntelligence() /20 + Knight.getInstance().getLevel() / 3, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 20, 11, 0.1, 0.1, 1.5));
        enemyPersonList.add(new enemy("人型", "刺客", Knight.getBodySum() / 25 + Knight.getHeadSum() / 20 + Knight.getArmLeftSum() / 10 + Knight.getArmRightSum() / 15, Knight.getInstance().getLevel() * 0.2 + Knight.getInstance().getAgility() /20+ 2, Knight.getInstance().getLevel() * 0.1, Knight.getInstance().getPower() /20 + Knight.getInstance().getLevel() * 0.3 + Knight.getInstance().getAgility()/15, Knight.getInstance().getLevel() / 3, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 25, 15, 0.3, 0.2, 1.3));
        enemyPersonList.add(new enemy("人型", "赏金猎手", Knight.getBodySum() / 20 + Knight.getHeadSum() / 20 + Knight.getArmLeftSum() / 10 + Knight.getArmRightSum() / 10, Knight.getInstance().getLevel() * 0.2 + Knight.getInstance().getAgility() /20 + 2, Knight.getInstance().getLevel() * 0.1, Knight.getInstance().getPower() /15 + Knight.getInstance().getLevel() * 0.3 + Knight.getInstance().getAgility() /15 + 2, Knight.getInstance().getLevel() / 3 + 1, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 28, 20, 0.15, 0.115, 1.5));
        enemyPersonList.add(new enemy("人型", "女巫", Knight.getBodySum() / 20 + Knight.getHeadSum() / 20 + Knight.getArmLeftSum() / 15, Knight.getInstance().getLevel() * 0.3, Knight.getInstance().getLevel() / 3 + 4, Knight.getInstance().getPower() /20+ Knight.getInstance().getLevel() * 0.3, Knight.getInstance().getLevel() / 3 + 3, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 28, 15, 0.1, 0.1, 3.0));
        enemyPersonList.add(new enemy("人型", "邪教教徒", Knight.getBodySum() / 20 + Knight.getHeadSum() / 16 + Knight.getArmLeftSum() / 15, Knight.getInstance().getLevel() / 5 + 3, Knight.getInstance().getLevel() / 5 + 2, Knight.getInstance().getPower() /15 + 3 + Knight.getInstance().getLevel() * 0.3, Knight.getInstance().getLevel() / 4 + 1, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 29, 15, 0.1, 0.1, 2.0));
    }

    public static void InitOrcEnemy(List<enemy> enemyOrcList) {
        enemyOrcList.clear();
        //兽形怪
        enemyOrcList.add(new enemy("兽型", "蜘蛛", Knight.getBodySum() / 30 + Knight.getHeadSum() / 15 + Knight.getLegLeftSum() / 20, Knight.getInstance().getLevel() / 4 + 1, 0, Knight.getInstance().getPower() /20+1, Knight.getInstance().getIntelligence() * 0.05, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 6, 1, 0.05, 0.05, 0.8));
        enemyOrcList.add(new enemy("兽型", "剧毒蜘蛛", Knight.getBodySum() / 25 + Knight.getHeadSum() / 15 + Knight.getLegLeftSum() / 15, Knight.getInstance().getLevel() / 4 + 2, 0, Knight.getInstance().getPower()/20+1, Knight.getInstance().getIntelligence() *0.05, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 8, 2, 0.05, 0.1, 0.8));
        enemyOrcList.add(new enemy("兽型", "哥布林", Knight.getBodySum() / 15 + Knight.getHeadSum() / 15 + Knight.getLegLeftSum() / 15, Knight.getInstance().getLevel() / 4 + 2, 0, Knight.getInstance().getPower()/15+2, Knight.getInstance().getIntelligence() * 0.0, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 9, 3, 0.1, 0.1, 1));
        enemyOrcList.add(new enemy("兽型", "半兽人", Knight.getBodySum() / 10 + Knight.getHeadSum() / 10 + Knight.getLegLeftSum() / 10, Knight.getInstance().getLevel() / 3 + 3, 0, Knight.getInstance().getPower() /15+3, Knight.getInstance().getIntelligence() * 0.0, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 13, 5, 0.1, 0.1, 1));
        enemyOrcList.add(new enemy("兽型", "恐狼", Knight.getBodySum() / 15 + Knight.getHeadSum() / 13 + Knight.getLegLeftSum() / 15, Knight.getInstance().getLevel() / 4 + 4, 0.1, Knight.getInstance().getPower()/15+2, Knight.getInstance().getIntelligence() * 0.05, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 12, 3, 0.1, 0.1, 0.8));
        enemyOrcList.add(new enemy("兽型", "哥布林弓箭手", Knight.getBodySum() / 20 + Knight.getHeadSum() / 15 + Knight.getLegLeftSum() / 15, Knight.getInstance().getLevel() / 4 + 3, 0.2, Knight.getInstance().getPower() /15+3, Knight.getInstance().getIntelligence() * 0.05, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 14, 5, 0.15, 0.15, 2.5));
        enemyOrcList.add(new enemy("兽型", "半兽人投掷手", Knight.getBodySum() / 20 + Knight.getHeadSum() / 15 + Knight.getLegLeftSum() / 15, Knight.getInstance().getLevel() / 4 + 4, 0.1, Knight.getInstance().getPower() /15+4, Knight.getInstance().getIntelligence() * 0.05, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 18, 6, 0.15, 0.15, 3.0));
        enemyOrcList.add(new enemy("兽型", "强兽人", Knight.getBodySum() / 15 + Knight.getHeadSum() / 10 + Knight.getLegLeftSum() / 15, Knight.getInstance().getLevel() / 4 + 4 + Knight.getInstance().getPower() / 13 + 2, 0, Knight.getInstance().getPower() /13+4 + Knight.getInstance().getLevel() / 5 + 1, Knight.getInstance().getIntelligence() * 0.1, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 20, 9, 0.15, 0.15, 1.0));
    }

    public static void InitMonsterEnemy(List<enemy> listMonster) {
        listMonster.clear();
        listMonster.add(new enemy("魔型", "被污染的农民", Knight.getBodySum() / 15 + Knight.getHeadSum() / 15 + Knight.getHeadSum() / 15, Knight.getInstance().getLevel() / 4 + 4, Knight.getInstance().getLevel() / 4 + 1, Knight.getInstance().getPower() , Knight.getInstance().getIntelligence(), RandomGetDouble.getDragonAttackSpeed(), RandomGetDouble.getActionTime(), 16, 6, 0.05, 0.1, 1));
        listMonster.add(new enemy("魔型", "被污染的人类士兵", Knight.getBodySum() / 15 + Knight.getHeadSum() / 15 + Knight.getHeadSum() / 15, Knight.getInstance().getLevel() / 4 + 6, Knight.getInstance().getLevel() / 4, Knight.getInstance().getPower()  + 1, Knight.getInstance().getIntelligence() * 0.3+2, RandomGetDouble.getDragonAttackSpeed(), RandomGetDouble.getActionTime(), 32, 8, 0.05, 0.0, 1.2));
        listMonster.add(new enemy("魔型", "黑暗火龙", Knight.getBodySum() / 15 + Knight.getHeadSum() / 15 + Knight.getLegLeftSum() / 15, Knight.getInstance().getLevel() / 4 + 3, Knight.getInstance().getLevel() / 4 + 3, Knight.getInstance().getPower(), Knight.getInstance().getIntelligence(), RandomGetDouble.getDragonAttackSpeed(), RandomGetDouble.getActionTime(), 30, 5, 0.1, 0.05, 2.5));
        listMonster.add(new enemy("魔型", "梦魇", Knight.getBodySum() / 20 + Knight.getHeadSum() / 15, Knight.getInstance().getLevel() / 4 + 8, Knight.getInstance().getLevel() / 4 + 3, Knight.getInstance().getPower() +2, Knight.getInstance().getIntelligence() , RandomGetDouble.getDragonAttackSpeed(), RandomGetDouble.getActionTime(), 35, 5, 0.1, 0.1, 1));
        listMonster.add(new enemy("魔型", "狼人", Knight.getBodySum() / 10 + Knight.getHeadSum() / 2, Knight.getInstance().getLevel() / 3 + 5, Knight.getInstance().getLevel() / 3 + 4, Knight.getInstance().getPower() +8, Knight.getInstance().getIntelligence() , RandomGetDouble.getDragonAttackSpeed(), RandomGetDouble.getActionTime(), 46, 13, 0.3, 0.1, 1));
    }

    public static void InitLowerList() {
        enemyCreatLowerList.clear();
        enemyCreatLowerList.add(new enemy("人型", "逃犯", Knight.getBodySum() / 20 + Knight.getHeadSum() / 20+Knight.getArmRightSum()/20, Knight.getInstance().getLevel() / 5 + 1, Knight.getInstance().getLevel() * 0.1, Knight.getInstance().getPower() * 0.5 + Knight.getInstance().getLevel() / 6, Knight.getInstance().getIntelligence() * 0.2, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 5, 3, 0.1, 0.05, 1));
        enemyCreatLowerList.add(new enemy("人型", "混混", Knight.getBodySum() / 20 + Knight.getHeadSum() / 15+Knight.getArmRightSum()/20, Knight.getInstance().getLevel() / 5 + 3, Knight.getInstance().getLevel() * 0.1, Knight.getInstance().getPower() * 0.7 + Knight.getInstance().getLevel() / 6, Knight.getInstance().getIntelligence() * 0.2, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 8, 5, 0.1, 0.05, 1));
        enemyCreatLowerList.add(new enemy("人型", "强盗", Knight.getBodySum() / 15 + Knight.getHeadSum() / 25 + Knight.getArmLeftSum() / 10 + Knight.getArmRightSum() / 5, Knight.getInstance().getLevel() / 5 + Knight.getInstance().getPower() * 0.5 + 1, Knight.getInstance().getLevel() * 0.2, Knight.getInstance().getPower() * 0.7 + Knight.getInstance().getLevel() / 3, Knight.getInstance().getIntelligence() * 0.2 + Knight.getInstance().getLevel() / 3, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 15, 8, 0.1, 0.1, 1.2));
        enemyCreatLowerList.add(new enemy("兽型", "蜘蛛", Knight.getBodySum() / 30 + Knight.getHeadSum() / 15 + Knight.getLegLeftSum() / 20, Knight.getInstance().getLevel() / 4 + 1, 0, Knight.getInstance().getPower() * 1.1, Knight.getInstance().getIntelligence() * 0.1, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 6, 1, 0.05, 0.05, 0.8));
        enemyCreatLowerList.add(new enemy("兽型", "剧毒蜘蛛", Knight.getBodySum() / 25 + Knight.getHeadSum() / 15 + Knight.getLegLeftSum() / 15, Knight.getInstance().getLevel() / 4 + 2, 0, Knight.getInstance().getPower(), Knight.getInstance().getIntelligence() * 0.1, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 8, 2, 0.05, 0.1, 0.8));
        enemyCreatLowerList.add(new enemy("人型", "流浪法师", Knight.getBodySum() / 30 + Knight.getHeadSum() / 25 + Knight.getArmLeftSum() / 20 + Knight.getArmRightSum() / 20, Knight.getInstance().getLevel() * 0.3, Knight.getInstance().getLevel() * 0.5 + 4, Knight.getInstance().getPower() * 0.1 + Knight.getInstance().getLevel() * 0.3, Knight.getInstance().getIntelligence() * 0.7 + Knight.getInstance().getLevel() / 3, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 20, 11, 0.1, 0.1, 1.5));
        enemyCreatLowerList.add(new enemy("人型", "女巫", Knight.getBodySum() / 20 + Knight.getHeadSum() / 20 + Knight.getArmLeftSum() / 15, Knight.getInstance().getLevel() * 0.3, Knight.getInstance().getLevel() / 3 + 4, Knight.getInstance().getPower() * 0.2 + Knight.getInstance().getLevel() * 0.5, Knight.getInstance().getLevel() / 2 + 3, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 28, 15, 0.1, 0.1, 3.0));
        enemyCreatLowerList.add(new enemy("兽型", "哥布林", Knight.getBodySum() / 15 + Knight.getHeadSum() / 15 + Knight.getLegLeftSum() / 15, Knight.getInstance().getLevel() / 4 + 2, 0, Knight.getInstance().getPower() * 1.15, Knight.getInstance().getIntelligence() * 0.0, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 9, 3, 0.1, 0.1, 1));
        enemyCreatLowerList.add(new enemy("兽型", "哥布林弓箭手", Knight.getBodySum() / 20 + Knight.getHeadSum() / 15 + Knight.getLegLeftSum() / 15, Knight.getInstance().getLevel() / 4 + 3, 0.2, Knight.getInstance().getPower() * 1.2, Knight.getInstance().getIntelligence() * 0.1, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 14, 5, 0.15, 0.15, 2.5));
        enemyCreatLowerList.add(new enemy("魔型", "被污染的农民", Knight.getBodySum() / 15 + Knight.getHeadSum() / 15 + Knight.getHeadSum() / 15, Knight.getInstance().getLevel() / 4 + 4, Knight.getInstance().getLevel() / 4 + 1, Knight.getInstance().getPower() * 1.1, Knight.getInstance().getIntelligence(), RandomGetDouble.getDragonAttackSpeed(), RandomGetDouble.getActionTime(), 16, 6, 0.05, 0.1, 1));
        enemyCreatLowerList.add(new enemy("人型", "刺客", Knight.getBodySum() / 20 + Knight.getHeadSum() / 20 + Knight.getArmLeftSum() / 10 + Knight.getArmRightSum() / 15, Knight.getInstance().getLevel() * 0.5 + Knight.getInstance().getAgility() * 0.5 + 2, Knight.getInstance().getLevel() * 0.3, Knight.getInstance().getPower() * 0.7 + Knight.getInstance().getLevel() * 0.3 + Knight.getInstance().getAgility() * 0.5, Knight.getInstance().getLevel() / 3, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 25, 15, 0.3, 0.2, 1.3));
        enemyCreatLowerList.add(new enemy("人型", "赏金猎手", Knight.getBodySum() / 20 + Knight.getHeadSum() / 20 + Knight.getArmLeftSum() / 10 + Knight.getArmRightSum() / 10, Knight.getInstance().getLevel() * 0.5 + Knight.getInstance().getAgility() * 0.5 + 2, Knight.getInstance().getLevel() * 0.2, Knight.getInstance().getPower() * 0.7 + Knight.getInstance().getLevel() * 0.3 + Knight.getInstance().getAgility() * 0.5 + 2, Knight.getInstance().getLevel() / 3 + 1, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 28, 20, 0.15, 0.115, 1.5));
        enemyCreatLowerList.add(new enemy("人型", "邪教教徒", Knight.getBodySum() / 20 + Knight.getHeadSum() / 16 + Knight.getArmLeftSum() / 15, Knight.getInstance().getLevel() / 5 + 6, Knight.getInstance().getLevel() / 5 + 1, Knight.getInstance().getPower() * 0.5 + 3 + Knight.getInstance().getLevel() * 0.5, Knight.getInstance().getLevel() / 4 + 1, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 29, 15, 0.1, 0.1, 2.0));
        enemyCreatLowerList.add(new enemy("兽型", "半兽人", Knight.getBodySum() / 10 + Knight.getHeadSum() / 10 + Knight.getLegLeftSum() / 10, Knight.getInstance().getLevel() / 3 + 3, 0, Knight.getInstance().getPower() * 1.2, Knight.getInstance().getIntelligence() * 0.0, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 13, 5, 0.1, 0.1, 1));
        enemyCreatLowerList.add(new enemy("兽型", "恐狼", Knight.getBodySum() / 15 + Knight.getHeadSum() / 13 + Knight.getLegLeftSum() / 15, Knight.getInstance().getLevel() / 4 + 4, 0.1, Knight.getInstance().getPower() * 1.15, Knight.getInstance().getIntelligence() * 0.1, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 12, 3, 0.1, 0.1, 0.8));
        enemyCreatLowerList.add(new enemy("兽型", "半兽人投掷手", Knight.getBodySum() / 20 + Knight.getHeadSum() / 15 + Knight.getLegLeftSum() / 15, Knight.getInstance().getLevel() / 4 + 4, 0.1, Knight.getInstance().getPower() * 1.5, Knight.getInstance().getIntelligence() * 0.1, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 18, 6, 0.15, 0.15, 3.0));
        enemyCreatLowerList.add(new enemy("兽型", "强兽人", Knight.getBodySum() / 15 + Knight.getHeadSum() / 10 + Knight.getLegLeftSum() / 15, Knight.getInstance().getLevel() / 4 + 4 + Knight.getInstance().getPower() / 2 + 2, 0, Knight.getInstance().getPower() * 1.3 + Knight.getInstance().getLevel() / 3 + 1, Knight.getInstance().getIntelligence() * 0.1, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime(), 20, 9, 0.15, 0.15, 1.0));
        enemyCreatLowerList.add(new enemy("魔型", "被污染的人类士兵", Knight.getBodySum() / 15 + Knight.getHeadSum() / 15 + Knight.getHeadSum() / 15, Knight.getInstance().getLevel() / 4 + 6, Knight.getInstance().getLevel() / 4, Knight.getInstance().getPower() * 1.5 + 2, Knight.getInstance().getIntelligence() * 1.1, RandomGetDouble.getDragonAttackSpeed(), RandomGetDouble.getActionTime(), 32, 8, 0.05, 0.0, 1.2));
        enemyCreatLowerList.add(new enemy("魔型", "梦魇", Knight.getBodySum() / 20 + Knight.getHeadSum() / 15, Knight.getInstance().getLevel() / 4 + 8, Knight.getInstance().getLevel() / 4 + 3, Knight.getInstance().getPower() +2, Knight.getInstance().getIntelligence() , RandomGetDouble.getDragonAttackSpeed(), RandomGetDouble.getActionTime(), 35, 5, 0.1, 0.1, 1));
    }

    //静态工厂，生成敌人
    public static enemy createEnemyFactory(int a) {
        if (a <= 2) {
            InitLowerList();
        }
        enemy enemy1=null;
        if (a==1){
             enemy1 = setUpEnemySkill(enemyCreatLowerList.get(RandomGetDouble.getInteger(0,8)));
        }
        else if (a==2) {
             enemy1 = setUpEnemySkill(enemyCreatLowerList.get(RandomGetDouble.getInteger(9,18)));
        }
        return enemy1;
    }

    public static enemy setUpEnemySkill(enemy enemy) {
        String name = enemy.getEnemyName();
        switch (name) {
            case "流浪法师":
                enemy.setSkill(RandomGetDouble.randomDecimals() <= 0.3 ? SkillList.getEnemySkillLists().get(6) : null);
                break;
            case "赏金猎手":
                enemy.setSkill((RandomGetDouble.randomDecimals() > 0.2 && RandomGetDouble.randomDecimals() < 0.25) ? SkillList.getEnemySkillLists().get(4) : null);
                break;
            case "剧毒蜘蛛":
                enemy.setSkill(RandomGetDouble.randomDecimals() < 0.4 ? SkillList.getEnemySkillLists().get(2) : null);
                break;
            case "小火龙":
                enemy.setSkill(RandomGetDouble.randomDecimals() < 0.5 ? SkillList.getEnemySkillLists().get(5) : null);
                break;
            case "女巫":
                enemy.setSkill(RandomGetDouble.randomDecimals() < 0.6 ? SkillList.getEnemySkillLists().get(1) : null);
                break;
            case "半兽人投掷手":
                enemy.setSkill(RandomGetDouble.randomDecimals() < 0.3 ? SkillList.getEnemySkillLists().get(5) : null);
                break;
            default:
                break;
        }
        return enemy;
    }

}
