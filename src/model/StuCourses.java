package model;

public class StuCourses {
    private int sc_id;//选课id
    private int cno;//课程号，引用课程表的id
    private String sno;//学号，引用学生信息表的id
    private String teacher;//任课老师，引用教师表id
    private int term;//学期
    private double daily_work;//平时分
    private double mid_exam;//期中成绩
    private double final_exam;//期末成绩
    private double total_remark;//总评成绩
    private int status;//引用课程状态表的id
    private double experiment;//实验成绩
    private boolean is_experiment;//判断是否有实验成绩部分

    //setters

    public void setSc_id(int sc_id) { this.sc_id = sc_id; }

    public void setCno(int cno) { this.cno = cno; }

    public void setSno(String sno) { this.sno = sno; }

    public void setTeacher(String teacher) { this.teacher = teacher; }

    public void setTerm(int term) { this.term = term; }

    public void setDaily_work(double daily_work) { this.daily_work = daily_work; }

    public void setMid_exam(double mid_exam) { this.mid_exam = mid_exam; }

    public void setFinal_exam(double final_exam) { this.final_exam = final_exam; }

    //总评成绩=0.1*平时分+0.1*期中成绩+0.1*实验成绩+0.7*期末成绩
    public void setTotal_remark() {
        if(is_experiment)
        this.total_remark = daily_work*0.1+mid_exam*0.1+experiment*0.1+final_exam*0.7;
    else{
            this.total_remark = daily_work*0.15+mid_exam*0.15+final_exam*0.7;
            this.experiment=-1;//代表没有实验成绩，和实验成绩=0区分
        }
    }

    public void setStatus(int status) { this.status = status; }

    public void setExperiment(double experiment) { this.experiment = experiment; }

    public void setIs_experiment(boolean is_experiment) { this.is_experiment = is_experiment; }
//getters

    public int getSc_id() { return sc_id; }

    public int getCno() { return cno; }

    public String getSno() { return sno; }

    public String getTeacher() { return teacher; }

    public int getTerm() { return term; }

    public double getDaily_work() { return daily_work; }

    public double getMid_exam() { return mid_exam; }

    public double getFinal_exam() { return final_exam; }

    public double getTotal_remark() { return total_remark; }

    public int getStatus() { return status; }

    public double getExperiment() { return experiment; }

    public boolean getIs_experiment() { return is_experiment; }
}
