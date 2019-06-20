package com.duminda.mybatis.controllers;

import com.duminda.mybatis.models.Param;
import com.duminda.mybatis.models.PatientCount;
import com.duminda.mybatis.mappers.PatientMapper;
import com.duminda.mybatis.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientMapper patientMapper;

    @GetMapping("/api/patient")
    public List<Patient> getAllPatients() {
        return patientMapper.findAllPatients();
    }

    @GetMapping("/api/patient/{id}")
    public Patient getPatient(@PathVariable(name="id") int id) {
        return patientMapper.findPatientById(id);
    }

    @GetMapping("/api/patient/count")
    public List<PatientCount> getPatientCount() {
        return patientMapper.findPatientCountByGender();
    }

    @GetMapping("/api/patient/total")
    public Object getTotalPatients() {

        Param param = new Param();
        param.setTotal(0);

        patientMapper.findPatientTotal(param);

        return param.getTotal();

    }
}
