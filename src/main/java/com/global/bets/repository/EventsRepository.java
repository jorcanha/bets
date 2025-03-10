package com.global.bets.repository;

import com.global.bets.model.entity.Events;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends CrudRepository<Events, String> {
}
