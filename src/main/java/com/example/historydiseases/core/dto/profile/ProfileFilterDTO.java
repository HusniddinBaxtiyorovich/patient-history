package com.example.historydiseases.core.dto.profile;


import com.example.historydiseases.core.subpplier.FilterDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProfileFilterDTO  extends FilterDTO {
    private String name;
    private String surname;
    private String email;
    private String contact;
    private List<String> nameList;
}
