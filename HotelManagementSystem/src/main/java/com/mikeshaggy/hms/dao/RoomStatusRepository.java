package com.mikeshaggy.hms.dao;

import com.mikeshaggy.hms.entity.room.RoomStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "roomstatus")
public interface RoomStatusRepository extends JpaRepository<RoomStatusEntity, Integer> {
}
