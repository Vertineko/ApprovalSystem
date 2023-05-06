const approve = async(pass,teacher_id,apply_id,role) =>{
    const data = new FormData()
    const note = document.getElementById("note").value
    if(pass == 0){
        if(note == ""){
            alert("拒绝申请时，备注一栏不能为空!")
            return
        }else{
            data.set("pass",pass)
            data.set("teacher_id",teacher_id)
            data.set("apply_id",apply_id)
            data.set("role",role)
            data.set("note",note)
            const res = await fetch("ApproveServlet",{
                method:"post",
                body:new URLSearchParams(data)
            })
            const response = await res.json()
            if(response.flag){
                alert("已同意该申请！")
            }else {
                alert("已驳回该申请！")
            }
            window.location = "TeacherMenu.jsp"
        }







    }else{
        data.set("pass",pass)
        data.set("teacher_id",teacher_id)
        data.set("apply_id",apply_id)
        data.set("role",role)
        const res = await fetch("ApproveServlet",{
            method:"post",
            body:new URLSearchParams(data)
        })
        const response = await res.json()
        if(response.flag){
            alert("已同意该申请！")
        }else {
            alert("已驳回该申请！")
        }
        window.location = "TeacherMenu.jsp"
    }

}