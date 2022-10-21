package com.example.demo.service.impl;

import com.example.demo.model.Country;
import com.example.demo.model.CountryResponse;
import com.example.demo.repository.CountryRepository;
import com.example.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    String COUNTRY_NOT_FOUND = "Country not found";
    String COUNTRY_NOT_AVAILABLE = "Country not available";
    String COUNTRY_BAD_REQUEST = "Bad request";


    @Override
    public CountryResponse save(Country country) {
        try {
            return countryToResponse(countryRepository.save(country));
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, COUNTRY_BAD_REQUEST, ex);
        }
    }

    @Override
    public CountryResponse findCountryById(String id) {
        Integer countryId = stringToInt(id);
        try {
            return countryToResponse(countryRepository.findCountryById(countryId));
        } catch (Exception ex) {
         throw new ResponseStatusException(HttpStatus.NOT_FOUND, COUNTRY_NOT_FOUND, ex);
        }
    }

    @Override
    public CountryResponse findCountryByCapital(String capital) {
        try {
            return countryToResponse(countryRepository.findCountryByCapital(capital));
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, COUNTRY_NOT_FOUND, ex);
        }
    }

    @Override
    public List<CountryResponse> findAll() {
        try {
            List<Country> countryList = countryRepository.findAll();
            List<CountryResponse> countryResponse = new ArrayList<>();
            for (Country country: countryList) {
                countryResponse.add(countryToResponse(country));
            }
            return countryResponse;
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, COUNTRY_NOT_AVAILABLE, ex);
        }
    }

    private Integer stringToInt(String id) {
        if (pattern.matcher(id).matches()) {
            return Integer.parseInt(id);
        }
        return 0;
    }

    private CountryResponse countryToResponse(Country country) {
        Optional<Country> countryOp = Optional.of(country);
        var countryResponse = CountryResponse.builder();
        if (countryOp.isPresent()) {
            countryResponse
                    .name(country.getName())
                    .capital(country.getCapital());
        }
        return countryResponse.build();
    }

}
