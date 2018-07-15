/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.service.custom.impl;

import com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE;
import com.ijse.shoppingcart.DTO.OrderDTO;
import com.ijse.shoppingcart.modal.Order;
import com.ijse.shoppingcart.repostory.RepositoryFactory;
import com.ijse.shoppingcart.repostory.custom.OrderRepository;
import com.ijse.shoppingcart.service.custom.OrderService;
import java.util.List;

/**
 *
 * @author Hafees
 */
public class OrderServiceImpl implements OrderService{
    private OrderRepository orderRepository=null;   
    
    public OrderServiceImpl() throws Exception {
         orderRepository =  (OrderRepository) RepositoryFactory.getInstance().getRepository(CONSTANTSTYPE.ORDERS);
    }
    

    @Override
    public boolean insert(OrderDTO dto) throws Exception {
     
        Order order = new Order(dto.getOid(), dto.getDate(), dto.getTIME(),dto.getCid(),dto.getTOTALQTY(),dto.getTotalvalue());
        return  orderRepository.save(order);
    }

    @Override
    public boolean remove(OrderDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(OrderDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderDTO findOne(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrderDTO> showAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
