package com.dh.fullstack.users.service.model.repositories;

import com.dh.fullstack.users.service.model.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRespository extends JpaRepository<Account,Long> {


}
