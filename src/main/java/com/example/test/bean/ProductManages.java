
package com.example.test.bean;
public class ProductManages {
    //id
    private Integer id;
    //品类
    private String  category;
    //型号
    private String  model;
    //主题
    private String  type;
    //国家语言
    private String  nationLanguage;
    //市场产品名称
    private String  productName;
    //图片
    private String  imgpath;
    //sku
    private String  sku;
    //条形码
    private String  barCode;
    //新品发布会
    private String  productLaunch;
    //产销状态
    private String  marketingStatus;
    //单个净重
    private String  weightNet;
    //单个毛重
    private String  grossWeight;
    //单个包装尺寸
    private String  singlePackageSize;
    //出货大箱箱入数
    private String  numberOfLargeBoxesDelivered;
    //出货单位净重
    private String  unitNetWeight;
    //出货单位毛重
    private String  unitGrossWeight;
    //出货单位包装尺寸
    private String  packageSizeShip;
    //国内零售定价（rmb含税）
    private String  dRetailPrice;
    //国内普通经销商批发价（rmb含税）
    private String  dOrdinaryDealersWholesale;
    //国内核心经销商批发价（rmb含税）
    private String  dCoreWholesalePrice;
    //国内特别处理批发价（rmb含税）
    private String  dSpecialTreatmentWholesale;
    //国内备用批发价（rmb含税）
    private String  dStandbyWholesalePrice;
    //海外零售定价
    private String  oGeneralWholesalePrice;
    //海外普通经销商批发价
    private String  oRetailPrice;
    //海外核心经销商批发价
    private String  oCWPrice;
    //海外特别处理批发价
    private String  oSTWholesale;
    //海外备用批发价
    private String  oReserveWholesale;
    //空白备份1
    private String  remake1;
    //空白备份2
    private String  remake2;
    //做成日期
    private String  makeTime;
    //更新时间
    private String  updateTime;
    //更新人
    private String  updatePerson;
    //逻辑删除
    private Integer deletedId;


