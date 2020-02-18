package buy.entity;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private int id;
    private String userId;
    private String loginName;
    private String userAddress;
    private Date createTime;
    private float cost;
    private int status;
    private int type;
    private String serialNumber;
}
