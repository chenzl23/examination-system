$(document).ready(function(){
    $("#modify").click(function(){
        window.location.href="studentInfoModify.html";
    })
    $("#delete").click(function(){
        var r=confirm("是否从该课程删除该学生");
        if (r==true)
        {
            //TODO:后端删除该学生与该课程的联系
            alert("删除成功");
            window.close();
        }
    })

    $("#confirmModify").click(function(){
        var r=confirm("是否确认修改");
        if (r==true)
        {
            //TODO:后端修改该学生信息
            alert("修改成功");
            window.location.href="studentInfo.html";
        }
    })
    $("#cancelModify").click(function(){
        window.location.href="studentInfo.html";
    })


    $("#confirmModifyAttendScore").click(function(){
        var r=confirm("是否确认修改");
        if (r==true)
        {
            //TODO:后端修改该学生考勤
            alert("修改成功");
            window.location.href="studentAttendScoreModify.html";
        }
    })
    $("#cancelModifyAttendScore").click(function(){
        window.close();
    })


    $("#confirmModifyOrdinaryScore").click(function(){
        var r=confirm("是否确认修改");
        if (r==true)
        {
            //TODO:后端修改该平时成绩
            alert("修改成功");
            window.location.href="studentOrdinaryScoreModify.html";
        }
    })
    $("#cancelModifyOrdinaryScore").click(function(){
        window.close();
    })

    $("#confirmModifyExperimentScore").click(function(){
        var r=confirm("是否确认修改");
        if (r==true)
        {
            //TODO:后端修改该实验成绩
            alert("修改成功");
            window.location.href="studentExperimentScoreModify.html";
        }
    })
    $("#cancelModifyExperimentScore").click(function(){
        window.close();
    })

    $("#confirmModifyMidTestScore").click(function(){
        var r=confirm("是否确认修改");
        if (r==true)
        {
            //TODO:后端修改该期中成绩
            alert("修改成功");
            window.location.href="studentMidTestScoreModify.html";
        }
    })
    $("#cancelModifyMidTestScore").click(function(){
        window.close();
    })


    $("#confirmModifyFinalExamScore").click(function(){
        var r=confirm("是否确认修改");
        if (r==true)
        {
            //TODO:后端修改该期末成绩
            alert("修改成功");
            window.location.href="studentFinalExamScoreModify.html";
        }
    })
    $("#cancelModifyFinalExamScore").click(function(){
        window.close();
    })

    $("#confirmModifyTotalScore").click(function(){
        var r=confirm("是否确认修改");
        if (r==true)
        {
            //TODO:后端修改该总成绩和重新排名
            alert("修改成功");
            window.location.href="studentTotalScoreModify.html";
        }
    })
    $("#cancelModifyTotalScore").click(function(){
        window.close();
    })


})