package com.dagasource.Controller.InsertUser.Entity;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by fabio on 25/01/17.
 */
public interface UserRepo extends CrudRepository<Users, Long> {

}