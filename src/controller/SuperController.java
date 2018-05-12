package controller;


import dao.LogDao;
import dao.StuinfoDao;
import model.Log;
import model.Stuinfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/super")
public class SuperController {

    private Boolean isLogin(HttpSession session, String key)
    {
        if (session.getAttribute("key")==null)
        {
            return false;
        }
        if ((Integer) session.getAttribute("role") != 1){
            return false;}
        LogDao dao = new LogDao();
        Log log = null;
        try {
            log = dao.searchSingleLog( Integer.parseInt(session.getAttribute("username").toString()));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        if (log.getKey().equals(session.getAttribute("key").toString()) && log.getKey().equals(key))
        {
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(@RequestParam("key") String key,Model model, HttpSession session)
    {
        //判断登录权限
        if (!isLogin(session,key))
        {
            model.addAttribute("message","登录时间过期,请重新登录");
            return "/common/error";
        }

        List<Stuinfo> stu;
        StuinfoDao dao = new StuinfoDao();
        try {
            stu = dao.searchAllStuinfo();
            model.addAttribute("list",stu);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        model.addAttribute("base_url","super");
        return "/teacher/index";
    }

    @RequestMapping(value = "/importStudentInfo",method = RequestMethod.GET)
    public String importStudentInfo(@RequestParam("key") String key, HttpServletRequest request, Model model, HttpSession session)
    {
        //判断登录权限
        if (!isLogin(session,key))
        {
            model.addAttribute("message","登录时间过期,请重新登录");
            return "/common/error";
        }

        model.addAttribute("base_url","super");
        return "/teacher/importStudentInfo";
    }

    @RequestMapping(value = "/studentAttendScore",method = RequestMethod.GET)
    public String studentAttendScore(@RequestParam("key") String key,Model model,HttpSession session)
    {
        if (!key.equals((String)session.getAttribute("key")))
        {
            model.addAttribute("message","非法操作");
            return "/common/error";
        }
        return "/teacher/studentAttendScore";
    }
}
