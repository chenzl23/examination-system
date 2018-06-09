package controller;


import bean.CourseList;
import dao.*;
import model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.MajorService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.*;

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

    @RequestMapping(value = "markList",method = RequestMethod.GET)
    public String markList (@RequestParam(value = "id",required = true) String id,@RequestParam("key") String key,Model model, HttpSession session)
    {
        //判断登录权限
        if (!isLogin(session,key))
        {
            model.addAttribute("message","登录时间过期,请重新登录");
            return "/common/error";
        }
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
        model.addAttribute("page","markList");
        model.addAttribute("base_url","super");
        return "/administrator/stu_mark";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(@RequestParam("key") String key,@RequestParam(value = "grade",required = false)
            int grade ,@RequestParam(value = "course",required = false) int course,Model model, HttpSession session)
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
            //获取课程列表
            List<CourseList> returnCourseList = new ArrayList();
            CoursesDao cd = new CoursesDao();
            List<Courses> courseList = cd.searchAllCourse();
            for (Courses item:courseList)
            {
                CourseList cl = new CourseList();
                cl.setCno(item.getC_id());
                cl.setC_name(item.getC_name());
                returnCourseList.add(cl);
            }
            model.addAttribute("courselist",returnCourseList);
            stu = dao.searchAllStuinfo();
            for(Stuinfo data:stu)
            {
                if (data.getEnrollyear() != grade && grade!=0)
                    continue;
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
                line.add("<a target=\"_blank\" href=\"http://localhost/super/markList?key="+key+"&id="+data.getId()+"\">查看成绩单</a>");
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
        title.add("操作");
        model.addAttribute("grade",1);
        model.addAttribute("course",0);
        model.addAttribute("table_js","table_stuinfo.js");
        model.addAttribute("title",title);
        model.addAttribute("page","index");
        model.addAttribute("base_url","super");
        return "/administrator/index";
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

        model.addAttribute("img","../../resources/image/学生信息导入格式.png");
        model.addAttribute("page","importStudentInfo");
        model.addAttribute("base_url","super");
        model.addAttribute("sub_url","stuinfo");
        model.addAttribute("title","学生信息");
        return "/administrator/importStudentInfo";
    }

    @RequestMapping(value = "/getTeacher",method = RequestMethod.GET)
    public String getTeacher(@RequestParam("key") String key,@RequestParam(value = "grade",required = false)
            int grade ,@RequestParam(value = "course",required = false) int course,Model model,HttpSession session)
    {
        //判断登录权限
        if (!isLogin(session,key))
        {
            model.addAttribute("message","登录时间过期,请重新登录");
            return "/common/error";
        }

        List tealist = new ArrayList();
        List<Teachinfo> tea;
        TeachinfoDao dao = new TeachinfoDao();
        try {
            //获取课程列表
            System.out.println(grade+" "+session.getAttribute("username").toString() + " "+course);
            List<CourseList> returnCourseList = new ArrayList();
            CoursesDao cd = new CoursesDao();
            List<Courses> courseList = cd.searchAllCourse();
            for (Courses item:courseList)
            {
                CourseList cl = new CourseList();
                cl.setCno(item.getC_id());
                cl.setC_name(item.getC_name());
                returnCourseList.add(cl);
            }
            model.addAttribute("courselist",returnCourseList);
            tea = dao.searchAllTeachinfo();
            for(Teachinfo data:tea)
            {
                List line = new ArrayList<>();
                line.add(data.getT_id());
                line.add(data.getT_name());
                line.add(data.getT_birth());
                line.add(data.getT_tel());
                line.add(data.getT_email());
                MajorService mjs = new MajorService();
                line.add(mjs.searchMajorNameService(data.getT_major()).getM_name());
                tealist.add(line);
            }
            model.addAttribute("list",tealist);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<String> title = new ArrayList<>();
        title.add("教师工号");
        title.add("教师姓名");
        title.add("出生年月");
        title.add("电话");
        title.add("邮箱");
        title.add("专业");
        model.addAttribute("grade",0);
        model.addAttribute("course",0);
        model.addAttribute("table_js","table_teainfo.js");
        model.addAttribute("title",title);
        model.addAttribute("page","getTeacher");
        model.addAttribute("base_url","super");
        return "/administrator/index";
    }

    @RequestMapping(value = "/importTeacher",method = RequestMethod.GET)
    public String importTeacher(@RequestParam("key") String key,Model model,HttpSession session)
    {
        //判断登录权限
        if (!isLogin(session,key))
        {
            model.addAttribute("message","登录时间过期,请重新登录");
            return "/common/error";
        }
        model.addAttribute("img","../../resources/image/教师信息导入格式.png");
        model.addAttribute("page","importTeacher");
        model.addAttribute("base_url","super");
        model.addAttribute("sub_url","teainfo");
        model.addAttribute("title","教师信息");
        return "/administrator/importStudentInfo";
    }

    @RequestMapping(value = "/getCourseInfo",method = RequestMethod.GET)
    public String getCourseInfo(@RequestParam("key") String key,@RequestParam(value = "grade",required = false)
            int grade ,@RequestParam(value = "course",required = false) int course,Model model,HttpSession session)
    {
        //判断登录权限
        if (!isLogin(session,key))
        {
            model.addAttribute("message","登录时间过期,请重新登录");
            return "/common/error";
        }

        List courselist = new ArrayList();
        List<Courses> courses;
        CoursesDao dao = new CoursesDao();
        try {
            //获取课程列表
            System.out.println(grade+" "+session.getAttribute("username").toString() + " "+course);
            List<CourseList> returnCourseList = new ArrayList();
            CoursesDao cd = new CoursesDao();
            List<Courses> courseList = cd.searchAllCourse();
            for (Courses item:courseList)
            {
                CourseList cl = new CourseList();
                cl.setCno(item.getC_id());
                cl.setC_name(item.getC_name());
                returnCourseList.add(cl);
            }
            model.addAttribute("courselist",returnCourseList);
            courses = dao.searchAllCourse();
            for(Courses data:courses)
            {
                List line = new ArrayList<>();
                line.add(data.getC_id());
                line.add(data.getC_name());
                line.add(data.getGrade());
                line.add(data.getCredit());
                StuCoursesDao scd =new StuCoursesDao();
                List<StuCourses>  clist = scd.getScoreByTeacher(data.getGrade(),null,data.getC_id());
                if (clist.size()==0)
                    line.add(" ");
                else
                    line.add("<a target=\"_blank\" href=\"/super/analysis?key="+key+"&grade="+data.getGrade()+"&course="+data.getC_id()+"&teacher=0\">查看成绩分析</a>");
                courselist.add(line);
            }
            model.addAttribute("list",courselist);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<String> title = new ArrayList<>();
        title.add("课程号");
        title.add("课程名");
        title.add("开设年级");
        title.add("学分");
        title.add("操作");
        model.addAttribute("grade",0);
        model.addAttribute("course",0);
        model.addAttribute("table_js","table_courseinfo.js");
        model.addAttribute("title",title);
        model.addAttribute("page","getCourseInfo");
        model.addAttribute("base_url","super");
        return "/administrator/index";
    }

    @RequestMapping(value = "/importCourseInfo",method = RequestMethod.GET)
    public String importCourseInfo(@RequestParam("key") String key,Model model,HttpSession session)
    {
        //判断登录权限
        if (!isLogin(session,key))
        {
            model.addAttribute("message","登录时间过期,请重新登录");
            return "/common/error";
        }
        model.addAttribute("img","../../resources/image/课程信息导入格式.png");
        model.addAttribute("page","importCourseInfo");
        model.addAttribute("base_url","super");
        model.addAttribute("sub_url","courseinfo");
        model.addAttribute("title","课程信息");
        return "/administrator/importStudentInfo";
    }

    @RequestMapping(value = "/getCourseChosen",method = RequestMethod.GET)
    public String getCourseChosen(@RequestParam("key") String key,@RequestParam(value = "grade",required = false)
            int grade ,@RequestParam(value = "course",required = false) int course,Model model,HttpSession session)
    {
        //判断登录权限
        if (!isLogin(session,key))
        {
            model.addAttribute("message","登录时间过期,请重新登录");
            return "/common/error";
        }

        List courselist = new ArrayList();
        List<StuCourses> courses;
        StuCoursesDao dao = new StuCoursesDao();
        try {
            //获取课程列表
            System.out.println(grade+" "+session.getAttribute("username").toString() + " "+course);
            List<CourseList> returnCourseList = new ArrayList();
            CoursesDao cd = new CoursesDao();
            List<Courses> courseList = cd.searchAllCourse();
            for (Courses item:courseList)
            {
                CourseList cl = new CourseList();
                cl.setCno(item.getC_id());
                cl.setC_name(item.getC_name());
                returnCourseList.add(cl);
            }
            model.addAttribute("courselist",returnCourseList);
            //获得成绩信息
            if (grade != 0  && course!=0)
            {
                courses = dao.getScoreByTeacher(grade,null,course);
            }
            else {
                int findCourse = courseList.get(0).getC_id();
                courses = dao.getScoreByTeacher(2015,null,findCourse);
                System.out.println(findCourse);
            }
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
                CourseStatusDao csd = new CourseStatusDao();
                line.add(csd.searchCourseStatus(data.getStatus()).getCs_name());
                courselist.add(line);
            }
            model.addAttribute("list",courselist);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> title = new ArrayList<>();
        title.add("选课号");
        title.add("课程名");
        title.add("学号");
        title.add("学生");
        title.add("开设年级");
        title.add("教师");
        title.add("选课状态");
        model.addAttribute("grade",1);
        model.addAttribute("course",1);
        model.addAttribute("table_js","table_getCourseChosen.js");
        model.addAttribute("title",title);
        model.addAttribute("page","getCourseChosen");
        model.addAttribute("base_url","super");
        return "/administrator/index";
    }

    @RequestMapping(value = "/importCourseChosen",method = RequestMethod.GET)
    public String importCourseChosen(@RequestParam("key") String key,Model model,HttpSession session)
    {
        //判断登录权限
        if (!isLogin(session,key))
        {
            model.addAttribute("message","登录时间过期,请重新登录");
            return "/common/error";
        }
        model.addAttribute("img","../../resources/image/选课信息导入格式.png");
        model.addAttribute("page","importCourseChosen");
        model.addAttribute("base_url","super");
        model.addAttribute("sub_url","coursechosen");
        model.addAttribute("title","选课信息");
        return "/administrator/importStudentInfo";
    }

    //查询学生成绩
    @RequestMapping(value = "/getStudentMark",method = RequestMethod.GET)
    public String getStudentMark(@RequestParam("key") String key,@RequestParam(value = "grade",required = false)
            int grade ,@RequestParam(value = "course",required = false) int course,Model model, HttpSession session)
    {
        //判断登录权限
        if (!isLogin(session,key))
        {
            model.addAttribute("message","登录时间过期,请重新登录");
            return "/common/error";
        }

        List courselist = new ArrayList();
        List<StuCourses> courses;
        StuCoursesDao dao = new StuCoursesDao();
        try {
            //获取课程列表与教师列表
            List<CourseList> returnCourseList = new ArrayList();
            CoursesDao cd = new CoursesDao();
            List<Courses> courseList = cd.searchAllCourse();
            for (Courses item:courseList)
            {
                CourseList cl = new CourseList();
                cl.setCno(item.getC_id());
                cl.setC_name(item.getC_name());
                returnCourseList.add(cl);
            }
            model.addAttribute("courselist",returnCourseList);
            //获得成绩信息
            if (grade != 0  && course!=0)
            {
                courses = dao.getScoreByTeacher(grade,null,course);
            }
            else {
                int findCourse = courseList.get(0).getC_id();
                courses = dao.getScoreByTeacher(2015,null,findCourse);
                System.out.println(findCourse);
            }
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

        model.addAttribute("grade",1);
        model.addAttribute("course",1);
        model.addAttribute("table_js","table_mark.js");
        model.addAttribute("title",title);
        model.addAttribute("page","getStudentMark");
        model.addAttribute("base_url","super");
        return "/administrator/index";
    }

    //成绩分析页面
    @RequestMapping(value = "/analysis",method = RequestMethod.GET)
    public String Analysis(@RequestParam("key") String key,@RequestParam(value = "grade",required = false)
            int grade ,@RequestParam(value = "course",required = false) int course,
                                 @RequestParam(value = "teacher",required = false) String tea,Model model, HttpSession session){
        //判断登录权限
        if (!isLogin(session,key))
        {
            model.addAttribute("message","登录时间过期,请重新登录");
            return "/common/error";
        }

        String[] title = {"平时成绩","期中成绩","期末成绩","实验成绩","总评成绩"};
        model.addAttribute("title",title);
        try {
            //加载教师列表
            StuCoursesDao dao = new StuCoursesDao();
            Set<String> hs =dao.searchTeacher(grade,course);
            List<Teachinfo> teacherlist = new ArrayList<>();
            Iterator it = hs.iterator();
            TeachinfoDao td = new TeachinfoDao();
            while (it.hasNext()) {
                Teachinfo teainfo = td.searchTeachinfoByName(it.next().toString());
                teacherlist.add(teainfo);
            }
            model.addAttribute("tealist",teacherlist);
            //载入页面
            List<StuCourses> sclist;
            //统计这门课所有老师的成绩分析
            if (tea.equals("0"))
            {
                sclist = dao.getScoreByTeacher(grade,null,course);
            }
            //统计这门课单个老师的成绩分析
            else {
                sclist = dao.getScoreByTeacher(grade,tea,course);
            }
            Integer[]  daily_num = {0,0,0,0,0};//0-59,60-69,70-79,80-89,90-100
            Integer[]  mid_num = {0,0,0,0,0};//0-59,60-69,70-79,80-89,90-100
            Integer[]  final_num = {0,0,0,0,0};//0-59,60-69,70-79,80-89,90-100
            Integer[]  exp_num ={0,0,0,0,0};//0-59,60-69,70-79,80-89,90-100
            Integer[]  total_num = {0,0,0,0,0};//0-59,60-69,70-79,80-89,90-100
            for (StuCourses sc :sclist) {
                if (sc.getDaily_work() >= 90) {
                    daily_num[4]++;
                } else if (sc.getDaily_work() >= 80) {
                    daily_num[3]++;
                } else if (sc.getDaily_work() >= 70) {
                    daily_num[2]++;
                } else if (sc.getDaily_work() >= 60) {
                    daily_num[1]++;
                } else {
                    daily_num[0]++;
                }

                if (sc.getMid_exam() >= 90) {
                    mid_num[4]++;
                } else if (sc.getMid_exam() >= 80) {
                    mid_num[3]++;
                } else if (sc.getMid_exam() >= 70) {
                    mid_num[2]++;
                } else if (sc.getMid_exam() >= 60) {
                    mid_num[1]++;
                } else {
                    mid_num[0]++;
                }

                if (sc.getFinal_exam() >= 90) {
                    final_num[4]++;
                } else if (sc.getFinal_exam() >= 80) {
                    final_num[3]++;
                } else if (sc.getFinal_exam() >= 70) {
                    final_num[2]++;
                } else if (sc.getFinal_exam() >= 60) {
                    final_num[1]++;
                } else {
                    final_num[0]++; }

                if (sc.getExperiment()>=90){exp_num[4]++;}
                else if (sc.getExperiment()>=90){exp_num[3]++;}
                else if (sc.getExperiment()>=90){exp_num[2]++;}
                else if (sc.getExperiment()>=90){exp_num[1]++;}
                else {exp_num[0]++;}

                if (sc.getTotal_remark()>=90){total_num[4]++;}
                else if (sc.getTotal_remark()>=80){total_num[3]++;}
                else if (sc.getTotal_remark()>=70){total_num[2]++;}
                else if (sc.getTotal_remark()>=60){total_num[1]++;}
                else {total_num[0]++;}
            }
            model.addAttribute("daily",Arrays.asList(daily_num));
            model.addAttribute("mid",Arrays.asList(mid_num));
            model.addAttribute("fin",Arrays.asList(final_num));
            model.addAttribute("exp",Arrays.asList(exp_num));
            model.addAttribute("total",Arrays.asList(total_num));
            return "/administrator/analysis";


        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        model.addAttribute("message","未知错误");
        return "/common/error";
    }

    @RequestMapping(value = "/getmessage",method = RequestMethod.GET)
    public String getmessage(@RequestParam("key") String key,Model model,HttpSession session) {
        if (!isLogin(session,key))
        {
            model.addAttribute("message","登录时间过期,请重新登录");
            return "/common/error";
        }

        List messagelist = new ArrayList();
        MessagesDao dao = new MessagesDao();
        TeachinfoDao td = new TeachinfoDao();
        StuinfoDao sd = new StuinfoDao();
        List<Messages> mes ;
        try {
            mes = dao.searchMessage();
            for(Messages data:mes)
            {
                List line = new ArrayList<>();
                line.add(data.getFrom_id());
                line.add(sd.searchSingleStuinfo(data.getFrom_id()).getName());
                line.add(data.getMessage());
                line.add(td.searchSingleTeachinfo(data.getTo_id()).getT_name());
                messagelist.add(line);
            }
            model.addAttribute("list",messagelist);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<String> title = new ArrayList<>();
        title.add("学号");
        title.add("学生姓名");
        title.add("反馈信息");
        title.add("反馈老师");
        model.addAttribute("grade",0);
        model.addAttribute("course",0);
        model.addAttribute("table_js","table_message.js");
        model.addAttribute("title",title);
        model.addAttribute("page","getmessage");
        model.addAttribute("base_url","super");
        return "/administrator/index";
    }

}
