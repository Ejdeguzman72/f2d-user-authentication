package com.f2d.user_authentication.repository;

import com.f2d.user_authentication.domain.F2DUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface F2DUserRepository extends JpaRepository<F2DUser, Long> {

}
