package com.gyoguma.repository.location;

import com.gyoguma.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {

    boolean existsByName(String name);
}
