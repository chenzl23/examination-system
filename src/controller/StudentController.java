package controller;


import bean.CourseList;
import dao.*;
import helper.TimeHelper;
import model.Log;
import model.Messages;
import model.StuCourses;
import model.Teachinfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.*;

@Controller
@RequestMapping("/student")
public class StudentController {
    private Boolean isLogin(HttpSession session, String key)
    {
        if (session.getAttribute("key")==null)
        {
            return false;
        }
        if ((Integer) session.getAttribute("role") != 3){
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


    //查询学生成绩
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String getStudentMark(@RequestParam("key") String key,Model model, HttpSession session)
    {
        //判断登录权限
        if (!isLogin(session,key))
        {
            model.addAttribute("message","登录时间过期,请重新登录");
            return "/common/error";
        }
        String id = session.getAttribute("username").toString();
        List courselist = new ArrayList();
        List<StuCourses> courses;
        StuCoursesDao dao = new StuCoursesDao();
        try {
            courses = dao.searchStuScore(id.toString());
            CoursesDao cd = new CoursesDao();
            for(StuCourses data:courses)
            {
                List line = new ArrayList<>();
                line.add(data.getSc_id());
                line.add(cd.searchSingleCourse(data.getCno()).getC_name());
                line.add(data.getSno());
                StuinfoDao sd = new StuinfoDao();
                line.add(sd.searchSingleStuinfo(data.getSno()).getName());
                line.add(data.getTerm());
                line.add(data.getTeacher());
                line.add(data.getDaily_work());
                line.add(data.getMid_exam());
                line.add(data.getFinal_exam());
                line.add(data.getExperiment());
                line.add(data.getTotal_remark());
                CourseStatusDao csd = new CourseStatusDao();
                line.add(csd.searchCourseStatus(data.getStatus()).getCs_name());
                courselist.add(line);
            }
            model.addAttribute("list",courselist);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> title = new ArrayList<>();
        title.add("选课编码");
        title.add("课程名");
        title.add("学号");
        title.add("学生");
        title.add("开设年级");
        title.add("教师");
        title.add("平时成绩");
        title.add("期中成绩");
        title.add("期末成绩");
        title.add("实验成绩");
        title.add("总评成绩");
        title.add("选课状态");

        model.addAttribute("table_js","table_mark.js");
        model.addAttribute("title",title);
        model.addAttribute("page","index");
        model.addAttribute("base_url","student");
        return "/student/index";
    }

    @RequestMapping(value = "/reply",method = RequestMethod.GET)
    public String reply(@RequestParam("key") String key,Model model, HttpSession session) {

        //加载教师列表
        TeachinfoDao dao = new TeachinfoDao();
        List<Teachinfo> teacherlist = null;
        try {
            teacherlist = dao.searchAllTeachinfo();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        model.addAttribute("tealist",teacherlist);

        model.addAttribute("page","reply");
        model.addAttribute("base_url","student");
        return "/student/reply";
    }

    @RequestMapping(value = "/sendmessage",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> sendmessage(@RequestParam("key") String key, @RequestParam("to") String to,
                                           @RequestParam("message") String message, Model model, HttpSession session) {
        System.out.println("添加反馈");
        Map<String, Object> hashmap = new HashMap<String,Object>();
        MessagesDao dao = new MessagesDao();
        TeachinfoDao td = new TeachinfoDao();
        Messages mes = new Messages();
        try {
            Teachinfo tea = td.searchTeachinfoByName(to);

            mes.setFrom_id((String) session.getAttribute("username"));
            mes.setTo_id(tea.getT_id());
            mes.setMessage(message);
            dao.addMessages(mes);
            hashmap.put("state","true");
            return hashmap;

        } catch (SQLException e) {
            e.printStackTrace();
            hashmap.put("error_message",e.getMessage());
            hashmap.put("state","false");
            return hashmap;
        }


    }





    }
