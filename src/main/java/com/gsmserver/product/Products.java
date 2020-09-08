package com.gsmserver.product;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import static com.gsmserver.product.ProductDto.*;

@Getter
@ToString
@AllArgsConstructor
public enum Products {

    MedusaBox(builder()
            .id("860988")
            .basePath("/medusa-pro-box")
            .category("Boxes")
            .title("Medusa PRO Box")
            .build()),
    MedusaPro2UpgradeSet(builder()
            .id("882882")
            .basePath("/medusa-pro-ii-upgrade-set/")
            .category("Boxes")
            .title("Medusa Pro II Upgrade Set")
            .build());

    public ProductDto productDto;

    public ProductDto getDto() {
        return productDto;
    }
}
