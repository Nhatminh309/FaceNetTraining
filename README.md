# FaceNetTraining
Learn Spring Boot

# Quản Lý Xe - Car Manager

## Giới thiệu

Đây là dự án **Quản Lý Xe** sử dụng cơ sở dữ liệu MariaDB để lưu trữ thông tin **chủ xe**, **xe** và **hãng xe**. Dự án cho phép quản lý thông tin các xe, chủ sở hữu, và hãng sản xuất xe.

## Cấu trúc cơ sở dữ liệu

- **Bảng owner**: Lưu thông tin chủ xe (tên, số điện thoại, email, địa chỉ, ngày sinh, giới tính).
- **Bảng car**: Lưu thông tin xe (biển số, model, năm sản xuất, màu sắc, ngày mua, khóa ngoại tới owner và brand).
- **Bảng brand**: Lưu thông tin hãng xe (tên, quốc gia, năm thành lập, trụ sở, website, mô tả).

## Các bước triển khai

### 1. Tải mã nguồn từ GitHub

```bash
https://github.com/Nhatminh309/FaceNetTraining
```

### 2. Tạo database `car_manager` trong MariaDB
Vui lòng đổi mật khẩu nếu khác: 12345678
Đăng nhập MariaDB:

```bash
mysql -u root -p
```

Tạo database:

```sql
CREATE DATABASE car_manager;
EXIT;
```

### 3. Chạy các file SQL để tạo bảng và dữ liệu mẫu

Từ thư mục gốc của dự án, chạy các lệnh sau:

```bash
mysql -u root -p car_manager < Database/create.sql
mysql -u root -p car_manager < Database/insert.sql
```

> Lưu ý: Sửa `root` thành user MariaDB của bạn nếu khác.

### 4. Mở project trong IntelliJ IDEA

- Mở **IntelliJ IDEA**.
- Chọn **Open** và trỏ tới folder project vừa tải về.

### 5. Chạy ứng dụng

- Chọn file main của project (thường là class có `main()`).
- Nhấn nút **Run** (`Shift + F10` hoặc biểu tượng tam giác xanh).

### 6. Truy cập hệ thống quản lý xe

Mở trình duyệt và truy cập:

```
http://localhost:8080/manager
```

---

## Thông tin liên hệ

Mọi thắc mắc, góp ý xin liên hệ qua email: nhatminh2k22k3@gmail.com

