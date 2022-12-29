package com.example.java21.controller;

import com.example.java21.dto.ProductReadDto;
import com.example.java21.model.Product;
import com.example.java21.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/")
public class ProductController {

    private final ProductService productService;

    @PostMapping(value = "/add/product")
    public Map<String,Object> addProduct (Product product){
        productService.addproduct(product);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("code",200);
        result.put("message","등록완료");
        return  result;
    }

    @PostMapping(value = "/list/product")
    public Map<String,Object> readProducts(ProductReadDto dto){
        Map<String,Object> result = new HashMap<String, Object>();
        List<Product>data = productService.readProducts(dto);
        result.put("code",200);
        result.put("totalCount",data.size());
        result.put("data",data);
        return result;
    }

    @PostMapping(value = "/update/product")
    public Map<String,Object> changeProduct(ProductReadDto dto){
        Map<String,Object> result = new HashMap<String, Object>();
        productService.changeProducts(dto);
        result.put("code",200);
        result.put("message","변경완료");
        return result;
    }

    @PostMapping(value = "/remove/product")
    public Map<String,Object> deleteProduct(ProductReadDto dto){
        Map<String,Object> result = new HashMap<String, Object>();
        productService.deleteProduct(dto);
        result.put("code",200);
        result.put("message","삭제완료");
        return result;
    }
}
