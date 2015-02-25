package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Vote extends Model {
  public static Finder<Long, Vote> find = new Finder<>(Long.class, Vote.class);

  @Id
  @GeneratedValue
  public Long id;

  @Constraints.Required
  @ManyToOne
  public TeamMember teamMember;

  @Constraints.Required
  public LocalDate day;

  @Constraints.Required
  @Constraints.Min(1)
  @Constraints.Max(5)
  public Integer happiness;

  public Vote(TeamMember teamMember, LocalDate day, Integer happiness) {
    this.teamMember = teamMember;
    this.day = day;
    this.happiness = happiness;
  }
}
