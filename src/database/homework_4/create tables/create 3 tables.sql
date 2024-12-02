create table shelters
(
    shelter_id   int auto_increment comment 'идентификатор приюта'
        primary key,
    shelter_name varchar(255) null comment 'название приюта',
    location     varchar(255) null comment 'местоположение приюта'
);

create table animals
(
    animal_id   int auto_increment comment 'идентификатор животного'
        primary key,
    animal_name varchar(255) null comment 'имя животного',
    species     varchar(255) null comment 'вид животного',
    shelter_id  int          null comment 'идентификатор приюта',
    constraint animals_shelters_shelter_id_fk
        foreign key (shelter_id) references shelters (shelter_id)
);

create table adoptions
(
    adoption_id   int auto_increment comment 'идентификатор адоптации'
        primary key,
    animal_id     int          null comment 'идентификатор животного',
    adopter_name  varchar(255) null comment 'имя усыновителя',
    adoption_date date         null comment 'дата усыновления',
    constraint adoptions_animals_animal_id_fk
        foreign key (animal_id) references animals (animal_id)
);


