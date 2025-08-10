/* CodingNomads (C)2024 */
package com.codingnomads.springtest.usingtestresttemplate.repos;

import com.codingnomads.springtest.usingtestresttemplate.models.CoffeePreference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoffeePreferenceRepo extends JpaRepository<CoffeePreference, Long> {
    List<CoffeePreference> findCoffeePreferenceByType(String type);
}
