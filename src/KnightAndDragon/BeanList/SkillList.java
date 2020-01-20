package KnightAndDragon.BeanList;

import KnightAndDragon.Bean.Addition.skill;
import KnightAndDragon.Bean.Object.Knight;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class SkillList {
    //低级技能列表
    private  static List<skill> Lowerskills =new ArrayList<>();

    //中级技能列表
    private  static List<skill> Mediumskills;

    //高级技能列表
    private  static List<skill> Higherskills;

    //怪物技能
    private static List<skill> enemySkillLists =new ArrayList<>();

    //装备附魔技能
    private static List<skill> equipmentSkillLists =new ArrayList<>();

    private static ConcurrentHashMap<Integer,List<skill>> concurrentHashMap;

    private static SkillList skillList;

    static {
        skillList=new SkillList();
    }

    public static List<skill> getLowerskills() {
        return Lowerskills;
    }

    public static List<skill> getEnemySkillLists() {
        return enemySkillLists;
    }

    public static List<skill> getEquipmentSkillLists() {
        return equipmentSkillLists;
    }

    private SkillList(){}

    public static ConcurrentHashMap<Integer, List<skill>> getConcurrentHashMap() {
        return concurrentHashMap;
    }

    public static SkillList getInstance(){
        return skillList;
    }

    public void InitSkillList(){
        synchronized (Object.class) {
            enemySkillLists.clear();
            //敌人技能初始化
            enemySkillLists.add(new skill("虚弱1级", true, 5, StatusList.getConcurrentHashMap().get("虚弱1级"), 0, 0));
            enemySkillLists.add(new skill("沉默1级", true, 5, StatusList.getConcurrentHashMap().get("沉默1级"), 0, 0));
            enemySkillLists.add(new skill("中毒1级", true, 5, StatusList.getConcurrentHashMap().get("中毒1级"), 0, 0));
            enemySkillLists.add(new skill("麻痹1级", true, 5, StatusList.getConcurrentHashMap().get("麻痹1级"), 0, 0));
            enemySkillLists.add(new skill("迟缓1级", true, 5, StatusList.getConcurrentHashMap().get("迟缓1级"), 0, 0));
            enemySkillLists.add(new skill("灼烧1级", true, 5, StatusList.getConcurrentHashMap().get("灼烧1级"), 0, 0));
            enemySkillLists.add(new skill("治疗1级", true, 5, StatusList.getConcurrentHashMap().get("治疗1级"), 0, 0));


            Lowerskills.clear();
            Lowerskills.add(new skill("恢复术", true, 5, StatusList.getConcurrentHashMap().get("恢复术"), 10, 1));
            Lowerskills.add(new skill("治疗术", true, 0, StatusList.getConcurrentHashMap().get("治疗术"), 15, 2));
            Lowerskills.add(new skill("火球术", true, 0, StatusList.getConcurrentHashMap().get("火球术"), 15, 3));
            Lowerskills.add(new skill("冰冻术", true, 5, StatusList.getConcurrentHashMap().get("冰冻术"), 12, 3));
            Lowerskills.add(new skill("流血术", true, 5, StatusList.getConcurrentHashMap().get("流血术"), 10, 2));

            equipmentSkillLists.clear();
            equipmentSkillLists.add(new skill("装备力量1级", true, 0, StatusList.getConcurrentHashMap().get("装备力量1级"), 0, 0));
            equipmentSkillLists.add(new skill("装备力量2级", true, 0, StatusList.getConcurrentHashMap().get("装备力量2级"), 0, 0));
            equipmentSkillLists.add(new skill("装备力量3级", true, 0, StatusList.getConcurrentHashMap().get("装备力量3级"), 0, 0));
            equipmentSkillLists.add(new skill("装备力量4级", true, 0, StatusList.getConcurrentHashMap().get("装备力量4级"), 0, 0));
            equipmentSkillLists.add(new skill("装备力量5级", true, 0, StatusList.getConcurrentHashMap().get("装备力量5级"), 0, 0));
            equipmentSkillLists.add(new skill("装备智力1级", true, 0, StatusList.getConcurrentHashMap().get("装备智力1级"), 0, 0));
            equipmentSkillLists.add(new skill("装备智力2级", true, 0, StatusList.getConcurrentHashMap().get("装备智力2级"), 0, 0));
            equipmentSkillLists.add(new skill("装备智力3级", true, 0, StatusList.getConcurrentHashMap().get("装备智力3级"), 0, 0));
            equipmentSkillLists.add(new skill("装备智力4级", true, 0, StatusList.getConcurrentHashMap().get("装备智力4级"), 0, 0));
            equipmentSkillLists.add(new skill("装备智力5级", true, 0, StatusList.getConcurrentHashMap().get("装备智力5级"), 0, 0));
        }
    }

    //打印可学技能
    public  List<skill> toStringKnightSkills(){
        List<skill> knightSkill=new ArrayList<>();
        StringBuffer sb=new StringBuffer();
        Knight knight=Knight.getInstance();
        Integer count=0;
        for (skill skills:Lowerskills) {
            if (!knight.getSkillList().contains(skills)){
                knightSkill.add(skills);
                sb.append(count+"、"+skills.getSkillKind()+"\t 魔耗："+skills.getReduceMana()+"\t费用："+skills.getNeedPoint()+"\n");
                count++;
            }
        }
        String str=String.valueOf(sb);
        System.out.println(str);
    return knightSkill;
    }
}
