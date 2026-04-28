package com.example.demo.service.impl;

import com.example.demo.domain.entity.Parent;
import com.example.demo.repository.ParentRepository;
import com.example.demo.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParentServiceimpl implements ParentService{
    private final ParentRepository parentRepository;

    public List<Parent> findAll(){
        return parentRepository.findAll();
    }

    public Optional<Parent> findById(Long id){
        return parentRepository.findById(id);
    }

    public Parent save(Parent parent){
        return parentRepository.save(parent);
    }

    public Parent update(Long id, Parent parent){
        Parent existingParent = parentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Parent can not found"));
        existingParent.setFull_name(parent.getFull_name());
        existingParent.setEmail(parent.getEmail());
        existingParent.setAddress(parent.getAddress());
        existingParent.setPhone(parent.getPhone());
        return parentRepository.save(existingParent);
    }

    public void deleteParent(Long id){
        parentRepository.deleteById(id);
    }

    public void deleteAllParent(){
        parentRepository.deleteAll();
    }




}
