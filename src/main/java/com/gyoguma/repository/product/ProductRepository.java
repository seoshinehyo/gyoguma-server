package com.gyoguma.repository.product;

import com.gyoguma.domain.Member;
import com.gyoguma.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {

    Page<Product> findAllByMember(Member member, PageRequest pageRequest);
}
