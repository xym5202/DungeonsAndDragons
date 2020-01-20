package KnightAndDragon.Bean.Items;


import KnightAndDragon.Bean.Addition.skill;

public class Book extends Item implements CanUse {

    private skill skills;

    public Book(Integer itemNumber, String itemName, String introduce, Integer gold,skill skills) {
        this.skills=skills;
        this.itemName=itemName;
        this.itemNumber=itemNumber;
        this.introduce=introduce;
        this.gold=gold;
    }

    public skill getSkills() {
        return skills;
    }

    public Book setSkills(skill skills) {
        this.skills = skills;
        return this;
    }

    @Override
    public String toString() {
        return "书名：'" + itemName +
                ",介绍：'" + introduce  +
                ",售卖金额" + gold ;
    }
}
