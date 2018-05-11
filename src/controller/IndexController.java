package controller;

import dao.StuinfoDao;
import helper.KeyGenerator;
import model.Stuinfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

//用于分配路由与确认身份
@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping(value="",method = RequestMethod.GET)
    public ModelAndView index(Model model, HttpSession session){
        if (session.getAttribute("username") == null)
        {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("/common/error");
            mav.addObject("message","你还未登录");
            return mav;
        }
        ModelMap mmap = new ModelMap();
        //超级管理员重定向
        String key = KeyGenerator.createKey((Integer)session.getAttribute("role"));
        session.setAttribute("key",key);
        if ((Integer)session.getAttribute("role") == 1)
        {

            mmap.addAttribute("key",key);
            return new ModelAndView("redirect:/super/index",mmap);
        }
        else if ((Integer)session.getAttribute("role") == 2)
        {
            mmap.addAttribute("key",key);
            return new ModelAndView("redirect:/teacher/index",mmap);
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/common/error");
        mav.addObject("message","非法操作");
        return mav;
    }

    @RequestMapping(value="/importStudentInfo",method = RequestMethod.GET)
    public ModelAndView importStudentInfo(Model model, HttpSession session){
        if (session.getAttribute("username") == null)
        {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("/common/error");
            mav.addObject("message","你还未登录");
            return mav;
        }
        ModelMap mmap = new ModelMap();
        //超级管理员重定向
        String key = KeyGenerator.createKey((Integer)session.getAttribute("role"));
        session.setAttribute("key",key);
        if ((Integer)session.getAttribute("role") == 1)
        {

            mmap.addAttribute("key",key);
            return new ModelAndView("redirect:/super/importStudentInfo",mmap);
        }
        else if ((Integer)session.getAttribute("role") == 2)
        {
            mmap.addAttribute("key",key);
            return new ModelAndView("redirect:/teacher/importStudentInfo",mmap);
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/common/error");
        mav.addObject("message","非法操作");
        return mav;
    }

    @RequestMapping(value="/studentAttendScore",method = RequestMethod.GET)
    public ModelAndView studentAttendScore(Model model, HttpSession session){
        if (session.getAttribute("username") == null)
        {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("/common/error");
            mav.addObject("message","你还未登录");
            return mav;
        }
        ModelMap mmap = new ModelMap();
        //超级管理员重定向
        String key = KeyGenerator.createKey((Integer)session.getAttribute("role"));
        session.setAttribute("key",key);
        if ((Integer)session.getAttribute("role") == 1)
        {

            mmap.addAttribute("key",key);
            return new ModelAndView("redirect:/super/studentAttendScore",mmap);
        }
        else if ((Integer)session.getAttribute("role") == 2)
        {
            mmap.addAttribute("key",key);
            return new ModelAndView("redirect:/teacher/studentAttendScore",mmap);
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/common/error");
        mav.addObject("message","非法操作");
        return mav;
    }
}
