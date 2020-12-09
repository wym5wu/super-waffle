package soft.Util;

public class ObjectFactory {
    public static Object newInstance(String className){
        Object object =null;
        try {
            Class clz = Class.forName(className);
            object =clz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return object;
    }
}
