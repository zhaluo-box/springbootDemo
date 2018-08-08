package com.example.activemqdemo4.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor //全参数构造
@NoArgsConstructor  //无参构造
public class Order implements Serializable {

    private String content;
    private Date timestamp;

}
