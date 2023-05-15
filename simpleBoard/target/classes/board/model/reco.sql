
create table board_reco(
	reco_no int auto_increment,
	member_id varchar(50) not null,
	board_no int not null,
	reco_status int not null,
	reco_regiDate datetime default now(),
	
	primary key(reco_no)
)

drop table board_reco;
truncate table board_reco;

select * from board_reco;