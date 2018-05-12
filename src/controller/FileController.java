package controller;

import helper.ImportExcelUtil;
import model.Stuinfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import service.StuinfoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping(value="/upload")
public class FileController {

    @RequestMapping(value="/stuinfo",method=RequestMethod.POST)
    @ResponseBody
    public  String  uploadExcel(HttpServletRequest request,HttpServletResponse response) {
        try {
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            System.out.println("通过传统方式form表单提交方式导入excel文件！");

            InputStream in = null;
            List<List<Object>> listob = null;
            MultipartFile file = multipartRequest.getFile("file");
            if (file.isEmpty()) {
                throw new Exception("文件不存在！");
            }
            in = file.getInputStream();
            listob = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
            in.close();

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
                stu.setMajor(String.valueOf(lo.get(5)));
                System.out.println(stu.getMajor());
                stu.setEnrollyear(Integer.valueOf(lo.get(6).toString()));
                System.out.println(stu.getEnrollyear());

                stu.setCredit_got(Double.valueOf(lo.get(7).toString()));
                System.out.println(stu.getCredit_got());

                stu.setCredit_need(Double.valueOf(lo.get(8).toString()));
                System.out.println(stu.getCredit_need());

            }

            return "result";
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "false";
    }

    @RequestMapping("/stuinfo2")
    @ResponseBody
    public void uploadExcelModel(HttpServletRequest request,HttpServletResponse response) throws Exception {
        //开始上传excel
        System.out.println("开始上传文件");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("file");
        String sourceName = multipartFile.getOriginalFilename(); // 原始文件名
        Long size = multipartFile.getSize();
        String fileType = sourceName.substring(sourceName.lastIndexOf("."));
        System.out.println("上传的文件名为:"+sourceName+"类型为:"+fileType+"大小："+size);
        String base = request.getSession().getServletContext().getRealPath("/upload//");  //获取文件上传的路径，在webapp下的upload中
        File file = new File(base);
        if(!file.exists()){
            file.mkdirs();
        }
        String path=base + File.separator + sourceName;
        multipartFile.transferTo(new File(path));

    }
}
