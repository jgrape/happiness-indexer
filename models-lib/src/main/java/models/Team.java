package models;

import lombok.EqualsAndHashCode;
import lombok.Value;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Value
@Entity
public class Team extends Model {
  public static Finder<Long, Team> find = new Finder<>(Long.class, Team.class);

  @Id
  @GeneratedValue
  Long id;

  @Constraints.Required
  String name;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @OrderBy("firstName, lastName")
  List<TeamMember> teamMembers;
}
