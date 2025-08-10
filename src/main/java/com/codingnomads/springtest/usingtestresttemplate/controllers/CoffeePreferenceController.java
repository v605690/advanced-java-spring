/* CodingNomads (C)2024 */
package com.codingnomads.springtest.usingtestresttemplate.controllers;

import com.codingnomads.springtest.usingtestresttemplate.models.CoffeePreference;
import com.codingnomads.springtest.usingtestresttemplate.services.CoffeePreferenceService;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/coffee")
public class CoffeePreferenceController {

    @Autowired
    CoffeePreferenceService service;

    @PostMapping
    public ResponseEntity<?> postNewCoffeePreference(@RequestBody CoffeePreference coffeePreference) {
        try {
            CoffeePreference preference = service.insertNewCoffeePreference(coffeePreference);
            return ResponseEntity.ok()
                    .header("Location", "http://www.url.com/new/location")
                    .body(preference);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Exception(e.getMessage()));
        }
    }
    @GetMapping("/search/{type}")
    public ResponseEntity<?> getCoffeePreference(@PathVariable("type") String type) {
        try {
            List<CoffeePreference> matchingCoffeeTypes = service.getCoffeePreferenceByType(type);
            return ResponseEntity.ok(matchingCoffeeTypes);
        } catch (NoResultException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCoffeePreferenceById(@PathVariable("id") Long id) {
        try {
            CoffeePreference preference = service.getCoffeePreferenceById(id);
            return ResponseEntity.ok(preference);
        } catch (NoResultException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
