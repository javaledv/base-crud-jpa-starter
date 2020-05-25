package com.reserver.common.starter.data.jpa.basecrud.service;

import com.reserver.common.starter.data.jpa.basecrud.entity.BaseEntity;
import com.reserver.common.starter.data.jpa.basecrud.search.BaseSearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

/**
 * The base CRUD service interface to extend.
 *
 * @param <E> - target entity type
 * @param <S> - target search criteria type
 */
public interface BaseCrudService<E extends BaseEntity, S extends BaseSearchCriteria> {

    /**
     * Getting entity by specified id.
     *
     * @param id the entity's id
     * @return the optional for the requested entity
     */
    Optional<E> getById(Long id);

    /**
     * Getting all entities.
     *
     * @return the list of the entities
     */
    List<E> getAll();

    /**
     * Getting all entities by specified filter.
     *
     * @param filter the filter
     * @return the list of the entities
     */
    List<E> getAll(S filter);

    /**
     * Getting page of entities by specified pageable.
     *
     * @param pageable the pageable
     * @return the page of the entities
     */
    Page<E> getPage(Pageable pageable);

    /**
     * Getting page of entities by specified pageable and filter.
     *
     * @param filter   the filter
     * @param pageable the pageable
     * @return the page of the entities
     */
    Page<E> getPage(S filter, Pageable pageable);

    /**
     * Saving specified entity.
     *
     * @param entity the entity
     * @return the saved entity
     */
    E save(E entity);

    /**
     * Saving specified list of entities
     *
     * @param entities the entities
     * @return the list of saved entities
     */
    List<E> saveAll(List<E> entities);

    /**
     * Deleting the list of the entities.
     *
     * @param entities the list of the entities
     */
    void delete(List<E> entities);

    /**
     * Deleting the list of the entities in batch.
     *
     * @param entities the list of the entities
     */
    void deleteInBatch(List<E> entities);

    /**
     * Creating the example by the specified searchCriteria.
     *
     * @param searchCriteria the searchCriteria
     * @return the example
     */
    Specification<E> createSpecification(S searchCriteria);
}
