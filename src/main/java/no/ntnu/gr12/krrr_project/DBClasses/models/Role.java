package no.ntnu.gr12.krrr_project.DBClasses.models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * @author Thomas Ystenes
 * Class for handeling user roles.
 */
@Entity(name="roles")
public class Role {
  @Id
  @GeneratedValue
  private Long id;

  private String name;

  @ManyToMany(mappedBy ="roles")
  private Set<User> users = new LinkedHashSet<>();

  /**
   * Empty constructor for JPA
   */
  public Role() {

  }

  public Role(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<User> getUsers() {
    return users;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }
}
