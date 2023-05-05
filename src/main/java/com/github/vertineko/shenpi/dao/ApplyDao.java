package com.github.vertineko.shenpi.dao;

import com.github.vertineko.shenpi.model.Apply;
import org.apache.ibatis.annotations.Param;

public interface ApplyDao {
    public void addApply(Apply apply);
    public Apply getApply(@Param("course_id")int course_id , @Param("user_id")int user_id);
}
