CREATE TABLE people3.person (
                        id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
                        age INT NOT NULL,
                        salary DECIMAL(7, 2) NULL,
                        passport CHAR(10) NOT NULL,
                        address VARCHAR(200) NOT NULL,
                        dateOfBirthday DATE NOT NULL,
                        dateTimeCreate DATETIME DEFAULT CURRENT_TIMESTAMP NULL,
                        timeToLunch TIME NULL,
                        letter TEXT NULL
);