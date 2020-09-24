

package com.example.test.serviceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.test.bean.PermissionTable;
import com.example.test.bean.ProductManages;
import com.example.test.mapper.ProductManagesDao;


import com.example.test.service.
        ProductManagesService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProductManagesServiceImpl extends ServiceImpl<ProductManagesDao, ProductManages> implements ProductManagesService {
    @Autowired
    ProductManagesDao productManagesDao;

    //商品信息查询
    @Override
    public List<ProductManages> selectpermissionByLimit(PermissionTable permissionTable1, String s, String s1) {

        List<ProductManages> productManagesList = productManagesDao.selectListByLimit(0,s, s1);
        if (permissionTable1.getA().equals("0")) {
            for (int i = 0; i < productManagesList.size(); i++) {
                productManagesList.get(i).setdRetailPrice("");
            }
        }
        if (permissionTable1.getB().equals("0")) {
            for (int i = 0; i < productManagesList.size(); i++) {
                productManagesList.get(i).setdCoreWholesalePrice("");
                productManagesList.get(i).setdOrdinaryDealersWholesale("");
                productManagesList.get(i).setdSpecialTreatmentWholesale("");
                productManagesList.get(i).setdStandbyWholesalePrice("");
            }
        }
        if (permissionTable1.getC().equals("0")) {
            for (int i = 0; i < productManagesList.size(); i++) {
                productManagesList.get(i).setoRetailPrice("");
            }

        }
        if (permissionTable1.getD().equals("0")) {
            for (int i = 0; i < productManagesList.size(); i++) {
                productManagesList.get(i).setoSTWholesale("");
                productManagesList.get(i).setoGeneralWholesalePrice("");
                productManagesList.get(i).setoCWPrice("");
                productManagesList.get(i).setoReserveWholesale("");
            }
        }

        return productManagesList;
    }

    @Override
    public int selectpermissionCount() {
        QueryWrapper<ProductManages> queryWrapper = new QueryWrapper<ProductManages>()
                .eq("deletedId",0);
        int count = productManagesDao.selectCount(queryWrapper);
        return count;
    }

    //商品信息修改(基础信息)
    @Override
    public String updatepermissionA(PermissionTable permissionTable1, ProductManages productManages) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        String s = sdf.format(d);
        if (permissionTable1.getE().equals("0")) {
            return "0";
        } else {
            UpdateWrapper<ProductManages> updateWrapper = new UpdateWrapper<ProductManages>()
                    .set("category", productManages.getCategory())
                    .set("model", productManages.getModel())
                    .set("type", productManages.getType())
                    .set("nation_language", productManages.getNationLanguage())
                    .set("product_name", productManages.getProductName())
                    .set("imgpath", productManages.getImgpath())
                    .set("sku", productManages.getSku())
                    .set("remake1", productManages.getRemake1())
                    .set("remake2", productManages.getRemake2())
                    .set("update_person", permissionTable1.getUserName())
                    .set("update_time", s)
                    .eq("id", productManages.getId());
            productManagesDao.update(null,updateWrapper);
            return "1";
        }
    }
//修改条形码
    @Override
    public String updatepermissionB(PermissionTable permissionTable1, ProductManages productManages) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        String s = sdf.format(d);
        if (permissionTable1.getE().equals("0")) {
            return "0";
        } else {
            UpdateWrapper<ProductManages> updateWrapper = new UpdateWrapper<ProductManages>()
                    .set("bar_code", productManages.getBarCode())
                    .set("update_person", permissionTable1.getUserName())
                    .set("update_time", s)
                    .eq("id", productManages.getId());
            productManagesDao.update(null,updateWrapper);
            return "1";
        }
    }
//修改新品发布会
    @Override
    public String updatepermissionC(PermissionTable permissionTable1, ProductManages productManages) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        String s = sdf.format(d);
        if (permissionTable1.getE().equals("0")) {
            return "0";
        } else {
            UpdateWrapper<ProductManages> updateWrapper = new UpdateWrapper<ProductManages>()
                    .set("product_launch",productManages.getProductLaunch())
                    .set("update_person", permissionTable1.getUserName())
                    .set("update_time", s)
                    .eq("id", productManages.getId());
            productManagesDao.update(null,updateWrapper);
            return "1";
        }
    }
