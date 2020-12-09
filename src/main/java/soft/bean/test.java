package soft.bean;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import soft.Util.MyBatisUtil;
import soft.mapper.AdminMapper;
import soft.mapper.DocInfoMapper;
import soft.mapper.MenuMapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        Admin admin = new Admin();
        SqlSession session= MyBatisUtil.getInstance().getSqlSession();
        MenuMapper menuMapper = session.getMapper(MenuMapper.class);
        menuMapper.findMenus();
        menuMapper.findeAlluser();
        menuMapper.findMenu();
        System.out.println(menuMapper.findMenus());
        System.out.println(menuMapper.findeAlluser());
        System.out.println( "一对多"+menuMapper.findMenu());
        System.out.println( "多对一"+menuMapper.findeAlluser1());

        DocInfoMapper docInfoMapper = session.getMapper(DocInfoMapper.class);
        RowBounds rowBounds = new RowBounds(0,2);
        System.out.println(docInfoMapper.findAll(null,rowBounds));

//        for (Menu menu : menuMapper.findMenus()) {
//            for (Admin menuAdmin : menu.getAdmins()) {
//                System.out.println(menuAdmin);
//            }
//        }
        System.out.println();
//        List list= new ArrayList();
//        list.add(1);
//        list.add(2);
//        RowBounds rowBounds = new RowBounds(0,4);
////        List<Admin> list1 = adminMapper.findAll(rowBounds);
//
////        System.out.println(list1.size());
        MyBatisUtil.close();
    }
}
