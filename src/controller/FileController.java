package controller;

import dao.*;
import helper.ImportExcelUtil;
import model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import service.CourseStausService;
import service.CoursesService;
import service.MajorService;
import service.StuinfoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/upload")
public class FileController {

    @RequestMapping(value="/stuinfo",method=RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> uploadStudentExcel(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            System.out.println("通过传统方式form表单提交方式导入excel文件！");
            InputStream in = null;
            List<List<Object>> listob = null;
            MultipartFile file = multipartRequest.getFile("file");
            if (file.isEmpty()) {
                modelMap.put("state","FileNotFound");
                return modelMap;
            }
            in = file.getInputStream();
            listob = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
            in.close();

            StuinfoDao dao = new StuinfoDao();
            UsersDao ud = new UsersDao();
            int nums = 0;
            //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
            for (int i = 0; i < listob.size(); i++) {
                List<Object> lo = listob.get(i);
                Stuinfo stu = new Stuinfo();
                stu.setId(String.valueOf(lo.get(0)).substring(0,9));
                System.out.println(stu.getId());
                stu.setName(String.valueOf(lo.get(1)));
                System.out.println(stu.getName());
                stu.setBirth(Date.valueOf(lo.get(2).toString()));
                System.out.println(stu.getBirth());
                stu.setTel(String.valueOf(lo.get(3)));
                System.out.println(stu.getTel());
                stu.setEmail(String.valueOf(lo.get(4)));
                System.out.println(stu.getEmail());
                stu.setMajor(String.valueOf(lo.get(5).toString()));
                System.out.println(stu.getMajor());
                stu.setEnrollyear(Integer.valueOf(lo.get(6).toString()));
                System.out.println(stu.getEnrollyear());
                stu.setCredit_got(Double.valueOf(lo.get(7).toString()));
                System.out.println(stu.getCredit_got());
                stu.setCredit_need(Double.valueOf(lo.get(8).toString()));
                System.out.println(stu.getCredit_need());
                //存入数据库
                try{
                    if (dao.searchSingleStuinfo(stu.getId()) == null)
                    {
                        dao.addStuinfo(stu);
                        nums++;
                    }
                    if (ud.searchSingle(stu.getId()) == null)
                    {
                        Users newuser = new Users();
                        newuser.setId(stu.getId());
                        newuser.setPasswd(stu.getId());
                        newuser.setRole_id(3);
                        ud.addUsers(newuser);
                    }
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                    modelMap.put("state","DataBaseError");
                    return modelMap;
                }
                modelMap.put("nums",nums);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            modelMap.put("state","UnknownError");
            return modelMap;
        }
        modelMap.put("state","success");
        return modelMap;
    }

    @RequestMapping(value="/teainfo",method=RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> uploadTeacherExcel(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            System.out.println("通过传统方式form表单提交方式导入excel文件！");
            InputStream in = null;
            List<List<Object>> listob = null;
            MultipartFile file = multipartRequest.getFile("file");
            if (file.isEmpty()) {
                modelMap.put("state","FileNotFound");
                return modelMap;
            }
            in = file.getInputStream();
            listob = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
            in.close();

            TeachinfoDao dao = new TeachinfoDao();
            UsersDao ud = new UsersDao();
            int nums = 0;
            //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
            for (int i = 0; i < listob.size(); i++) {
                List<Object> lo = listob.get(i);
                Teachinfo tea = new Teachinfo();
                tea.setT_id(String.valueOf(lo.get(0)).substring(0,9));
                tea.setT_name(String.valueOf(lo.get(1)));
                tea.setT_birth(Date.valueOf(lo.get(2).toString()));
                tea.setT_tel(String.valueOf(lo.get(3)));
                tea.setT_email(String.valueOf(lo.get(4)));
                MajorService mjs = new MajorService();
                tea.setT_major( mjs.searchMajorIdService(String.valueOf(lo.get(5))).getM_id());
                //存入数据库
                try{
                    if (dao.searchSingleTeachinfo(tea.getT_id()) == null)
                    {
                        dao.addTeachinfo(tea);
                        nums++;
                    }
                    if (ud.searchSingle(tea.getT_id()) == null)
                    {
                        Users newuser = new Users();
                        newuser.setId(tea.getT_id());
                        newuser.setPasswd(tea.getT_id());
                        newuser.setRole_id(2);
                        ud.addUsers(newuser);
                    }
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                    modelMap.put("state","DataBaseError");
                    return modelMap;
                }
                modelMap.put("nums",nums);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            modelMap.put("state","UnknownError");
            return modelMap;
        }
        modelMap.put("state","success");
        return modelMap;
    }

    @RequestMapping(value="/courseinfo",method=RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> uploadCourseExcel(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            System.out.println("通过传统方式form表单提交方式导入excel文件！");
            InputStream in = null;
            List<List<Object>> listob = null;
            MultipartFile file = multipartRequest.getFile("file");
            if (file.isEmpty()) {
                modelMap.put("state","FileNotFound");
                return modelMap;
            }
            in = file.getInputStream();
            listob = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
            in.close();

            CoursesDao dao = new CoursesDao();
            int nums = 0;
            //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
            for (int i = 0; i < listob.size(); i++) {
                List<Object> lo = listob.get(i);
                Courses course = new Courses();
                course.setC_id(Integer.valueOf(lo.get(0).toString()));
                course.setC_name(String.valueOf(lo.get(1)));
                course.setGrade(Integer.valueOf(lo.get(2).toString()));
                course.setCredit(Integer.valueOf(lo.get(3).toString()));
                //存入数据库
                try{
                    if (dao.searchSingleCourse(course.getC_id()) == null)
                    {
                        dao.addCourse(course);
                        nums++;
                    }
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                    modelMap.put("state","DataBaseError");
                    return modelMap;
                }
                modelMap.put("nums",nums);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            modelMap.put("state","UnknownError");
            return modelMap;
        }
        modelMap.put("state","success");
        return modelMap;
    }

    @RequestMapping(value="/coursechosen",method=RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> uploadCourseChosenExcel(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            System.out.println("通过传统方式form表单提交方式导入excel文件！");
            InputStream in = null;
            List<List<Object>> listob = null;
            MultipartFile file = multipartRequest.getFile("file");
            if (file.isEmpty()) {
                modelMap.put("state","FileNotFound");
                return modelMap;
            }
            in = file.getInputStream();
            listob = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
            in.close();

            StuCoursesDao dao = new StuCoursesDao();
            int nums = 0;
            //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
            for (int i = 0; i < listob.size(); i++) {
                List<Object> lo = listob.get(i);
                if (lo.get(0).toString().length() == 0)
                    break;
                StuCourses course = new StuCourses();
                CoursesService cs = new CoursesService();
                course.setSc_id(Integer.valueOf(lo.get(0).toString().substring(0,10)));
                course.setCno(cs.searchCourseByNameService(lo.get(1).toString()).getC_id());
                course.setSno(String.valueOf(lo.get(2)).substring(0,9));
                course.setTerm(Integer.valueOf(lo.get(4).toString()));
                course.setStatus(Integer.valueOf(lo.get(5).toString()));
                course.setTeacher(lo.get(6).toString());
                //存入数据库
                try{
                    if (dao.searchStuCourse(course.getSc_id()) == null)
                    {
                        dao.addStuCourse(course);
                        nums++;
                    }
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                    modelMap.put("state","DataBaseError");
                    return modelMap;
                }
                modelMap.put("nums",nums);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            modelMap.put("state","UnknownError");
            return modelMap;
        }
        modelMap.put("state","success");
        return modelMap;
    }

    @RequestMapping(value="/stumark",method=RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> uploadSutMarkExcel(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            System.out.println("通过传统方式form表单提交方式导入excel文件！");
            InputStream in = null;
            List<List<Object>> listob = null;
            MultipartFile file = multipartRequest.getFile("file");
            if (file.isEmpty()) {
                modelMap.put("state","FileNotFound");
                return modelMap;
            }
            in = file.getInputStream();
            listob = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
            in.close();

            StuCoursesDao dao = new StuCoursesDao();
            int nums = 0;
            //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
            for (int i = 0; i < listob.size(); i++) {
                List<Object> lo = listob.get(i);
                if (lo.get(0).toString().length() == 0)
                    break;
                int scno = Integer.parseInt(lo.get(0).toString().substring(0,10));
                StuCourses course = dao.searchStuCourse(scno);
                course.setDaily_work(Double.parseDouble(lo.get(6).toString()));
                course.setMid_exam(Double.parseDouble(lo.get(7).toString()));
                course.setFinal_exam(Double.parseDouble(lo.get(8).toString()));
                course.setExperiment(Double.parseDouble(lo.get(9).toString()));
                course.setTotal_remark(Double.parseDouble(lo.get(10).toString()));
                //存入数据库
                try{
                    dao.updateStuCourse(course);
                    nums++;
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                    modelMap.put("state","DataBaseError");
                    return modelMap;
                }
            }
            modelMap.put("nums",nums);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            modelMap.put("state","UnknownError");
            return modelMap;
        }
        modelMap.put("state","success");
        return modelMap;
    }
}
