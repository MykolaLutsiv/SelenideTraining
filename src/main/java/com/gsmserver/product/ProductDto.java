package com.gsmserver.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
//@AllArgsConstructor
@Builder
public class ProductDto {

    @Builder.Default
    private String id = "1";
    @Builder.Default
    private String title = "1";
    @Builder.Default
    private String basePath = "1";
    @Builder.Default
    private String category = "1";



}
