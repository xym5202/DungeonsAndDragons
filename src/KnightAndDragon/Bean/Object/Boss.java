package KnightAndDragon.Bean.Object;

import KnightAndDragon.Bean.Addition.skill;
import KnightAndDragon.BeanList.SkillList;
import KnightAndDragon.util.RandomGetDouble;

import java.util.ArrayList;
import java.util.List;

public class Boss  {

    private static List<enemy> enemies=new ArrayList<>();

    private static Knight knight=Knight.getInstance();

    private static Boss boss;

    static {
        boss=new Boss();
    }

    private Boss(){}

    public static Boss getInstance(){
        return boss;
    }

    public  List<enemy> getEnemies() {
        enemies.clear();
        InitBoss();
        return enemies;
    }

    public static void InitBoss(){
        enemies.add(new enemy("兽型","哥布林王",Knight.getHeadSum(),knight.getPower()/10+knight.getLevel()/3+3,knight.getIntelligence()/20+2+knight.getLevel()/5+2,knight.getLevel()/4+2,knight.getLevel()/4+2, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime()+1,66,66,0.15,0.1,1.5, SkillList.getEnemySkillLists().get(3)));
        enemies.add(new enemy("人型","黑暗法师",Knight.getHeadSum()/2+20,knight.getIntelligence()/10+1,knight.getIntelligence()/9+knight.getLevel()/3+3,knight.getLevel()/4+3,knight.getLevel()/3+5, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime()+1,77,77,0.05,0.05,2.3, SkillList.getEnemySkillLists().get(2)));
        enemies.add(new enemy("兽型","守宝火龙",Knight.getHeadSum()/2+Knight.getBodySum()/7,knight.getPower()/9+knight.getLevel()/3+5,knight.getIntelligence()/20+knight.getLevel()/4+5,knight.getLevel()/5+2,knight.getLevel()/4+5, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime()+1,66,66,0.1,0.00,2.5, SkillList.getEnemySkillLists().get(5)));
        enemies.add(new enemy("兽型","矿道黑龙",Knight.getHeadSum()/2+Knight.getBodySum()/3,knight.getPower()/8+knight.getLevel()/3+8,knight.getIntelligence()/20+knight.getLevel()/4+8,knight.getLevel()/5+4,knight.getLevel()/4+4, RandomGetDouble.getAttackSpeed(), RandomGetDouble.getActionTime()+1,88,88,0.1,0.00,2.5, SkillList.getEnemySkillLists().get(5)));

    }
}
