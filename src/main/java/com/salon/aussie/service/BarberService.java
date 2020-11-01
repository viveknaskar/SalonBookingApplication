package com.salon.aussie.service;

import com.salon.aussie.domain.BarberDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BarberService {
    BarberDetails registerBarberDetails(BarberDetails barberDetails);
    List<BarberDetails> getBarberAllRecords();
    BarberDetails getBarberRecord(long id);
}
