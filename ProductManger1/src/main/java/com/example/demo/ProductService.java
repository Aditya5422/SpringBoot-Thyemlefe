package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository repo;

	/*
	 * public List<Product> listAll() { return repo.findAll(); }
	 */
	public Page<Product> listAll(int pageNum, String sortField, String sortDir) {

		Pageable pageable = PageRequest.of(pageNum - 1, 3,
				sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());

		return repo.findAll(pageable);
	}
	
	public List<Product> listAll(String keyword) {
			return repo.findAll(keyword);
	}
	
	
	/*
	 * public List<Product> findByKayword(String keyword) { return
	 * repo.findByKayword(keyword); }
	 */

	public void save(Product product) {
		repo.save(product);
	}

	public Product get(long id) {
		return repo.findById(id).get();
	}

}
