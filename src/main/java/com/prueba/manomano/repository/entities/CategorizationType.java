package com.prueba.manomano.repository.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "CATEGORIZATION_TYPE")
@Data
public class CategorizationType {

  @Id
  @Column(name = "CATEGORIZATION_ID")
  private Long id;

  @Column(name = "TYPE")
  private String type;

  @Column(name = "DESCRIPTION")
  private String desc;

  @OneToMany(mappedBy = "categorizationType")
  private List<Product> products;
}
