package soft.Dao.Impl;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import soft.Dao.DocInfoDao;
import soft.Util.MyBatisUtil;
import soft.bean.Admin;
import soft.bean.DocInfo;
import soft.mapper.AdminMapper;
import soft.mapper.DocInfoMapper;

import java.util.HashMap;
import java.util.List;

public class DocInfoDaoImpl implements DocInfoDao {
    @Override
    public List<DocInfo> findAll(HashMap<String, String> map, int curPage, int pageSize) {
        SqlSession session= MyBatisUtil.getInstance().getSqlSession();
        DocInfoMapper docInfoMapper = session.getMapper(DocInfoMapper.class);
        RowBounds rowBounds = new RowBounds(curPage,pageSize);
        List<DocInfo> list= docInfoMapper.findAll(map,rowBounds);
        MyBatisUtil.close();
        return list;
    }

    @Override
    public int totalPage(HashMap<String, String> map) {
        SqlSession session= MyBatisUtil.getInstance().getSqlSession();
        DocInfoMapper docInfoMapper = session.getMapper(DocInfoMapper.class);
        int a= docInfoMapper.totalPage(map);
        MyBatisUtil.close();
        return a;
    }
}
