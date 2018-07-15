/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.service.custom.impl;

import com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE;
import com.ijse.shoppingcart.DTO.CategoryDTO;
import com.ijse.shoppingcart.modal.Category;
import com.ijse.shoppingcart.repostory.RepositoryFactory;
import com.ijse.shoppingcart.repostory.custom.CategoryRepository;
import com.ijse.shoppingcart.service.ServiceFactory;
import com.ijse.shoppingcart.service.SuperService;
import com.ijse.shoppingcart.service.custom.CategoryService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hafees
 */
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;
    public CategoryServiceImpl() throws Exception {
         categoryRepository =  (CategoryRepository) RepositoryFactory.getInstance().getRepository(CONSTANTSTYPE.CATEGORY);
    }    

    @Override
    public boolean insert(CategoryDTO dto) throws Exception {
        Category category=new Category(dto.getId(), dto.getName());
        return  categoryRepository.save(category);
    }

    @Override
    public boolean remove(CategoryDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(CategoryDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CategoryDTO findOne(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CategoryDTO> showAll() throws Exception {
        List<Category> catlist = categoryRepository.getAll();
        List<CategoryDTO>categlist=null;
        
        for (Category category : catlist) {
            CategoryDTO ct=new CategoryDTO(category.getId(), category.getName());
            if(categlist==null){
            categlist=new ArrayList<>();
            }
            categlist.add(ct);
        }
        return categlist;
    }
    
}
