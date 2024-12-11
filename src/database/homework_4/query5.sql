SELECT sh.shelter_name, count(an.animal_id) AS animal_count
FROM animals_in_shelters.shelters AS sh
         LEFT JOIN animals_in_shelters.animals AS an ON an.shelter_id = sh.shelter_id
GROUP BY sh.shelter_name