package com.gs.backend_template.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
@Entity
public class Foo {

    @Id
//    @GeneratedValue( strategy = GenerationType.AUTO )
    int id;

    String desc;

    public Foo() {}
}
