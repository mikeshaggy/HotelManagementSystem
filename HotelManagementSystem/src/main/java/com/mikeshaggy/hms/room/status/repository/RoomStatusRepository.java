package com.mikeshaggy.hms.room.status.repository;

import com.mikeshaggy.hms.room.status.entity.RoomStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "roomstatus")
public interface RoomStatusRepository extends JpaRepository<RoomStatusEntity, Integer> {
}
