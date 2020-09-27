package com.example.test.serviceImpl;
import com.example.test.bean.Manages;
import com.example.test.mapper.ManageServiceMapper;
import com.example.test.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ManageServiceImpl implements ManageService {

    @Autowired
    ManageServiceMapper manageServiceDaoA;


    @Override
    public void updateImgPath(Manages manages) {

        manageServiceDaoA.updateA(manages);
    }

    @Override
    public List<Manages> selectcc() {
         List<Manages>    managesList= manageServiceDaoA.selectA();

        return managesList;
    }


    @Override
    public void updateBlank(Manages manages) {
        manageServiceDaoA.updateA(manages);
    }
}
