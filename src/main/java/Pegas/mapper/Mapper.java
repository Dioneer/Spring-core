package Pegas.mapper;

public interface Mapper <T, K>{
    K fromTo(T t);
}
