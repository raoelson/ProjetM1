/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Djazz Jah
 */
@Entity
@Table(name = "utilisateurs", catalog = "gesitoncommande_ligne", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"email_canonical"}),
    @UniqueConstraint(columnNames = {"username_canonical"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateurs.findAll", query = "SELECT u FROM Utilisateurs u"),
    @NamedQuery(name = "Utilisateurs.findById", query = "SELECT u FROM Utilisateurs u WHERE u.id = :id"),
    @NamedQuery(name = "Utilisateurs.findByUsername", query = "SELECT u FROM Utilisateurs u WHERE u.username = :username"),
    @NamedQuery(name = "Utilisateurs.findByUsernameCanonical", query = "SELECT u FROM Utilisateurs u WHERE u.usernameCanonical = :usernameCanonical"),
    @NamedQuery(name = "Utilisateurs.findByEmail", query = "SELECT u FROM Utilisateurs u WHERE u.email = :email"),
    @NamedQuery(name = "Utilisateurs.findByEmailCanonical", query = "SELECT u FROM Utilisateurs u WHERE u.emailCanonical = :emailCanonical"),
    @NamedQuery(name = "Utilisateurs.findByEnabled", query = "SELECT u FROM Utilisateurs u WHERE u.enabled = :enabled"),
    @NamedQuery(name = "Utilisateurs.findBySalt", query = "SELECT u FROM Utilisateurs u WHERE u.salt = :salt"),
    @NamedQuery(name = "Utilisateurs.findByPassword", query = "SELECT u FROM Utilisateurs u WHERE u.password = :password"),
    @NamedQuery(name = "Utilisateurs.findByLastLogin", query = "SELECT u FROM Utilisateurs u WHERE u.lastLogin = :lastLogin"),
    @NamedQuery(name = "Utilisateurs.findByLocked", query = "SELECT u FROM Utilisateurs u WHERE u.locked = :locked"),
    @NamedQuery(name = "Utilisateurs.findByExpired", query = "SELECT u FROM Utilisateurs u WHERE u.expired = :expired"),
    @NamedQuery(name = "Utilisateurs.findByExpiresAt", query = "SELECT u FROM Utilisateurs u WHERE u.expiresAt = :expiresAt"),
    @NamedQuery(name = "Utilisateurs.findByConfirmationToken", query = "SELECT u FROM Utilisateurs u WHERE u.confirmationToken = :confirmationToken"),
    @NamedQuery(name = "Utilisateurs.findByPasswordRequestedAt", query = "SELECT u FROM Utilisateurs u WHERE u.passwordRequestedAt = :passwordRequestedAt"),
    @NamedQuery(name = "Utilisateurs.findByCredentialsExpired", query = "SELECT u FROM Utilisateurs u WHERE u.credentialsExpired = :credentialsExpired"),
    @NamedQuery(name = "Utilisateurs.findByCredentialsExpireAt", query = "SELECT u FROM Utilisateurs u WHERE u.credentialsExpireAt = :credentialsExpireAt")})
public class Utilisateurs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "username", nullable = false, length = 255)
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "username_canonical", nullable = false, length = 255)
    private String usernameCanonical;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email", nullable = false, length = 255)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email_canonical", nullable = false, length = 255)
    private String emailCanonical;
    @Basic(optional = false)
    @NotNull
    @Column(name = "enabled", nullable = false)
    private boolean enabled;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "salt", nullable = false, length = 255)
    private String salt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "locked", nullable = false)
    private boolean locked;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expired", nullable = false)
    private boolean expired;
    @Column(name = "expires_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiresAt;
    @Size(max = 255)
    @Column(name = "confirmation_token", length = 255)
    private String confirmationToken;
    @Column(name = "password_requested_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date passwordRequestedAt;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "roles", nullable = false, length = 2147483647)
    private String roles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "credentials_expired", nullable = false)
    private boolean credentialsExpired;
    @Column(name = "credentials_expire_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date credentialsExpireAt;
    @OneToMany(mappedBy = "utilisateurId")
    private Collection<Commandes> commandesCollection;
    @OneToMany(mappedBy = "utilisateurId")
    private Collection<Utilisateursadresses> utilisateursadressesCollection;

    public Utilisateurs() {
    }

    public Utilisateurs(Integer id) {
        this.id = id;
    }

    public Utilisateurs(Integer id, String username, String usernameCanonical, String email, String emailCanonical, boolean enabled, String salt, String password, boolean locked, boolean expired, String roles, boolean credentialsExpired) {
        this.id = id;
        this.username = username;
        this.usernameCanonical = usernameCanonical;
        this.email = email;
        this.emailCanonical = emailCanonical;
        this.enabled = enabled;
        this.salt = salt;
        this.password = password;
        this.locked = locked;
        this.expired = expired;
        this.roles = roles;
        this.credentialsExpired = credentialsExpired;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernameCanonical() {
        return usernameCanonical;
    }

    public void setUsernameCanonical(String usernameCanonical) {
        this.usernameCanonical = usernameCanonical;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailCanonical() {
        return emailCanonical;
    }

    public void setEmailCanonical(String emailCanonical) {
        this.emailCanonical = emailCanonical;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean getLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean getExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Date expiresAt) {
        this.expiresAt = expiresAt;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Date getPasswordRequestedAt() {
        return passwordRequestedAt;
    }

    public void setPasswordRequestedAt(Date passwordRequestedAt) {
        this.passwordRequestedAt = passwordRequestedAt;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public boolean getCredentialsExpired() {
        return credentialsExpired;
    }

    public void setCredentialsExpired(boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }

    public Date getCredentialsExpireAt() {
        return credentialsExpireAt;
    }

    public void setCredentialsExpireAt(Date credentialsExpireAt) {
        this.credentialsExpireAt = credentialsExpireAt;
    }

    @XmlTransient
    public Collection<Commandes> getCommandesCollection() {
        return commandesCollection;
    }

    public void setCommandesCollection(Collection<Commandes> commandesCollection) {
        this.commandesCollection = commandesCollection;
    }

    @XmlTransient
    public Collection<Utilisateursadresses> getUtilisateursadressesCollection() {
        return utilisateursadressesCollection;
    }

    public void setUtilisateursadressesCollection(Collection<Utilisateursadresses> utilisateursadressesCollection) {
        this.utilisateursadressesCollection = utilisateursadressesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateurs)) {
            return false;
        }
        Utilisateurs other = (Utilisateurs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.Entities.Utilisateurs[ id=" + id + " ]";
    }
    
}
