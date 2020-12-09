package soft.Service.Impl;

import com.alibaba.fastjson.JSON;
import soft.Dao.AdminDao;
import soft.Dao.DocInfoDao;
import soft.Dao.Impl.AdminDaoImpl;
import soft.Service.DocInfoService;
import soft.Util.ObjectFactory;
import soft.bean.Admin;
import soft.bean.DocInfo;

import java.util.HashMap;
import java.util.List;

public class DocInfoServiceImpl implements DocInfoService {
    DocInfoDao docInfoDao =(DocInfoDao) ObjectFactory.newInstance("soft.Dao.Impl.DocInfoDaoImpl");
    @Override
    public String findByPage(HashMap<String, String> map, int curPage, int pageSize) {
        List<DocInfo> list = docInfoDao.findAll(map,curPage,pageSize);
        int a= docInfoDao.totalPage(map);
        HashMap<String,Object> map1 =new HashMap<>();
        map1.put("code",0);
        map1.put("msg","");
        map1.put("count",a);
        map1.put("data",list);
        return JSON.toJSONString(map1);
    }
}
