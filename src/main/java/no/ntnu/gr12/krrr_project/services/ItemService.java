package no.ntnu.gr12.krrr_project.services;

import no.ntnu.gr12.krrr_project.models.Item;
import no.ntnu.gr12.krrr_project.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemService {
        @Autowired
        ItemRepository repository;

        @Transactional
        public String addItem(Item item) {
            repository.save(item);
        /*try {
            //TODO wonky solution by making ID into toString, but IDK should work?
            if(repository.findById(item.getItemID()).isEmpty()) {

                return "Item is saved";
            } else {
                return "Item already exists";
            }
        } catch (Exception e) {
            throw e;
        }*/
            return "The item was added";
    }

        public Iterable<Item> readCarts() {
        return repository.findAll();
    }

        @Transactional
        public String updateItem(Item item) {
        if (repository.findById(item.getItemID()).isPresent()) {
            try {
                Item itemToUpdate = repository.findById(item.getItemID()).get();
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
        if (repository.findById(item.getItemID()).isPresent()) {
            try {
                repository.delete(item);
                return "Item has been deleted";
            } catch (Exception e) {
                throw e;
            }
        } else {
            return "Item does not exist in DB";
        }
    }
}
