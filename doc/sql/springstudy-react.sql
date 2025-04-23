
use springstudy

=============================================================

select * from board



create table zoo (
	id int(11) not null auto_increment comment 'seq id',
	species varchar(100) not null default 'any' comment '종',
	gender varchar(1) not null default 'M' comment '성별',
	name varchar(100) null default null comment '이름',
	age int(4) null default null comment '나이',
	reg_date datetime not null default current_timestamp comment '등록 날짜', 
	chg_date datetime not null default current_timestamp comment '변경 날짜',
	
	constraint zoo_pk primary key(id) comment '동물원'
)


-- alter
alter table zoo
add reg_date datetime not null default current_timestamp comment '등록 날짜',
add chg_date datetime not null default current_timestamp comment '변경 날짜'









