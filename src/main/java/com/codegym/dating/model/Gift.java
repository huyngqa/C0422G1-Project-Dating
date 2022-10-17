package com.codegym.dating.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Gift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGift;
    private String giftName;
    private Integer price;
    @OneToMany(mappedBy = "gift")
    @JsonBackReference
    List<GiftUser> giftUsers;
}
