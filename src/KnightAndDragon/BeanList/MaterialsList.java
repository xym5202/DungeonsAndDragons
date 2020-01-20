package KnightAndDragon.BeanList;

import KnightAndDragon.Bean.Addition.Materials;

import java.util.ArrayList;
import java.util.List;

public class MaterialsList {

    private static  MaterialsList materialsList;

    static {
        materials=new ArrayList<>();
        greateMaterials=new ArrayList<>();
        materialsList=new MaterialsList();
    }

    //普通材质队列
    private static List<Materials> materials;

    //稀有材质队列
    private static List<Materials> greateMaterials;

    public static List<Materials> getMaterials() {
        return materials;
    }

    public static void setMaterials(List<Materials> materials) {
        MaterialsList.materials = materials;
    }

    public static List<Materials> getGreateMaterials() {
        return greateMaterials;
    }

    public static void setGreateMaterials(List<Materials> greateMaterials) {
        MaterialsList.greateMaterials = greateMaterials;
    }

    private MaterialsList(){}

    public static MaterialsList getInstance(){
        return  materialsList;
    }

    public  void Initmaterials(){
        synchronized (Object.class) {
            materials.add(new Materials("木", 1, 1, 1.0));
            materials.add(new Materials("石", 2, 2, 2.0));
            materials.add(new Materials("铁", 3, 3, 3.0));
            materials.add(new Materials("银", 4, 4, 2.0));
            materials.add(new Materials("金", 5, 4, 2.5));
            greateMaterials.add(new Materials("黑金", 1001, 5, 3.5));
            greateMaterials.add(new Materials("轻丝木", 1002, 5, 0.75));
        }
    }
}
