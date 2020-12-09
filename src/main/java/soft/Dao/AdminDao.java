package soft.Dao;

import soft.bean.Admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AdminDao {
    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    public Admin login(String account,String password);

    /**
     * 注册账号
     * @param admin
     * @return
     */
    public  int registerAdmin(Admin admin);

    /**
     * 查询所有信息
     * @param
     * @return
     */
    public List<Admin> findAdminInfo(HashMap<String, String> map, int curPage, int pageSize);

    public int totalPage(HashMap<String, String> map);

    public int updateState(int id,String state);
    public int deleteAdmin(int id);
}
