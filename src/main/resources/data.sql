create schema wikicredit;

drop table if exists company;
drop table if exists wikipedia_data;

create table wikipedia_data
(
    id int auto_increment,
    title varchar2 not null,
    page_id int,
    summary clob,
    loading_timestamp timestamp
);

alter table wikipedia_data
    add constraint WIKIPEDIA_DATA_PK
        primary key (id);

create unique index WIKI_COMPANY_TITLE_UINDEX
    on wikipedia_data (title);

comment on table wikipedia_data is 'Data loaded from Wikipedia REST API';

create table company
(
    id int auto_increment,
    title varchar2 not null,
    wikipedia_data_id int
);

comment on table company is 'Our table for entity - company name, identified by by id';

alter table company
    add constraint COMPANY_PK
        primary key (id);

alter table company
    add foreign key (wikipedia_data_id)
        references wikipedia_data(id);

create unique index COMPANY_TITLE_UINDEX
    on company (title);

-- INSERT INTO COMPANY (title) VALUES ('Swedbank');
-- INSERT INTO COMPANY (title) VALUES ('AirBaltic');
-- INSERT INTO COMPANY (title) VALUES ('Ave_Line');
-- INSERT INTO COMPANY (title) VALUES ('Olainfarm');
-- INSERT INTO COMPANY (title) VALUES ('VEF');

commit;