SELECT sh.shelter_name, sh.location, an.animal_name, an.species
FROM animals_in_shelters.animals AS an
    RIGHT JOIN animals_in_shelters.shelters AS sh ON sh.shelter_id = an.shelter_id;