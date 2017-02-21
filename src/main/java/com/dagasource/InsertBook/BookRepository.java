package com.dagasource.InsertBook;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by fabio on 25/01/17.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
