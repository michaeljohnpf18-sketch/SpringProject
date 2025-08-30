package com.michaelspringproject.store.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.michaelspringproject.store.entities.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {
    // Define repository methods here
}
