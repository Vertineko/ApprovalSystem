function approve(course_id,user_id){
    const desturl = "AdminApply.jsp?" + "course_id=" + course_id + "&" + "user_id=" + user_id;
    window.location = desturl;
}