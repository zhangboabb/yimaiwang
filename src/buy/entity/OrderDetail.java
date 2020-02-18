package buy.entity;

import java.io.Serializable;

public class OrderDetail implements Serializable {
    private int id;
    private int orderId;
    private  int productId;
    private  int quantity;
    private float cost;

}
