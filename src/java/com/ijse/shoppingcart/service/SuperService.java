/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.service;

import com.ijse.shoppingcart.DTO.SuperDTO;
import java.util.List;

/**
 *
 * @author Hafees
 */
public interface SuperService<E extends SuperDTO>{
    public boolean insert(E dto)throws Exception;
    public boolean remove(E dto)throws Exception;
    public boolean update(E dto)throws Exception;
    public E findOne(String id)throws Exception;
    public List<E> showAll()throws Exception;
}
