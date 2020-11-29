package com.hava.satistakip.init;

import com.hava.satistakip.model.Airport;
import com.hava.satistakip.model.Company;
import com.hava.satistakip.model.Route;
import com.hava.satistakip.model.common.Country;
import com.hava.satistakip.model.common.Province;
import com.hava.satistakip.model.common.Town;
import com.hava.satistakip.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataLoaderInit {
    @Autowired
    private IAirportRepository airportRepository;
    @Autowired
    private ICompanyRepository companyRepository;
    @Autowired
    private ICountryRepository countryRepository;
    @Autowired
    private IProvinceRepository provinceRepository;
    @Autowired
    private ITownRepository townRepository;
    @Autowired
    private IRouteRepository routeRepository;

    public DataLoaderInit(IAirportRepository airportRepository,
                          ICompanyRepository companyRepository,
                          ICountryRepository countryRepository,
                          IProvinceRepository provinceRepository,
                          ITownRepository townRepository,
                          IRouteRepository routeRepository){
        this.airportRepository = airportRepository;
        this.companyRepository = companyRepository;
        this.countryRepository = countryRepository;
        this.provinceRepository = provinceRepository;
        this.townRepository = townRepository;
        this.routeRepository = routeRepository;
        LoadAirport();
        LoadCountry();

    }

    private void LoadAirport(){
        Airport airport = new Airport();
        airport.setName("Esenboğa Havaalanı");
        airport.setActive(true);
        airportRepository.save(airport);

        Airport airport2 = new Airport();
        airport2.setName("Sabiha Gökçen Havaalanı");
        airport2.setActive(true);
        airportRepository.save(airport2);
        LoadCompany(airport,"Anka");
        LoadCompany(airport2,"TGS");
        LoadRoute(airport,airport2);
    }

    private void LoadCompany(Airport airport,String name){
        Company company = new Company();
        company.setName(name);
        company.setActive(true);
        company.setAirport(airport);
        companyRepository.save(company);
    }

    private void LoadCountry(){
        Country country = new Country();
        country.setName("Türkiye");
        country.setActive(true);
        countryRepository.save(country);
        LoadProvince(country,"Ankara","İstanbul","Konya");

        Country country1 = new Country();
        country1.setName("Almanya");
        country1.setActive(true);
        countryRepository.save(country1);
        LoadProvince(country1,"Berlin","Hamburg","Münih");

        Country country2 = new Country();
        country2.setName("Çin");
        country2.setActive(true);
        countryRepository.save(country2);
        LoadProvince(country1,"Pekin","Şanghay","Wuhan");
    }

    private void LoadProvince(Country country,String ...names){
        for (String name : names) {
            Province province = new Province();
            province.setCountry(country);
            province.setName(name);
            province.setActive(true);
            provinceRepository.save(province);
            if(name.equals("Ankara")){
                LoadTown(province,"Çubuk","Etimesgut","Merkez","Sincan");
            }else if(name.equals("İstanbul")){
                LoadTown(province,"Kadıköy","Florya","Silivri","Üsküdar","Kadıköy");
            }
        }
    }

    private void LoadTown(Province province,String ...names){
        for (String name : names) {
            Town town = new Town();
            town.setName(name);
            town.setProvince(province);
            town.setActive(true);
            townRepository.save(town);
        }
    }

    private void LoadRoute(Airport airport1,Airport airport2){
        Route route = new Route();
        route.setDescription("First router");
        route.setArriveAirport(airport1);
        route.setGoingAirport(airport2);
        routeRepository.save(route);
    }
}
