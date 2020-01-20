package KnightAndDragon.Bean.Items;

import KnightAndDragon.BeanList.Items;
import KnightAndDragon.Effect.AccessoriesEffect;
import KnightAndDragon.util.RandomGetDouble;
import KnightAndDragon.util.TimeSleep;

import java.util.ArrayList;
import java.util.List;

//饰品包
public class AccessoriesBackPack {

    private static AccessoriesBackPack accessoriesBackPack;

    static{
        accessoriesBackPack=new AccessoriesBackPack();
    }

    //容量
    private  Integer capacity=10;

    //拥有的饰品
    private static List<Accessories> AccessoriesList=new ArrayList<>();

    private AccessoriesBackPack(){}

    public static AccessoriesBackPack getInstance(){
        return accessoriesBackPack;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public static List<Accessories> getAccessoriesList() {
        return AccessoriesList;
    }

    public static void setAccessoriesList(List<Accessories> accessoriesList) {
        AccessoriesList = accessoriesList;
    }

    //得到饰品
    public void putAccessories(Accessories accessories){
        if (AccessoriesList.size()>=capacity){
            System.out.println("饰品容量不足");
            return;
        }else {
            AccessoriesList.add(accessories);
            AccessoriesEffect.getInstance().giveKinghtStatus(accessories.getItemNumber(),accessories.getStatus(),true);
            System.out.println("装备"+accessories.getItemName());
        }
    }

    //丢弃饰品
    public void dropAccessories(Integer num){
        Accessories accessories=AccessoriesList.get(num);
        AccessoriesEffect.getInstance().giveKinghtStatus(accessories.getItemNumber(),accessories.getStatus(),false);
        AccessoriesList.remove(accessories);
        TimeSleep.timeSleep(500);
        System.out.println(accessories.getItemName()+"已丢弃");
    }

    //扩容背包
    public void dilatationABP(){
        accessoriesBackPack.setCapacity(accessoriesBackPack.getCapacity()+5);
    }

    //查看饰品
    public void openAccessoriesBackPack(){
        StringBuffer sb=new StringBuffer();
        int count=0;
        for (Accessories accessories:AccessoriesList) {
            sb.append(count+"、"+accessories.toString());
            count++;
        }
        String str=String.valueOf(sb);
        System.out.println(str);
    }

    public static void main(String[] args) {
        AccessoriesBackPack accessoriesBackPack=AccessoriesBackPack.getInstance();
        accessoriesBackPack.putAccessories(Items.getAccessoriesHashMap().get(2000+RandomGetDouble.getInteger(Items.getAccessoriesHashMap().size())));
        accessoriesBackPack.openAccessoriesBackPack();
    }
}
