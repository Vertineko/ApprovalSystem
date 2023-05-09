function modify_stu(id){
    window.location = "modifystu.jsp?" + "id=" + id;
}

const deletestu = async(id) =>{
    const data = new FormData()
    data.set("id",id)
    const res = await fetch("DeletestuServlet",{
        method:"post",
        body: new URLSearchParams(data)
    })
    const response = await res.json()
    if(response.flag){
        alert("删除成功！")
        window.location.reload()
    }else {
        alert("删除失败！该用户已不存在！")
        window.location.reload()
    }
}
function addstu(){
    window.location = "Addstu.jsp"
}

function create(id){
    window.location = "AdminCre.jsp?" + "id=" + id
}







const deletetch = async(id) =>{
    const data = new FormData()
    data.set("id",id)
    const res = await fetch("DeletetchServlet",{
        method:"post",
        body: new URLSearchParams(data)
    })
    const response = await res.json()
    if(response.flag){
        alert("删除成功！")
        window.location.reload()
    }else {
        alert("删除失败！该用户已不存在！")
        window.location.reload()
    }
}
function modify_tch(id){
    window.location = "modifytch.jsp?" + "id=" + id;
}
function addtch(){
    window.location = "Addtch.jsp"
}






const deleteadm = async(id) =>{
    const data = new FormData()
    data.set("id",id)
    const res = await fetch("DeleteadmServlet",{
        method:"post",
        body: new URLSearchParams(data)
    })
    const response = await res.json()
    if(response.flag){
        alert("删除成功！")
        window.location.reload()
    }else {
        alert("删除失败！该用户已不存在！")
        window.location.reload()
    }
}
function modify_adm(id){
    window.location = "modifyadm.jsp?" + "id=" + id;
}
function addadm(){
    window.location = "Addadm.jsp"
}