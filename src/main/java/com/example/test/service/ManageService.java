package com.example.test.service;

import com.example.test.bean.Manages;

import java.util.List;

public interface ManageService {
    void updateImgPath(Manages manages);

    List<Manages> selectAll();

    void updateBlank(Manages manages);
}
