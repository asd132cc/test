package com.example.test.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.test.bean.PermissionTable;
import org.apache.ibatis.annotations.Param;



import java.util.List;

public interface PermissionTableMapper extends BaseMapper<PermissionTable> {
    List<PermissionTable> selectPermissionByLimit(@Param("deletedId")Integer deletedId,
                                                                 @Param("currPage") String currPage,
                                                                 @Param("pageSize") String pageSize);

    PermissionTable selectPermission(@Param("userName")String userName,@Param("password")String passWord);
}