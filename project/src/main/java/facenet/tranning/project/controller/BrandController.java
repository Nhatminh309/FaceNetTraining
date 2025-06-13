package facenet.tranning.project.controller;

import facenet.tranning.project.dto.request.BrandRequest;
import facenet.tranning.project.entity.BrandEntity;
import facenet.tranning.project.service.BrandService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Class thực hiện lấy request từ người dùng liên quan đến Brand
@RestController
public class BrandController {
    @Autowired
    private BrandService brandService;

    // Thực hiện hiển thị danh sách tất cả các brand
    @GetMapping("/brands")
    public List<BrandEntity> listAllBrand() {
        return brandService.brandList();
    }

    // Thực hiện thêm một brand mới
    @PostMapping("/brands")
    public BrandEntity createBrand(@RequestBody @Valid BrandRequest brandRequest) {
        return brandService.createBrand(brandRequest);
    }

    // Thực hiện chỉnh sửa một brand
    @PutMapping("/brands/{brandId}")
    public BrandEntity updateBrand(@PathVariable Integer brandId, @RequestBody @Valid BrandRequest brandRequest){
        return brandService.updateBrand(brandId, brandRequest);
    }

}
