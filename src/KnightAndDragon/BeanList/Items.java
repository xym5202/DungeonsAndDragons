package KnightAndDragon.BeanList;

import KnightAndDragon.Bean.Addition.Status;
import KnightAndDragon.Bean.Items.*;
import KnightAndDragon.Effect.ItemEffect;

import java.util.HashMap;

//物品大全
public class Items {

    static{
        map=new HashMap<>();
        Nomap=new HashMap<>();
        BossMap=new HashMap<>();
        issueMap=new HashMap<>();
        items=new Items();
    }

    //掉落map
    private static HashMap<Integer,Item> map;

    //不掉落map
    private static HashMap<Integer,Item> Nomap;

    //任务物品
    private static HashMap<Integer,Item> issueMap;

    //饰品
    private static HashMap<Integer,Accessories> accessoriesHashMap;

    //Boss掉落
    private static HashMap<Integer,Item> BossMap;

    private static Items items;

    protected Items(){
    }

    public static Items getInstance(){
        return items;
    }

    public void InitMap(){
        synchronized (Object.class) {
            this.initMap();
            this.InitNomap();
            this.InitAccessoriesHashMap();
            this.InitBossHashMap();
            this.InitIssueHashMap();
        }
    }

    //药水范围1-21，物品范围21-299，300-400为武器范围，1001+为合成物品使用范围，2001+为饰品,3000+为boss掉落稀有物品/合成材料,4000+为任务物品
    private  void initMap(){
        Status status=StatusList.getConcurrentHashMap().get("恢复药水1级");
        map.put(1,new Liquid(1,"恢复药水1级", StatusList.getConcurrentHashMap().get("恢复药水1级"),5,"每秒恢复2点生命",1));
        map.put(2,new  Liquid(2,"恢复药水2级",StatusList.getConcurrentHashMap().get("恢复药水2级"),5,"每秒恢复4点生命",2));
        map.put(3,new Liquid(3,"恢复药水3级",StatusList.getConcurrentHashMap().get("恢复药水3级"),5,"每秒恢复6点生命",3));
        map.put(4,new Liquid(4,"恢复药水4级",StatusList.getConcurrentHashMap().get("恢复4级"),5,"每秒恢复8点生命",4));
        map.put(5,new Liquid(5,"恢复药水5级",StatusList.getConcurrentHashMap().get("恢复5级"),5,"每秒恢复10点生命",5));
        map.put(6,new Liquid(6,"治疗药水",StatusList.getConcurrentHashMap().get("治疗药水"),0,"整体回复20点血量",2));
        map.put(7,new Liquid(7,"治愈药水",StatusList.getConcurrentHashMap().get("治愈药水"),0,"整体回复30点血量",4));
        map.put(8,new Liquid(8,"大治愈药水",StatusList.getConcurrentHashMap().get("大治愈药水"),0,"整体回复40点血量",6));
        map.put(9,new Liquid(9,"康复药水",StatusList.getConcurrentHashMap().get("康复"),0,"完全回复",10));
        map.put(10,new Liquid(10,"力量药水1级",StatusList.getConcurrentHashMap().get("力量药水1级"),20,"增加20点力量",3));
        map.put(11,new Liquid(11,"力量药水2级",StatusList.getConcurrentHashMap().get("力量药水2级"),20,"增加40点力量",5));
        map.put(12,new Liquid(12,"力量药水3级",StatusList.getConcurrentHashMap().get("力量药水3级"),20,"增加60点力量",7));
        map.put(13,new Liquid(13,"精神药水1级",StatusList.getConcurrentHashMap().get("精神药水1级"),0,"回复30点法力值",3));
        map.put(14,new Liquid(14,"精神药水2级",StatusList.getConcurrentHashMap().get("精神药水2级"),0,"回复60点法力值",4));
        map.put(15,new Liquid(15,"精神药水3级",StatusList.getConcurrentHashMap().get("精神药水3级"),0,"回复90点法力值",5));
        map.put(16,new Liquid(16,"魔力药水1级",StatusList.getConcurrentHashMap().get("魔力药水1级"),20,"增加10点智力",3));
        map.put(17,new Liquid(17,"魔力药水2级",StatusList.getConcurrentHashMap().get("魔力药水2级"),20,"增加20点智力",5));
        map.put(18,new Liquid(18,"魔力药水3级",StatusList.getConcurrentHashMap().get("魔力药水3级"),20,"增加30点智力",7));
        map.put(19,new Liquid(19,"敏捷药水1级",StatusList.getConcurrentHashMap().get("敏捷药水1级"),20,"增加10点敏捷",3));
        map.put(20,new Liquid(20,"敏捷药水2级",StatusList.getConcurrentHashMap().get("敏捷药水2级"),20,"增加20点敏捷",5));
        map.put(21,new Liquid(21,"敏捷药水3级",StatusList.getConcurrentHashMap().get("敏捷药水3级"),20,"增加30点敏捷",7));
        map.put(22,new Item(22,"木头","合成木质装备的材料",1));
        map.put(23,new Item(23,"石块","合成石质装备的材料",2));
        map.put(24,new Item(24,"铁锭","合成铁质装备的材料",3));
        map.put(25,new Item(25,"银锭","合成银质装备的材料",4));
        map.put(26,new Item(26,"金锭","合成金质装备的材料",5));
        map.put(27,new Item(27,"黑金剑柄","合成黑金剑的材料",5));
        map.put(28,new Item(28,"黑金剑托","合成黑金剑的材料",5));
        map.put(29,new Item(29,"黑金剑身","合成黑金剑的材料",5));
        map.put(30,new Item(30,"迅捷木","合成迅捷弓的材料",4));
        map.put(31,new Item(31,"疾速丝线","合成迅捷弓的材料",4));
        map.put(32,new Item(32,"轻羽","合成迅捷弓的材料",4));
        map.put(33,new Item(33,"剑柄","合成剑的必备材料",3));
        map.put(34,new Item(34,"刀柄","合成刀的必备材料",3));
        map.put(35,new Item(35,"头盔图纸","合成头盔的必备材料",3));
        map.put(36,new Item(36,"盔甲图纸","合成盔甲的必备材料",3));
        map.put(37,new Item(37,"左臂图纸","合成左臂的必备材料",3));
        map.put(38,new Item(38,"右臂图纸","合成右臂的必备材料",3));
        map.put(39,new Item(39,"左腿图纸","合成左腿的必备材料",3));
        map.put(40,new Item(40,"右腿图纸","合成右腿的必备材料",3));
        map.put(41,new Book(41,"力量1级附魔书","给武器附魔力量1级",1, SkillList.getEquipmentSkillLists().get(0)));
        map.put(42,new Book(42,"力量2级附魔书","给武器附魔力量2级",2,SkillList.getEquipmentSkillLists().get(1)));
        map.put(43,new Book(43,"力量3级附魔书","给武器附魔力量3级",4,SkillList.getEquipmentSkillLists().get(2)));
        map.put(44,new Book(44,"力量4级附魔书","给武器附魔力量4级",8,SkillList.getEquipmentSkillLists().get(3)));
        map.put(45,new Book(45,"力量5级附魔书","给武器附魔力量5级",16,SkillList.getEquipmentSkillLists().get(4)));
        map.put(46,new Book(46,"智力1级附魔书","给武器附魔智力1级",1, SkillList.getEquipmentSkillLists().get(5)));
        map.put(47,new Book(47,"智力2级附魔书","给武器附魔智力2级",2, SkillList.getEquipmentSkillLists().get(6)));
        map.put(48,new Book(48,"智力3级附魔书","给武器附魔智力3级",4, SkillList.getEquipmentSkillLists().get(7)));
        map.put(49,new Book(49,"智力4级附魔书","给武器附魔智力4级",8, SkillList.getEquipmentSkillLists().get(8)));
        map.put(50,new Book(50,"智力5级附魔书","给武器附魔智力5级",16, SkillList.getEquipmentSkillLists().get(9)));
        map.put(51,new Item(51,"碎布","3个碎布合成布,2个碎布合成迷彩布",1));
        map.put(52,new Item(52,"布","3个布合成背包扩容器",3));
        map.put(53,new Item(53,"迷彩布","2个迷彩布合成装备包扩容器",4));;
        map.put(54,new Item(54,"磨刀石碎片","2个磨刀石碎片合成磨刀石",3));;
        map.put(55,new Item(55,"力量碎片","5个力量碎片合成力量之心",6));
        map.put(56,new Item(56,"智力碎片","5个智力碎片合成智力之心",6));
        map.put(57,new Item(57,"敏捷碎片","5个敏捷碎片合成敏捷之心",6));
        map.put(58,new Item(58,"生命碎片","5个生命碎片合成生命之心",6));
        map.put(59,new Item(59,"攻速碎片","5个攻速碎片合成攻速之心",6));
    }

