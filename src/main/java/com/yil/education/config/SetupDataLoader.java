package com.yil.education.config;

import com.yil.education.model.EducationType;
import com.yil.education.repository.EducationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SetupDataLoader implements ApplicationListener<ContextStartedEvent> {
    @Autowired
    private EducationTypeRepository educationTypeRepository;

    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("Start Up Events");
        System.out.println(new Date(event.getTimestamp()));
        System.out.println("----------------------");
        initEducationTypes();
    }

    private void initEducationTypes() {
        educationTypeRepository.save(EducationType.builder().id(1).name("İlkokul").build());
        educationTypeRepository.save(EducationType.builder().id(2).name("Ortaokul").build());
        educationTypeRepository.save(EducationType.builder().id(3).name("Lise").build());
        educationTypeRepository.save(EducationType.builder().id(4).name("Lisans").build());
        educationTypeRepository.save(EducationType.builder().id(5).name("Yüksek Lisans").build());
        educationTypeRepository.save(EducationType.builder().id(6).name("Doktora").build());
        educationTypeRepository.save(EducationType.builder().id(7).name("Okur-Yazar Değil").build());
    }
}
