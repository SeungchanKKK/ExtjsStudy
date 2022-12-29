package com.example.java21.service;

import com.example.java21.dto.ProductReadDto;
import com.example.java21.model.Product;
import com.example.java21.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public void addproduct(Product product) {
        Product addproduct = new Product(product.getProductNM(), product.getPrice(), product.getAmount());
        productRepository.save(addproduct);
        }

    public List<Product> readProducts(ProductReadDto dto) {
        if(dto.getSearchValue()==null){
        return productRepository.findAll();}
        else {
            return productRepository.findAllByProductNMContaining(dto.getSearchValue());
        }
    }

    public void changeProducts(ProductReadDto dto) {
        Product product = productRepository.findById(dto.getId()).orElseThrow(()-> new NullPointerException("찾을수없는 상품입니다"));
        product.changeProduct(dto.getProductNM(), dto.getPrice(), dto.getAmount());
        productRepository.save(product);
    }

    public void deleteProduct(ProductReadDto dto) {
        productRepository.deleteById(dto.getId());
    }
}

