package com.example.demo.dto.parent;

import com.example.demo.domain.enums.Gender;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ParentResponse {
    private Long id;
    private String fullName;
    private String phone;
    private String email;
    private String address;
    private String relationship;
    private Gender gender;
}
