package com.dagasource.InsertUser;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by fabio on 25/01/17.
 */
public interface UserRepo extends CrudRepository<Users, Long> {

}