package ua.goit.petstore.repository;

import ua.goit.petstore.model.BaseEntity;
import java.util.Optional;

public interface BaseRepository<E extends BaseEntity<ID>, ID> {

    E save(E e);

    E deleteById(ID id);

    E getOne(ID id);

    Optional<E> findById(ID id);

}
