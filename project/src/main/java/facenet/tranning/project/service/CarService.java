package facenet.tranning.project.service;

import facenet.tranning.project.dto.request.CarDTOList;
import facenet.tranning.project.dto.request.CarRequest;
import facenet.tranning.project.entity.BrandEntity;
import facenet.tranning.project.entity.CarEntity;
import facenet.tranning.project.entity.OwnerEntity;
import facenet.tranning.project.mapper.CarMapper;
import facenet.tranning.project.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// Class thực hiện các bussiness logic của car
public class CarService {
    @Autowired
    private CarRepo carRepo;
    @Autowired
    private BrandService brandService;
    @Autowired
    private OwnerService ownerService;
    @Autowired
    CarMapper carMapper;

    // Hiển thị tất cả các xe
    public List<CarDTOList> carList(){
        return carRepo.getCarList();
    }

    // Lấy ra xe theo carId
    public CarEntity getCarById(int carId) {
        return carRepo.findById(carId).
                orElseThrow(() -> new RuntimeException("Car not found"));
    }



    // Map carRequest sang carEntity
    public CarEntity mapCarRequestToCarEntity(CarRequest carRequest) {
        return carMapper.mapCarDTOToCarEntity(carRequest);
    }

    // Map carDTOList sang carEntity
    public CarEntity mapCarDTOListToCarEntity(CarDTOList carDTOList) {
        CarEntity carEntity = carMapper.mapCarDTOToCarEntity(carDTOList);
        BrandEntity brandEntity = brandService.getBrandByName(carDTOList.getBrandName());
        OwnerEntity ownerEntity = ownerService.findOwnerByPhone(carDTOList.getOwnerPhone());
        carEntity.setOwnerId(ownerEntity.getId());
        carEntity.setBrandId(brandEntity.getId());
        return carEntity;
    }

    // Tạo mới một car
    public CarEntity createCar(CarRequest carRequest) {
        //Kiểm tra số điện thoại chủ xe đã tồn tại chưa
        String phone = carRequest.getOwnerPhone();
        String licensePlate = carRequest.getLicensePlate();
        String brandName = carRequest.getBrandName();

        // Tìm chủ sở hữu qua số điện thoại
        if(ownerService.isPhoneNotExist(phone)) {
            throw new RuntimeException("Phone not found in owner");
        }

        // Kiểm tra biển số xe đã tồn tại chưa
        if(isExistByLicensePlate(licensePlate)){
            throw new RuntimeException("License plate already exist");
        }

        // Kiểm tra hãng xe có tồn tại không
        if (brandService.isNotExistsBrandName(brandName)) {
            throw new RuntimeException("Brand name not found");
        }
        OwnerEntity ownerEntity = ownerService.findOwnerByPhone(phone);
        BrandEntity brandEntity = brandService.getBrandByName(brandName);

        CarEntity carEntity = mapCarRequestToCarEntity(carRequest);
        carEntity.setBrandId(brandEntity.getId());
        carEntity.setOwnerId(ownerEntity.getId());

        return carRepo.save(carEntity);
    }

    // Cập nhật một car
    public CarEntity updateCar(int carId, CarDTOList carDTOList) {
        String phone = carDTOList.getOwnerPhone();
        String licensePlate = carDTOList.getLicensePlate();

        // Tìm chủ sở hữu qua số điện thoại
        if(ownerService.isPhoneNotExist(phone)) {
            throw new RuntimeException("Phone not found in owner");
        }

        // Kiểm tra biển số xe đã tồn tại ngoài xe đang update chưa
        if(isExistByLicensePlateWithoutCarId(licensePlate, carId)){
            throw new RuntimeException("License plate already exist in other car");
        }

        CarEntity carEntity = mapCarDTOListToCarEntity(carDTOList);
        carEntity.setId(carId);
        return carRepo.save(carEntity);
    }

    // Xóa một car
    public void deleteCar(int carId) {
        CarEntity carEntity = getCarById(carId);
        carRepo.delete(carEntity);
    }

    // Kiểm tra biển số xe đã tồn tại chưa
    public boolean isExistByLicensePlate(String licensePlate) {
        return carRepo.existsByLicensePlate(licensePlate);
    }

    // Kiểm tra biển số xe đã tồn tại ngoài xe đang update chưa
    public boolean isExistByLicensePlateWithoutCarId(String licensePlate, int carId) {
        return carRepo.existsByLicensePlateAndIdNot(licensePlate, carId);
    }
}
