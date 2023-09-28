package com.erenuygur.datajpapostgresrestapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString()
public class UserAddress {
    @Id
    @SequenceGenerator(name = "seq_user_address", allocationSize = 1)
    @GeneratedValue(generator = "seq_user_address", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "address", length = 500)
    private String address;

    @Enumerated
    private AddressType addressType;

    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "user_address_id")
    private User user;

    public enum AddressType {HOME, WORK, OTHER}
}
