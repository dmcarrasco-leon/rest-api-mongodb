package com.example.restapimongodb9.controllers;


import com.example.restapimongodb9.CustomizedResponse;
import com.example.restapimongodb9.models.Product;
import com.example.restapimongodb9.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public ResponseEntity getproducts()
    {
        var customizedResponse = new CustomizedResponse(" A list of products", service.getProducts());
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }
    /*public List<Product> getproducts()
    {
        return service.getProducts();
    }*/

    // /Products/title?title= blabla &limit = 15
    //public ResponseEntity getproductsByTitle(@RequestParam(value="title") String t, @RequestParam(value="limit") String limit)
    @GetMapping("/products/title")
    public ResponseEntity getproductsByTitle(@RequestParam(value="title") String t)
    {
        var customizedResponse = new CustomizedResponse(" A list of products", service.getProductsWithTitle(t));
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    @GetMapping("/products/type")
    public ResponseEntity getProductsByType(@RequestParam(value="type") String t)
    {
        var customizedResponse = new CustomizedResponse(" A list of type " + t , service.getProductsWithType(t));
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    @GetMapping("/products/featured")
    public ResponseEntity getFeaturedProducts(@RequestParam(value="type") String productType)
    {
        var customizedResponse = new CustomizedResponse(" A list of type " + productType
                , service.getFeaturedProducts(productType));
        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }

    // Get movie or tv show
    @GetMapping("/products/{id}")
    public ResponseEntity getAProduct(@PathVariable("id") String id)
    {
        CustomizedResponse customizedResponse = null;
        try {
            customizedResponse = new CustomizedResponse(" Product with id : " + id, Collections.singletonList(service.getAProduct(id)));
        } catch (Exception e) {
            customizedResponse = new CustomizedResponse(e.getMessage(), null);
            return new ResponseEntity(customizedResponse, HttpStatus.NOT_FOUND );
        }

        return new ResponseEntity(customizedResponse, HttpStatus.OK );
    }


   @DeleteMapping("/products/{id}")
   public ResponseEntity deleteProduct(@PathVariable("id") String id)
   {
       CustomizedResponse customizedResponse = null;
       try {
           customizedResponse = new CustomizedResponse(" Deleted Product with id : " + id, Collections.singletonList(service.deleteAProduct(id)));
       } catch (Exception e) {
           customizedResponse = new CustomizedResponse(e.getMessage(), null);
           return new ResponseEntity(customizedResponse, HttpStatus.NOT_FOUND );
       }

       return new ResponseEntity(customizedResponse, HttpStatus.OK );
   }

    @PostMapping(value="/products", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity addProduct(@RequestBody Product product)
    {
        service.insertIntoProducts(product);
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @PutMapping(value="/products/{id}", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity editProduct(@PathVariable("id") String id, @RequestBody Product newProduct)
    {
        CustomizedResponse customizedResponse = null;
        try {
            customizedResponse = new CustomizedResponse(" Product with id : " + id + " was updated successfully", Collections.singletonList(service.updateProduct(id, newProduct)));
        } catch (Exception e) {
            customizedResponse = new CustomizedResponse(e.getMessage(), null);
            return new ResponseEntity(customizedResponse, HttpStatus.NOT_FOUND );
        }

        return new ResponseEntity(customizedResponse, HttpStatus.OK );
    }
}

