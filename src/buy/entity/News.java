package buy.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Spliterator;

public class News implements Serializable {
    private int id;
    private String title;
    private String content;
    private Date createTime;
}
