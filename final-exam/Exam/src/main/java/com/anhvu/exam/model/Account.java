package com.anhvu.exam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(unique = true)
    @NotBlank(message = "Account Number cannot be empty")
    private String accountNumber;

    @NotNull(message = "Opened Date cannot be empty")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate dateOpened;

    @NotNull(message = "Active Status cannot be null")
    @Enumerated(EnumType.STRING)
    private ActiveStatus status;

    @NotNull(message = "Balance cannot be null")
    private Double balance;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }, mappedBy = "accounts")
    @JsonIgnore
    private Set<Customer> customers = new HashSet<>();
}
