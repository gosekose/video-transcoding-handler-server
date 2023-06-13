alter table video_metadata

drop
foreign key FKccwcre7a2ik4379h39pen4rx5;

drop table if exists video_description_seq;
drop table if exists video_metadata_seq;
drop table if exists video_description;
drop table if exists video_metadata;

create table video_description_seq (
    next_val bigint
) engine=InnoDB;

insert into video_description_seq values ( 1 );

create table video_metadata_seq (
    next_val bigint
) engine=InnoDB;

insert into video_metadata_seq values ( 1 );

create table video_description (
   video_description_id bigint not null,
   primary key (video_description_id)
) engine=InnoDB;

create table video_metadata (
    video_description_id bigint,
    video_metadata_id bigint not null,
    bitrate varchar(255),
    duration varchar(255),
    file_path varchar(255),
    format varchar(255),
    primary key (video_metadata_id)
) engine=InnoDB;

alter table video_metadata
    add constraint FKccwcre7a2ik4379h39pen4rx5
        foreign key (video_description_id)
            references video_description (video_description_id);


