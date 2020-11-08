package com.viveknaskar.salonbooking.service.impl;

import com.viveknaskar.salonbooking.data.BarberRepository;
import com.viveknaskar.salonbooking.domain.BarberDetails;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
class BarberServiceImplTest {

    @Mock
    BarberRepository barberRepository;

    @InjectMocks
    BarberServiceImpl barberService;

    @BeforeEach
    void  setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void registerBarberDetailsSuccess(){
        BarberDetails barberDetails = new BarberDetails();
        barberDetails.setId(123546);
        barberDetails.setName("test");
        barberDetails.setAddress("tester");
        barberDetails.setChargePerSession("12");
        barberDetails.setExperience("4");
        barberDetails.setPhoneNumber("1234654");
        barberDetails.setRating("5");
        Mockito.when(barberRepository.save(barberDetails)).thenReturn(barberDetails);
        Assert.assertEquals(barberDetails,barberService.registerBarberDetails(barberDetails));
    }

    @Test
    void getBarberAllRecordsPassTest(){
        List<BarberDetails> barberDetailsList = new ArrayList<>();
        BarberDetails barberDetails = new BarberDetails();
        barberDetails.setId(123546);
        barberDetails.setName("test");
        barberDetails.setAddress("tester");
        barberDetails.setChargePerSession("12");
        barberDetails.setExperience("4");
        barberDetails.setPhoneNumber("1234654");
        barberDetails.setRating("5");
        barberDetailsList.add(barberDetails);
        Mockito.when(barberRepository.findAll()).thenReturn(barberDetailsList);
        Assert.assertEquals(barberDetailsList,barberService.getBarberAllRecords());
    }

    @Test
    void getBarberRecordSuccess(){
        BarberDetails barberDetails = new BarberDetails();
        barberDetails.setId(123546);
        barberDetails.setName("test");
        barberDetails.setAddress("tester");
        barberDetails.setChargePerSession("12");
        barberDetails.setExperience("4");
        barberDetails.setPhoneNumber("1234654");
        barberDetails.setRating("5");
        Mockito.when(barberRepository.findById(123456)).thenReturn(barberDetails);
        Assert.assertEquals(barberDetails,barberService.getBarberRecord(123456));
    }
}