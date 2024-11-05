package vn.iotstar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iotstar.entity.CategoryEntity;


@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer>{
	//tim kiem noi dung theo ten
	// Đổi tên phương thức nếu thuộc tính thực sự là 'categoryName'
	List<CategoryEntity> findByCategoryNameContaining(String categoryName);
	Page<CategoryEntity> findByCategoryNameContaining(String categoryName, Pageable pageable);

	Page<CategoryEntity> findAll(Pageable pageable);
	List<CategoryEntity> findAll(Sort sort);
	List<CategoryEntity> findAllById(Iterable<Integer> ids);
}
