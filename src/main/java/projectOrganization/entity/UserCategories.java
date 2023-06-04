package projectOrganization.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "Категории_пользователей")

public class UserCategories {
    @Id
    @Column(name = "ID_категории")
    private Integer id_category;

    @Column(name = "Название_категории", nullable = false)
    private String name_category;

    @OneToMany(mappedBy = "id_user")
    private List<Users> users;

    public UserCategories(Integer id_category, String name_category) {
        this.id_category = id_category;
        this.name_category = name_category;
    }

    public UserCategories() { }

    public Integer getId_category() { return id_category; }

    public void setId_category(Integer id_category) { this.id_category = id_category; }

    public String getName_category() { return name_category; }

    public void setName_category(String name_category) { this.name_category = name_category; }

    public List<Users> getUsers() { return users; }

    public void setUsers(List<Users> users) { this.users = users; }
}

