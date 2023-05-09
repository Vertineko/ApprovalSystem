package com.github.vertineko.shenpi.dao;

import com.github.vertineko.shenpi.model.Admin;

import java.util.List;

public interface AdminDao {
    public Admin getAdmin(String username);
    public List<Admin> getAllAdmin();
    public void addAdmin(Admin admin);
    public void modify(Admin admin);
    public void delete(int id);
    public Admin getAdminById(int id);
}
