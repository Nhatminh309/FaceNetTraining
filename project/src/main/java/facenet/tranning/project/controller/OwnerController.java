package facenet.tranning.project.controller;

import facenet.tranning.project.dto.request.OwnerRequest;
import facenet.tranning.project.entity.OwnerEntity;
import facenet.tranning.project.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    //Hiển thị tất cả danh sách chủ xe
    @GetMapping("/owners")
    public List<OwnerEntity> getOwners() {
        return ownerService.ownerList();
    }

    //Tạo một chủ xe mới
    @PostMapping("/owners")
    public OwnerEntity creatOwner(@RequestBody OwnerRequest ownerRequest) {
        return ownerService.createOwner(ownerRequest);
    }

    //Chỉnh sửa một chủ xe
    @PutMapping("/owners/{ownerId}")
    public OwnerEntity updateOwner(@PathVariable int ownerId,@RequestBody OwnerRequest ownerRequest) {
        return ownerService.updateOwner(ownerId, ownerRequest);
    }

    // Xóa một chủ xe
    @DeleteMapping("/owners/{ownerId}")
    public void deleteOwner(@PathVariable int ownerId) {
        ownerService.deleteOwner(ownerId);
    }
}
