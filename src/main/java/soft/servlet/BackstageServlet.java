package soft.servlet;



import soft.Service.AdminInfoService;
import soft.Service.DocInfoService;
import soft.Service.Impl.AdminInfoServiceImpl;
import soft.Service.Impl.LoginSeviceImpl;
import soft.Service.Impl.RegisterServiceImpl;
import soft.Service.LoginSevice;
import soft.Service.RegisterService;
import soft.Util.ObjectFactory;
import soft.bean.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@WebServlet("/backstageServlet")
public class BackstageServlet extends BaseServlet {


    AdminInfoService adminInfoService = (AdminInfoService) ObjectFactory.newInstance("soft.Service.Impl.AdminInfoServiceImpl");
    DocInfoService docInfoService = (DocInfoService) ObjectFactory.newInstance("soft.Service.Impl.DocInfoServiceImpl");


    /**
     * 登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("请求登录");
        //获取账户
        String account = request.getParameter("account");
        //获取密码
        String password = request.getParameter("password");
         LoginSevice loginSevice = new LoginSeviceImpl();
        System.out.println(password+account);
        Admin admin= loginSevice.login(account,password);

        if (admin==null){
            System.out.println("登录失败");
            response.getWriter().write("登录失败");
        }else{
            System.out.println("登录成功");
            response.getWriter().write("登录成功");
        }
    }
    public void isAccountUserName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("请求验证");
        //获取昵称
        String userName = request.getParameter("userName");
        //获取账号
        String rsAccount = request.getParameter("rsAccount");


    }
    public String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("请求注册");
        //获取账户
        String adminName = request.getParameter("userName");
        //获取密码
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String sex = request.getParameter("sex");
        String education = request.getParameter("type");
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sf.format(new Date());
        Admin admin = new Admin(null,account,password,adminName,sex,email,education,phone,time,"启用","普通用户");
        RegisterService registerService = new RegisterServiceImpl();
        int a =registerService.registerAdmin(admin);
        if (a>0){
            System.out.println("注册成功");
        }else{
            System.out.println("注册失败");
        }
        return "pages/login.jsp";
    }

    public  void adminInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{


        String pageSize =request.getParameter("limit");
        String  curPage =request.getParameter("page");

        String  name =request.getParameter("name");
        String  endTime =request.getParameter("endTime");
        String  beginTime =request.getParameter("beginTime");

        System.out.println(name);

//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//        endTime =sf.format(endTime);
//        beginTime=sf.format(beginTime);
        HashMap<String,String> map = new HashMap<>();

        if (name != null&& !name.equals("")){
            map.put("name",name);
        }
        if (endTime != null&&!endTime.equals("")){
            map.put("endTime",endTime);
        }
        if (beginTime != null&&!beginTime.equals("")){
            map.put("beginTime",beginTime);
        }

        String  str = adminInfoService.findByPage(map,(Integer.valueOf(curPage)-1)*Integer.valueOf(pageSize),Integer.valueOf(pageSize));
        System.out.println(str);
        response.getWriter().write(str);
    }

    public  void updateState(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{


        String id =request.getParameter("id");
        String  updateType =request.getParameter("updateType");
        System.out.println("id"+id+"updateType"+updateType);
        if (updateType.trim().equals("删除")){
            int a = adminInfoService.deleteAdmin(Integer.valueOf(id));
            if (a>0){
                response.getWriter().write("删除成功");
            }else{
                response.getWriter().write("删除失败");
            }
        }else{
            int a = adminInfoService.updateState(Integer.valueOf(id),updateType);
            if (a>0){
                response.getWriter().write("修改成功");
            }else{
                response.getWriter().write("修改失败");
            }
        }
    }

    public  void docInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{


        String pageSize =request.getParameter("limit");
        String  curPage =request.getParameter("page");
        String endTime =request.getParameter("endTime");
        String  beginTime =request.getParameter("beginTime");
        String docTitle =request.getParameter("docTitle");
        String  adminName =request.getParameter("adminName");
        String  type =request.getParameter("type");
        HashMap<String,String> map = new HashMap<>();
        if (beginTime != null&&!beginTime.equals("")){
            map.put("beginTime",beginTime);
        }
        if (endTime != null&&!endTime.equals("")){
            map.put("endTime",endTime);
        }
        if (docTitle != null&&!docTitle.equals("")){
            map.put("docTitle",docTitle);
        }
        if (adminName != null&&!adminName.equals("")){
            map.put("adminName",adminName);
        }
        if (type != null&&!type.equals("")){
            map.put("type",type);
        }


        String  str = docInfoService.findByPage(map,(Integer.valueOf(curPage)-1)*Integer.valueOf(pageSize),Integer.valueOf(pageSize));
        System.out.println(str);
        response.getWriter().write(str);
    }
}


