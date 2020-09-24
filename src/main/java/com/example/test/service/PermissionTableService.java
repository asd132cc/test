package com.example.test.service;

import com.example.test.bean.PermissionTable;

import java.util.List;

public interface PermissionTableService {

    //查看Permission
    PermissionTable selectPermissionByUserName(String userName);
    //插入权限
    String insertPermissionTable(PermissionTable permissionTable);
    //查询权限
    List<PermissionTable> selectPermission();
    //查询权限分页
    List<PermissionTable> selectPermissionByLimit(String s1,String k);
    //修改权限
    String updatePermission(PermissionTable permissionTable);
    //删除权限
    String delPermission(PermissionTable permissionTable);
}