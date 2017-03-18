package com.atog.grrrben.kemepo.classes;

import java.io.Serializable;

/**
 * Just a pojo
 */
public class Product implements Serializable {
    public int id;
    public String name;
    public Long ean;
    public Double price;
    public String url;
    public Boolean active;
}
