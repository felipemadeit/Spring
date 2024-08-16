package com.crudspring.apicrud.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudspring.apicrud.Entities.Product;

// <Class (entity), type of the PK>
public interface ProductRepository extends JpaRepository<Product, Long>{

}
