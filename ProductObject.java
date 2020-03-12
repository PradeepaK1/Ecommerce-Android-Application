package com.example.ptljdf.entities;
public class ProductObject {
    private int productId;
    private String productName;
    private int productImage;
    private String productDescription;
    private double productPrice;
    private String productQuantity;
    private String productCategory;
    public ProductObject(int productId, String productName, int productImage, String productDescription, double productPrice, String productQuantity, String productCategory) {
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productCategory = productCategory;
    }
    public int getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }
    public int getProductImage() {
        return productImage;
    }
    public String getProductDescription() {
        return productDescription;
    }
    public double getProductPrice() {
        return productPrice;
    }
    public String getProductQuantity() {
        return productQuantity;
    }
    public String getProductCategory() {
        return productCategory;
    }
    @Override
    public String toString() {
        return "Product id and name: " + productId + " " + productName;
    }
}