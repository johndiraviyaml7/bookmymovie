package com.booking.platform.users.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.platform.users.entity.BkpRole;
import com.booking.platform.users.entity.ERole;

@Repository
public interface RoleRepository extends JpaRepository<BkpRole, Long> {
	Optional<BkpRole> findByName(ERole name);
}
