package controller;

import bean.LoginUser;
import dao.LogDao;
import dao.UsersDao;
import helper.KeyGenerator;
import helper.TimeHelper;
import model.Log;
import model.Users;
import java.lang.Object;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")

/*登录控制1*/
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
            user.setUsername((String)httpSession.getAttribute("username"));
            user.setRole((Integer) httpSession.getAttribute("role"));
            user.setKey((String)httpSession.getAttribute("key"));
            return user;
        }
        UsersDao dao = new UsersDao();
        Users u = null;
        try {
            u = dao.searchSingle(username);
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
        //生成登录key
        System.out.println(user.getUsername());
        String key = KeyGenerator.createKey(user.getRole());
        //保存key到数据库
        try
        {
            LogDao ldao = new LogDao();
            Log log_item = ldao.searchSingleLog(Integer.parseInt(user.getUsername()));
            Log log = new Log();
            if (log_item == null)
            {
                log.setLogin_time(TimeHelper.getCurrentTime());
                log.setKey(key);
                log.setLogin_id(Integer.parseInt(username));
                ldao.addLog(log);
            }
            else
            {
                log_item.setKey(key);
                log_item.setLogin_time(TimeHelper.getCurrentTime());
                ldao.updateLog(log_item);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        user.setKey(key);

        httpSession.setAttribute("key",key);
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
