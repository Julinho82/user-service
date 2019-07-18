package com.dh.fullstack.users.service.model.repositories;

import com.dh.fullstack.users.service.model.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
