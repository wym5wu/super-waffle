package soft.Service;

import java.util.HashMap;

public interface DocInfoService {
    public String findByPage(HashMap<String, String> map, int curPage, int pageSize);
}
