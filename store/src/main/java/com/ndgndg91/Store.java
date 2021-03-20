package com.ndgndg91;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class Store {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
