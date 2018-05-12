package controller;


import dao.StuinfoDao;
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
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(@RequestParam("key") String key,Model model,HttpSession session)
    {
        if (!key.equals((String)session.getAttribute("key")))
        {
            model.addAttribute("message","非法操作");
            return "/common/error";
        }
        return "/teacher/index";
    }


    @RequestMapping(value = "/importStudentInfo",method = RequestMethod.GET)
    public String importStudentInfo(@RequestParam("key") String key,Model model,HttpSession session)
    {
        if (!key.equals((String)session.getAttribute("key")))
        {
            model.addAttribute("message","非法操作");
            return "/common/error";
        }
        return "/teacher/importStudentInfo";
    }

    @RequestMapping(value = "/studentAttendScore",method = RequestMethod.GET)
    public String studentAttendScore(Model model)
    {
        return "/teacher/studentAttendScor  e";
    }
}
