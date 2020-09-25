package com.example.test.serviceImpl;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.test.bean.Manages;
import com.example.test.mapper.ManageServiceMapper;
import com.example.test.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
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
        UpdateWrapper<Manages> managesUpdateWrapper=new UpdateWrapper<Manages>()
                .set("blank",manages.getBlank())
                .eq("id",manages.getId());
        manageServiceDaoA.update(null,managesUpdateWrapper);
    }
}
