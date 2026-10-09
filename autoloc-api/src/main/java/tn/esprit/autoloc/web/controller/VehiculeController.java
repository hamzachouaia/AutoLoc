package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
@RequiredArgsConstructor
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicule add(@RequestBody Vehicule vehicule) {
        return vehiculeService.add(vehicule);
    }

    @GetMapping
    public List<Vehicule> retrieveAll() {
        return vehiculeService.retrieveAll();
    }

    @GetMapping("/{id}")
    public Vehicule retrieveById(@PathVariable Long id) {
        return vehiculeService.retrieveById(id);
    }

    @PutMapping("/{id}")
    public Vehicule update(@PathVariable Long id, @RequestBody Vehicule vehicule) {
        return vehiculeService.update(id, vehicule);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        vehiculeService.delete(id);
    }
}