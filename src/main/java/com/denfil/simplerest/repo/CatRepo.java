package com.denfil.simplerest.repo;

import com.denfil.simplerest.dto.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepo extends JpaRepository<Cat, Integer> {
}
