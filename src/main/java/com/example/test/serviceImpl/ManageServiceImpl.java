package com.example.test.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.test.bean.Manages;
import com.example.test.mapper.ManageServiceDao;
import com.example.test.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    ManageServiceDao manageServiceDao;



    @Override
    public void updateImgPath(Manages manages) {
        UpdateWrapper<Manages> managesUpdateWrapper=new UpdateWrapper<Manages>()
                .set("solving_doubts",manages.getSolvingDoubts())
                .eq("id",manages.getId());
        manageServiceDao.update(null,managesUpdateWrapper);
    }

    @Override
    public List<Manages> selectAll() {
        QueryWrapper<Manages> queryWrapper=new QueryWrapper<Manages>();
         List<Manages>    managesList= manageServiceDao.selectList(queryWrapper);

        return managesList;
    }


    @Override
    public void updateBlank(Manages manages) {
        UpdateWrapper<Manages> managesUpdateWrapper=new UpdateWrapper<Manages>()
                .set("blank",manages.getBlank())
                .eq("id",manages.getId());
        manageServiceDao.update(null,managesUpdateWrapper);
    }
}
