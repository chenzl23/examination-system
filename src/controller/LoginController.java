package controller;

import bean.LoginUser;
import dao.UsersDao;
import model.Users;
import java.lang.Object;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")

/*登录控制*/
public class LoginController {

    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public @ResponseBody  LoginUser login(@RequestParam("username") String username , @RequestParam("psw") String psw,
                                          @RequestParam("role") String role, HttpServletRequest request, Model model, HttpSession httpSession)
    {
        System.out.println("Login controller");
        LoginUser user = new LoginUser();
        //已经有用户登录
        if (httpSession.getAttribute("username")!=null)
        {
            user.setState("valid");
            return user;
        }
        UsersDao dao = new UsersDao();
        Users u = null;
        try {
            u = dao.searchSingle(username);
            System.out.println(u.getPasswd());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //判断账号密码是否正确
        if (u == null)
        {
            user.setState("false");
            return user;
        }
        if (!u.getPasswd().equals(psw))
        {
            user.setState("false");
            return user;
        }
        user.setPsw(psw);
        user.setUsername(username);
        user.setState("true");
        switch (role)
        {
            case "1":user.setRole(1);break;
            case "2":user.setRole(2);break;
            case "3":user.setRole(3);break;
            default:user.setState("false");break;
        }
        if (user.getRole() != u.getRole_id())
        {
            user.setState("false");
            return user;
        }
        httpSession.setAttribute("username",user.getUsername());
        httpSession.setAttribute("role",user.getRole());
        return user;
    }

    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, java.lang.Object> logout(HttpServletRequest request, Model model, HttpSession httpSession)
    {
        Map<String, Object> hashmap = new HashMap<String,Object>();
        hashmap.put("state","false");
        if (httpSession.getAttribute("username")!=null)
        {
            httpSession.removeAttribute("username");
            httpSession.removeAttribute("key");
        }
        if (httpSession.getAttribute("username")==null)
        {
            hashmap.put("state","true");
            return hashmap;
        }
        return hashmap;
    }
}
