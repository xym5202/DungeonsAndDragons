package KnightAndDragon.Bean.Items;

import KnightAndDragon.Bean.Addition.Status;

public class Liquid extends Item implements CanUse {

    //介绍
    private String introduce;

    //金额
    private Integer gold;

    public Liquid(Integer itemNumber, String itemName, Status status, Integer time,String introduce,Integer gold) {
        this.itemNumber=itemNumber;
        this.itemName=itemName;
        this.status = status;
        this.time=time;
        this.introduce=introduce;
        this.gold=gold;
    }

    @Override
    public Integer getItemNumber() {
        return itemNumber;
    }
    @Override
    public void setItemNumber(Integer itemNumber) {
        this.itemNumber = itemNumber;
    }

    @Override
    public String getItemName() {
        return itemName;
    }

    @Override
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public String getIntroduce() {
        return introduce;
    }

    @Override
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Override
    public Integer getGold() {
        return gold;
    }

    @Override
    public void setGold(Integer gold) {
        this.gold = gold;
    }

    @Override
    public String toString() {
        return  itemName+"（介绍："+introduce+",持续时间："+time+"）";
    }
}
