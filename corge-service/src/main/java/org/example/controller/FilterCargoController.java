package org.example.controller;

import org.example.dto.CargoDtoRead;
import org.example.entity.CargoStatus;
import org.example.mapper.impl.CargoDtoReadMapper;
import org.example.service.impl.FilterCargoServiceImpl;
import org.example.validator.PageNumberValidator;
import org.example.validator.RegistrationNumberValidator;
import org.example.validator.TimeIntervalValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cargos/filters")
public class FilterCargoController {

    private final FilterCargoServiceImpl filterCargoService;
    private final CargoDtoReadMapper cargoDtoReadMapper;
    private final PageNumberValidator pageNumberValidator;
    private final RegistrationNumberValidator registrationNumberValidator;
    private final TimeIntervalValidator timeIntervalValidator;

    @Autowired
    public FilterCargoController(FilterCargoServiceImpl filterCargoService,
                                 CargoDtoReadMapper cargoDtoReadMapper,
                                 PageNumberValidator pageNumberValidator,
                                 RegistrationNumberValidator registrationNumberValidator,
                                 TimeIntervalValidator timeIntervalValidator) {
        this.filterCargoService = filterCargoService;
        this.cargoDtoReadMapper = cargoDtoReadMapper;
        this.pageNumberValidator = pageNumberValidator;
        this.registrationNumberValidator = registrationNumberValidator;
        this.timeIntervalValidator = timeIntervalValidator;
    }

    @GetMapping("/status")
    public List<CargoDtoRead> filterByStatus(@RequestParam(value = "status", required = false, defaultValue = "NEW") String status,
                                             @RequestParam(value = "page", required = false, defaultValue = "0") int page){
        if (pageNumberValidator.validate(page)){
            throw new RuntimeException("page number is invalid!");
        }
        return filterCargoService.findByStatus(CargoStatus.valueOf(status), page)
                .stream()
                .map(this.cargoDtoReadMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{registration-number}")
    public CargoDtoRead filterByRegistrationNumber(@PathVariable("registration-number") String registrationNumber){
        if (registrationNumberValidator.validate(registrationNumber)){
            throw new RuntimeException("registration name is invalid!");
        }
        return cargoDtoReadMapper.toDto(filterCargoService.findByRegistrationNumber(registrationNumber));
    }

    @GetMapping("/last")
    public List<CargoDtoRead> filterLastCargos(@RequestParam(value = "interval-in-minutes", required = false, defaultValue = "5L")
                                                   long timeIntervalInMinutes){
        if (timeIntervalValidator.validate(timeIntervalInMinutes)){
            throw new RuntimeException("time interval is invalid!");
        }
        return filterCargoService.findLastCargos(timeIntervalInMinutes)
                .stream()
                .map(this.cargoDtoReadMapper::toDto)
                .collect(Collectors.toList());
    }
}
