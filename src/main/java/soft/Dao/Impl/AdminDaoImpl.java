package soft.Dao.Impl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import soft.Dao.AdminDao;
import soft.Util.MyBatisUtil;
import soft.bean.Admin;
import soft.mapper.AdminMapper;
import sun.misc.Resource;

import java.io.IOException;
import java.io.Reader;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminDaoImpl implements AdminDao {
//    public static void main(String[] args) {
//        try {
//            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//            SqlSession session = sqlSessionFactory.openSession(false);//打开事务，取消自动提交
//            AdminMapper adminMapper= session.getMapper(AdminMapper.class);
//            Admin admin = new Admin();
//            admin.setAdminName("猪");
//            admin.setPassword("22");
//            admin.setAccount("2");
//            adminMapper.deleteAdmin(admin);
//            session.commit();
//            session.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public void init(){
//        //把配置文件读到IO流
//        try {
//            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//            SqlSession session = sqlSessionFactory.openSession(false);//打开事务，取消自动提交
//            AdminMapper adminMapper= session.getMapper(AdminMapper.class);
//            /**************/
//            Admin admin = new Admin();
//            admin.setAdminName("猪");
//            adminMapper.addAdmin(admin);
//            /**************/
//            session.commit();
//            session.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    @Override
    public Admin login(String account, String password) {
        SqlSession session= MyBatisUtil.getInstance().getSqlSession();
        AdminMapper adminMapper = session.getMapper(AdminMapper.class);
        Admin admin= adminMapper.login(account,password);
        System.out.println(account);
        MyBatisUtil.close();
        return admin;
    }
    public  int registerAdmin(Admin admin){
        SqlSession session= MyBatisUtil.getInstance().getSqlSession();
        AdminMapper adminMapper = session.getMapper(AdminMapper.class);
        int a= adminMapper.addAdmin(admin);
        MyBatisUtil.close();
        return a;
    }

    @Override
    public List<Admin> findAdminInfo(HashMap<String, String> map, int curPage, int pageSize) {
        SqlSession session= MyBatisUtil.getInstance().getSqlSession();
        AdminMapper adminMapper = session.getMapper(AdminMapper.class);
        RowBounds rowBounds = new RowBounds(curPage,pageSize);
        List<Admin> list= adminMapper.findAll(map,rowBounds);
        MyBatisUtil.close();
        return list;
    }


    public int totalPage(HashMap<String, String> map){
        SqlSession session= MyBatisUtil.getInstance().getSqlSession();
        AdminMapper adminMapper = session.getMapper(AdminMapper.class);
        int a= adminMapper.totalPage(map);
        MyBatisUtil.close();
        return a;
    }
    public int updateState(int id,String state){
        SqlSession session= MyBatisUtil.getInstance().getSqlSession();
        AdminMapper adminMapper = session.getMapper(AdminMapper.class);
        int a= adminMapper.updateState(id,state);
        MyBatisUtil.close();
        return a;
    }
    public int deleteAdmin(int id){
        SqlSession session= MyBatisUtil.getInstance().getSqlSession();
        AdminMapper adminMapper = session.getMapper(AdminMapper.class);
        int a= adminMapper.deleteAdmin(id);
        MyBatisUtil.close();
        return a;
    }
}
