package KnightAndDragon.Bean.Items;

import KnightAndDragon.Bean.Addition.Status;

public class Item {
    //物品编号
    protected Integer itemNumber;
    //物品名称
    protected String itemName;
    //物品介绍
    protected String introduce;
    //物品金额
    protected Integer gold;
    //物品使用状态
    protected Status status;
    //物品使用时间
    protected Integer time;

    public Item(){}

    public Item(Integer itemNumber, String itemName, String introduce,Integer gold) {
        this.itemNumber = itemNumber;
        this.itemName = itemName;
        this.introduce = introduce;
        this.gold=gold;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(Integer itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "物品名称："+itemName+",物品介绍:"+introduce;
    }
}
