$(document).ready(function(){
    $("#menu ul li ul").hide();
    $("#chosenPage").parent().show();
    if($("#chosenPage").parent().attr("class")=="third_menu"){
        $("#chosenPage").parent().parent().parent().show();
    }
    $("#chosenPage a").addClass("chosenMenu");
    $("#menu ul.first_menu li a").click(function(){
        $(this).parent().siblings().find("ul").slideUp("normal");
        $(this).parent().find("ul.second_menu").slideToggle("normal");
    })
    $("#menu ul.first_menu li ul.second_menu li a").click(function(){
        $(this).parent().siblings().find("ul").slideUp("normal");
        $(this).parent().find("ul.third_menu").slideToggle("normal");
    })
    $("#btnLogout").click(function(){
        var r=confirm("是否退出当前账号");
        if (r==true) 
        {
            //TODO:取消Session
            $.ajax({
                type: "POST",
                dataType: "json",
                url:"/user/logout",
                data: {},
                success: function (data) {
                    if (data.state == "true")
                    {
                        window.location.href="/login.html";
                    }
                    else
                    {
                        alert("注销失败");
                    }
                }
            });
            window.location.href="../../login.html";
            //window.location.replace("../../login.html");
        }
    })
    

    $("#btnConfirm").click(function(){
        if(true) //TODO:后端判断学期和课程
        { 
            //TODO:加载学生信息
            $("#stuInfo").show();
        }
    })
    $("#btnSelectStu").click(function(){
        if(true) //TODO:后端判断是否有该学生
        {
            window.open("./studentInfo.html");
        }
    })
    $("#btnRefresh").click(function(){
        //TODO:重新加载学生信息
    })


    $("#stuAttendScore").hide();
    $("#btnConfirmAttendScore").click(function(){
        if(true) //TODO:后端判断学期和课程
        { 
            //TODO:加载学生考勤
            $("#stuAttendScore").show();
        }
    })
    $("#btnSelectStuAttendScore").click(function(){
        if(true) //TODO:后端判断是否有该学生
        {
            window.open("./studentAttendScoreModify.html");
        }
    })
    $("#btnRefreshAttendScore").click(function(){
        //TODO:重新加载学生考勤
    })

    $("#stuOrdinaryScore").hide();
    $("#btnConfirmOrdinaryScore").click(function(){
        if(true) //TODO:后端判断学期和课程
        { 
            //TODO:加载学生考勤
            $("#stuOrdinaryScore").show();
        }
    })
    $("#btnSelectStuOrdinaryScore").click(function(){
        if(true) //TODO:后端判断是否有该学生
        {
            window.open("./studentOrdinaryScoreModify.html");
        }
    })
    $("#btnRefreshOrdinaryScore").click(function(){
        //TODO:重新加载学生考勤
    })


    $("#stuExperimentScore").hide();
    $("#btnConfirmExperimentScore").click(function(){
        if(true) //TODO:后端判断学期和课程
        { 
            //TODO:加载实验成绩
            $("#stuExperimentScore").show();
        }
    })
    $("#btnSelectStuExperimentScore").click(function(){
        if(true) //TODO:后端判断是否有该学生
        {
            window.open("./studentExperimentScoreModify.html");
        }
    })
    $("#btnRefreshExperimentScore").click(function(){
        //TODO:重新加载实验成绩
    })


    $("#stuMidTestScore").hide();
    $("#btnConfirmMidTestScore").click(function(){
        if(true) //TODO:后端判断学期和课程
        { 
            //TODO:加载期中成绩
            $("#stuMidTestScore").show();
        }
    })
    $("#btnSelectStuMidTestScore").click(function(){
        if(true) //TODO:后端判断是否有该学生
        {
            window.open("./studentMidTestScoreModify.html");
        }
    })
    $("#btnRefreshMidTestScore").click(function(){
        //TODO:重新加载期中成绩
    })


    $("#stuFinalExamScore").hide();
    $("#btnConfirmFinalExamScore").click(function(){
        if(true) //TODO:后端判断学期和课程
        { 
            //TODO:加载期末成绩
            $("#stuFinalExamScore").show();
        }
    })
    $("#btnSelectStuFinalExamScore").click(function(){
        if(true) //TODO:后端判断是否有该学生
        {
            window.open("./studentFinalExamScoreModify.html");
        }
    })
    $("#btnRefreshFinalExamScore").click(function(){
        //TODO:重新加载期末成绩
    })


    $("#stuTotalScore").hide();
    $("#btnConfirmTotalScore").click(function(){
        if(true) //TODO:后端判断学期和课程
        { 
            //TODO:加载总成绩
            $("#stuTotalScore").show();
        }
    })
    $("#btnSelectStuTotalScore").click(function(){
        if(true) //TODO:后端判断是否有该学生
        {
            window.open("./studentTotalScoreModify.html");
        }
    })
    $("#btnRefreshTotalScore").click(function(){
        //TODO:重新加载总成绩
    })
    $("#btnExportTotalScore").click(function(){
        //TODO:返回总成绩表格文件，在浏览器选择路径并下载
        alert("导出单科总成绩成功");
    })
    
})
