package com.greenfox.chatapp.repositories;

import com.greenfox.chatapp.model.Logger;
import org.springframework.data.repository.CrudRepository;
import javax.persistence.criteria.CriteriaBuilder;

public interface LoggerRepository extends CrudRepository<Logger,Long> {

}
