package com.example.demo.controllers;

import com.example.demo.common.ApiResponse;
import com.example.demo.domain.entity.Parent;
import com.example.demo.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/parents")
@RequiredArgsConstructor
public class ParentController {
    private final ParentService parentService;

    @GetMapping
    public ResponseEntity<List<Parent>> getParents(){
        return ResponseEntity.ok(parentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Parent>> getParentById(@PathVariable Long id){
        Optional<Parent> parent = parentService.findById(id);
        if(parent.isPresent()){
            return ResponseEntity.ok((ApiResponse.success(parent.get())));
        } else {
            return ResponseEntity.notFound().build();
        }
      //  return parent.map(value->
          //      ResponseEntity.ok(ApiResponse.success(value)))
           //     .orElseGet(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Parent>> updateParent(@PathVariable Long id, @RequestBody Parent parent){
        Optional<Parent> existingParent = parentService.findById(id);
        if(existingParent.isPresent()){
            Parent updatedParent = parentService.update(id, parent);
            return ResponseEntity.ok(ApiResponse.success(updatedParent));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Parent>> createParent(@RequestBody Parent parent){
        Parent newParent = parentService.save(parent);
        return ResponseEntity.ok((ApiResponse.success(newParent)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteParent(@PathVariable Long id){
        Optional<Parent> existingParent =parentService.findById(id);

        if(existingParent.isPresent()){
            parentService.deleteParent(id);
        } else{
            return ResponseEntity.notFound().build();
        }
        return null;
    }

    @DeleteMapping("/all")
    public ResponseEntity<ApiResponse<String>> deleteAllParent(){
        parentService.deleteAllParent();;
        return ResponseEntity.ok(ApiResponse.success("Parents' Information have been deleted succesfully"));
    }
}
