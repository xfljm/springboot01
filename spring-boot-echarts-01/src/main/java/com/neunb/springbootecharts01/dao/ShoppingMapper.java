package com.neunb.springbootecharts01.dao;

import com.neunb.springbootecharts01.pojo.Shopping;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShoppingMapper {

    //查找所有商品
    @Select("select * from shopping")
    public List<Shopping> findAllShopping();

}
