package soft.Util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Field;

public class MappingUtils {
    /**
     * 获取解析XML
     * @return
     */
    public static Element fetchXml(){
        File file = new File("src/main/resources/TestTable.xml");
        //实例化xml解析器
        SAXReader reader = new SAXReader();
        try {
            Document document=  reader.read(file);
            //获取到根节点
            Element root = document.getRootElement();
            return  root;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成插入语句
     * @param bean
     * @return
     */
    public static String fetchInsertSql(String bean){
        try {
            Class clz = Class.forName(bean);
            String clzStr = clz.toString();
            //获取类名
            String beanName = clzStr.substring(clzStr.lastIndexOf(".")+1).toLowerCase();
            //获取类中所有属性;
            Field[]fields = clz.getDeclaredFields();
            StringBuffer stringBuffer =null;
            String fileName ="";
            for (Field field:fields){
                fileName+=","+field.getName();
                if (stringBuffer==null){
                    stringBuffer = new StringBuffer();
                    stringBuffer.append("?");
                }else{
                    stringBuffer.append(" , ?");
                }
            }
            return "insert into "+beanName+"("+fileName.substring(1)+")values("+stringBuffer.toString()+")";
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}
