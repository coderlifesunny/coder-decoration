package com.decoration.dao.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author
 */
@Data
public class TestDO implements Serializable {
    private Integer id;

    private String name;

    private static final long serialVersionUID = 1L;
}