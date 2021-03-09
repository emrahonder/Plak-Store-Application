package com.nioya.plak.controller;

import com.nioya.plak.enums.PlakTypes;
import com.nioya.plak.model.Plak;
import com.nioya.plak.model.PlakStat;
import com.nioya.plak.model.PlakType;
import com.nioya.plak.repository.PlakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class OperationController {
    @Autowired
    private PlakRepository plakRepository;

    @GetMapping("/plaks")
    @ResponseBody
    public List<Plak> getPlakList(HttpServletRequest request) {
        return (List<Plak>) plakRepository.findAll(Sort.by(Sort.Direction.ASC, "singer"));
    }

    @GetMapping("/plakstats")
    @ResponseBody
    public List<PlakStat> getPlakStats(HttpServletRequest request) {

        List<PlakStat> plakStats =  plakRepository.groupBy();
        plakStats.stream().forEach( p -> p.setVisibleName(PlakTypes.getEnumValue(p.getCode())));

        return plakStats;
    }
    @GetMapping("/plaktypes")
    @ResponseBody
    public List<PlakType> getPlakTypes(HttpServletRequest request) {
        List<PlakType> plakTypes = new ArrayList<>();
        plakTypes.add(new PlakType(PlakTypes.TSM.getValue(), PlakTypes.TSM));
        plakTypes.add(new PlakType(PlakTypes.THM.getValue(),PlakTypes.THM));
        plakTypes.add(new PlakType(PlakTypes.POP.getValue(),PlakTypes.POP));
        plakTypes.add(new PlakType(PlakTypes.FOR.getValue(),PlakTypes.FOR));
        plakTypes.add(new PlakType(PlakTypes.OZG.getValue(),PlakTypes.OZG));
        plakTypes.add(new PlakType(PlakTypes.ARA.getValue(),PlakTypes.ARA));
        return plakTypes;
    }

    @GetMapping("/plak/{id}")
    @ResponseBody
    public Optional<Plak> getPlakByID(HttpServletRequest request, @PathVariable int id, HttpServletResponse res) {
        Optional<Plak> plak = plakRepository.findById(id);
        if(plak.isPresent()){
            return plak;
        }else {
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        }
    }


    @PostMapping("/plak")
    @ResponseBody
    public Plak createPlak(HttpServletRequest request, @RequestBody Plak plak) {
        return plakRepository.save(plak);
    }

    @PutMapping("/plak")
    @ResponseBody
    public Plak setPlak(HttpServletRequest request, @RequestBody Plak plak) {
        return plakRepository.save(plak);

    }

    @DeleteMapping("/plak/{id}")
    @ResponseBody
    public ResponseEntity deletePlak(HttpServletRequest request, @PathVariable int id) {
        Optional<Plak> plak = plakRepository.findById(id);
        if(plak.isPresent()){
            plakRepository.deleteById(id);
        }
        return ResponseEntity.ok().build();

    }
}
