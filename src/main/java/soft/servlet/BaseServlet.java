package soft.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(name = "BaseServlet")
public class BaseServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取是什么请求
        String whatName = req.getParameter("whatName");
        System.out.println("我发送了一个什么请求"+whatName);
        //获取当前调用的对象
        Class  clazz = this.getClass();
        try {
            if (whatName != null && !whatName.trim().equals("")){
                //Class.getMethod 参数传入 方法名  和 方法对应的参数的class
                Method method = clazz.getMethod(whatName, HttpServletRequest.class, HttpServletResponse.class);
                //传入要执行的实体类  和 执行的方法对应的参数
                String path = (String) method.invoke(this,req,resp);
                //当路径不为空时进行请求转发
                if (path!=null && !path.trim().equals("")){
                    req.getRequestDispatcher(path).forward(req,resp);
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
