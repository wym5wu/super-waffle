package soft.mapper;

import org.apache.ibatis.session.RowBounds;
import soft.bean.Admin;
import soft.bean.DocInfo;

import java.util.HashMap;
import java.util.List;

public interface DocInfoMapper {
    public List<DocInfo> findAll(HashMap<String, String> map, RowBounds rowBounds);
    public int totalPage(HashMap<String, String> map);
}
