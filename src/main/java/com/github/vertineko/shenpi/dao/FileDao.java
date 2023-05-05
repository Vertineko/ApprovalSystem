package com.github.vertineko.shenpi.dao;

import com.github.vertineko.shenpi.model.Exfile;

public interface FileDao {
    public void addFile(Exfile file);
    public Exfile getfile(int id);
}