    private  void InitNomap(){
        Nomap.put(1001,new UseItem(1001,"背包扩容器","扩容背包5格",5,new ItemEffect(1,"背包扩容")));
        Nomap.put(1002,new UseItem(1002,"装备包扩容器","扩容装备包2格",5,new ItemEffect(2,"装备包扩容")));
        Nomap.put(1003,new UseItem(1003,"磨刀石","打磨器,装备耐久度增加20点",2,new ItemEffect(3,"修复装备")));
        Nomap.put(1004,new UseItem(1004,"力量之心","永久增加1点力量",50,new ItemEffect(4,"永久增加1点力量")));
        Nomap.put(1005,new UseItem(1005,"智力之心","永久增加1点智力",50,new ItemEffect(5,"永久增加1点智力")));
        Nomap.put(1006,new UseItem(1006,"敏捷之心","永久增加1点敏捷",50,new ItemEffect(6,"永久增加1点敏捷")));
        Nomap.put(1007,new UseItem(1007,"生命之心","永久增加10点生命",50,new ItemEffect(7,"永久增加10点生命")));
        Nomap.put(1008,new UseItem(1008,"攻速之心","永久增加10%攻速",50,new ItemEffect(8,"永久增加10%攻速")));
        Nomap.put(1009,new UseItem(1009,"饰品包扩容器","扩容饰品包5格",5,new ItemEffect(9,"饰品包扩容")));
    }

