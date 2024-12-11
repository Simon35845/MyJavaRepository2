CREATE TABLE animals_in_shelters.shelters
(
    shelter_id   INT AUTO_INCREMENT NOT NULL COMMENT 'идентификатор приюта'
        PRIMARY KEY,
    shelter_name VARCHAR(255) NULL COMMENT 'название приюта',
    location     VARCHAR(255) NULL COMMENT 'местоположение приюта'
);

CREATE TABLE animals_in_shelters.animals
(
    animal_id   INT AUTO_INCREMENT NOT NULL COMMENT 'идентификатор животного'
        PRIMARY KEY,
    animal_name VARCHAR(255) NULL COMMENT 'имя животного',
    species     VARCHAR(255) NOT NULL COMMENT 'вид животного',
    shelter_id  INT          NULL COMMENT 'идентификатор приюта',
    CONSTRAINT animals_shelters_shelter_id_fk
        FOREIGN KEY (shelter_id) REFERENCES shelters (shelter_id)
);

CREATE TABLE animals_in_shelters.adoptions
(
    adoption_id   INT AUTO_INCREMENT NOT NULL COMMENT 'идентификатор адоптации'
        PRIMARY KEY,
    animal_id     INT          NOT NULL COMMENT 'идентификатор животного',
    adopter_name  VARCHAR(255) NOT NULL COMMENT 'имя усыновителя',
    adoption_date DATE         NOT NULL COMMENT 'дата усыновления',
    CONSTRAINT adoptions_animals_animal_id_fk
        FOREIGN KEY (animal_id) REFERENCES animals (animal_id)
);


