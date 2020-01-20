package KnightAndDragon.Bean.Items;


import KnightAndDragon.Effect.Effect;
import KnightAndDragon.Effect.ItemEffect;

import java.lang.reflect.Method;

public class UseItem extends Item implements CanUse{

    //使用效果
    private ItemEffect effect;

    public UseItem(Integer itemNumber, String itemName, String introduce, Integer gold,ItemEffect effect) {
        this.gold=gold;
        this.itemName=itemName;
        this.itemNumber=itemNumber;
        this.introduce=introduce;
        this.effect=effect;
    }

    public ItemEffect getEffect() {
        return effect;
    }

    public UseItem setEffect(ItemEffect effect) {
        this.effect = effect;
        return this;
    }

    //使用物品效果
    public void useItem(ItemEffect itemEffect) {
        Integer effectNumber=itemEffect.getEffectNumber();
        Class cla = ItemEffect.class;
        Method[] methods = cla.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Effect.class)) {
                Effect effect = method.getAnnotation(Effect.class);
                if (null != effect.startNum() && !effect.startNum().equals("") && (null == effect.endNum() || effect.endNum().equals(""))) {
                    Integer staNum = Integer.parseInt(effect.startNum());
                    if (effectNumber.equals(staNum)) {
                        try {
                            method.invoke(itemEffect);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
