package KnightAndDragon.BeanList;

import KnightAndDragon.Bean.Addition.Materials;
import KnightAndDragon.Bean.Equipment.shield;
import KnightAndDragon.util.RandomGetDouble;

/**
 * 武器栏
 */
public class shieldFactory {

    //静态工厂，生产盾牌
    public static shield createShieldEquipmentFactory() {

        double d = RandomGetDouble.randomDecimals();
        shield shield =new shield();
        shield.setGold(6);
        shield.setShieldKind("盾牌");
        return   shieldFactory.createShieldEquipment(shield);

    }

    public static shield createShieldEquipment(shield shields){

        Materials m= MaterialsList.getMaterials().get(RandomGetDouble.getList(MaterialsList.getMaterials()));
        shields.setShieldHarm(m.getMeterialsRigidity());
        shields.setShieldMagicHarm(m.getMeterialsRigidity());
        shields.setShieldDurability(RandomGetDouble.getDoubleTwo());
        shields.setAffectAction(1-m.getMeterialsWeight()*0.1);
        shields.setShieldMaterials(m);
        shields.setItemNumber(300);
        return shields;
    }



}
