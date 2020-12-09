package soft.Dao;

import org.apache.ibatis.session.RowBounds;
import soft.bean.Admin;
import soft.bean.DocInfo;

import java.util.HashMap;
import java.util.List;

public interface DocInfoDao {
    public List<DocInfo> findAll(HashMap<String, String> map,int curPage, int pageSize);
    public int totalPage(HashMap<String, String> map);
}
