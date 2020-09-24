package com.example.test.controller;

import com.ssm.controller.vo.LayuiReturn;
import com.ssm.entity.PermissionTable;
import com.ssm.entity.ProductManages;
import com.ssm.service.PermissionTableService;
import com.ssm.service.ProductManagesService;
import com.ssm.service.SubjectProductTableService;
import com.ssm.service.SubjectShaftTableService;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class QueryAuthorityController {
    @Autowired
    PermissionTableService permissionTableService;
    @Autowired
    ProductManagesService productManagesService;


//登入后
    @RequestMapping("/select_AllFrom_permission")
    public LayuiReturn<ProductManages> select_AllFrom_permission(HttpSession session, @RequestParam(value = "page", required = false) Integer currPage,
                                                                 @RequestParam(value = "limit", required = false) Integer pageSize){
        String userName= (String) session.getAttribute("userName");
        PermissionTable   permissionTable1=permissionTableService.selectPermissionByUserName(userName);
        List<ProductManages> productManagesList=productManagesService.selectpermissionByLimit(permissionTable1,
                pageSize*(currPage-1)+"",pageSize+"");
        int count=productManagesService.selectpermissionCount();
       return  LayuiReturn.convert(count,productManagesList);

    }
//登入前
@RequestMapping("/select_AllFirst")
public LayuiReturn<ProductManages> select_AllFirst(HttpSession session, @RequestParam(value = "page", required = false) Integer currPage,
                                                             @RequestParam(value = "limit", required = false) Integer pageSize){
    List<ProductManages> productManagesList=productManagesService.selectpermissionByLimitFirst(
            pageSize*(currPage-1)+"",pageSize+"");
    int count=productManagesService.selectpermissionCount();
    return  LayuiReturn.convert(count,productManagesList);

}



    //修改基础信息
    @RequestMapping(value="/update_AllFrom_permissionA",method = RequestMethod.POST)
    public String update_AllFrom_permissionA(HttpSession session,ProductManages productManages){
        String userName= (String) session.getAttribute("userName");
        PermissionTable   permissionTable1=permissionTableService.selectPermissionByUserName(userName);
        String flag=productManagesService.updatepermissionA(permissionTable1,productManages);

        return  flag;

    }
    //修改条形码
    @RequestMapping(value="/update_AllFrom_permissionB",method = RequestMethod.POST)
    public String update_AllFrom_permissionB(HttpSession session,ProductManages productManages){
        String userName= (String) session.getAttribute("userName");
        PermissionTable   permissionTable1=permissionTableService.selectPermissionByUserName(userName);
        String flag=productManagesService.updatepermissionB(permissionTable1,productManages);

        return  flag;

    }
    //修改新品发布会
    @RequestMapping(value="/update_AllFrom_permissionC",method = RequestMethod.POST)
    public String update_AllFrom_permissionC(HttpSession session,ProductManages productManages){
        String userName= (String) session.getAttribute("userName");
        PermissionTable   permissionTable1=permissionTableService.selectPermissionByUserName(userName);
        String flag=productManagesService.updatepermissionC(permissionTable1,productManages);

        return  flag;

    }
    //修改产销状态
    @RequestMapping(value="/update_AllFrom_permissionD",method = RequestMethod.POST)
    public String update_AllFrom_permissionD(HttpSession session,ProductManages productManages){
        String userName= (String) session.getAttribute("userName");
        PermissionTable   permissionTable1=permissionTableService.selectPermissionByUserName(userName);
        String flag=productManagesService.updatepermissionD(permissionTable1,productManages);

        return  flag;

    }
    //修改报价
    @RequestMapping(value="/update_AllFrom_permissionE",method = RequestMethod.POST)
    public String update_AllFrom_permissionE(HttpSession session,ProductManages productManages){
        String userName= (String) session.getAttribute("userName");
        PermissionTable   permissionTable1=permissionTableService.selectPermissionByUserName(userName);
        String flag=productManagesService.updatepermissionE(permissionTable1,productManages);

        return  flag;

    }

    //修改产品包装信息
    @RequestMapping(value="/update_AllFrom_permissionF",method = RequestMethod.POST)
    public String update_AllFrom_permissionF(HttpSession session,ProductManages productManages){
        String userName= (String) session.getAttribute("userName");
        PermissionTable   permissionTable1=permissionTableService.selectPermissionByUserName(userName);
        String flag=productManagesService.updatepermissionF(permissionTable1,productManages);

        return  flag;

    }
  //新增商品
  @RequestMapping(value="/insert_product",method = RequestMethod.POST)
  public String insert_product(HttpSession session,ProductManages productManages){
      String userName= (String) session.getAttribute("userName");
      PermissionTable   permissionTable1=permissionTableService.selectPermissionByUserName(userName);
      if(permissionTable1.getV().equals("0")){
          return "0";
      }
      productManages.setUpdatePerson(userName);
      String flag=productManagesService.insertProduct(permissionTable1,productManages);
      return  flag;

  }
 //通过品类，型号，主题，国家语言查询(模糊查询，分页)
 @RequestMapping("/select_AllByCategoryModelTypeNationLanguage")
 public LayuiReturn<ProductManages> select_AllByCategoryModelTypeNationLanguage(HttpSession session,
                                                                                @RequestParam("category") String category,
                                                                                @RequestParam("model") String model,
                                                                                @RequestParam("type") String type,
                                                                                @RequestParam("NationLanguage") String NationLanguage,
                                                                                @RequestParam("sku") String sku,
                                                                                @RequestParam(value = "page", required = false) Integer currPage,
                                                                                @RequestParam(value = "limit", required = false) Integer pageSize){
     String userName= (String) session.getAttribute("userName");
     PermissionTable   permissionTable1=permissionTableService.selectPermissionByUserName(userName);
     List<ProductManages> productManagesList=
             productManagesService.selectpermissionByLimitFromCategroyModelTypeNationLanguage(category,
                     model,type,NationLanguage,sku,permissionTable1,
             pageSize*(currPage-1)+"",pageSize+"");
     int count=productManagesService.selectpermissionCountFromCategroyModelTypeNationLanguage(category,
             model,type,NationLanguage,sku);
     return  LayuiReturn.convert(count,productManagesList);

 }
   //删除商品信息
   @RequestMapping(value="/del_product",method = RequestMethod.POST)
   public String del_product(HttpSession session,ProductManages productManages){
       String userName= (String) session.getAttribute("userName");
       PermissionTable   permissionTable1=permissionTableService.selectPermissionByUserName(userName);
       if(permissionTable1.getZ().equals("0")){
           return "0";
       }
       productManages.setUpdatePerson(userName);
       String flag=productManagesService.deletedProduct(permissionTable1,productManages);
       return  flag;

   }
   //导出excel
    @RequestMapping("/put_excel")
    public void put_excel(HttpServletResponse response,
                          HttpSession session,
                          @RequestParam("category") String category,
                          @RequestParam("model") String model,
                          @RequestParam("type") String type,
                          @RequestParam("NationLanguage") String NationLanguage,
                          @RequestParam("sku") String sku) throws IOException {

        String userName= (String) session.getAttribute("userName");
        PermissionTable   permissionTable1=permissionTableService.selectPermissionByUserName(userName);
        SXSSFWorkbook workBook = productManagesService.put_excel(permissionTable1,category,model,type,NationLanguage,sku);
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("shangpingxinxi"+ ".xls",
                "UTF-8"));
        OutputStream ouputStream = response.getOutputStream();
        workBook.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();

    }







}
