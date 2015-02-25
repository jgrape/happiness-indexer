package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TeamMember extends Model {
  public static Finder<Long, TeamMember> find = new Finder<>(Long.class, TeamMember.class);

  @Id
  @GeneratedValue
  public Long id;

  @Constraints.Required
  public String firstName;

  @Constraints.Required
  public String lastName;

  @Constraints.Required
  @ManyToOne
  public Team team;

  public String name() {
    return firstName + " " + lastName;
  }
}
