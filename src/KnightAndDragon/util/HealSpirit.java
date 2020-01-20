package KnightAndDragon.util;

import KnightAndDragon.Bean.Object.Knight;

public class HealSpirit implements Runnable{


    private static HealSpirit healSpirit;

    static {
        healSpirit=new HealSpirit();
    }

    private HealSpirit(){}

    public static HealSpirit getInstance(){return healSpirit;};

    private static Boolean flag=false;

    public static Boolean getFlag() {
        return flag;
    }

    public static void setFlag(Boolean flag) {
        HealSpirit.flag = flag;
    }

    /**
     * 自动回蓝,3s回复一点蓝量
     */
    public static void healSpirit(){
        while (flag){
            Knight knight = Knight.getInstance();
            knight.setMana(knight.getMana() + 1 <= Knight.getManaSum() ? knight.getMana() + 1 : Knight.getManaSum());
            TimeSleep.timeSleep(3000);
        }
    }

    @Override
    public void  run(){
        try {
            healSpirit();
        }catch (Exception e){
            System.out.println("蓝量自动恢复结束");
        }
    }

}
