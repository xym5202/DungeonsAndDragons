package KnightAndDragon.util;

import KnightAndDragon.Bean.Object.Boss;
import KnightAndDragon.BeanList.*;
import KnightAndDragon.action.Event;

public class InitClass {

    private  static InitClass initClass=new InitClass();

    private InitClass(){}

    public static InitClass getInstance(){
        return initClass;
    }

    public void InitClass(){
        Items items=Items.getInstance();
        MaterialsList materialsList=MaterialsList.getInstance();
        SkillList skillList=SkillList.getInstance();
        StatusList statusList=StatusList.getInstance();
        enemyList.init();
        Boss.InitBoss();
        materialsList.Initmaterials();
        skillList.InitSkillList();
        items.InitMap();
        statusList.InitialStatus();
        skillList.InitSkillList();
        items.InitMap();
        Event.InitEvent();
    }
}
