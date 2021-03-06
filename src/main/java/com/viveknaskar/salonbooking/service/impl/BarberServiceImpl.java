package com.viveknaskar.salonbooking.service.impl;

import com.viveknaskar.salonbooking.data.BarberRepository;
import com.viveknaskar.salonbooking.domain.BarberDetails;
import com.viveknaskar.salonbooking.service.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Component
public class BarberServiceImpl implements BarberService {

    @Autowired
    BarberRepository barberRepository;

    @Override
    public BarberDetails registerBarberDetails(BarberDetails barberDetails) {
        barberDetails.setId(generateRandomId());
        return barberRepository.save(barberDetails);
    }

    @Override
    public List<BarberDetails> getBarberAllRecords() {
        List<BarberDetails> barberDetailsList = barberRepository.findAll();
        Comparator<BarberDetails> comparator = Comparator.comparing(BarberDetails::getId);
        Collections.sort(barberDetailsList, comparator);
        return barberDetailsList;
    }

    @Override
    public BarberDetails getBarberRecord(long id) {
        return barberRepository.findById(id);
    }

    private long generateRandomId(){
        Random rand = new Random();
        // Generate random id in range 0 to 999
        return rand.nextInt(1000);
    }
}
