package soft.Service.Impl;

import soft.Dao.AdminDao;
import soft.Dao.Impl.AdminDaoImpl;
import soft.Service.RegisterService;
import soft.bean.Admin;

public class RegisterServiceImpl implements RegisterService {
    public  int registerAdmin(Admin admin){
        AdminDao adminDao = new AdminDaoImpl();
        return  adminDao.registerAdmin(admin);
    }

}
