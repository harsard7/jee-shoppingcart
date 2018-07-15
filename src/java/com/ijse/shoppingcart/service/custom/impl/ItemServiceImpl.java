/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.service.custom.impl;

import com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE;
import com.ijse.shoppingcart.DTO.ItemDTO;
import com.ijse.shoppingcart.modal.Item;
import com.ijse.shoppingcart.repostory.RepositoryFactory;
import com.ijse.shoppingcart.repostory.custom.ItemRepository;
import com.ijse.shoppingcart.service.custom.ItemService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hafees
 */
public class ItemServiceImpl implements ItemService{
    private ItemRepository itemRepository;

    public ItemServiceImpl() throws Exception {
        itemRepository=(ItemRepository) RepositoryFactory.getInstance().getRepository(CONSTANTSTYPE.ITEM);
    }
    
    @Override
    public boolean insert(ItemDTO dto) throws Exception {
        Item item=new Item(dto.getId(), dto.getCatid(), dto.getDescription(), dto.getPrice(), dto.getQty(),dto.getImage());
        return itemRepository.save(item);
    }

    @Override
    public boolean remove(ItemDTO dto) throws Exception {
       Item item=new Item(dto.getId(), dto.getCatid(), dto.getDescription(),dto.getPrice(),dto.getQty(), dto.getImage());
        return itemRepository.delete(item);
    }

    @Override
    public boolean update(ItemDTO dto) throws Exception {
        Item item=new Item(dto.getId(), dto.getCatid(), dto.getDescription(),dto.getPrice(),dto.getQty(), dto.getImage());
        return itemRepository.update(item);
    }

    @Override
    public ItemDTO findOne(String id) throws Exception {
        Item item = itemRepository.search(id);
        System.out.println("ItemServiceImpl  "+item);
        ItemDTO itemDTO=new ItemDTO(
                item.getId(),
                item.getCatid(), 
                item.getDescription(),
                item.getPrice(),
                item.getQty(),
                item.getImage() 
                    );
        return itemDTO;
    }

    @Override
    public List<ItemDTO> showAll() throws Exception {
        List<Item> itemlist = itemRepository.getAll();
        List<ItemDTO>itemslst=null;
        if(itemlist!=null){
            for (Item item : itemlist) {
                ItemDTO itemDTO=new ItemDTO(
                        item.getId(),
                        item.getCatid() ,
                        item.getDescription(),
                        item.getPrice(),
                        item.getQty(),
                        item.getImage()
                        );
                if(itemslst==null){
                itemslst=new ArrayList<>();
                }
                itemslst.add(itemDTO);
            }
        }
        return itemslst;
    }
    
}
