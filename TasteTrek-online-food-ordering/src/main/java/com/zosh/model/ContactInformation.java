package com.zosh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
// @AllArgsConstructor
// @NoArgsConstructor
@Getter
@Setter
public class ContactInformation {

    private String mobile;
    private String email;
    private String twitter;
    private String instagram;
}
