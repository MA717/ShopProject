package com.example.ShopProject.Entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@AllArgsConstructor
public enum OrderStatus {

    ORDERED,IN_PROGRESS, DELEVIERD , RETURNED
}