//修改产销状态
    @Override
    public String updatepermissionD(PermissionTable permissionTable1, ProductManages productManages) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        String s = sdf.format(d);
        if (permissionTable1.getE().equals("0")) {
            return "0";
        } else {
            UpdateWrapper<ProductManages> updateWrapper = new UpdateWrapper<ProductManages>()
                    .set("marketing_status",productManages.getMarketingStatus())
                    .set("update_person", permissionTable1.getUserName())
                    .set("update_time", s)
                    .eq("id", productManages.getId());
            productManagesDao.update(null,updateWrapper);
            return "1";
        }
    }
//修改报价
    @Override
    public String updatepermissionE(PermissionTable permissionTable1, ProductManages productManages) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        String s = sdf.format(d);
        if (permissionTable1.getE().equals("0")) {
            return "0";
        } else {
            UpdateWrapper<ProductManages> updateWrapper = new UpdateWrapper<ProductManages>()
                   .set("d_retail_price",productManages.getdRetailPrice())
                   .set("d_ordinary_dealers_wholesale",productManages.getdOrdinaryDealersWholesale())
                   .set("d_core_wholesale_price",productManages.getdCoreWholesalePrice())
                   .set("d_special_treatment_wholesale",productManages.getdSpecialTreatmentWholesale())
                   .set("d_standby_wholesale_price",productManages.getdStandbyWholesalePrice())
                   .set("o_general_wholesale_price",productManages.getoGeneralWholesalePrice())
                   .set("o_retail_price",productManages.getoRetailPrice())
                   .set("o_c_w_price",productManages.getoCWPrice())
                   .set("o_s_t_wholesale",productManages.getoSTWholesale())
                   .set("o_reserve_wholesale",productManages.getoReserveWholesale())
                   .set("update_person", permissionTable1.getUserName())
                   .set("update_time", s)
                   .eq("id", productManages.getId());
            productManagesDao.update(null,updateWrapper);
            return "1";
        }
    }
