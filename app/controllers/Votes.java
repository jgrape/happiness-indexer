package controllers;

import models.TeamMember;
import models.Vote;
import play.db.ebean.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


public class Votes extends Controller {
  public static Result voteForm(final Long memberId) {
    final TeamMember teamMember = TeamMember.find.byId(memberId);
    Objects.requireNonNull(teamMember);

    return ok(views.html.votes.votesForm.render(teamMember));
  }


  @Transactional
  public static Result vote(final Long memberId, final Integer happiness) {
    final TeamMember teamMember = TeamMember.find.byId(memberId);
    Objects.requireNonNull(teamMember, "Det finns ingen medlem med id=" + memberId);

    LocalDate today = LocalDate.now();
    List<Vote> oldVotes = Vote.find.where().eq("team_member_id", memberId).eq("day", today).findList();
    oldVotes.stream().forEach(Vote::delete);

    Vote newVote = new Vote(null, teamMember, today, happiness);
    newVote.save();

    return ok(views.html.votes.thankyou.render(teamMember));
  }

}
