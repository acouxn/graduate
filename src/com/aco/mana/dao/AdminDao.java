package com.aco.mana.dao;

import com.aco.mana.domain.Admin;

public interface AdminDao {

	Admin findByUsernameAndPassword(Admin admin);

}
