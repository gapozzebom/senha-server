package senha.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Senha {

  @Id
  @GeneratedValue
  private Long id;
  private String tpoFila;
  private String numero;
  private Boolean isDeleted;
  private LocalDateTime chamadoEm;

}