    @Override
    public String toString() {
        return "ProductManages{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", nationLanguage='" + nationLanguage + '\'' +
                ", productName='" + productName + '\'' +
                ", imgpath='" + imgpath + '\'' +
                ", sku='" + sku + '\'' +
                ", barCode='" + barCode + '\'' +
                ", productLaunch='" + productLaunch + '\'' +
                ", marketingStatus='" + marketingStatus + '\'' +
                ", weightNet='" + weightNet + '\'' +
                ", grossWeight='" + grossWeight + '\'' +
                ", singlePackageSize='" + singlePackageSize + '\'' +
                ", numberOfLargeBoxesDelivered='" + numberOfLargeBoxesDelivered + '\'' +
                ", unitNetWeight='" + unitNetWeight + '\'' +
                ", unitGrossWeight='" + unitGrossWeight + '\'' +
                ", packageSizeShip='" + packageSizeShip + '\'' +
                ", dRetailPrice='" + dRetailPrice + '\'' +
                ", dOrdinaryDealersWholesale='" + dOrdinaryDealersWholesale + '\'' +
                ", dCoreWholesalePrice='" + dCoreWholesalePrice + '\'' +
                ", dSpecialTreatmentWholesale='" + dSpecialTreatmentWholesale + '\'' +
                ", dStandbyWholesalePrice='" + dStandbyWholesalePrice + '\'' +
                ", oGeneralWholesalePrice='" + oGeneralWholesalePrice + '\'' +
                ", oRetailPrice='" + oRetailPrice + '\'' +
                ", oCWPrice='" + oCWPrice + '\'' +
                ", oSTWholesale='" + oSTWholesale + '\'' +
                ", oReserveWholesale='" + oReserveWholesale + '\'' +
                ", remake1='" + remake1 + '\'' +
                ", remake2='" + remake2 + '\'' +
                ", makeTime='" + makeTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", updatePerson='" + updatePerson + '\'' +
                ", deletedId=" + deletedId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNationLanguage() {
        return nationLanguage;
    }

    public void setNationLanguage(String nationLanguage) {
        this.nationLanguage = nationLanguage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getProductLaunch() {
        return productLaunch;
    }

    public void setProductLaunch(String productLaunch) {
        this.productLaunch = productLaunch;
    }

    public String getMarketingStatus() {
        return marketingStatus;
    }

    public void setMarketingStatus(String marketingStatus) {
        this.marketingStatus = marketingStatus;
    }

    public String getWeightNet() {
        return weightNet;
    }

    public void setWeightNet(String weightNet) {
        this.weightNet = weightNet;
    }

    public String getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(String grossWeight) {
        this.grossWeight = grossWeight;
    }

    public String getSinglePackageSize() {
        return singlePackageSize;
    }

    public void setSinglePackageSize(String singlePackageSize) {
        this.singlePackageSize = singlePackageSize;
    }

    public String getNumberOfLargeBoxesDelivered() {
        return numberOfLargeBoxesDelivered;
    }

    public void setNumberOfLargeBoxesDelivered(String numberOfLargeBoxesDelivered) {
        this.numberOfLargeBoxesDelivered = numberOfLargeBoxesDelivered;
    }

    public String getUnitNetWeight() {
        return unitNetWeight;
    }

    public void setUnitNetWeight(String unitNetWeight) {
        this.unitNetWeight = unitNetWeight;
    }

    public String getUnitGrossWeight() {
        return unitGrossWeight;
    }

    public void setUnitGrossWeight(String unitGrossWeight) {
        this.unitGrossWeight = unitGrossWeight;
    }

    public String getPackageSizeShip() {
        return packageSizeShip;
    }

    public void setPackageSizeShip(String packageSizeShip) {
        this.packageSizeShip = packageSizeShip;
    }

    public String getdRetailPrice() {
        return dRetailPrice;
    }

    public void setdRetailPrice(String dRetailPrice) {
        this.dRetailPrice = dRetailPrice;
    }

    public String getdOrdinaryDealersWholesale() {
        return dOrdinaryDealersWholesale;
    }

    public void setdOrdinaryDealersWholesale(String dOrdinaryDealersWholesale) {
        this.dOrdinaryDealersWholesale = dOrdinaryDealersWholesale;
    }

    public String getdCoreWholesalePrice() {
        return dCoreWholesalePrice;
    }

    public void setdCoreWholesalePrice(String dCoreWholesalePrice) {
        this.dCoreWholesalePrice = dCoreWholesalePrice;
    }

    public String getdSpecialTreatmentWholesale() {
        return dSpecialTreatmentWholesale;
    }

    public void setdSpecialTreatmentWholesale(String dSpecialTreatmentWholesale) {
        this.dSpecialTreatmentWholesale = dSpecialTreatmentWholesale;
    }

    public String getdStandbyWholesalePrice() {
        return dStandbyWholesalePrice;
    }

    public void setdStandbyWholesalePrice(String dStandbyWholesalePrice) {
        this.dStandbyWholesalePrice = dStandbyWholesalePrice;
    }

    public String getoGeneralWholesalePrice() {
        return oGeneralWholesalePrice;
    }

    public void setoGeneralWholesalePrice(String oGeneralWholesalePrice) {
        this.oGeneralWholesalePrice = oGeneralWholesalePrice;
    }

    public String getoRetailPrice() {
        return oRetailPrice;
    }

    public void setoRetailPrice(String oRetailPrice) {
        this.oRetailPrice = oRetailPrice;
    }

    public String getoCWPrice() {
        return oCWPrice;
    }

    public void setoCWPrice(String oCWPrice) {
        this.oCWPrice = oCWPrice;
    }

    public String getoSTWholesale() {
        return oSTWholesale;
    }

    public void setoSTWholesale(String oSTWholesale) {
        this.oSTWholesale = oSTWholesale;
    }

    public String getoReserveWholesale() {
        return oReserveWholesale;
    }

    public void setoReserveWholesale(String oReserveWholesale) {
        this.oReserveWholesale = oReserveWholesale;
    }

    public String getRemake1() {
        return remake1;
    }

    public void setRemake1(String remake1) {
        this.remake1 = remake1;
    }

    public String getRemake2() {
        return remake2;
    }

    public void setRemake2(String remake2) {
        this.remake2 = remake2;
    }

    public String getMakeTime() {
        return makeTime;
    }

    public void setMakeTime(String makeTime) {
        this.makeTime = makeTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(String updatePerson) {
        this.updatePerson = updatePerson;
    }

    public Integer getDeletedId() {
        return deletedId;
    }

    public void setDeletedId(Integer deletedId) {
        this.deletedId = deletedId;
    }
}
