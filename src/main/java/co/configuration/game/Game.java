package co.configuration.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "game", schema = "configuration")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class Game {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(updatable = false, nullable = false)
  private Integer id;

  @Column(name = "game_code", nullable = false)
  private String code;

  @Column(name = "platform_id", nullable = false)
  private String platformId;

  @Column(name = "name", nullable = false)
  private String name;
}
