package KnightAndDragon.Bean.Addition;

public class Materials {

    //材质名称
    private String materialsName;

    //材质编号
    private Integer materialsNumber;

    //材质硬度
    private Integer meterialsRigidity;

    //重量系数
    private Double meterialsWeight;

    public Materials(String materialsName, Integer materialsNumber, Integer meterialsRigidity,Double meterialsWeight) {
        this.materialsName = materialsName;
        this.materialsNumber = materialsNumber;
        this.meterialsRigidity = meterialsRigidity;
        this.meterialsWeight=meterialsWeight;
    }

    public String getMaterialsName() {
        return materialsName;
    }

    public void setMaterialsName(String materialsName) {
        this.materialsName = materialsName;
    }

    public Integer getMaterialsNumber() {
        return materialsNumber;
    }

    public Materials setMaterialsNumber(Integer materialsNumber) {
        this.materialsNumber = materialsNumber;
        return this;
    }

    public Integer getMeterialsRigidity() {
        return meterialsRigidity;
    }

    public Materials setMeterialsRigidity(Integer meterialsRigidity) {
        this.meterialsRigidity = meterialsRigidity;
        return this;
    }

    public Double getMeterialsWeight() {
        return meterialsWeight;
    }

    public Materials setMeterialsWeight(Double meterialsWeight) {
        this.meterialsWeight = meterialsWeight;
        return this;
    }

}
