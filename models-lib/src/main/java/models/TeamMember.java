package models;

import lombok.EqualsAndHashCode;
import lombok.Value;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = false)
@Value
@Entity
public class TeamMember extends Model {
  public static Finder<Long, TeamMember> find = new Finder<>(Long.class, TeamMember.class);

  @Id
  @GeneratedValue
  Long id;

  @Constraints.Required
  String firstName;

  @Constraints.Required
  String lastName;

  @Constraints.Required
  @ManyToOne
  Team team;

  public String name() {
    return firstName + " " + lastName;
  }
}
