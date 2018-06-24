create table todo (
  id varchar(60) NOT NULL PRIMARY KEY,
  message text not null,
  created_date datetime not null,
  updated_date datetime not null,
  is_done bool not null
)