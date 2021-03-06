package com.coderscampus.olaf.guteidee.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coderscampus.olaf.guteidee.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findByTitle(String title);

	@Query("select distinct c from Category c"
			+ " left join fetch c.ideas"
			+ " order by c.id asc")
	Set<Category> findAllCategories();

	Set<Category> findByIdIn(List<Long> categoryIds);

}
