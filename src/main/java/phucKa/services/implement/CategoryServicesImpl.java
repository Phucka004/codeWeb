package phucKa.services.implement;

import phucKa.dao.ICategoryDao;
import phucKa.dao.implement.CategoryDaoImpl;
import phucKa.models.CategoryModel;
import phucKa.services.ICategoryServices;

import java.util.List;

public class CategoryServicesImpl implements ICategoryServices {

    public ICategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<CategoryModel> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public CategoryModel findById(int id) {
        return categoryDao.findByID(id);
    }

    @Override
    public void insert(CategoryModel category) {
        categoryDao.insert(category);
    }

    @Override
    public void update(CategoryModel category) {
        categoryDao.update(category);
    }

    @Override
    public void delete(int id) {
        categoryDao.delete(id);
    }

    @Override
    public List<CategoryModel> findName(String keyword) {
        return categoryDao.findName(keyword);
    }

    public static void main(String[] args) {
        CategoryServicesImpl categoryServices = new CategoryServicesImpl();
        List<CategoryModel> list = categoryServices.findAll();
        for (CategoryModel categoryModel : list) {
            System.out.println(categoryModel.getCategoryname());
        }
    }
}
