package com.viveknaskar.salonbooking.service;

import com.viveknaskar.salonbooking.domain.BarberDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BarberService {
    BarberDetails registerBarberDetails(BarberDetails barberDetails);
    List<BarberDetails> getBarberAllRecords();
    BarberDetails getBarberRecord(long id);
}
