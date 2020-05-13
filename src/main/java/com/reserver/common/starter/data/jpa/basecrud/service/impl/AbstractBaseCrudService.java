package com.reserver.common.starter.data.jpa.basecrud.service.impl;

import com.reserver.common.starter.data.jpa.basecrud.entity.BaseEntity;
import com.reserver.common.starter.data.jpa.basecrud.repository.BaseCrudRepository;
import com.reserver.common.starter.data.jpa.basecrud.search.BaseSearchCriteria;
import com.reserver.common.starter.data.jpa.basecrud.service.BaseCrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * The base abstract CRUD service implementation for extend.
 *
 * @param <E> the entity type
 * @param <F> the filter type
 */
public abstract class AbstractBaseCrudService<E extends BaseEntity, F extends BaseSearchCriteria> implements BaseCrudService<E, F> {

    protected BaseCrudRepository<E> repository;

    public AbstractBaseCrudService(BaseCrudRepository<E> repository) {
        this.repository = repository;
    }

    @Override
    public Optional<E> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<E> getAll() {
        return repository.findAll();
    }

    @Override
    public List<E> getAll(F filter) {
        return repository.findAll(createSpecification(filter));
    }

    @Override
    public Page<E> getPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<E> getPage(F filter, Pageable pageable) {
        return repository.findAll(createSpecification(filter), pageable);
    }

    @Override
    public E save(E entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(List<E> entities) {
        repository.deleteAll(entities);
    }

    @Override
    public void deleteInBatch(List<E> entities) {
        repository.deleteInBatch(entities);
    }
}
