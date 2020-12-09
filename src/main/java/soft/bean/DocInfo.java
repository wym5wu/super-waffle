package soft.bean;

public class DocInfo {
    int id;
    String docTittle;//文档标题
    String adminName;//上传人
    int adminId;//上传人ID
    int dowNum;//下载积分
    String docState;//文档状态
    String updateTime;//上传时间
    String type;//类型
    public DocInfo() {
    }



    public DocInfo(int id, String docTittle, String adminName, int adminId, int dowNum, String docState, String updateTime, String type) {
        this.id = id;
        this.docTittle = docTittle;
        this.adminName = adminName;
        this.adminId = adminId;
        this.dowNum = dowNum;
        this.docState = docState;
        this.updateTime = updateTime;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocTittle() {
        return docTittle;
    }

    public void setDocTittle(String docTittle) {
        this.docTittle = docTittle;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getDowNum() {
        return dowNum;
    }

    public void setDowNum(int dowNum) {
        this.dowNum = dowNum;
    }

    public String getDocState() {
        return docState;
    }

    public void setDocState(String docState) {
        this.docState = docState;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "DocInfo{" +
                "id=" + id +
                ", docTittle='" + docTittle + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminId=" + adminId +
                ", dowNum=" + dowNum +
                ", docState='" + docState + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
