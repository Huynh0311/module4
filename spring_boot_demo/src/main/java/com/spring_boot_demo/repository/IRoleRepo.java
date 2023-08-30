package com.spring_boot_demo.repository;

import com.spring_boot_demo.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface IRoleRepo extends CrudRepository<Role, Integer> {
}
