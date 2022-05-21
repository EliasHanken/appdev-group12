package no.ntnu.gr12.krrr_project.services;

import no.ntnu.gr12.krrr_project.models.Item;
import no.ntnu.gr12.krrr_project.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ItemService {

  @Autowired
  private ItemRepository repository;

  @Transactional
  public String addItem(Item item) {
    try {
      if(repository.findById(item.getItemID().toString()).isEmpty()) {
        repository.save(item);
        return "Item is saved";
      } else {
        return "Item already exists";
      }
    } catch (Exception e) {
      throw e;
    }
  }

  public Iterable<Item> readItems() {
    return repository.findAll();
  }

  @Transactional
  public String updateItem(Item item) {
    if (repository.findById(item.getItemID().toString()).isEmpty()) {
      try {
        Item itemToBeUpdated = repository.findById(item.getItemID().toString()).get();
        itemToBeUpdated.setItemID(item.getItemID());
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
    if (repository.findById(item.getItemID().toString()).isPresent()) {
      try {
        repository.delete(item);
        return "Item is deleted";
      } catch (Exception e) {
        throw e;
      }
    } else {
      return "Item does not exist in DB";
    }
  }
}
