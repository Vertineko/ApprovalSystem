package com.github.vertineko.shenpi.dao;

import com.github.vertineko.shenpi.model.Admin;

import java.util.List;

public interface AdminDao {
    public Admin getAdmin(String username);
    public List<Admin> getAllAdmin();
}
