package com.sky.idea.controller;

import com.sky.idea.dao.ProductMapper;
import com.sky.idea.entity.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@RestController
public class ProductController {
    @Resource
    private ProductMapper productMapper;

    @GetMapping("/products")
    public List<Product> queryProducts() {
        return productMapper.queryProducts();
    }

}
