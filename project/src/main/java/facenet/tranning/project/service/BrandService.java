package facenet.tranning.project.service;

import facenet.tranning.project.dto.request.BrandRequest;
import facenet.tranning.project.entity.BrandEntity;
import facenet.tranning.project.repository.BrandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
// Class thực hiện các bussiness logic của brand
public class BrandService {
    @Autowired
    private BrandRepo brandRepo;

    // Lấy ra tất cả danh sách các brand
    public List<BrandEntity> brandList(){
        return brandRepo.findAll();
    }

    // Map BrandRequest sang BrandEntity
    public void mapBrandRequestToBrandEntity(BrandRequest brandRequest, BrandEntity brandEntity){
        brandEntity.setName(brandRequest.getName());
        brandEntity.setCountry(brandRequest.getCountry());
        brandEntity.setYearFounded(brandRequest.getYearFounded());
        brandEntity.setHeadquarters(brandRequest.getHeadquarters());
        brandEntity.setWebsite(brandRequest.getWebsite());
        brandEntity.setDescription(brandRequest.getDescription());
    }

    // Xử lý thêm một brand mới
    public BrandEntity createBrand(BrandRequest brandRequest) {
        LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();
        String brandName = brandRequest.getName();

        if (!isNotExistsBrandName(brandName)) {
            throw new RuntimeException("Brand name is exist");
        }
        // Kiểm tra năm nhập nhỏ hơn hiện tại
        if (brandRequest.getYearFounded() > year) {
            throw new RuntimeException("Year founded is greater than year founded");
        }

        BrandEntity brandEntity = new BrandEntity();
        mapBrandRequestToBrandEntity(brandRequest, brandEntity);
        return brandRepo.save(brandEntity);
    }

    // Xử lý cập nhật brand mới
    public BrandEntity updateBrand(Integer brandId, BrandRequest brandRequest) {
        BrandEntity brandEntity = getBrandById(brandId);
        mapBrandRequestToBrandEntity(brandRequest, brandEntity);
        return brandRepo.save(brandEntity);
    }

    // Xử lý xóa một brand
    public void deleteBrand(Integer brandId) {
        BrandEntity brandEntity = getBrandById(brandId);
    }

    // Lấy ra brand với brandId
    public BrandEntity getBrandById(Integer brandId) {
        return brandRepo.findById(brandId).
                orElseThrow(() -> new RuntimeException("Brand not found"));
    }

    // Lấy ra brand theo brandNam
    public BrandEntity getBrandByName(String name) {
        return (BrandEntity) brandRepo.findByName(name).
                orElseThrow(() -> new RuntimeException("Brand name not found"));
    }

    // Kiểm tra xem hãng xe có tồn tại không
    public boolean isNotExistsBrandName(String brandName) {
        return !brandRepo.existsByName(brandName);
    }
}
