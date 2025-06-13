-- Thêm hãng xe (brand)
INSERT INTO brand (name, country, year_founded, headquarters, website, description) VALUES
('Toyota', 'Japan', 1937, 'Toyota City', 'https://www.toyota-global.com', 'Toyota là hãng xe lớn nhất Nhật Bản.'),
('Ford', 'USA', 1903, 'Dearborn, Michigan', 'https://www.ford.com', 'Ford là hãng xe nổi tiếng của Mỹ.'),
('Hyundai', 'South Korea', 1967, 'Seoul', 'https://www.hyundai.com', 'Hyundai là hãng xe hàng đầu Hàn Quốc.'),
('Mercedes-Benz', 'Germany', 1926, 'Stuttgart', 'https://www.mercedes-benz.com', 'Thương hiệu xe sang của Đức.'),
('Honda', 'Japan', 1948, 'Tokyo', 'https://www.honda.com', 'Honda nổi bật với động cơ bền bỉ.');

-- Thêm chủ sở hữu (owner)
INSERT INTO owner (name, phone, email, address, date_of_birth, gender) VALUES
('Nguyen Van An', '0912345678', 'an@gmail.com', 'Hà Nội', '1990-05-21', 'Male'),
('Tran Thi Binh', '0987654321', 'binh@gmail.com', 'TP.HCM', '1985-12-05', 'Female'),
('Le Van Cuong', '0971122334', 'cuong@gmail.com', 'Đà Nẵng', '1995-07-10', 'Male'),
('Pham Thi Dao', '0961234567', 'dao@gmail.com', 'Hải Phòng', '1988-01-18', 'Female'),
('Hoang Minh Duong', '0933445566', 'duong@gmail.com', 'Cần Thơ', '1992-11-30', 'Male'),
('Vu Thi Em', '0912333444', 'em@gmail.com', 'Nam Định', '1998-04-25', 'Female'),
('Nguyen Tuan Kiet', '0977333222', 'kiet@gmail.com', 'Bình Dương', '1986-08-12', 'Male'),
('Tran Van Lap', '0944556677', 'lap@gmail.com', 'Hà Nam', '1991-03-17', 'Male');

-- Thêm ô tô (car)
INSERT INTO car (license_plate, model, year, color, purchase_date, owner_id, brand_id) VALUES
('30A-12345', 'Camry', 2020, 'Black', '2020-07-15', 1, 1),
('29B-54321', 'Ranger', 2021, 'White', '2021-03-20', 2, 2),
('43C-67890', 'Accent', 2019, 'Red', '2019-09-09', 3, 3),
('30A-11111', 'Fortuner', 2018, 'Silver', '2018-05-10', 1, 1),
('29B-22222', 'EcoSport', 2017, 'Blue', '2017-11-22', 2, 2),
('51D-33333', 'Civic', 2022, 'Gray', '2022-02-28', 4, 5),
('17A-44444', 'CR-V', 2021, 'White', '2021-09-14', 5, 5),
('60C-55555', 'SantaFe', 2018, 'Brown', '2018-06-19', 6, 3),
('88A-66666', 'GLC 300', 2022, 'Black', '2022-10-05', 7, 4),
('30A-77777', 'E-Class', 2023, 'Silver', '2023-01-12', 8, 4),
('43A-88888', 'Vios', 2019, 'Red', '2019-08-08', 3, 1),
('51G-99999', 'Everest', 2020, 'Gray', '2020-12-30', 4, 2),
('30F-10101', 'Tucson', 2021, 'Blue', '2021-04-16', 1, 3),
('29C-20202', 'S-Class', 2022, 'Black', '2022-11-21', 2, 4),
('92A-30303', 'City', 2020, 'White', '2020-05-25', 5, 5),
('17D-40404', 'Sonata', 2019, 'Yellow', '2019-01-01', 6, 3);

