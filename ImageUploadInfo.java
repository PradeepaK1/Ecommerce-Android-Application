package com.example.ptljdf;


public class ImageUploadInfo {
    public String name_or_ownername_or_suppliername;
    public String phno;
    public String mail;
    public String address;
    public String area;
    public String crop_or_produces_or_equipment;
    public String stage_or_shopname_or_supplierunit;
    public String location;
    public String imageURL;

    public ImageUploadInfo() {

    }

    public ImageUploadInfo(String name_or_ownername_or_suppliername, String phno, String mail, String address, String area, String crop_or_produces_or_equipment, String stage_or_shopname_or_supplierunit, String location, String url) {
        this.name_or_ownername_or_suppliername = name_or_ownername_or_suppliername;
        this.phno = phno;
        this.mail = mail;
        this.address = address;
        this.area = area;
        this.crop_or_produces_or_equipment = crop_or_produces_or_equipment;
        this.stage_or_shopname_or_supplierunit = stage_or_shopname_or_supplierunit;
        this.location = location;
        this.imageURL= url;
    }
    public String getName_or_ownername() {
        return name_or_ownername_or_suppliername;
    }
    public String getPhno() {
        return phno;
    }
    public String getMail() {
        return mail;
    }
    public String getAddress() {
        return address;
    }
    public String getArea() {
        return area;
    }
    public String getCrop_or_produces_or_equipment() {
        return crop_or_produces_or_equipment;
    }
    public String getStage_or_shopname_or_supplierunit() {
        return stage_or_shopname_or_supplierunit;
    }
    public String getLocation() {
        return location;
    }

    public String getImageURL() {
        return imageURL;
    }

}