package com.example.ptljdf;


public class ShopUpload{
    public String ownername;
    public String shopname;
    public String phno;
    public String mail;
    public String shopaddress;
    public String area;
    public String produces;
    public String location;
    public String imageURL;

    public ShopUpload() {

    }

    public ShopUpload(String ownername, String shopname, String phno, String mail, String shopaddress, String area, String produces, String location, String url) {
        this.ownername = ownername;
        this.shopname = shopname;
        this.phno = phno;
        this.mail = mail;
        this.shopaddress = shopaddress;
        this.area = area;
        this.produces = produces;
        this.location = location;
        this.imageURL= url;
    }
    public String getOwnernamenameName() {
        return ownername;
    }
    public String getShopnameName() {
        return shopname;
    }
    public String getPhno() {
        return phno;
    }
    public String getMail() {
        return mail;
    }
    public String getShopAddress() {
        return shopaddress;
    }
    public String getArea() {
        return area;
    }
    public String getProduces() {
        return produces;
    }
    public String getLocation() {
        return location;
    }

    public String getImageURL() {
        return imageURL;
    }

}