package org.example.service.impl;

import org.example.entity.Cargo;
import org.example.entity.CargoStatus;
import org.example.repository.CargoRepository;
import org.example.service.CargoService;
import org.example.util.XlsxFileCargoParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class CargoServiceImpl implements CargoService {

    private final CargoRepository cargoRepository;
    private static final Logger logger = LoggerFactory.getLogger(CargoServiceImpl.class);

    @Autowired
    public CargoServiceImpl(CargoRepository cargoRepository){
        this.cargoRepository = cargoRepository;
    }

    @Override
    @Transactional
    public void saveBatch(MultipartFile file) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String fileType = file.getContentType();
        String fileName = file.getOriginalFilename();
        if (Objects.equals(fileType, "xlsx")){
            InputStream inputStream = file.getInputStream();
            XlsxFileCargoParser parser = new XlsxFileCargoParser();
            List<Cargo> cargos = parser.toListCargo(inputStream);
            logger.info("File with name {} was been parsed", fileName);
            cargos.forEach(cargo -> {
                cargo.setTimestampOfRegistration(new Date());
                cargo.setCargoStatus(CargoStatus.NEW);
            });
            cargoRepository.saveAll(cargos);
            logger.info("Data on cargos from file with name {} was saved", fileName);
        } else {
            RuntimeException e = new RuntimeException("Invalid file type");
            logger.error("file type invalid {}", fileName);
            throw e;
        }
    }

    @Override
    @Transactional
    public Cargo save(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    @Override
    @Transactional
    public Cargo findById(Long id) {
        return cargoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cargo not found!"));
    }

    @Override
    public void delete(Long id) {
        cargoRepository.deleteById(id);
    }
}
