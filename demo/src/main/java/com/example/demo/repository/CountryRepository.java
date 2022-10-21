package com.example.demo.repository;

import com.example.demo.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer>{

    public Country findCountryById(Integer id);

    public List<Country> findAll();

    public Country findCountryByCapital(String capital);

}
