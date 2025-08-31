package com.michaelspringproject.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.michaelspringproject.store.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
