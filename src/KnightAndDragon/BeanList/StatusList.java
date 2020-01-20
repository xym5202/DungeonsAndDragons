package KnightAndDragon.BeanList;

import KnightAndDragon.Bean.Addition.Status;
import KnightAndDragon.Bean.Addition.skill;
import KnightAndDragon.Bean.Items.Accessories;
import KnightAndDragon.Bean.Items.Item;
import KnightAndDragon.util.InitClass;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StatusList {

    private static StatusList statusList = new StatusList();

    static {
        concurrentHashMap = new ConcurrentHashMap<>();
    }

    //状态集合;不包括ItemEffect
    private static volatile ConcurrentHashMap<String, Status> concurrentHashMap;

    public static ConcurrentHashMap<String, Status> getConcurrentHashMap() {
        return concurrentHashMap;
    }

    private StatusList() {
    }

    public static StatusList getInstance() {
        return statusList;
    }

    public void InitialStatus() {
        synchronized (Object.class) {
            List<skill> enemySkillList = SkillList.getEnemySkillLists();
            int count = 0;
            for (skill s : enemySkillList) {
                count++;
                if (count > 7) {
                    break;
                }
                concurrentHashMap.put(s.getSkillKind(), new Status(count, s.getSkillKind(), 1));
            }

            //英雄技能
            List<skill> LowerSkillList = SkillList.getLowerskills();
            int lowerSkillflag = 201;
            for (skill s : LowerSkillList) {
                concurrentHashMap.put(s.getSkillKind(), new Status(lowerSkillflag, s.getSkillKind(), 1));
                lowerSkillflag++;
            }
        }

        List<skill> equipmentSkillList = SkillList.getEquipmentSkillLists();
        int equipflag = 1001;
        int levelequipment = 0;
        for (skill s : equipmentSkillList) {
            levelequipment++;
            concurrentHashMap.put(s.getSkillKind(), new Status(equipflag, s.getSkillKind(), levelequipment));
            equipflag++;
            if (levelequipment >= 5) {
                levelequipment = 0;
            }
        }

        Map<Integer, Item> liquidmap = Items.getItemsMap();
        int levelLiquid = 0;
        for (Map.Entry<Integer, Item> entry : liquidmap.entrySet()) {
            levelLiquid++;
            if (entry.getKey() > 21) {
                break;
            }
            concurrentHashMap.put(entry.getValue().getItemName(), new Status(100 + entry.getValue().getItemNumber(), entry.getValue().getItemName(), levelLiquid));
            if (levelLiquid >= 3) {
                levelLiquid = 0;
            }
        }


        Map<Integer, Accessories> accessoriesMap = Items.getAccessoriesHashMap();
        for (Map.Entry<Integer, Accessories> entry : accessoriesMap.entrySet()) {
            concurrentHashMap.put(entry.getValue().getItemName(), new Status(entry.getKey(), entry.getValue().getIntroduce(), (entry.getKey() % 5 != 0 ? entry.getKey() % 5 : 5)));
        }
    }

    //检测编号是否重复
    public static void main(String[] args) {
        InitClass initClass = InitClass.getInstance();
        initClass.InitClass();
        List<Integer> list = new LinkedList<>();
        int count = 0;
        for (ConcurrentHashMap.Entry<String, Status> entry : concurrentHashMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
//            if (list.contains(entry.getValue().getStatusFlag())){
//                count++;
//            }
//                list.add(entry.getValue().getStatusFlag());
        }
        // System.out.println(count);
    }
}
