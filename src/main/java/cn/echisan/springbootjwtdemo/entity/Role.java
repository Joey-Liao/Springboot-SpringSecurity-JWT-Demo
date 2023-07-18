package cn.echisan.springbootjwtdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @descriptions:
 * @author: Joey Liao
 * @date: 2023/7/17 15:01
 * @version: 1.0
 */
@Data
@AllArgsConstructor
public class Role {
    private Integer id;
    private String name;
    private String nameZh;
    //get set..
}
