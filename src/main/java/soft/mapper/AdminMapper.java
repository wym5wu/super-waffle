package soft.mapper;

import org.apache.ibatis.session.RowBounds;
import soft.bean.Admin;

import java.util.HashMap;
import java.util.List;

public interface AdminMapper {
    public int addAdmin(Admin admin);
//    public int deleteAdmin(Admin admin);
    public int updateAdmin(Admin admin);
    public Admin login(String account,String password);
    public List<Admin>findAll(HashMap<String, String> map, RowBounds rowBounds);

    public int totalPage(HashMap<String, String> map);
//    public List<Admin> totalPage1(List list);

    public int updateState(int id,String state);
    public int deleteAdmin(int id);
}
