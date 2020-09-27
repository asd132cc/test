
package com.example.test.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.test.bean.PermissionTable;
import com.example.test.mapper.PermissionTableMapper;

import com.example.test.service.PermissionTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PermissionTableServiceImpl extends ServiceImpl<PermissionTableMapper, PermissionTable> implements PermissionTableService {
    @Resource
    PermissionTableMapper permissionTableDao;


   //查询权限
    @Override
    public PermissionTable selectPermissionByUserName(String userName) {
        QueryWrapper<PermissionTable> queryWrapper=new QueryWrapper<PermissionTable>()
                .eq("user_name",userName)
                .eq("deletedId" ,0);
        PermissionTable permissionTable= permissionTableDao.selectOne(queryWrapper);
        return permissionTable;
    }

    @Override
    public String insertPermissionTable(PermissionTable permissionTable) {
        // 格式化日期月日小时分钟秒
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        String s = sdf.format(d);
        permissionTable.setUpdateTime(s);
        permissionTable.setDeletedId(0);
        try {
            permissionTableDao.insert(permissionTable);
            return "1";
        }catch (Exception e){
            e.printStackTrace();
            return "0";
        }
    }

    @Override
    public List<PermissionTable> selectPermission() {
        QueryWrapper<PermissionTable> queryWrapper=new QueryWrapper<PermissionTable>()
                .eq("deletedId",0);
       List<PermissionTable> permissionTableList=permissionTableDao.selectList(queryWrapper);
       return  permissionTableList;

    }

    @Override
    public List<PermissionTable> selectPermissionByLimit(String s1,String k ) {
      List<PermissionTable>  permissionTableList= permissionTableDao.selectPermissionByLimit(0, s1,k);

          return permissionTableList;
    }

    @Override
    public String updatePermission(PermissionTable permissionTable) {
        // 格式化日期月日小时分钟秒
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        String s = sdf.format(d);
        permissionTable.setUpdateTime(s);
        String flag="0";
        try {
            permissionTableDao.updateById(permissionTable);
            flag="1";
        }catch(Exception e){
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public String delPermission(PermissionTable permissionTable) {
        String flag="0";
        UpdateWrapper<PermissionTable> updateWrapper=new UpdateWrapper<PermissionTable>()
                .set("deletedId",1)
                .eq("id",permissionTable.getId());
        try {
          permissionTableDao.update(null,updateWrapper);
            flag="1";
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public PermissionTable selectFromUserNameAndPassWord(String userName, String passWord) {

        List<PermissionTable>  permissionTable =permissionTableDao.selectPermission(userName,passWord,0);
        return permissionTable.get(0);
    }
}
