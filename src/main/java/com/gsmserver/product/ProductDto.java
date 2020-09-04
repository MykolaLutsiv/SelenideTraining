package com.gsmserver.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
//@AllArgsConstructor
@Builder
public class ProductDto {

    private String id;
    private String title;
    private String basePath;
    private String category;

}
