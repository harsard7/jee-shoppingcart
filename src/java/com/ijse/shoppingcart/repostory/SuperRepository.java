/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.repostory;

import com.ijse.shoppingcart.modal.SuperModal;
import java.util.List;

/**
 *
 * @author Hafees
 */
public interface SuperRepository<E> {
    
    public boolean save(E modal)throws Exception;
    public boolean delete(E modal)throws Exception;
    public boolean update(E modal)throws Exception;
    public E search(String id)throws Exception;
    public List<E> getAll()throws Exception;
    
    
}
