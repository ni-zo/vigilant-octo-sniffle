package com.natural.beauty.Model.Repository;

import com.natural.beauty.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
