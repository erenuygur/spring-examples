package com.erenuygur.datajpapostgresrestapi.repository;

import com.erenuygur.datajpapostgresrestapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
