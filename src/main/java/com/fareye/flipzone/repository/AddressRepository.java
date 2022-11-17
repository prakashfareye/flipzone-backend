package com.fareye.flipzone.repository;

import com.fareye.flipzone.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

    List<Address> findByUserId(long id);
}
