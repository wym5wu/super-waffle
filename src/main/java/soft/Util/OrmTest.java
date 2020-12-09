package soft.Util;

import org.dom4j.Element;
import soft.bean.TestTable;

import java.util.Iterator;

public class OrmTest {
    public static void main(String[] args) {
        TestTable testTable = new TestTable();
        testTable.setName("root");
        testTable.setPwd("123456");
        Element root = MappingUtils.fetchXml();
        Element foo;
        for (Iterator i = root.elementIterator("table");i.hasNext();){
            foo = (Element)i.next();
            System.out.println("sql"+ foo.attributeValue("name"));
            String sql = MappingUtils.fetchInsertSql(foo.attributeValue("name"));
            System.out.println("sql"+sql);
        }
    }
}
