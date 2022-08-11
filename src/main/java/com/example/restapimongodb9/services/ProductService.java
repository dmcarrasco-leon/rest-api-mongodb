package com.example.restapimongodb9.services;


import com.example.restapimongodb9.models.Product;
import com.example.restapimongodb9.models.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Product> getProducts()
    {
        return repository.findAll();
    }

    public List<Product> getProductsWithTitle(String t)
    {
        Query query = new Query();

        query.addCriteria(Criteria.where("title").is(t));

        List<Product> products =  mongoTemplate.find(query, Product.class);
        return products;
    }

    // type = movie / tv show
    public List<Product> getProductsWithType(String t)
    {
        Query query = new Query();
        query.addCriteria(Criteria.where("type").is(t));

        List<Product> products =  mongoTemplate.find(query, Product.class);
        return products;
    }

    // productType = movie / tv show
    public List<Product> getFeaturedProducts(String productType)
    {
        Query query = new Query();
        query.addCriteria(Criteria.where("type").is(productType).and("featured").is(true));

        List<Product> products =  mongoTemplate.find(query, Product.class);
        return products;
    }

    public void insertIntoProducts(Product product)
    {
        repository.insert(product);
    }

    public Product updateProduct(String id, Product newProductData)
    {
        Optional<Product> product = repository.findById(id);

        //if(product.isPresent()) {
        product.get().setTitle(newProductData.getTitle());
        product.get().setPrice(newProductData.getPrice());
        product.get().setSynopsis(newProductData.getSynopsis());
        product.get().setBestSeller(newProductData.getBestSeller());
        product.get().setSmallImage(newProductData.getSmallImage());
        product.get().setLargeImage(newProductData.getLargeImage());
        product.get().setRentPrice (newProductData.getRentPrice());
        product.get().setPurchasePrice(newProductData.getPurchasePrice());
        product.get().setOutrightPrice(newProductData.getOutrightPrice());
        product.get().setFeatured(newProductData.getFeatured());
            //...
            Product updatedProduct = repository.save(product.get());
            return updatedProduct;
        //}
    }


    // P2-7 - Get movie or tv show
    public Optional<Product> getAProduct(String id) throws Exception
    {
        Optional<Product> product = repository.findById(id);
        if(!product.isPresent()){
            throw new Exception("Product with id : " + id + " is not found");
        }
        return product;
    }



    /*public void deleteAProduct(String id)
    {
        repository.deleteById(id);
    }*/
    public Optional<Product> deleteAProduct(String id) throws Exception
    {
        Optional<Product> product = repository.findById(id);
        if(!product.isPresent()){
            throw new Exception("Product with id : " + id + " is not found");
        }else{
            repository.deleteById(id);
        }
        return product;
    }

}
