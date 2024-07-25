package com.veryveg.product.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.veryveg.product.entity.TipiProdotto;


@Repository
public interface TipiProdottoRepository extends MongoRepository<TipiProdotto, String> {

}