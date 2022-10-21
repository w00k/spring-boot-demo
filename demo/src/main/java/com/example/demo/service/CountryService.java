package com.example.demo.service;

import com.example.demo.model.Country;
import com.example.demo.model.CountryResponse;

import java.util.List;

public interface CountryService {

    public CountryResponse save(Country country);

    public CountryResponse findCountryById(String id);

    public List<CountryResponse> findAll();

    public CountryResponse findCountryByCapital(String capital);
}
