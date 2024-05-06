package com.mikeshaggy.hms.room.type.repository;

import com.mikeshaggy.hms.room.type.entity.RoomTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "roomtypes")
public interface RoomTypeRepository extends JpaRepository<RoomTypeEntity, Integer> {
}
