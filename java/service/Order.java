package service;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Order {
    private int id;
    private String name;
    private Date date;
    private int prodId;



}
