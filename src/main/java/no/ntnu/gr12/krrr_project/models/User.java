package no.ntnu.gr12.krrr_project.models;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String username;
  private String password;
  private String bio;
  private String name;
  private String email;
  @OneToOne(cascade = {CascadeType.ALL})
  private ShoppingCart cart;
  private boolean active = true;
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "user_role",
          joinColumns = @JoinColumn(name="user_id"),
          inverseJoinColumns = @JoinColumn(name="role_id")
  )

  private Set<Role> roles = new LinkedHashSet<>();

  /**
   * Empty constructor needed for JPA
   */
  public User() {
  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
    this.cart = new ShoppingCart();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String description) {
    this.email = description;
  }

  public boolean hasRole(String roleName) {
    boolean found = false;
    Iterator<Role> it = roles.iterator();
    while (!found && it.hasNext()) {
      Role role = it.next();
      if (role.getName().equals(roleName)) {
        found = true;
      }
    }
    return found;
  }
  /**
   * Adds role to user
   * @param role Role which should be added to user.
   */
  public void addRole(Role role) {
    roles.add(role);
  }

  public Long getCartID() {
    return cart.getCartID();
  }

  public void setCart(ShoppingCart cart) {
    this.cart = cart;
  }

  public ShoppingCart getCart() {
    return this.cart;
  }

  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
