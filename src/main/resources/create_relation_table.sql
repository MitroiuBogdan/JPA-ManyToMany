create table yllu_bank_client 
(
id varchar(50) not null,
client_id varchar(50) not null,
bank_id varchar(50) not null,
constraint bank_client_pk primary key(id),
constraint bank_client_bank_fk foreign key(bank_id) references yllu_bank(id),
constraint bank_client_client_fk foreign key(client_id) references yllu_client(id)
)