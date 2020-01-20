package KnightAndDragon.Effect;

import KnightAndDragon.Bean.Object.Knight;

import java.lang.reflect.Method;

public class EquipmentEffect {

    private static EquipmentEffect equipmentEffect;

    static {
        equipmentEffect=new EquipmentEffect();
    }

    private EquipmentEffect(){}

    public static EquipmentEffect getInstance(){
        return equipmentEffect;
    }
    /**
     * 装备附魔，力量
     * 1001-1005
     * @param level
     */
    @Effect(startNum = "1001",endNum = "1005")
    public  void equipmentPower(int level,boolean flag) {
        Knight knight = Knight.getInstance();
        if (flag){
            knight.setPower(knight.getPower() + 5 * level);
        }else {
            knight.setPower(knight.getPower() - 5 * level);
        }
    }

    /**
     * 装备附魔，智力
     * 1006-1010
     * @param level
     */
    @Effect(startNum = "1006",endNum = "1010")
    public  void equipmentIntelligence(int level,boolean flag) {
        Knight knight = Knight.getInstance();
        if (flag){
            knight.setIntelligence(knight.getIntelligence() + 5 * level);
        }else {
            knight.setIntelligence(knight.getIntelligence() - 5 * level);
        }
    }




    public void equip(int a,int level,boolean flag){
        Class cla=EquipmentEffect.class;
        Method[] methods=cla.getMethods();
        for (Method method:methods){
            if (method.isAnnotationPresent(Effect.class)){
                Effect effect=method.getAnnotation(Effect.class);
                if(!((null==effect.startNum()||effect.startNum().equals(""))&&(null==effect.endNum()||effect.endNum().equals("")))){
                    Integer startNum=Integer.parseInt(effect.startNum());
                    Integer endNum=Integer.parseInt(effect.endNum());
                    if (a>=startNum&&a<=endNum){
                        try {
                            method.invoke(EquipmentEffect.getInstance(),level,flag);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }

}
