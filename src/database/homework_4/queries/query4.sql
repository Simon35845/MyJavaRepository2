select an.animal_id, an.animal_name, 'Yes' as adopted
from animals as an inner join adoptions as ad on an.animal_id = ad.animal_id
union
select an.animal_id, an.animal_name, 'No' as adopted
from animals as an left join adoptions as ad on an.animal_id = ad.animal_id
where ad.animal_id is null