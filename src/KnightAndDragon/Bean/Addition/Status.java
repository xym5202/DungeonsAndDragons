package KnightAndDragon.Bean.Addition;

public class Status {

    //状态编号
    private int statusFlag;

    //状态名称
    private String statusName;

    //状态等级
    private Integer statusLevel;

    public Status(int statusFlag, String statusName, Integer statusLevel) {
        this.statusFlag = statusFlag;
        this.statusName = statusName;
        this.statusLevel = statusLevel;
    }

    public int getStatusFlag() {
        return statusFlag;
    }

    public void setStatusFlag(int statusFlag) {
        this.statusFlag = statusFlag;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public Integer getStatusLevel() {
        return statusLevel;
    }

    public void setStatusLevel(Integer statusLevel) {
        this.statusLevel = statusLevel;
    }

    @Override
    public String toString() {
        return "状态编号：" + statusFlag +
                "，状态名称" + statusName +
                "，状态等级" + statusLevel;
    }
}
