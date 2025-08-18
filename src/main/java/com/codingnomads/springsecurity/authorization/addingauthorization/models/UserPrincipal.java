/* CodingNomads (C)2024 */
package com.codingnomads.springsecurity.authorization.addingauthorization.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPrincipal implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    @JsonIgnore
    private String password;

    @OneToOne(cascade = CascadeType.PERSIST, optional = false)
    private UserMeta userMeta;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "user_authority_join_table",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private List<Authority> authorities;

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public UserPrincipal(String username, String password, List<Authority> authorities, UserMeta userMeta) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.userMeta = userMeta;
        accountNonExpired = true;
        accountNonLocked = true;
        credentialsNonExpired = true;
        enabled = true;
    }
}
