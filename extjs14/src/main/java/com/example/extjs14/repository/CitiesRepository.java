package com.example.extjs14.repository;

import com.example.extjs14.model.Cities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitiesRepository extends JpaRepository<Cities,Long> {
}
