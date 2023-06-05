package com.example.gracefood.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="food_Table")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "food_id")
    int food_id;
    @Column(name = "food_name")
    String food_name;
    @Column(name = "food_order")
    String food_order;
    @Column(name = "food_desc")
    String food_desc;
    @Column(name = "food_price")
    int food_price;
    @Column(name = "food_type")
    String food_type;
}
