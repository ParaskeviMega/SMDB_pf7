package com.pf7.smdb.service;

import com.pf7.smdb.base.AbstractLogComponent;
import com.pf7.smdb.domain.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class BaseServiceImpl<T extends BaseModel> extends AbstractLogComponent implements BaseService<T,Long> {

    public abstract JpaRepository<T,Long> getRepository();

    @Override
    public T create(T obj) {
        logger.trace("Creating {}.",obj);
        return getRepository().save(obj);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public List<T> createAll(List<T> obj) {
        logger.trace("Creating All By List{}.",obj);
        return getRepository().saveAll(obj);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public List<T> createAll(T... obj) {
        logger.trace("Create All by Objs {}.",obj);
        return getRepository().saveAll(Arrays.asList(obj));
    }

    @Override
    public void update(T obj) {
        logger.trace("Updating {}.",obj);
        getRepository().save(obj);
    }

    @Override
    public void delete(T obj) {
        logger.trace("Delete {}.",obj);
        getRepository().delete(obj);
    }

    @Override
    public void deleteById(Long id) {
        logger.trace("Delete by Id {}.",id);
        getRepository().deleteById(id);
    }

    @Override
    public boolean exists(T obj) {
        logger.trace("Exists {}.",obj);
        return getRepository().existsById(obj.getId());
    }

    @Override
    public T find(Long id) {
        logger.trace("Find by Id {}.",id);
        return getRepository().findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<T> findAll() {
        logger.trace("Retrieving all data.");
        return getRepository().findAll();
    }
}
