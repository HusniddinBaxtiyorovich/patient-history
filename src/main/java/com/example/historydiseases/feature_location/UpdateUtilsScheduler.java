//package com.example.historydiseases.feature_location;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import com.example.historydiseases.feature_location.endpoints.CountriesService;
//import com.example.historydiseases.feature_location.endpoints.DistrictsService;
//import com.example.historydiseases.feature_location.endpoints.RegionService;
//import com.example.historydiseases.feature_location.entity.Countries;
//import com.example.historydiseases.feature_location.entity.Districts;
//import com.example.historydiseases.feature_location.entity.Regions;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//
//
//@Component
//@EnableScheduling
//@RequiredArgsConstructor
//public class UpdateUtilsScheduler {
//    private final RegionService regionsService;
//    private final CountriesService countriesService;
//    private final DistrictsService districtsService;
//
//    public void fetchRegions() {
//        List<Regions> regions2db = new ArrayList<>();
//        for (RegionsResponse region : regions) {
//            if (regionsService.getById(region.getRegionId()) == null) {
//                Regions record = new Regions();
//                record.setRegionId(region.getRegionId());
//                Map<String, String> lang = new HashMap<>();
//                lang.put("uz", region.getRegionName());
//                record.setName(lang);
//                regions2db.add(record);
//            }
//        }
//        regionsService.addRegions(regions2db);
//    }
//
//    public void fetchCountries() {
//        var countries = absRepository.getCountries();
//        List<Countries> countries2db = new ArrayList<>();
//        for (CountriesResponse country : countries) {
//            if (countriesService.getById(country.getNumericCode()) == null) {
//                Countries record = new Countries();
//                record.setCountryId(country.getNumericCode());
//                record.setCodeAlpha(country.getAlpha2());
//                Map<String, String> lang = new HashMap<>();
//                lang.put("ru", country.getName());
//                record.setName(lang);
//                countries2db.add(record);
//            }
//        }
//        countriesService.addCountries(countries2db);
//    }
//
//    public void fetchDistricts() {
//
//        List<Districts> districts2db = new ArrayList<>();
//        for (DistrictsResponse district : districts) {
//            if (districtsService.getById(district.getDistrictId()) == null) {
//                Districts record = new Districts();
//                record.setDistrictId(district.getDistrictId());
//                record.setRegion(regionsService.getById(district.getRegionId()));
//                Map<String, String> lang = new HashMap<>();
//                lang.put("ru", district.getDistrictName());
//                record.setName(lang);
//                districts2db.add(record);
//            }
//        }
//        districtsService.addDistricts(districts2db);
//    }
//
//    @EventListener(ApplicationReadyEvent.class)
//    @Scheduled(cron = "0 43 18 1/1 * ?")
//    public void fetch() {
//        fetchCountries();
//        fetchRegions();
//        fetchDistricts();
//    }
//}
