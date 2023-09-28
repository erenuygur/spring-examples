package com.erenuygur.datajpapostgresrestapi.repository;

import com.erenuygur.datajpapostgresrestapi.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {
}
