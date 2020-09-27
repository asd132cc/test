package com.example.test.mapper;




import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.example.test.bean.Manages;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface ManageServiceMapper extends BaseMapper<Manages> {
    List<Manages> selectA();

    void updateA(@Param("Manages") Manages manages);

}
