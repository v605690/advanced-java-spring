/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.dml.usingqueryannotation.repositories;

import com.codingnomads.springdata.example.dml.usingqueryannotation.models.SoilType;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoilTypeRepo extends JpaRepository<SoilType, Long> {
    @Query("SELECT st FROM SoilType st WHERE st.name = ?1")
    SoilType getSoilTypeByName(String soilTypeName);

    @Query("SELECT st FROM SoilType st WHERE st.ph > ?1")
    SoilType getSoilTypeWithPhGreaterThan(double phUpperBound);

    @Query("SELECT st FROM SoilType st WHERE st.ph >= ?1 AND st.ph <= ?2")
    SoilType getSoilTypeWithPhBetween(double phLowerBound, double phUpperBound);

    @Query("SELECT st FROM SoilType st WHERE st.ph < ?1")
    SoilType getSoilTypeWithPhLessThan(double phLowerBound);

    @Query("SELECT st FROM SoilType st")
    List<SoilType> getAllSoilTypes(Sort sort);

    @Query("SELECT st FROM SoilType st WHERE st.ph BETWEEN ?1 AND ?2")
    Iterable<SoilType> getSoilTypesWithPhBetween(double phLowerBound, double phUpperBound);
}
