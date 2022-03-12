package com.example.historydiseases.core.subpplier;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter
@Setter
public class FilterDTO {
    private Integer page = 0;
    private Integer size = 10;

    private String sortBy = "createdDate";
    private Sort.Direction direction = Sort.Direction.DESC;
}
