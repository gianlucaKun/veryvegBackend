package com.veryveg.product.mapper;

import com.veryveg.product.DTO.ProductDTO;
import com.veryveg.product.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO toProductDTO(Product product);
    Product toProduct(ProductDTO productDTO);

    List<ProductDTO> toProductDTOs(List<Product> products);
    List<Product> toProducts(List<ProductDTO> productDTOs);
}