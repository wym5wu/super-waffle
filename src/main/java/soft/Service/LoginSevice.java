package soft.Service;

import soft.bean.Admin;

public interface LoginSevice {
    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    public Admin login(String account, String password);
}
