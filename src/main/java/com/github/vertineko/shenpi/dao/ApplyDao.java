package com.github.vertineko.shenpi.dao;

import com.github.vertineko.shenpi.model.Apply;

public interface ApplyDao {
    public void addApply(Apply apply);
    public Apply getApply(int course_id , int user_id);
}
