package ir.maktab.entity;

import ir.maktab.base.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Account extends BaseEntity<Integer> {
    @Column(unique = true,nullable = false)
    private String username;
    private String email;
    @Column(nullable = false)
    private String password;
    private LocalDate createAt;

    public Account(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.createAt = LocalDate.now();
    }

    public static AccountBuilder builder() {
        return new AccountBuilder();
    }

    public static class AccountBuilder {
        private String username;
        private String email;
        private String password;
        AccountBuilder() {
        }

        public AccountBuilder username(String username) {
            this.username = username;
            return this;
        }

        public AccountBuilder email(String email) {
            this.email = email;
            return this;
        }

        public AccountBuilder password(String password) {
            this.password = password;
            return this;
        }

        public Account build() {
            return new Account(username, email, password);
        }
    }
}