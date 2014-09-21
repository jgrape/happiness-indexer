# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table team (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_team primary key (id))
;

create table team_member (
  id                        bigint not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  team_id                   bigint,
  constraint pk_team_member primary key (id))
;

create table vote (
  id                        bigint not null,
  team_member_id            bigint,
  day                       date,
  happiness                 integer,
  constraint pk_vote primary key (id))
;

create sequence team_seq;

create sequence team_member_seq;

create sequence vote_seq;

alter table team_member add constraint fk_team_member_team_1 foreign key (team_id) references team (id);
create index ix_team_member_team_1 on team_member (team_id);
alter table vote add constraint fk_vote_teamMember_2 foreign key (team_member_id) references team_member (id);
create index ix_vote_teamMember_2 on vote (team_member_id);



# --- !Downs

drop table if exists team cascade;

drop table if exists team_member cascade;

drop table if exists vote cascade;

drop sequence if exists team_seq;

drop sequence if exists team_member_seq;

drop sequence if exists vote_seq;

