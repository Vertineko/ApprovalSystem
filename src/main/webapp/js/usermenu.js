function approve(id){
    const course_id = id;
    const desturl = "approve.jsp?" + "course_id=" + course_id;
    window.location = desturl;
}
function check(apply_id){
    const desturl = "details.jsp?" + "apply_id=" + apply_id;
    window.location = desturl;
}

