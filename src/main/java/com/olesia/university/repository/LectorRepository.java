package com.olesia.university.repository;

import com.olesia.university.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {
    List<Lector> findByNameContainingIgnoreCaseOrSurnameContainingIgnoreCase(String nameTemplate, String surnameTemplate);
}
