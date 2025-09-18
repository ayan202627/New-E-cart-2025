package com.jwt.auth_service.controller;

import com.jwt.auth_service.model.Product;
import com.jwt.auth_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin
@RestController
@RequestMapping("/product-app")
public class ProductController {
    @Autowired
    private ProductService productService;

    // http://localhost:8080/product-app/products    [GET]
    @GetMapping("/products")
    public ResponseEntity getProducts(){
        return new ResponseEntity(productService.getAllProducts(), HttpStatus.OK);
    }


    // http://localhost:8080/product-app/addProduct    [POST]
    @PostMapping("/addProduct")
    public ResponseEntity addProduct(@RequestBody Product product){
        return new ResponseEntity(productService.addProduct(product), HttpStatus.OK);
    }

    // http://localhost:8080/product-app/updateProduct    [PUT]
    @PutMapping("/updateProduct")
    public ResponseEntity updateProduct(@RequestBody Product product){
        return new ResponseEntity(productService.updateProduct(product), HttpStatus.OK);
    }

    // http://localhost:8080/product-app/deleteProduct    [DELETE]
    @DeleteMapping("/deleteProduct/{pid}")
    public ResponseEntity deleteProduct(@PathVariable String pid){
        return new ResponseEntity(productService.deleteProduct(pid), HttpStatus.OK);
    }

}
