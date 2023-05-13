function dispatch(teacher_id,apply_id){
    window.location = "TeacherApprove.jsp?" + "teacher_id=" + teacher_id + "&" + "apply_id=" + apply_id ;
}
function approve(teacher_id){
    const desturl = "ShowAllApprove.jsp?" + "teacher_id=" + teacher_id + "&" + "page=" + 1
    window.location.href = desturl;
}