    private  void InitAccessoriesHashMap(){
        accessoriesHashMap=new HashMap<>();
        //增加智力
        accessoriesHashMap.put(2001,new Accessories(2001,"蓝宝石戒指","增加3点智力",StatusList.getConcurrentHashMap().get("蓝宝石戒指"),20));
        accessoriesHashMap.put(2002,new Accessories(2002,"蓝宝石项链","增加6点智力",StatusList.getConcurrentHashMap().get("蓝宝石项链"),40));
        accessoriesHashMap.put(2003,new Accessories(2003,"蓝宝石手镯","增加9点智力",StatusList.getConcurrentHashMap().get("蓝宝石手镯"),60));
        accessoriesHashMap.put(2004,new Accessories(2004,"蓝宝石饰品","增加12点智力",StatusList.getConcurrentHashMap().get("蓝宝石饰品"),80));
        accessoriesHashMap.put(2005,new Accessories(2005,"蓝宝石","增加15点智力",StatusList.getConcurrentHashMap().get("蓝宝石"),100));
        //减少智力
        accessoriesHashMap.put(2006,new Accessories(2006,"黑曜石戒指","减少2点智力",StatusList.getConcurrentHashMap().get("黑曜石戒指"),20));
        accessoriesHashMap.put(2007,new Accessories(2007,"黑曜石项链","减少4点智力",StatusList.getConcurrentHashMap().get("黑曜石项链"),40));
        accessoriesHashMap.put(2008,new Accessories(2008,"黑曜石手镯","减少6点智力",StatusList.getConcurrentHashMap().get("黑曜石手镯"),60));
        accessoriesHashMap.put(2009,new Accessories(2009,"黑曜石饰品","减少8点智力",StatusList.getConcurrentHashMap().get("黑曜石饰品"),80));
        accessoriesHashMap.put(2010,new Accessories(2010,"黑曜石","减少10点智力",StatusList.getConcurrentHashMap().get("黑曜石"),100));
        //增加力量
        accessoriesHashMap.put(2011,new Accessories(2011,"红宝石戒指","增加3点力量",StatusList.getConcurrentHashMap().get("红宝石戒指"),20));
        accessoriesHashMap.put(2012,new Accessories(2012,"红宝石项链","增加6点力量",StatusList.getConcurrentHashMap().get("红宝石项链"),40));
        accessoriesHashMap.put(2013,new Accessories(2013,"红宝石手镯","增加9点力量",StatusList.getConcurrentHashMap().get("红宝石手镯"),60));
        accessoriesHashMap.put(2014,new Accessories(2014,"红宝石饰品","增加12点力量",StatusList.getConcurrentHashMap().get("红宝石饰品"),80));
        accessoriesHashMap.put(2015,new Accessories(2015,"红宝石","增加15点力量",StatusList.getConcurrentHashMap().get("红宝石"),100));
        //减少力量
        accessoriesHashMap.put(2016,new Accessories(2016,"虚空石戒指","减少2点力量",StatusList.getConcurrentHashMap().get("虚空石戒指"),20));
        accessoriesHashMap.put(2017,new Accessories(2017,"虚空石项链","减少4点力量",StatusList.getConcurrentHashMap().get("虚空石项链"),40));
        accessoriesHashMap.put(2018,new Accessories(2018,"虚空石手镯","减少6点力量",StatusList.getConcurrentHashMap().get("虚空石手镯"),60));
        accessoriesHashMap.put(2019,new Accessories(2019,"虚空石饰品","减少8点力量",StatusList.getConcurrentHashMap().get("虚空石饰品"),80));
        accessoriesHashMap.put(2020,new Accessories(2020,"虚空石","减少10点力量",StatusList.getConcurrentHashMap().get("虚空石"),100));
        //增加敏捷
        accessoriesHashMap.put(2021,new Accessories(2021,"绿宝石戒指","增加3点敏捷",StatusList.getConcurrentHashMap().get("绿宝石戒指"),20));
        accessoriesHashMap.put(2022,new Accessories(2022,"绿宝石项链","增加6点敏捷",StatusList.getConcurrentHashMap().get("绿宝石项链"),40));
        accessoriesHashMap.put(2023,new Accessories(2023,"绿宝石手镯","增加9点敏捷",StatusList.getConcurrentHashMap().get("绿宝石手镯"),60));
        accessoriesHashMap.put(2024,new Accessories(2024,"绿宝石饰品","增加12点敏捷",StatusList.getConcurrentHashMap().get("绿宝石饰品"),80));
        accessoriesHashMap.put(2025,new Accessories(2025,"绿宝石","增加15点敏捷",StatusList.getConcurrentHashMap().get("绿宝石"),100));
        //减少敏捷
        accessoriesHashMap.put(2026,new Accessories(2026,"重力石戒指","减少2点敏捷",StatusList.getConcurrentHashMap().get("重力石戒指"),20));
        accessoriesHashMap.put(2027,new Accessories(2027,"重力石项链","减少4点敏捷",StatusList.getConcurrentHashMap().get("重力石项链"),40));
        accessoriesHashMap.put(2028,new Accessories(2028,"重力石手镯","减少6点敏捷",StatusList.getConcurrentHashMap().get("重力石手镯"),60));
        accessoriesHashMap.put(2029,new Accessories(2029,"重力石饰品","减少8点敏捷",StatusList.getConcurrentHashMap().get("重力石饰品"),80));
        accessoriesHashMap.put(2030,new Accessories(2030,"重力石","减少10点敏捷",StatusList.getConcurrentHashMap().get("重力石"),100));
        //增加攻速
        accessoriesHashMap.put(2031,new Accessories(2031,"急速手套","增加10%攻速",StatusList.getConcurrentHashMap().get("急速手套"),20));
        accessoriesHashMap.put(2032,new Accessories(2032,"哥布林之号","增加20%攻速",StatusList.getConcurrentHashMap().get("哥布林之号"),40));
        accessoriesHashMap.put(2033,new Accessories(2033,"风脂","增加30%攻速",StatusList.getConcurrentHashMap().get("风脂"),60));
        accessoriesHashMap.put(2034,new Accessories(2034,"矮人披风","增加40%攻速",StatusList.getConcurrentHashMap().get("矮人披风"),80));
        accessoriesHashMap.put(2035,new Accessories(2035,"轻灵围巾","增加50%攻速",StatusList.getConcurrentHashMap().get("轻灵围巾"),100));
        //减少攻速
        accessoriesHashMap.put(2036,new Accessories(2036,"重木戒指","减少8%攻速",StatusList.getConcurrentHashMap().get("重木戒指"),20));
        accessoriesHashMap.put(2037,new Accessories(2037,"重木项链","减少16%攻速",StatusList.getConcurrentHashMap().get("重木项链"),40));
        accessoriesHashMap.put(2038,new Accessories(2038,"重木手镯","减少24%攻速",StatusList.getConcurrentHashMap().get("重木手镯"),60));
        accessoriesHashMap.put(2039,new Accessories(2039,"重木饰品","减少32%攻速",StatusList.getConcurrentHashMap().get("重木饰品"),80));
        accessoriesHashMap.put(2040,new Accessories(2040,"重木块","减少40%攻速",StatusList.getConcurrentHashMap().get("重木块"),100));
        //增加移速
        accessoriesHashMap.put(2041,new Accessories(2041,"矮人之靴","增加10%移速",StatusList.getConcurrentHashMap().get("矮人之靴"),20));
        accessoriesHashMap.put(2042,new Accessories(2042,"赏金猎人的筋腱","增加20%移速",StatusList.getConcurrentHashMap().get("赏金猎人的筋腱"),40));
        accessoriesHashMap.put(2043,new Accessories(2043,"游侠披风","增加30%移速",StatusList.getConcurrentHashMap().get("游侠披风"),60));
        accessoriesHashMap.put(2044,new Accessories(2044,"千里驹","增加40%移速",StatusList.getConcurrentHashMap().get("千里驹"),80));
        accessoriesHashMap.put(2045,new Accessories(2045,"轻灵之翼","增加50%移速",StatusList.getConcurrentHashMap().get("轻灵之翼"),100));
        //减少移速
        accessoriesHashMap.put(2046,new Accessories(2046,"哥布林的鞋子","减少8%移速",StatusList.getConcurrentHashMap().get("哥布林的鞋子"),20));
        accessoriesHashMap.put(2047,new Accessories(2047,"逃犯的脚链","减少16%移速",StatusList.getConcurrentHashMap().get("逃犯的脚链"),40));
        accessoriesHashMap.put(2048,new Accessories(2048,"蜘蛛丝线","减少24%移速",StatusList.getConcurrentHashMap().get("蜘蛛丝线"),60));
        accessoriesHashMap.put(2049,new Accessories(2049,"海盗的假肢","减少32%移速",StatusList.getConcurrentHashMap().get("海盗的假肢"),80));
        accessoriesHashMap.put(2050,new Accessories(2050,"笨重之翼","减少40%移速",StatusList.getConcurrentHashMap().get("笨重之翼"),100));
        //增加暴击
        accessoriesHashMap.put(2051,new Accessories(2051,"火龙的骨头","增加10%暴击",StatusList.getConcurrentHashMap().get("火龙的骨头"),20));
        accessoriesHashMap.put(2052,new Accessories(2052,"暴击宝石","增加20%暴击",StatusList.getConcurrentHashMap().get("暴击宝石"),40));
        accessoriesHashMap.put(2053,new Accessories(2053,"灵巧披风","增加30%暴击",StatusList.getConcurrentHashMap().get("灵巧披风"),60));
        accessoriesHashMap.put(2054,new Accessories(2054,"幽暗木","增加40%暴击",StatusList.getConcurrentHashMap().get("幽暗木"),80));
        accessoriesHashMap.put(2055,new Accessories(2055,"秘银弹弓","增加50%暴击",StatusList.getConcurrentHashMap().get("秘银弹弓"),100));
        //减少暴击
        accessoriesHashMap.put(2056,new Accessories(2056,"食人魔的舌头","减少8%暴击",StatusList.getConcurrentHashMap().get("食人魔的舌头"),20));
        accessoriesHashMap.put(2057,new Accessories(2057,"蜘蛛眼","减少16%暴击",StatusList.getConcurrentHashMap().get("蜘蛛眼"),40));
        accessoriesHashMap.put(2058,new Accessories(2058,"失败的化学试剂","减少24%暴击",StatusList.getConcurrentHashMap().get("失败的化学试剂"),60));
        accessoriesHashMap.put(2059,new Accessories(2059,"神秘的球","减少32%暴击",StatusList.getConcurrentHashMap().get("神秘的球"),80));
        accessoriesHashMap.put(2060,new Accessories(2060,"哥布林的牙齿","减少40%暴击",StatusList.getConcurrentHashMap().get("哥布林的牙齿"),100));
        //增加闪避
        accessoriesHashMap.put(2061,new Accessories(2061,"海妖的鳞片","增加5%闪避",StatusList.getConcurrentHashMap().get("海妖的鳞片"),20));
        accessoriesHashMap.put(2062,new Accessories(2062,"独角兽的尾巴","增加10%闪避",StatusList.getConcurrentHashMap().get("独角兽的尾巴"),40));
        accessoriesHashMap.put(2063,new Accessories(2063,"隐形斗篷","增加15%闪避",StatusList.getConcurrentHashMap().get("隐形斗篷"),60));
        accessoriesHashMap.put(2064,new Accessories(2064,"秘银靴","增加20%闪避",StatusList.getConcurrentHashMap().get("秘银靴"),80));
        accessoriesHashMap.put(2065,new Accessories(2065,"幻影之镜","增加25%闪避",StatusList.getConcurrentHashMap().get("幻影之镜"),100));
        //减少闪避
        accessoriesHashMap.put(2066,new Accessories(2066,"半兽人的脚趾","减少3%闪避",StatusList.getConcurrentHashMap().get("半兽人的脚趾"),20));
        accessoriesHashMap.put(2067,new Accessories(2067,"土蛟的鳞片","减少6%闪避",StatusList.getConcurrentHashMap().get("土蛟的鳞片"),40));
        accessoriesHashMap.put(2068,new Accessories(2068,"引力球","减少9%闪避",StatusList.getConcurrentHashMap().get("引力球"),60));
        accessoriesHashMap.put(2069,new Accessories(2069,"重力手套","减少12%闪避",StatusList.getConcurrentHashMap().get("重力手套"),80));
        accessoriesHashMap.put(2070,new Accessories(2070,"史莱姆的黏液","减少15%闪避",StatusList.getConcurrentHashMap().get("史莱姆的黏液"),100));
        //增加攻击力
        accessoriesHashMap.put(2071,new Accessories(2071,"岩浆蛟的毒牙","增加20%基础攻击力",StatusList.getConcurrentHashMap().get("岩浆蛟的毒牙"),20));
        accessoriesHashMap.put(2072,new Accessories(2072,"泰坦之戒","增加40%基础攻击力",StatusList.getConcurrentHashMap().get("泰坦之戒"),40));
        accessoriesHashMap.put(2073,new Accessories(2073,"精灵的匕首","增加60%基础攻击力",StatusList.getConcurrentHashMap().get("精灵的匕首"),60));
        accessoriesHashMap.put(2074,new Accessories(2074,"英雄剑的碎片","增加80%基础攻击力",StatusList.getConcurrentHashMap().get("英雄剑的碎片"),80));
        accessoriesHashMap.put(2075,new Accessories(2075,"神秘之刃","增加100%基础攻击力",StatusList.getConcurrentHashMap().get("神秘之刃"),100));
        //减少攻击力
        accessoriesHashMap.put(2076,new Accessories(2076,"独眼巨人之吼","减少10%基础攻击力",StatusList.getConcurrentHashMap().get("独眼巨人之吼"),20));
        accessoriesHashMap.put(2077,new Accessories(2077,"所罗门的秘境","减少20%基础攻击力",StatusList.getConcurrentHashMap().get("所罗门的秘境"),40));
        accessoriesHashMap.put(2078,new Accessories(2078,"食尸鬼的手指","减少30%基础攻击力",StatusList.getConcurrentHashMap().get("食尸鬼的手指"),60));
        accessoriesHashMap.put(2079,new Accessories(2079,"毒沼气","减少40%基础攻击力",StatusList.getConcurrentHashMap().get("毒沼气"),80));
        accessoriesHashMap.put(2080,new Accessories(2080,"流泪血石","减少50%基础攻击力",StatusList.getConcurrentHashMap().get("流泪血石"),100));
        //增加魔法攻击力
        accessoriesHashMap.put(2081,new Accessories(2081,"独角兽的犄角","增加20%基础魔法攻击力",StatusList.getConcurrentHashMap().get("独角兽的犄角"),20));
        accessoriesHashMap.put(2082,new Accessories(2082,"赏金猎人的指枪","增加40%基础魔法攻击力",StatusList.getConcurrentHashMap().get("赏金猎人的指枪"),40));
        accessoriesHashMap.put(2083,new Accessories(2083,"灵魂石","增加60%基础魔法攻击力",StatusList.getConcurrentHashMap().get("灵魂石"),60));
        accessoriesHashMap.put(2084,new Accessories(2084,"琉璃织木","增加80%基础魔法攻击力",StatusList.getConcurrentHashMap().get("琉璃织木"),80));
        accessoriesHashMap.put(2085,new Accessories(2085,"远古法师的遗物","增加100%基础魔法攻击力",StatusList.getConcurrentHashMap().get("远古法师的遗物"),100));
        //减少魔法攻击力
        accessoriesHashMap.put(2086,new Accessories(2086,"黑巫术之仗","减少10%基础魔法攻击力",StatusList.getConcurrentHashMap().get("黑巫术之仗"),20));
        accessoriesHashMap.put(2087,new Accessories(2087,"暗影宝石","减少20%基础魔法攻击力",StatusList.getConcurrentHashMap().get("暗影宝石"),40));
        accessoriesHashMap.put(2088,new Accessories(2088,"湮灭之光","减少30%基础魔法攻击力",StatusList.getConcurrentHashMap().get("湮灭之光"),60));
        accessoriesHashMap.put(2089,new Accessories(2089,"恐角梦魇","减少40%基础魔法攻击力",StatusList.getConcurrentHashMap().get("恐角梦魇"),80));
        accessoriesHashMap.put(2090,new Accessories(2090,"月海碧魔","减少50%基础魔法攻击力",StatusList.getConcurrentHashMap().get("月海碧魔"),100));
        //增加魔法值
        accessoriesHashMap.put(2091,new Accessories(2091,"小精灵的粉尘","增加20最大法力值",StatusList.getConcurrentHashMap().get("小精灵的粉尘"),20));
        accessoriesHashMap.put(2092,new Accessories(2092,"魔法球","增加40最大法力值",StatusList.getConcurrentHashMap().get("魔法球"),40));
        accessoriesHashMap.put(2093,new Accessories(2093,"蓝色妖姬","增加60最大法力值",StatusList.getConcurrentHashMap().get("蓝色妖姬"),60));
        accessoriesHashMap.put(2094,new Accessories(2094,"秩序之源","增加80最大法力值",StatusList.getConcurrentHashMap().get("秩序之源"),80));
        accessoriesHashMap.put(2095,new Accessories(2095,"凯旋之翼","增加100最大法力值",StatusList.getConcurrentHashMap().get("凯旋之翼"),100));
        //减少魔法值
        accessoriesHashMap.put(2096,new Accessories(2096,"玩具魔偶","减少15最大法力值",StatusList.getConcurrentHashMap().get("玩具魔偶"),20));
        accessoriesHashMap.put(2097,new Accessories(2097,"黑巫师的帽子","减少30最大法力值",StatusList.getConcurrentHashMap().get("黑巫师的帽子"),40));
        accessoriesHashMap.put(2098,new Accessories(2098,"暗影精灵的吊坠","减少45最大法力值",StatusList.getConcurrentHashMap().get("暗影精灵的吊坠"),60));
        accessoriesHashMap.put(2099,new Accessories(2099,"驱魔人之手","减少60最大法力值",StatusList.getConcurrentHashMap().get("驱魔人之手"),80));
        accessoriesHashMap.put(2100,new Accessories(2100,"恐怖魔偶","减少75最大法力值",StatusList.getConcurrentHashMap().get("恐怖魔偶"),100));
        //随机增加某个部位的血量
        accessoriesHashMap.put(2101,new Accessories(2101,"火狼之心","随机增加20最大生命值",StatusList.getConcurrentHashMap().get("火狼之心"),20));
        accessoriesHashMap.put(2102,new Accessories(2102,"火龙之心","随机增加40最大生命值",StatusList.getConcurrentHashMap().get("火龙之心"),40));
        accessoriesHashMap.put(2103,new Accessories(2103,"光明之泉","随机增加60最大生命值",StatusList.getConcurrentHashMap().get("光明之泉"),60));
        accessoriesHashMap.put(2104,new Accessories(2104,"精灵花","随机增加80最大生命值",StatusList.getConcurrentHashMap().get("精灵花"),80));
        accessoriesHashMap.put(2105,new Accessories(2105,"上帝之手","随机增加100最大生命值",StatusList.getConcurrentHashMap().get("上帝之手"),100));
        //随机减少某个部位的血量
        accessoriesHashMap.put(2106,new Accessories(2106,"毒狼之心","随机减少10最大生命值",StatusList.getConcurrentHashMap().get("毒狼之心"),20));
        accessoriesHashMap.put(2107,new Accessories(2107,"洞穴蜘蛛的毒液","随机减少20最大生命值",StatusList.getConcurrentHashMap().get("洞穴蜘蛛的毒液"),40));
        accessoriesHashMap.put(2108,new Accessories(2108,"恐狼怒吼","随机减少30最大生命值",StatusList.getConcurrentHashMap().get("恐狼怒吼"),60));
        accessoriesHashMap.put(2109,new Accessories(2109,"黑精灵的饰品","随机减少40最大生命值",StatusList.getConcurrentHashMap().get("黑精灵的饰品"),80));
        accessoriesHashMap.put(2110,new Accessories(2110,"假骨骼","随机减少50最大生命值",StatusList.getConcurrentHashMap().get("假骨骼"),100));
        //整体增加15点生命值，5点基础攻击力
        accessoriesHashMap.put(3000,new Accessories(3000,"哥布林王的王冠","整体增加15点最大生命值，增加5点基础攻击力",StatusList.getConcurrentHashMap().get("哥布林王的王冠"),100));
    }

