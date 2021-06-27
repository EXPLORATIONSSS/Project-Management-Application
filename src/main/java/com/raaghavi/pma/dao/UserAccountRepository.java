package com.raaghavi.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.raaghavi.pma.entities.UserAccount;

public interface UserAccountRepository extends CrudRepository<UserAccount,Long>{

}
