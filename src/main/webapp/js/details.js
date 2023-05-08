const configure = async(apply_id,status) =>{
    if(status != 'FAILED' && status != "PROCESSING_STAGE2"){
        alert("当前申请未完成，暂不可确认！")
        return
    }
    const data = new FormData()
    data.set("apply_id",apply_id)
    const res = await fetch("ConfigureServlet",{
        method:"post",
        body: new URLSearchParams(data)
    })
    const response = await res.json()
    if(response.flag){
        alert("确认完成！")
        window.location = "usermenu.jsp"
    }else {
        alert("确认失败！该申请已完成或不存在！")
        window.location = "usermenu.jsp"
    }


}
function back(){
    window.location = "usermenu.jsp"
}