    private  void InitBossHashMap(){
        BossMap.put(3001,new Item(3001,"哥布林的宝石","可以和哥布林的头环，哥布林的挂饰合成哥布林王冠（Boss）的材料",10));
        BossMap.put(3002,new Item(3002,"哥布林的头环","合成哥布林王冠（Boss）的材料",10));
        BossMap.put(3003,new Item(3003,"哥布林的挂饰","合成哥布林王冠（Boss）的材料",10));
        BossMap.put(3004,new Item(3004,"龙骨","合成龙翼(Boss)",10));
        BossMap.put(3005,new Item(3005,"龙筋","合成龙翼(Boss)",10));
        BossMap.put(3006,new Item(3006,"龙鳞","合成龙相关装备的基本元素",10));
    }

    public static HashMap<Integer, Item> getIssueMap() {
        return issueMap;
    }

    private void InitIssueHashMap(){
        issueMap.put(4001,new Item(4001,"哥布林的钥匙","打开哥布林地洞的大门钥匙",2));
    }

    public static  HashMap<Integer,Item> getItemsMap(){
        return map;
    }

    public static  HashMap<Integer,Item> getNomap(){
        return Nomap;
    }

    public static HashMap<Integer,Accessories> getAccessoriesHashMap(){return accessoriesHashMap;}

    public static HashMap<Integer, Item> getBossMap() {
        return BossMap;
    }
}