//修改产品包装信息
    @Override
    public String updatepermissionF(PermissionTable permissionTable1, ProductManages productManages) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        String s = sdf.format(d);
        if (permissionTable1.getE().equals("0")) {
            return "0";
        } else {
            UpdateWrapper<ProductManages> updateWrapper = new UpdateWrapper<ProductManages>()
                  .set("weight_net",productManages.getWeightNet())
                  .set("gross_weight",productManages.getGrossWeight())
                  .set("single_package_size",productManages.getSinglePackageSize())
                  .set("number_of_large_boxes_delivered",productManages.getNumberOfLargeBoxesDelivered())
                  .set("unit_net_weight",productManages.getUnitNetWeight())
                  .set("unit_gross_weight",productManages.getUnitGrossWeight())
                  .set("package_size_ship",productManages.getPackageSizeShip())
                  .set("update_person", permissionTable1.getUserName())
                  .set("update_time", s)
                  .eq("id", productManages.getId());
            productManagesDao.update(null,updateWrapper);
            return "1";
        }
    }

    @Override
    public String insertProduct(PermissionTable permissionTable1, ProductManages productManages) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        String s = sdf.format(d);
        productManages.setUpdateTime(s);
        productManages.setDeletedId(0);
        try {
            productManagesDao.insert(productManages);
            return "1";
        }catch(Exception e){
            e.printStackTrace();
            return "2";
        }
    }

    @Override
    public List<ProductManages> selectpermissionByLimitFirst( String s, String s1) {
        List<ProductManages> productManagesList = productManagesDao.selectListByLimit(0,s, s1);
            for (int i = 0; i < productManagesList.size(); i++) {
                productManagesList.get(i).setdRetailPrice("");
                productManagesList.get(i).setdCoreWholesalePrice("");
                productManagesList.get(i).setdOrdinaryDealersWholesale("");
                productManagesList.get(i).setdSpecialTreatmentWholesale("");
                productManagesList.get(i).setdStandbyWholesalePrice("");
                productManagesList.get(i).setoRetailPrice("");
                productManagesList.get(i).setoSTWholesale("");
                productManagesList.get(i).setoGeneralWholesalePrice("");
                productManagesList.get(i).setoCWPrice("");
                productManagesList.get(i).setoReserveWholesale("");
            }
        return productManagesList;
    }

    @Override
    public List<ProductManages> selectpermissionByLimitFromCategroyModelTypeNationLanguage(String category,
                                                                                           String model,
                                                                                           String type,
                                                                                           String nationLanguage,
                                                                                           String sku,
                                                                                           PermissionTable permissionTable1, String s, String s1) {

        List<ProductManages> productManagesList =
                productManagesDao.selectListByLimitFromCategroyModelTypeNationLanguage(0,s, s1,category,model,type,
                nationLanguage,sku);
        if (permissionTable1.getA().equals("0")) {
            for (int i = 0; i < productManagesList.size(); i++) {
                productManagesList.get(i).setdRetailPrice("");
            }
        }
        if (permissionTable1.getB().equals("0")) {
            for (int i = 0; i < productManagesList.size(); i++) {
                productManagesList.get(i).setdCoreWholesalePrice("");
                productManagesList.get(i).setdOrdinaryDealersWholesale("");
                productManagesList.get(i).setdSpecialTreatmentWholesale("");
                productManagesList.get(i).setdStandbyWholesalePrice("");
            }
        }
        if (permissionTable1.getC().equals("0")) {
            for (int i = 0; i < productManagesList.size(); i++) {
                productManagesList.get(i).setoRetailPrice("");
            }

        }
        if (permissionTable1.getD().equals("0")) {
            for (int i = 0; i < productManagesList.size(); i++) {
                productManagesList.get(i).setoSTWholesale("");
                productManagesList.get(i).setoGeneralWholesalePrice("");
                productManagesList.get(i).setoCWPrice("");
                productManagesList.get(i).setoReserveWholesale("");
            }
        }

        return productManagesList;

    }

    @Override
    public int selectpermissionCountFromCategroyModelTypeNationLanguage(String category,String model, String type,
                                                                        String nationLanguage,String sku) {

     int count= productManagesDao.selectpermissionCountFromCategroyModelTypeNationLanguage(0,category,model,type,
             nationLanguage,sku);
        return  count;
    }

    @Override
    public String deletedProduct(PermissionTable permissionTable1, ProductManages productManages) {
        UpdateWrapper<ProductManages> updateWrapper=new UpdateWrapper<ProductManages>()
                .set("deletedId",1)
                .eq("id",productManages.getId());
        try{
            productManagesDao.update(null,updateWrapper);
            return "1";
        }catch (Exception e){
            e.printStackTrace();
            return "0";
        }
    }

    @Override
    public SXSSFWorkbook put_excel(PermissionTable permissionTable1, String category, String model, String type,
                                   String nationLanguage, String sku) throws IOException {

        List<ProductManages> productManagesList =
                productManagesDao.selectListByLimitFromCategroyModelTypeNationLanguage2(0,category,model,type,
                        nationLanguage,sku);
        if (permissionTable1.getA().equals("0")) {
            for (int i = 0; i < productManagesList.size(); i++) {
                productManagesList.get(i).setdRetailPrice("");
            }
        }
        if (permissionTable1.getB().equals("0")) {
            for (int i = 0; i < productManagesList.size(); i++) {
                productManagesList.get(i).setdCoreWholesalePrice("");
                productManagesList.get(i).setdOrdinaryDealersWholesale("");
                productManagesList.get(i).setdSpecialTreatmentWholesale("");
                productManagesList.get(i).setdStandbyWholesalePrice("");
            }
        }
        if (permissionTable1.getC().equals("0")) {
            for (int i = 0; i < productManagesList.size(); i++) {
                productManagesList.get(i).setoRetailPrice("");
            }

        }
        if (permissionTable1.getD().equals("0")) {
            for (int i = 0; i < productManagesList.size(); i++) {
                productManagesList.get(i).setoSTWholesale("");
                productManagesList.get(i).setoGeneralWholesalePrice("");
                productManagesList.get(i).setoCWPrice("");
                productManagesList.get(i).setoReserveWholesale("");
            }
        }


        String[] excelHeader = {"序号","品类", "型号", "主题", "国家语言", "市场产品名称", "sku",
                "条形码", "新品发布会","产销状态","单个净重(kg)","单个毛重(kg)","单个包装尺寸(mm)","出货大箱箱入数","出货单位净重(kg)","出货单位毛重(kg)",
                "出货单位包装尺寸","国内零售定价(RMB含税)","国内普通经销商批发价(含税)","国内核心经销商批发价(含税)","国内特别处理批发价(含税)","国内备用批发价(含税)","海外零售定价" +
                "(USD含税)","海外普通经销商批发价(含税)","海外核心经销商批发价(含税)","海外特别处理批发价(含税)","海外备用批发价(含税)","空白备用1","空白备用2","做成日期",
                "更新日期","最后更新人"};
        // 单元格列宽
        int[] excelHeaderWidth = {50,100, 100, 150, 100, 200, 250, 100,150,150,150,150,150,150,150,150,300,300,300,300,
                300,300,300,300,300,300,300,150,150,150,150,150};
        // 创建工作薄对象
        SXSSFWorkbook wb = new SXSSFWorkbook(300);
        //优化,压缩
        wb.setCompressTempFiles(true);
        // 创建项对象
        SXSSFSheet sheet = (SXSSFSheet) wb.createSheet("商品详情");
        // 创建列对象
        SXSSFRow row;

        // 创建样式对象
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setFontName("C39HrP24DhTt");
        font.setFontHeightInPoints((short) 36);
        // 设置样式居中
        style.setFont(font);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 垂直居中
        style.setFillForegroundColor(HSSFColor.RED.index);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框

        // 设置合计样式
        CellStyle style1 = wb.createCellStyle();
        Font font1 = wb.createFont();
        // font.setBoldweight(Font.BOLDWEIGHT_BOLD); // 粗体
        font1.setFontName("黑体");
        style1.setFont(font1);
        style1.setAlignment(HSSFCellStyle.ALIGN_LEFT); // 水平居中
        style1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 垂直居中
        style1.setFillForegroundColor(HSSFColor.RED.index);
        style1.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
        style1.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
        style1.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
        style1.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框

        // 合并单元格
        // first row (0-based) last row (0-based) first column (0-based) last
        // column (0-based)
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));
        // 设置列宽度（像素）
        for (int i = 0; i < excelHeaderWidth.length; i++) {
            sheet.setColumnWidth(i, 32 * excelHeaderWidth[i]);
        }

        //当前行数
        int rowCount = 0;

        // 设置高度
        row = (SXSSFRow) sheet.createRow(rowCount);
        sheet.createRow(0).setHeightInPoints((short) 50);
        rowCount++;
        SXSSFCell cell = (SXSSFCell) row.createCell(0);
        cell.setCellValue("*" + "商品信息表" + "*");
        cell.setCellStyle(style);

        row = (SXSSFRow) sheet.createRow(rowCount);
        rowCount++;
        // 添加表格头
        for (int i = 0; i < excelHeader.length; i++) {
            SXSSFCell cell1 = (SXSSFCell) row.createCell(i);
            cell1.setCellValue(excelHeader[i]);
            cell1.setCellStyle(style1);
        }
        //当前序号
        int count = 1;

        // 所有信息
        for (int i = 0; i <productManagesList.size() ; i++) {
            row = (SXSSFRow) sheet.createRow(rowCount);
            rowCount++;

            SXSSFCell one = (SXSSFCell) row.createCell(0);
            one.setCellValue(count);
            count++;
            one.setCellStyle(style1);

            SXSSFCell two = (SXSSFCell) row.createCell(1);
            two.setCellValue(productManagesList.get(i).getCategory().toString());
            count++;
            one.setCellStyle(style1);

            SXSSFCell three = (SXSSFCell) row.createCell(2);
            three.setCellValue(productManagesList.get(i).getModel().toString());
            count++;
            three.setCellStyle(style1);

            SXSSFCell four = (SXSSFCell) row.createCell(3);
            four.setCellValue(productManagesList.get(i).getType().toString());
            count++;
            four.setCellStyle(style1);

            SXSSFCell five = (SXSSFCell) row.createCell(4);
            five.setCellValue(productManagesList.get(i).getNationLanguage().toString());
            count++;
            five.setCellStyle(style1);

            SXSSFCell six = (SXSSFCell) row.createCell(5);
            six.setCellValue(productManagesList.get(i).getProductName().toString());
            count++;
            six.setCellStyle(style1);

            SXSSFCell seven = (SXSSFCell) row.createCell(6);
            seven.setCellValue(productManagesList.get(i).getSku());
            count++;
            seven.setCellStyle(style1);

            SXSSFCell eight = (SXSSFCell) row.createCell(7);
            eight.setCellValue(productManagesList.get(i).getBarCode());
            count++;
            eight.setCellStyle(style1);


            SXSSFCell night = (SXSSFCell) row.createCell(8);
            night.setCellValue(productManagesList.get(i).getProductLaunch());
            count++;
            night.setCellStyle(style1);

            SXSSFCell ten = (SXSSFCell) row.createCell(9);
            ten.setCellValue(productManagesList.get(i).getMarketingStatus());
            count++;
            ten.setCellStyle(style1);

            SXSSFCell Eleven = (SXSSFCell) row.createCell(10);
            Eleven.setCellValue(productManagesList.get(i).getWeightNet());
            count++;
            Eleven.setCellStyle(style1);


            SXSSFCell Twelve = (SXSSFCell) row.createCell(11);
            Twelve.setCellValue(productManagesList.get(i).getGrossWeight());
            count++;
            Twelve.setCellStyle(style1);

            SXSSFCell Thirteen = (SXSSFCell) row.createCell(12);
            Thirteen.setCellValue(productManagesList.get(i).getSinglePackageSize());
            count++;
            Thirteen.setCellStyle(style1);

            SXSSFCell Fourteen = (SXSSFCell) row.createCell(13);
            Fourteen.setCellValue(productManagesList.get(i).getNumberOfLargeBoxesDelivered());
            count++;
            Fourteen.setCellStyle(style1);

            SXSSFCell Fifteen = (SXSSFCell) row.createCell(14);
            Fifteen.setCellValue(productManagesList.get(i).getUnitNetWeight());
            count++;
            Fifteen.setCellStyle(style1);

            SXSSFCell Sixteen = (SXSSFCell) row.createCell(15);
            Sixteen.setCellValue(productManagesList.get(i).getUnitGrossWeight());
            count++;
            Sixteen.setCellStyle(style1);

            SXSSFCell Seventeen = (SXSSFCell) row.createCell(16);
            Seventeen.setCellValue(productManagesList.get(i).getPackageSizeShip());
            count++;
            Seventeen.setCellStyle(style1);

            SXSSFCell  Eighteen = (SXSSFCell) row.createCell(17);
            Eighteen.setCellValue(productManagesList.get(i).getdRetailPrice());
            count++;
            Eighteen.setCellStyle(style1);

            SXSSFCell  Nineteen = (SXSSFCell) row.createCell(18);
            Nineteen.setCellValue(productManagesList.get(i).getdOrdinaryDealersWholesale());
            count++;
            Nineteen.setCellStyle(style1);

            SXSSFCell  Twenty = (SXSSFCell) row.createCell(19);
            Twenty.setCellValue(productManagesList.get(i).getdCoreWholesalePrice());
            count++;
            Twenty.setCellStyle(style1);

            SXSSFCell TwentyOne = (SXSSFCell) row.createCell(20);
            TwentyOne.setCellValue(productManagesList.get(i).getdSpecialTreatmentWholesale());
            count++;
            TwentyOne.setCellStyle(style1);

            SXSSFCell TwentyTwo = (SXSSFCell) row.createCell(21);
            TwentyTwo.setCellValue(productManagesList.get(i).getdStandbyWholesalePrice());
            count++;
            TwentyTwo.setCellStyle(style1);


            SXSSFCell TwentyThree = (SXSSFCell) row.createCell(22);
            TwentyThree.setCellValue(productManagesList.get(i).getoRetailPrice());
            count++;
            TwentyThree.setCellStyle(style1);

            SXSSFCell TwentyFour = (SXSSFCell) row.createCell(23);
            TwentyFour.setCellValue(productManagesList.get(i).getoGeneralWholesalePrice());
            count++;
            TwentyFour.setCellStyle(style1);

            SXSSFCell TwentyFive = (SXSSFCell) row.createCell(24);
            TwentyFive.setCellValue(productManagesList.get(i).getoCWPrice());
            count++;
            TwentyFive.setCellStyle(style1);


            SXSSFCell TwentySix = (SXSSFCell) row.createCell(25);
            TwentySix.setCellValue(productManagesList.get(i).getoSTWholesale());
            count++;
            TwentySix.setCellStyle(style1);

            SXSSFCell TwentySeven = (SXSSFCell) row.createCell(26);
            TwentySeven.setCellValue(productManagesList.get(i).getoReserveWholesale());
            count++;
            TwentySeven.setCellStyle(style1);

            SXSSFCell TwentyEight = (SXSSFCell) row.createCell(27);
            TwentyEight.setCellValue(productManagesList.get(i).getRemake1());
            count++;
            TwentyEight.setCellStyle(style1);

            SXSSFCell TwentyNight = (SXSSFCell) row.createCell(28);
            TwentyNight.setCellValue(productManagesList.get(i).getRemake2());
            count++;
            TwentyNight.setCellStyle(style1);

            SXSSFCell   Thirty = (SXSSFCell) row.createCell(29);
            Thirty.setCellValue(productManagesList.get(i).getMakeTime());
            count++;
            Thirty.setCellStyle(style1);

            SXSSFCell   ThirtyOne = (SXSSFCell) row.createCell(30);
            ThirtyOne.setCellValue(productManagesList.get(i).getUpdateTime());
            count++;
            ThirtyOne.setCellStyle(style1);

            SXSSFCell   Thirtytwo = (SXSSFCell) row.createCell(31);
            Thirtytwo.setCellValue(productManagesList.get(i).getUpdatePerson());
            count++;
            Thirtytwo.setCellStyle(style1);

        }
        return wb;

    }


}
