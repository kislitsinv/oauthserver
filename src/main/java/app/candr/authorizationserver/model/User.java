package app.candr.authorizationserver.model;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user", schema = "candr_oauthserver")
@Data
public class User implements Serializable {
    public User() {
    }

    public User(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.enabled = user.isEnabled();
        this.accountExpired = user.isAccountExpired();
        this.credentialsExpired = user.isCredentialsExpired();
        this.accountLocked = user.isAccountLocked();
        this.roles = user.getRoles();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "active")
    private boolean enabled;
    @Column(name = "account_expired")
    private boolean accountExpired;
    @Column(name = "credentials_expired")
    private boolean credentialsExpired;
    @Column(name = "account_locked")
    private boolean accountLocked;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_user", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;



}
