package controller;


import dao.LogDao;
import dao.StuinfoDao;
import model.Log;
import model.Stuinfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    private Boolean isLogin(HttpSession session, String key)
    {
        if (session.getAttribute("key")==null)
        {
            return false;
        }
        if ((Integer) session.getAttribute("role") != 2){
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

        //更换输入方式，用list多层封装
        List stulist = new ArrayList();
        List<Stuinfo> stu;
        StuinfoDao dao = new StuinfoDao();
        try {
            stu = dao.searchAllStuinfo();
            for(Stuinfo data:stu)
            {
                List line = new ArrayList<>();
                line.add(data.getId());
                line.add(data.getName());
                line.add(data.getBirth());
                line.add(data.getTel());
                line.add(data.getEmail());
                line.add(data.getCredit_got());
                line.add(data.getCredit_need());
                line.add(data.getEnrollyear());
                line.add(data.getMajor());
                stulist.add(line);
            }
            model.addAttribute("list",stulist);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<String> title = new ArrayList<>();
        title.add("学生学号");
        title.add("学生姓名");
        title.add("出生年月");
        title.add("电话");
        title.add("邮箱");
        title.add("已获学分");
        title.add("需获学分");
        title.add("入学年份");
        title.add("专业");
        model.addAttribute("table_js","table_stuinfo.js");
        model.addAttribute("title",title);
        model.addAttribute("page","index");
        model.addAttribute("base_url","teacher");
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

        model.addAttribute("page","importStudentInfo");
        model.addAttribute("base_url","teacher");
        model.addAttribute("sub_url","stuinfo");
        model.addAttribute("title","学生信息");
        return "/teacher/importStudentInfo";
    }
}
