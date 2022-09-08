package com.example.caching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SimpleBookRepository implements BookRepository {

	private static final Logger logger = LoggerFactory.getLogger(SimpleBookRepository.class);

	@Override
	@Cacheable(value = "books" , unless = "#isbn == 'isbn-4567'")
	public Book getByIsbn(String isbn) {
		simulateSlowService();
		return new Book(isbn, "Some book");
	}

	// Don't do this at home
	private void simulateSlowService() {
		try {
			long time = 5000L;
			logger.info("ERROR");
			Thread.sleep(time);
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		}
	}

}
