package soft.Util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisUtil {
    //mybatis 配置文件路径
    private static  final String CONFIG_PAGE="mybatis-config.xml";
    //SqlSessionFactory工厂对象
    private static SqlSessionFactory sessionFactory =null;
    private static SqlSession session=null;
    private  static  MyBatisUtil instance=null;
    private  MyBatisUtil(){

        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(CONFIG_PAGE);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            session = sessionFactory.openSession(false);//打开事务，取消自动提交
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null!=reader){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    //获取SqlSession单例
    public static synchronized MyBatisUtil getInstance(){
        if (null==instance){
            synchronized (MyBatisUtil.class){
                instance =new MyBatisUtil();
            }
        }
        return instance;
    }
    public  synchronized SqlSession getSqlSession(){
        return  session;
    }

    /**
     * 归还方法
     */
    public static void close(){
        session.commit();
//        session.close();
    }
}
