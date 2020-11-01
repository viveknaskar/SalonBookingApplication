package com.salon.aussie.data;

import com.salon.aussie.domain.BarberDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarberRepository extends MongoRepository<BarberDetails, String> {
    BarberDetails findById(long id);

}
