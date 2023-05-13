const approve = async(course_id,user_id) => {
    const reason = (String)(document.getElementById("reason").value)
    const file = document.getElementById("file").files[0]
    console.log(file)
    const data1 = new FormData()
    data1.set("course_id",course_id)
    data1.set("user_id",user_id)
    data1.set("reason",reason)
    const res1 = await fetch("ApplyServlet",{
        method:"post",
        body:new URLSearchParams(data1),
    })
    const response1 = await res1.json()
    if(response1.flag){
        const apply_id = response1.id
        console.log(apply_id)
        const data2 = new FormData()
        data2.set("apply_id",apply_id)
        data2.set("file",file)
        const res2 = await fetch("UploadServlet",{
            method:"post",
            body:data2,
        })
        const response2 = await res2.json()
        if(response2.flag){
            alert("申请已提交！")
            window.location = "adminmenu.jsp"
        }else{
            alert("提交文件过大！")
        }

    }else {
        alert("该学生已有该课程的申请正在审批中，请不要重复申请！即将回到选课界面。")
        window.location = "AdminCre.jsp?" + "id=" + user_id
    }


}