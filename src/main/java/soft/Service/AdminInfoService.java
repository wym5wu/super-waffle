package soft.Service;

import java.util.HashMap;

public interface AdminInfoService {
    public String findByPage(HashMap<String, String> map, int curPage, int pageSize);

    public int updateState(int id,String state);
    public int deleteAdmin(int id);
}
