package soft.Service.Impl;

import com.alibaba.fastjson.JSON;
import soft.Dao.AdminDao;
import soft.Dao.Impl.AdminDaoImpl;
import soft.Service.AdminInfoService;
import soft.Util.ObjectFactory;
import soft.bean.Admin;

import java.util.HashMap;
import java.util.List;

public class AdminInfoServiceImpl implements AdminInfoService {
AdminDao adminDao =(AdminDao) ObjectFactory.newInstance("soft.Dao.Impl.AdminDaoImpl");
    @Override
    public String findByPage(HashMap<String, String> map, int curPage, int pageSize) {
        AdminDao adminDao = new AdminDaoImpl();
       List<Admin> list = adminDao.findAdminInfo(map,curPage,pageSize);
       int a= adminDao.totalPage(map);
        HashMap<String,Object> map1 =new HashMap<>();
        map1.put("code",0);
        map1.put("msg","");
        map1.put("count",a);
        map1.put("data",list);
        return JSON.toJSONString(map1);
    }

    @Override
    public int updateState(int id, String state) {
        return adminDao.updateState(id,state);
    }

    @Override
    public int deleteAdmin(int id) {
        return adminDao.deleteAdmin(id);
    }
}
