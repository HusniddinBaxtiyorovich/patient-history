package com.example.historydiseases.feature_location.endpoints;

import com.example.historydiseases.feature_location.dto.CreateDistrictBranchDTO;
import com.example.historydiseases.feature_location.entity.DistrictBranch;
import com.example.historydiseases.feature_location.entity.Districts;
import com.example.historydiseases.feature_location.repository.DistrictBranchRepository;
import com.example.historydiseases.feature_location.repository.DistrictsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DistrictsService {
    private final DistrictsRepository repository;
    private final DistrictBranchRepository districtBranchRepository;

    public Districts getById(String districtId) {
        var districtOptional = repository.findById(districtId);
        if (!districtOptional.isPresent()) {
            return null;
        }
        return districtOptional.get();
    }

    public List<Districts> getAll() {
        return repository.findAll();
    }

    public Districts addDistrict(Districts district) {
        return repository.save(district);
    }

    public List<Districts> addDistricts(List<Districts> districts) {
        return repository.saveAll(districts);
    }

    @Transactional
    public void setBranch(String id, String branch) {
        var optionalDistrictBranch = districtBranchRepository.findByDistrictId(id);
        if (optionalDistrictBranch.isPresent()) {
            var districtBranch = optionalDistrictBranch.get();
            districtBranch.setBranch(branch);
            districtBranchRepository.save(districtBranch);
        } else {
            var optionalDistrict = repository.findById(id);
            optionalDistrict.ifPresent(districts -> {
                var districtBranch = new DistrictBranch();
                districtBranch.setDistrict(districts);
                districtBranch.setBranch(branch);
                districtBranchRepository.save(districtBranch);
            });
        }
    }

    @Transactional
    public void setDistrictBranches(CreateDistrictBranchDTO dto) {
        dto.getDistricts().forEach(districtBranchDTO -> setBranch(districtBranchDTO.getDistrictId(), districtBranchDTO.getBranch()));
    }
}