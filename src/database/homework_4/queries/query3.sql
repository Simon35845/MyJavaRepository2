select shelters.shelter_name, shelters.location, animals.animal_name, animals.species
from animals right join shelters on animals.shelter_id = shelters.shelter_id;