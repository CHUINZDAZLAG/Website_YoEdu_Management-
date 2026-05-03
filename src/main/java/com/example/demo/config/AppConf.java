package com.example.demo.config;

import com.example.demo.domain.entity.Student;
import com.example.demo.dto.student.StudentResponse;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration//nạp lên controller, nạp trước
public class AppConf {
    @Bean //nạp lên controller, nạp trước
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()  //biến.get
                .setFieldMatchingEnabled(true)
                .setMatchingStrategy(MatchingStrategies.STRICT) // STRICT VÀ LOOSE
                .setAmbiguityIgnored(false);
        return modelMapper; // dựa vào kiểu dữ liệu để nó biết và trả về => nếu phương thức thứ hai trả về kiểu dữ liệu
        //model mapper thì bị lỗi... (tên gì quên rùi)
        //STRICT đòi hỏi tên field của bên nhận là StudentResponse
    }
}
