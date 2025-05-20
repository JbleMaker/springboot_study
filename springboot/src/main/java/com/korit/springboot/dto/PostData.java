package com.korit.springboot.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Setter
@Getter

@Data
public class PostData {
    private String name;
    private int age;
    private Address address;
}
