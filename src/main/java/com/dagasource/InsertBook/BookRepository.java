package com.dagasource.InsertBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by fabio on 25/01/17.
 */
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
