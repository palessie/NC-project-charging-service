package com.nc.edu.be.repository;

import com.nc.edu.be.entities.Products;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ProductsRepository extends CrudRepository<Products, Integer>, PagingAndSortingRepository<Products, Integer> {
}
