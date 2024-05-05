package com.mikeshaggy.hms.entity.extraservice.repository;

import com.mikeshaggy.hms.entity.extraservice.ExtraServiceCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "categories")
public interface ExtraServiceCategoryRepository extends JpaRepository<ExtraServiceCategoryEntity, Integer> {
}
