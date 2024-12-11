SELECT an.animal_id, an.animal_name, 'Yes' AS adopted
FROM animals_in_shelters.animals AS an
         INNER JOIN animals_in_shelters.adoptions AS ad ON ad.animal_id = an.animal_id
UNION
SELECT an.animal_id, an.animal_name, 'No' AS adopted
FROM animals_in_shelters.animals AS an
         LEFT JOIN animals_in_shelters.adoptions AS ad ON ad.animal_id = an.animal_id
WHERE ad.animal_id IS NULL