
create table board(
	board_no int auto_increment,
	board_subject varchar(100) not null,
	board_writer varchar(50) not null,
	board_content text,  
	board_regiDate datetime default now(),
	board_views int default 0,
	member_id varchar(50),
	
	primary key(board_no)
)

drop table board;

select * from board;
select count(*) from board;
select * 
from board
limit 20, 5; -- 여기 start,

  select * 
        from (
        	select (@ROWNUM:=@ROWNUM+1),B.*
        	from board B, (SELECT @ROWNUM:=0) TMP
        )T
        order by board_no desc
        limit 0,3

insert into board (board_subject,board_writer,board_content,member_id)
values('글1 입니다.','test','안녕하세요!!1','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글2 입니다.','test','안녕하세요!!2','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글3 입니다.','test','안녕하세요!!3','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글4 입니다.','test','안녕하세요!!4','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글5 입니다.','test','안녕하세요!!5','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글6 입니다.','test','안녕하세요!!6','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글7 입니다.','test','안녕하세요!!7','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글8 입니다.','test','안녕하세요!!8','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글1 입니다.','test','안녕하세요!!1','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글2 입니다.','test','안녕하세요!!2','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글3 입니다.','test','안녕하세요!!3','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글4 입니다.','test','안녕하세요!!4','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글5 입니다.','test','안녕하세요!!5','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글6 입니다.','test','안녕하세요!!6','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글7 입니다.','test','안녕하세요!!7','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글8 입니다.','test','안녕하세요!!8','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글1 입니다.','test','안녕하세요!!1','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글2 입니다.','test','안녕하세요!!2','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글3 입니다.','test','안녕하세요!!3','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글4 입니다.','test','안녕하세요!!4','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글5 입니다.','test','안녕하세요!!5','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글6 입니다.','test','안녕하세요!!6','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글7 입니다.','test','안녕하세요!!7','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글8 입니다.','test','안녕하세요!!8','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글1 입니다.','test','안녕하세요!!1','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글2 입니다.','test','안녕하세요!!2','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글3 입니다.','test','안녕하세요!!3','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글4 입니다.','test','안녕하세요!!4','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글5 입니다.','test','안녕하세요!!5','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글6 입니다.','test','안녕하세요!!6','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글7 입니다.','test','안녕하세요!!7','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글8 입니다.','test','안녕하세요!!8','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글1 입니다.','test','안녕하세요!!1','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글2 입니다.','test','안녕하세요!!2','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글3 입니다.','test','안녕하세요!!3','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글4 입니다.','test','안녕하세요!!4','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글5 입니다.','test','안녕하세요!!5','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글6 입니다.','test','안녕하세요!!6','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글7 입니다.','test','안녕하세요!!7','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글8 입니다.','test','안녕하세요!!8','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글1 입니다.','test','안녕하세요!!1','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글2 입니다.','test','안녕하세요!!2','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글3 입니다.','test','안녕하세요!!3','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글4 입니다.','test','안녕하세요!!4','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글5 입니다.','test','안녕하세요!!5','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글6 입니다.','test','안녕하세요!!6','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글7 입니다.','test','안녕하세요!!7','test');
insert into board (board_subject,board_writer,board_content,member_id)
values('글8 입니다.','test','안녕하세요!!8','test');


truncate table board;


			delete from board;
			
			
select * 
from (
	select (@ROWNUM:=@ROWNUM+1),B.*
	from (
		
		select *
		from board
		where board_writer LIKE '%'||'h'||'%' 
		
	) B, (SELECT @ROWNUM:=0) TMP
)T
order by board_no desc
limit 0,5

select * from board;





create procedure insertBoard100Proc
begin
	DECLARE I INT;
	
	SET I = 1;
	
	MYWHILE : WHILE(I <= 100) DO
		insert into board (board_subject,board_writer,board_content,member_id)
			values('첫번째 글입니다.','test','안녕하세요!!'+I,'test');
		
		SET I = I+1;
	ITERATE MYWHILE;
	
end 

call insertBoard100Proc









