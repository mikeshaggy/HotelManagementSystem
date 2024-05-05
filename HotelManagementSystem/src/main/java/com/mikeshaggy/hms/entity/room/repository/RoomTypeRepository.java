package com.mikeshaggy.hms.entity.room.repository;

import com.mikeshaggy.hms.entity.room.RoomTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "roomtypes")
public interface RoomTypeRepository extends JpaRepository<RoomTypeEntity, Integer> {
}
