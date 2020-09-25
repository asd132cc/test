package com.example.test.controller;


import com.example.test.annotation.LoginAuthorization;
import com.example.test.bean.PermissionTable;
import com.example.test.service.PermissionTableService;
import com.ssm.controller.vo.LayuiReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProductPermissionsController {
@Autowired
PermissionTableService permissionTableService;


    //添加权限
    @LoginAuthorization(value = LoginAuthorization.backgoundusername)
    @RequestMapping(value="/insert_permission",method= RequestMethod.POST)
    public String insert_permission(HttpSession session, PermissionTable permissionTable){
       String userName = (String) session.getAttribute("userName");
       String flag;

          PermissionTable permissionTable1=permissionTableService.selectPermissionByUserName(userName);
          if(permissionTable1!=null){
              flag ="3";
              return flag;
          }

          if(permissionTable1.getY().equals("0")){
              flag="0";
              return flag;
          }
           permissionTable.setUpdatePerson(userName);
           flag=permissionTableService.insertPermissionTable(permissionTable);

        return flag;
    }
    //查询权限
    @LoginAuthorization(value = LoginAuthorization.backgoundusername)
    @RequestMapping(value="/select_permissions",method= RequestMethod.GET)
    @ResponseBody
    public LayuiReturn<PermissionTable> select_permissions(HttpSession session, @RequestParam(value = "page", required = false) Integer currPage,
                                                           @RequestParam(value = "limit", required = false) Integer pageSize){
        String userName = (String) session.getAttribute("userName");
        PermissionTable   permissionTable1=permissionTableService.selectPermissionByUserName(userName);
        if(permissionTable1.getY().equals("0")){
            return  LayuiReturn.convert(0,null);
        }
        //查询分页
       List<PermissionTable> permissionTableList=
               permissionTableService.selectPermissionByLimit(pageSize*(currPage-1)+"",pageSize+"");
        //查询所有个数
        List<PermissionTable> permissionTableList2= permissionTableService.selectPermission();
        int count=permissionTableList2.size();
        return LayuiReturn.convert(count,permissionTableList);
    }


    //修改权限
    @LoginAuthorization(value = LoginAuthorization.backgoundusername)
    @RequestMapping(value="/update_permission",method=RequestMethod.POST)
    public String update_permission(HttpSession session,PermissionTable permissionTable){
        String userName = (String) session.getAttribute("userName");
        String flag;
        PermissionTable   permissionTable1=permissionTableService.selectPermissionByUserName(userName);
        if(permissionTable1.getY().equals("0")){
            flag="0";
            return flag;
        }
        permissionTable.setUpdatePerson(userName);
        flag=permissionTableService.updatePermission(permissionTable);
        return flag;
    }
   //删除权限
   @LoginAuthorization(value = LoginAuthorization.backgoundusername)
    @RequestMapping(value="/del_permission",method=RequestMethod.POST)
    public String del_permission(HttpSession session,PermissionTable permissionTable){
        String userName = (String) session.getAttribute("userName");
        String flag;
        PermissionTable   permissionTable1=permissionTableService.selectPermissionByUserName(userName);
        if(permissionTable1.getY().equals("0")){
            flag="0";
            return flag;
        }
        permissionTable.setUpdatePerson(userName);
        flag=permissionTableService.delPermission(permissionTable);
        return flag;

    }
//登入
    @RequestMapping(value="/loginIn",method = RequestMethod.POST)

    public String loginINc( @RequestParam("userName") String userName,
                          @RequestParam("password") String passWord,HttpSession session){
          session.removeAttribute("userName");
          PermissionTable permissionTable=permissionTableService.selectFromUserNameAndPassWord(userName,passWord);
         if(permissionTable!=null){
             session.setAttribute("userName",userName);
             return "success";
         }else{
             return "0";
         }
    }


}
