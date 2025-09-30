package com.olesia.university.service;

import com.olesia.university.model.Lector;
import com.olesia.university.repository.LectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LectorService {

    private final LectorRepository repository;

    public List<Lector> getLectorsByTemplate(String template) {
        return repository.findByNameContainingIgnoreCaseOrSurnameContainingIgnoreCase(template, template);
    }
}
