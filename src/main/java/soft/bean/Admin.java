package soft.bean;

import java.math.BigDecimal;
import java.util.List;

public class Admin {
    private BigDecimal id;
    String account;
    String password;
    String adminName;
    String sex;
    String email;
    String education;
    String phone;
    String updateTime;
    String state;
    String role;

    Menu menus;
    List<Menu> menuc;




    public Menu getMenus() {
        return menus;
    }

    public void setMenus(Menu menus) {
        this.menus = menus;
    }

    public List<Menu> getMenuc() {
        return menuc;
    }

    public void setMenuc(List<Menu> menuc) {
        this.menuc = menuc;
    }

    public Admin() {
    }

    public Admin(BigDecimal id, String account, String password, String adminName, String sex, String email, String education, String phone, String updateTime, String state, String role) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.adminName = adminName;
        this.sex = sex;
        this.email = email;
        this.education = education;
        this.phone = phone;
        this.updateTime = updateTime;
        this.state = state;
        this.role = role;
    }



    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", adminName='" + adminName + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", education='" + education + '\'' +
                ", phone='" + phone + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", state='" + state + '\'' +
                ", role='" + role + '\'' +
                ", menu=" + menus +
                '}';
    }
}
