package com.prueba.h2.Repositorys;

import com.prueba.h2.Entitys.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

}
