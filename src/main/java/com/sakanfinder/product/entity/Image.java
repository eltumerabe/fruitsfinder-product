package com.sakanfinder.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Image")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder(toBuilder = true)
public class Image{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String publicId;
    private String imageString;
    @ManyToOne
    @JsonIgnore
    private Product product;



}
