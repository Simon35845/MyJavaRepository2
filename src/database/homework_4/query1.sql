SELECT an.animal_name, an.species, sh.shelter_name, sh.location
FROM animals_in_shelters.animals AS an
    INNER JOIN animals_in_shelters.shelters AS sh ON sh.shelter_id = an.shelter_id;