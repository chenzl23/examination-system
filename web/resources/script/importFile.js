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

    $("#btnChooseFile").click(function(){
        $("#file").click();
    })
    $("#file").change(function(){
        $("#URLText").val(this.value);
    })





    $("#btnConfirmAttendScore").click(function(){
        if(true) //URL存在并且文件内容格式正确
        {
            //TODO:后端录入文本框中的考勤情况Excel文件
            alert("导入考勤情况成功");
        }
    })

    $("#btnConfirmOrdinaryScore").click(function(){
        if(true) //URL存在并且文件内容格式正确
        {
            //TODO:后端录入文本框中的平时成绩Excel文件
            alert("导入平时成绩成功");
        }
    })

    $("#btnConfirmExperimentScore").click(function(){
        if(true) //URL存在并且文件内容格式正确
        {
            //TODO:后端录入文本框中的实验成绩Excel文件
            alert("导入实验成绩成功");
        }
    })

    $("#btnConfirmMidTestScore").click(function(){
        if(true) //URL存在并且文件内容格式正确
        {
            //TODO:后端录入文本框中的期中成绩Excel文件
            alert("导入期中成绩成功");
        }
    })

    $("#btnConfirmFinalExamScore").click(function(){
        if(true) //URL存在并且文件内容格式正确
        {
            //TODO:后端录入文本框中的期末成绩Excel文件
            alert("导入期末成绩成功");
        }
    })


    

})
