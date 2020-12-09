package soft.Service.Impl;

import soft.Dao.AdminDao;
import soft.Dao.Impl.AdminDaoImpl;
import soft.Service.LoginSevice;
import soft.bean.Admin;

public class LoginSeviceImpl implements LoginSevice {

    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    @Override
    public Admin login(String account, String password) {
        AdminDao adminDao =new AdminDaoImpl();
        return adminDao.login(account,password);
    }
}
