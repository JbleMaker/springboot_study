package com.korit.springboot.dto.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.web.bind.annotation.RequestParam;

@Data
@AllArgsConstructor
public class SearchStudyDto {

    private String searchValue;
    private Integer page = 1;
    private Integer count = 10;
//
//    @RequestParam(required = false) String searchValue,
//    @RequestParam(required = false, defaultValue = "1") Integer page,
//    @RequestParam(required = false, defaultValue = "10") Integer count
}
