/* CodingNomads (C)2024 */
package com.codingnomads.springtest.usingtestresttemplate.services;

import com.codingnomads.springsecurity.recipeapi.exceptions.NoSuchRecipeException;
import com.codingnomads.springtest.usingtestresttemplate.models.CoffeePreference;
import com.codingnomads.springtest.usingtestresttemplate.repos.CoffeePreferenceRepo;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeePreferenceService {

    @Autowired
    private CoffeePreferenceRepo repo;

    public CoffeePreference insertNewCoffeePreference(CoffeePreference coffeePreference) {
        return repo.save(coffeePreference);
    }

    public CoffeePreference getCoffeePreferenceById(Long id) throws NoResultException {
        Optional<CoffeePreference> coffeeOptional = repo.findById(id);

        if (coffeeOptional.isEmpty()) {
            throw new NoResultException("No coffee with that ID " + id + " could be found");
        }

        return coffeeOptional.get();
    }

    public List<CoffeePreference> getCoffeePreferenceByType(String type) throws NoResultException {
        List<CoffeePreference> coffeeType = repo.findCoffeePreferenceByType(type);

        if (coffeeType.isEmpty()) {
            throw new NoResultException("No coffees could be found with that type");
        }
        return coffeeType;
    }
}
