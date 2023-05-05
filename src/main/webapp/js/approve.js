const approve = async(course_id,user_id) => {
    const reason = (String)(document.getElementById("reason").value)
    const data = new FormData()
    data.set("course_id",course_id)
    data.set("user_id",user_id)
    data.set("reason",reason)
    const res = await fetch("ApplyServlet",{
        method:"post",
        body:new URLSearchParams(data),
    })
    const response = await res.json();
    if(response.flag){
        alert("申请已提交！")
        //window.location = "usermenu.jsp"
    }else {
        alert("你已有该课程的申请正在审批中，请不要重复申请！")
    }


}
