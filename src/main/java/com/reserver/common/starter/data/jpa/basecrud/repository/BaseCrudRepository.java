package com.reserver.common.starter.data.jpa.basecrud.repository;

import com.reserver.common.starter.data.jpa.basecrud.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * The base CRUD repository to extend.
 *
 * @param <E> - target entity type
 */
@NoRepositoryBean
public interface BaseCrudRepository<E extends BaseEntity> extends JpaRepository<E, Long>, JpaSpecificationExecutor<E> {
}
