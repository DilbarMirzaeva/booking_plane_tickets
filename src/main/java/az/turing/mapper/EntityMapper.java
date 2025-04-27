package az.turing.mapper;

public interface EntityMapper<E, D>{
    E toEntity(D t);
    D toDto(E e);
}
