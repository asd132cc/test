package com.example.test.mapper;




import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.test.bean.ProductManages;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;



import java.util.List;

public interface ProductManagesMapper extends BaseMapper<ProductManages> {
    //查询所有的商品信息
    List<ProductManages> selectListByLimit(@Param("deletedId")  Integer deletedId, @Param(
            "currPage")String s, @Param("pageSize") String s1);


    //按照条件调试分页
    int selectpermissionCountFromCategroyModelTypeNationLanguage(      @Param("deletedId")  Integer deletedId,
                                                                       @Param("category") String category,
                                                                       @Param("model")    String model,
                                                                       @Param("type")         String type,
                                                                       @Param("nationLanuage")String nationLanguage,
                                                                       @Param("sku") String sku);

    ///按照条件调试分页获得信息
    List<ProductManages> selectListByLimitFromCategroyModelTypeNationLanguage(
            @Param("deletedId")  Integer deletedId,
            @Param("currPage") String s,
            @Param("pageSize") String s1,
            @Param("category") String category,
            @Param("model")    String model,
            @Param("type")         String type,
            @Param("nationLanuage")String nationLanguage,
            @Param("sku") String sku);
    //excel 前半部分
    List<ProductManages> selectListByLimitFromCategroyModelTypeNationLanguage2(@Param("deletedId")  Integer deletedId,
                                                                                              @Param("category") String category,
                                                                                              @Param("model")    String model,
                                                                                              @Param("type")         String type,
                                                                                              @Param("nationLanuage") String nationLanguage,
                                                                                              @Param("sku") String sku);

    List<ProductManages> selectListByLimitTwo(@Param("deletedId")   Integer i,
                                              @Param("currPage")  String s,
                                              @Param("pageSize")  String s1,
                                              @Param("category")  String category,
                                              @Param("model") String model,
                                              @Param("type") String type,
                                              @Param("nationLanuage") String nationLanguage,
                                              @Param("sku") String sku);

    Integer selectListByLimitByCount(Integer i);


}

