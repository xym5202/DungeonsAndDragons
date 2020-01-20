package KnightAndDragon.Bean.Addition;

public class skill {

    //技能名称
    private  String skillKind;

    //技能状态 true为可以释放，false为禁用
    private boolean skillStatus;

    //持续时间
    private int time;

    //技能附加的状态
    private Status status;

    //蓝耗
    private int reduceMana;

    //消耗的技能点
    private int needPoint;

    public skill(String skillKind, boolean skillStatus, int time, Status status, int reduceMana, int needPoint) {
        this.skillKind = skillKind;
        this.skillStatus = skillStatus;
        this.time = time;
        this.status = status;
        this.reduceMana = reduceMana;
        this.needPoint=needPoint;
    }

    public String getSkillKind() {
        return skillKind;
    }

    public void setSkillKind(String skillKind) {
        this.skillKind = skillKind;
    }

    public boolean isSkillStatus() {
        return skillStatus;
    }

    public void setSkillStatus(boolean skillStatus) {
        this.skillStatus = skillStatus;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getReduceMana() {
        return reduceMana;
    }

    public void setReduceMana(int reduceMana) {
        this.reduceMana = reduceMana;
    }

    public int getNeedPoint() {
        return needPoint;
    }

    public void setNeedPoint(int needPoint) {
        this.needPoint = needPoint;
    }

    @Override
    public String toString() {
        return
                "技能名称：" + skillKind +
                "\t持续时间：" + time +
                "\t耗蓝：" + reduceMana ;
    }
}
