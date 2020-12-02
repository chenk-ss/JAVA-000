package com.chenk.abstractroutingdatasource.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author chenk
 * @create 2020/12/2 20:31
 */
@Data
@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
}
