package com.dagasource.InsertUser;

import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by fabio on 25/01/17.
 */
@Repository
public interface UserRepo extends CrudRepository<Users, Long> {

}