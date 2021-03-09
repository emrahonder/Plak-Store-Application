package com.nioya.plak.repository;

import com.nioya.plak.model.Plak;
import com.nioya.plak.model.PlakStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface PlakRepository extends JpaRepository<Plak, Integer> {

    @Query("select new com.nioya.plak.model.PlakStat(p.type as code,count(p.type) as count) from Plak p group by p.type")
    public List<PlakStat> groupBy();

}
