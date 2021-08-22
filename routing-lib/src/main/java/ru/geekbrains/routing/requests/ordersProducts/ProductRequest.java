package ru.geekbrains.routing.requests.ordersProducts;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.product.entity.ProductDto;

@FeignClient("ms-product")
public interface ProductRequest {
    @GetMapping
    Page<ProductDto> findAllProducts(@RequestParam MultiValueMap<String, String> params,@RequestParam(name = "p", defaultValue = "1") Integer page);

    @GetMapping("/{id}")
    ProductDto findProductById(@PathVariable Long id);

}
