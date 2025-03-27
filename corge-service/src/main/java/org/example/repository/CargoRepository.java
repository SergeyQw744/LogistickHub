package org.example.repository;

import io.lettuce.core.dynamic.annotation.Param;
import org.example.entity.Cargo;
import org.example.entity.CargoStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

    @Modifying
    @Query("update Cargo c set c.cargoStatus = :cargoStatus where c.id = :id")
    void updateStatus(@Param("cargoStatus") CargoStatus status, @Param("id") Long id);

    Slice<Cargo> findByCargoStatusOrderByCargoName(CargoStatus status, Pageable pageable);

    @Query(nativeQuery = true, value = """
            SELECT * FROM cargo c WHERE c.timestamp >= NOW() - INTERVAL ':timeInMinutes minutes'
            ORDER BY c.cargo_name
            """)
    List<Cargo> findLastCargos(long timeInMinutes);

    Optional<Cargo> findByRegistrationNumber(String registrationNumber);

    Optional<Cargo> findByComments_Id(Long commentId);
}
