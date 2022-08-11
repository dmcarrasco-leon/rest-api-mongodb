package com.example.restapimongodb9.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document ("products")
public class Product
{
    @Id
    private String id;
    private String title;
    private Number price ;
    private String synopsis ;
    private String type ;
    private Boolean bestSeller;
    private String smallImage;
    private String largeImage;
    private Number rentPrice ;
    private Number purchasePrice ;
    private	Number outrightPrice;
    private Boolean featured;


    public Product() {
    }

    public Product(String id, String title, Number price, String synopsis, String type, Boolean bestSeller, String smallImage, String largeImage, Number rentPrice, Number purchasePrice, Number outrightPrice, Boolean featured) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.synopsis = synopsis;
        this.type = type;
        this.bestSeller = bestSeller;
        this.smallImage = smallImage;
        this.largeImage = largeImage;
        this.rentPrice = rentPrice;
        this.purchasePrice = purchasePrice;
        this.outrightPrice = outrightPrice;
        this.featured = featured;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getBestSeller() {
        return bestSeller;
    }

    public void setBestSeller(Boolean bestSeller) {
        this.bestSeller = bestSeller;
    }

    public String getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }

    public String getLargeImage() {
        return largeImage;
    }

    public void setLargeImage(String largeImage) {
        this.largeImage = largeImage;
    }

    public Number getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Number rentPrice) {
        this.rentPrice = rentPrice;
    }

    public Number getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Number purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Number getOutrightPrice() {
        return outrightPrice;
    }

    public void setOutrightPrice(Number outrightPrice) {
        this.outrightPrice = outrightPrice;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", synopsis='" + synopsis + '\'' +
                ", type='" + type + '\'' +
                ", bestSeller=" + bestSeller +
                ", smallImage='" + smallImage + '\'' +
                ", largeImage='" + largeImage + '\'' +
                ", rentPrice=" + rentPrice +
                ", purchasePrice=" + purchasePrice +
                ", outrightPrice=" + outrightPrice +
                ", featured=" + featured +
                '}';
    }
}
