package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {


    Page<Blog> findAllByTacGiaContaining(String tieuDe, Pageable pageable);

    @Query("select U from Blog U where U.category.id=?1")
    Page<Blog> findAllByCategoryId(Integer id, Pageable pageable);
}
