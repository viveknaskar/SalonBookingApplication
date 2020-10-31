package com.viveknaskar.salonbooking.data;

import com.viveknaskar.salonbooking.domain.BarberDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberReposirory extends MongoRepository<BarberDetails, String> {
    BarberDetails findById(long id);

}
