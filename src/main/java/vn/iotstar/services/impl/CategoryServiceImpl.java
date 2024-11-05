package vn.iotstar.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import vn.iotstar.entity.CategoryEntity;
import vn.iotstar.repository.CategoryRepository;
import vn.iotstar.services.CategoryService;
import org.thymeleaf.util.StringUtils;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository;
	
	
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void deleteById(Integer id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public long count() {
		return categoryRepository.count();
	}

	@Override
	public List<CategoryEntity> findAll() {
		return categoryRepository.findAll();
	}

	public <S extends CategoryEntity> S save(S entity) {
		if(entity.getCategoryId() == null) {
			return categoryRepository.save(entity);
		}
		else {
			Optional<CategoryEntity> opt = findById(entity.getCategoryId());
			if (opt.isPresent()) {
				if(StringUtils.isEmpty(entity.getCategoryName())) {
					entity.setCategoryName(opt.get().getCategoryName());
				}
				else {
					entity.setCategoryName(entity.getCategoryName());
				}
			}
		}
		return categoryRepository.save(entity);
	}

	@Override
	public Optional<CategoryEntity> findById(Integer id) {
		return categoryRepository.findById(id);
	}

	@Override
	public List<CategoryEntity> findByCategoryNameContaining(String name) {
		return categoryRepository.findByCategoryNameContaining(name);
	}

	@Override
	public Page<CategoryEntity> findByCategoryNameContaining(String name, Pageable pageable) {
		return categoryRepository.findByCategoryNameContaining(name, pageable);
	}

	@Override
	public Page<CategoryEntity> findAll(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	@Override
	public List<CategoryEntity> findAll(Sort sort) {
		return categoryRepository.findAll(sort);
	}

	@Override
	public List<CategoryEntity> findAllById(Iterable<Integer> ids) {
		return categoryRepository.findAllById(ids);
	}

	@Override
	public void deleteAll() {
		categoryRepository.deleteAll();
	}

}
