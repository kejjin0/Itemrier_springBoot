package com.hotSix.itemrier_boot.repository.item;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotSix.itemrier_boot.domain.category.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
