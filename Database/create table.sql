
-- Bảng hãng xe (brand)
CREATE TABLE brand (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    country VARCHAR(100),
    year_founded INT,
    headquarters VARCHAR(100),
    website VARCHAR(100),
    description TEXT
);

-- Bảng chủ sở hữu (owner)
CREATE TABLE owner (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(100),
    address VARCHAR(255),
    date_of_birth DATE,
    gender VARCHAR(10)
);

-- Bảng ô tô (car)
CREATE TABLE car (
    id INT AUTO_INCREMENT PRIMARY KEY,
    license_plate VARCHAR(20) NOT NULL UNIQUE,
    model VARCHAR(100) NOT NULL,
    year INT,
    color VARCHAR(50),
    purchase_date DATE,
    owner_id INT,
    brand_id INT,
    FOREIGN KEY (owner_id) REFERENCES owner(id),
    FOREIGN KEY (brand_id) REFERENCES brand(id)
);
