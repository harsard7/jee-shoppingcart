/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.service.custom.impl;

import com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE;
import com.ijse.shoppingcart.DTO.OrderDetailDTO;
import com.ijse.shoppingcart.modal.OrderDetail;
import com.ijse.shoppingcart.repostory.RepositoryFactory;
import com.ijse.shoppingcart.repostory.custom.OrderDetailRepository;
import com.ijse.shoppingcart.service.ServiceFactory;
import com.ijse.shoppingcart.service.SuperService;
import com.ijse.shoppingcart.service.custom.OrderDetailService;
import java.util.List;

/**
 *
 * @author Hafees
 */
public class OrderDetailServiceImpl implements OrderDetailService{
    private OrderDetailRepository orderDetailrepository=null;
    
    public OrderDetailServiceImpl() throws Exception {
         orderDetailrepository = (OrderDetailRepository) RepositoryFactory.getInstance().getRepository(CONSTANTSTYPE.ORDERDETAIL);
    }
    
    @Override
    public boolean insert(OrderDetailDTO dto) throws Exception {
        return orderDetailrepository.save(new OrderDetail(dto.getOid(), dto.getItemid(), dto.getDate(), dto.getQty(), dto.getPrice()));
    }

    @Override
    public boolean remove(OrderDetailDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(OrderDetailDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderDetailDTO findOne(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrderDetailDTO> showAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
