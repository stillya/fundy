package com.fundy.proccesorservice.entities;

import com.fundy.commons.dto.types.CategoryType;
import com.fundy.commons.dto.types.TransactionType;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "transactions")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEntity {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Type(type = "org.hibernate.type.PostgresUUIDType")
  private UUID id;

  @Column(name = "account_id", nullable = false)
  private UUID accountId;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "transaction_type", nullable = false)
  @Enumerated(EnumType.STRING)
  private TransactionType type;

  @Column(name = "category")
  @Enumerated(EnumType.STRING)
  private CategoryType category;

  @Column(name = "amount", nullable = false)
  private BigInteger amount;

  @Column(name = "current_balance", nullable = false)
  private BigInteger currentBalance;

  @Column(name = "creation_date", nullable = false)
  private LocalDateTime creationDate;

  //
  // RELATIONS
  //

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "account_id", insertable = false, updatable = false)
  private AccountEntity account;

}
