package com.johnbarleycorn.locationtracker.persistent.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Repository to retrieve user's location history.
 * 
 * @author igorne
 *
 */
public interface LocationRepository extends PagingAndSortingRepository<LocationEntity, Serializable> {

	List<LocationEntity> findAllByUser(UserEntity user);

	Page<LocationEntity> findByUser(Pageable pageable, UserEntity user);

}
