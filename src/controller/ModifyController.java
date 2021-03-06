package controller;


import dao.MajorDao;
import dao.StuCoursesDao;
import dao.StuinfoDao;
import dao.TeachinfoDao;
import helper.MailHelper;
import model.Major;
import model.StuCourses;
import model.Stuinfo;
import model.Teachinfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/modify")
public class ModifyController {


    @RequestMapping(value="/stuinfo",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> modifyStuinfo(HttpServletRequest request, Model model, HttpSession session){
        Map<String, Object> hashmap = new HashMap<String,Object>();
        StuinfoDao dao= new StuinfoDao();
        try {
            Stuinfo stu = dao.searchSingleStuinfo(request.getParameter("id").toString());
            if (stu == null)
            {
                hashmap.put("status","error");
                return hashmap;
            }
            stu.setName(request.getParameter("name").toString());
            stu.setTel(request.getParameter("tel"));
            stu.setEmail(request.getParameter("email"));
            stu.setEnrollyear(Integer.parseInt(request.getParameter("encroll_year").toString()));
            dao.updateStuinfo(stu);
        } catch (SQLException e) {
            e.printStackTrace();
            hashmap.put("status","error");
            return hashmap;
        }
        hashmap.put("status","success");
        return hashmap;
    }

    @RequestMapping(value="/mark",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> modifyMark(HttpServletRequest request, Model model, HttpSession session){
        Map<String, Object> hashmap = new HashMap<String,Object>();
        StuCoursesDao dao = new StuCoursesDao();
        try {
            StuCourses stu = dao.searchStuCourse(Integer.parseInt(request.getParameter("course_num").toString()));
            if (stu == null)
            {
                hashmap.put("status","error");
                return hashmap;
            }
            stu.setDaily_work(Double.parseDouble(request.getParameter("daily_work").toString()));
            stu.setMid_exam(Double.parseDouble(request.getParameter("mid_exam").toString()));
            stu.setFinal_exam(Double.parseDouble(request.getParameter("final_exam").toString()));
            stu.setExperiment(Double.parseDouble(request.getParameter("experiment").toString()));
            stu.setTotal_remark(Double.parseDouble(request.getParameter("total_remark").toString()));
            dao.updateStuCourse(stu);
        } catch (SQLException e) {
            e.printStackTrace();
            hashmap.put("status","error");
            return hashmap;
        }
        hashmap.put("status","success");

        MailHelper mail = new MailHelper();
        StuinfoDao std = new StuinfoDao();
        try{
             Stuinfo sinfo = std.searchSingleStuinfo(request.getParameter("s_no").toString());
             System.out.println(sinfo.getEmail());
             if (sinfo.getEmail()!="")
             {
                 String message = sinfo.getName()+"同学，您的课程" + request.getParameter("course_name").toString() +
                         "成绩有更新，请登入系统查看";
                 mail.sendmail(sinfo.getEmail(),sinfo.getName(),message);
             }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return hashmap;
    }

    @RequestMapping(value="/teainfo",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> modifyTeacherInfo(HttpServletRequest request, Model model, HttpSession session){
        Map<String, Object> hashmap = new HashMap<String,Object>();
        TeachinfoDao dao = new TeachinfoDao();
        try {
            Teachinfo tea = dao.searchSingleTeachinfo(request.getParameter("id").toString());
            if (tea == null)
            {
                hashmap.put("status","error");
                return hashmap;
            }
           tea.setT_name(request.getParameter("name"));
           tea.setT_email(request.getParameter("email"));
           tea.setT_tel(request.getParameter("tel"));
           MajorDao  md = new MajorDao();
           Major major = md.searchMajorId(request.getParameter("major").toString());
           if (major == null)
           {
               hashmap.put("status","error");
               hashmap.put("message","Major error");
               return hashmap;
           }
           tea.setT_major(major.getM_id());
           dao.updateTeachinfo(tea);
        } catch (SQLException e) {
            e.printStackTrace();
            hashmap.put("status","error");
            return hashmap;
        }
        hashmap.put("status","success");
        return hashmap;
    }
}
