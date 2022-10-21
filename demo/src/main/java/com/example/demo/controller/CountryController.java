package com.example.demo.controller;

import com.example.demo.model.Country;
import com.example.demo.model.CountryResponse;
import com.example.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/find/id/{id}")
    public CountryResponse findCountryById(@PathVariable String id) {
        return countryService.findCountryById(id);
    }

    @GetMapping("/find/capital/{capital}")
    public CountryResponse findCountryByCapital(@PathVariable String capital) {
        return countryService.findCountryByCapital(capital);
    }

    @GetMapping("/find-all")
    public List<CountryResponse> findAllCountries() {
        return countryService.findAll();
    }

    @PostMapping("/save")
    public CountryResponse saveCountry(@RequestBody Country country) {
        return countryService.save(country);
    }

}
