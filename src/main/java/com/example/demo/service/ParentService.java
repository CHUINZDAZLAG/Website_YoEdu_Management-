package com.example.demo.service;

import com.example.demo.domain.entity.Parent;

import java.util.List;
import java.util.Optional;

public interface ParentService {
    List<Parent> findAll();
    Optional<Parent> findById(Long id);
    Parent save(Parent Parent);
    Parent update(Long id, Parent Parent);
    void deleteParent(Long id);
    void deleteAllParent();
}
