package no.ntnu.gr12.krrr_project.services;

import no.ntnu.gr12.krrr_project.models.Item;
import no.ntnu.gr12.krrr_project.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    @Transactional
    public String addItem(Item item) {
        try {
            itemRepository.save(item);
            return "Item is saved";
        } catch (Exception e){
            return "Item already exists";
        }
    }


        public Iterable<Item> readCarts() {
        return itemRepository.findAll();
    }

        @Transactional
        public String updateItem(Item item) {
        if (itemRepository.findById(item.getItemID()).isPresent()) {
            try {
                Item itemToUpdate = itemRepository.findById(item.getItemID()).get();
                itemToUpdate.setItemID(item.getItemID());
                return "Item info is updated";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Item does not exist in DB";
        }
    }

        @Transactional
        public String deleteItem(Item item) {
        if (itemRepository.findById(item.getItemID()).isPresent()) {
            try {
                itemRepository.delete(item);
                return "Item has been deleted";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Item does not exist in DB";
        }
    }
}
