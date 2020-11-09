package com.sky.idea.dao;

import com.sky.idea.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 * @Mapper标注这是一个mapper的接口类
 * @Repository 数据层交给spring
 */
@Mapper
@Repository
public interface ProductMapper {
    List<Product> queryProducts();
}
