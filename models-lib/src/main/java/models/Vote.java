package models;

import lombok.EqualsAndHashCode;
import lombok.Value;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@Value
@Entity
public class Vote extends Model {
  public static Finder<Long, Vote> find = new Finder<>(Long.class, Vote.class);

  @Id
  @GeneratedValue
  Long id;

  @Constraints.Required
  @ManyToOne
  TeamMember teamMember;

  @Constraints.Required
  LocalDate day;

  @Constraints.Required
  @Constraints.Min(1)
  @Constraints.Max(5)
  Integer happiness;
}
