package com.example.test.service;

import com.example.test.bean.PermissionTable;
import com.example.test.bean.ProductManages;
import com.example.test.bean.UserBean;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.IOException;
import java.util.List;

public  interface ProductManagesService {


    List<ProductManages> selectpermissionByLimit(PermissionTable permissionTable1, String s, String s1);

    int selectpermissionCount();

    String updatepermissionA(PermissionTable permissionTable1,ProductManages productManages);

    String updatepermissionB(PermissionTable permissionTable1, ProductManages productManages);

    String updatepermissionC(PermissionTable permissionTable1, ProductManages productManages);

    String updatepermissionD(PermissionTable permissionTable1, ProductManages productManages);

    String updatepermissionE(PermissionTable permissionTable1, ProductManages productManages);

    String updatepermissionF(PermissionTable permissionTable1, ProductManages productManages);

    String insertProduct(PermissionTable permissionTable1, ProductManages productManages);

    List<ProductManages> selectpermissionByLimitFirst( String s, String s1);

    List<ProductManages> selectpermissionByLimitFromCategroyModelTypeNationLanguage(String category, String model,
                                                                                    String type,
                                                                                    String nationLanguage,
                                                                                    String sku,
                                                                                    PermissionTable permissionTable1, String s, String s1);

    int selectpermissionCountFromCategroyModelTypeNationLanguage(String category, String model, String type,
                                                                 String nationLanguage, String sku);

    String deletedProduct(PermissionTable permissionTable1, ProductManages productManages);


    SXSSFWorkbook put_excel(PermissionTable permissionTable1, String category, String model, String type, String nationLanguage, String sku) throws IOException;

    List<ProductManages> selectpermissionByLimitFromCategroyModelTypeNationLanguageFirst(String category, String model, String type, String nationLanguage, String sku,
                                                                                         String s, String s1);
}
