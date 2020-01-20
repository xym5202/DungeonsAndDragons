package KnightAndDragon;

import KnightAndDragon.action.Action;
import KnightAndDragon.util.InitClass;

public class GameStart {

    public static void main(String[] args) {
        InitClass initClass=InitClass.getInstance();
        initClass.InitClass();
        for (int i=1;i<=2;i++) {
            Action.setA(i);
            Action.start();
        }
    }


}
