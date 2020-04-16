package com.reserver.common.starter.data.jpa.basecrud.service;

import com.reserver.common.starter.data.jpa.basecrud.entity.BaseEntity;
import com.reserver.common.starter.data.jpa.basecrud.filter.BaseFilter;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * The base CRUD service interface to extend.
 *
 * @param <E> - target entity type
 * @param <F> - target filter type
 */
public interface BaseCrudService<E extends BaseEntity, F extends BaseFilter> {

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
    List<E> getAll(F filter);

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
    Page<E> getPage(F filter, Pageable pageable);

    /**
     * Saving specified entity.
     *
     * @param entity the entity
     * @return the saved entity
     */
    E save(E entity);

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
     * Creating the example by the specified filter.
     *
     * @param filter the filter
     * @return the example
     */
    Example<E> createExample(BaseFilter filter);
}
