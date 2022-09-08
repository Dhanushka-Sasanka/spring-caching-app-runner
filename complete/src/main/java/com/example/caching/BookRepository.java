package com.example.caching;

import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository {

	Book getByIsbn(String isbn);

}
