select animals.animal_name, animals.species, shelters.shelter_name, shelters.location
from animals inner join shelters on animals.shelter_id = shelters.shelter_id;