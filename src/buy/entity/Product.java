package buy.entity;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private String description;
    private float price;
    private int stock;
    private int categoryLevel1;
    private int categoryLevel2;
    private int categoryLevel3;
    private String fileName;
    private int isDelete;
}
