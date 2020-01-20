package KnightAndDragon.Bean.Items;

import KnightAndDragon.Bean.Addition.Status;

/**
 * 饰品
 */
public class Accessories extends Item {

    //饰品附加状态
    private Status status;

    public Accessories(Integer itemNumber, String itemName, String introduce, Status status,Integer gold) {
        this.itemNumber = itemNumber;
        this.itemName = itemName;
        this.introduce = introduce;
        this.status = status;
        this.gold=gold;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\t" + itemName + "\t" + introduce + "\n";
    }
}
