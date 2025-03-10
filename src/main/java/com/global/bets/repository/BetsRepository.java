package com.global.bets.repository;

import com.global.bets.model.entity.Bets;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetsRepository extends CrudRepository<Bets, String> {
}
