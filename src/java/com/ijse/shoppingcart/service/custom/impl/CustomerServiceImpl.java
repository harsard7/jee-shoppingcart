/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.service.custom.impl;

import com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE;
import com.ijse.shoppingcart.DTO.CustomerDTO;
import com.ijse.shoppingcart.modal.Customer;
import com.ijse.shoppingcart.repostory.RepositoryFactory;
import com.ijse.shoppingcart.repostory.SuperRepository;
import com.ijse.shoppingcart.repostory.custom.CustomerRepository;
import com.ijse.shoppingcart.service.custom.CustomerService;
import java.util.List;

/**
 *
 * @author Hafees
 */
public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository customerRepository=null;

    public CustomerServiceImpl() throws Exception {
         customerRepository = (CustomerRepository) RepositoryFactory.getInstance().getRepository(CONSTANTSTYPE.CUSTOMER);
        
    }
    
    @Override
    public boolean insert(CustomerDTO dto) throws Exception {
        
        Customer customer=new Customer(dto.getId(), dto.getName(),dto.getPassword(), dto.getGender(),dto.getDob(),dto.getContact());
        System.out.println(" service "+customer);
        return customerRepository.save(customer);
    }

    @Override
    public boolean remove(CustomerDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(CustomerDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CustomerDTO findOne(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CustomerDTO> showAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
