
use springstudy

===========================================================================================

CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(100) NOT NULL COMMENT '제목',
  `writer` varchar(100) NOT NULL COMMENT '작성자',
  `contents` text DEFAULT NULL COMMENT '내용',
  `hits` int(11) NOT NULL default '0' COMMENT '조회수',
  `frst_reg_date` datetime NOT NULL DEFAULT current_timestamp() COMMENT '최초등록일',
  `frst_reg_user_id` varchar(20) NOT NULL DEFAULT 'SYSTEM' COMMENT '최초등록자',
  `last_chg_date` datetime NOT NULL DEFAULT current_timestamp() COMMENT '변경등록일',
  `last_chg_user_id` varchar(20) NOT NULL DEFAULT 'SYSTEM' COMMENT '변경등록자',  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci

CREATE TABLE `attach` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `blog_id` int(11) NOT NULL COMMENT 'blog id',
  `name` varchar(100) NOT NULL COMMENT '이름',
  `path` text NOT NULL COMMENT '경로',
  `size` varchar(100) DEFAULT NULL COMMENT '용량',
  `frst_reg_date` datetime NOT NULL DEFAULT current_timestamp() COMMENT '최초등록일',
  `frst_reg_user_id` varchar(20) NOT NULL DEFAULT 'SYSTEM' COMMENT '최초등록자',
  `last_chg_date` datetime NOT NULL DEFAULT current_timestamp() COMMENT '변경등록일',
  `last_chg_user_id` varchar(20) NOT NULL DEFAULT 'SYSTEM' COMMENT '변경등록자',  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci

CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `blog_id` int(11) NOT NULL COMMENT 'blog id',
  `writer` varchar(100) NOT NULL COMMENT '작성자',
  `contents` text DEFAULT NULL COMMENT '내용',
  `frst_reg_date` datetime NOT NULL DEFAULT current_timestamp() COMMENT '최초등록일',
  `frst_reg_user_id` varchar(20) NOT NULL DEFAULT 'SYSTEM' COMMENT '최초등록자',
  `last_chg_date` datetime NOT NULL DEFAULT current_timestamp() COMMENT '변경등록일',
  `last_chg_user_id` varchar(20) NOT NULL DEFAULT 'SYSTEM' COMMENT '변경등록자',  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci


-- alter
alter table zoo
add reg_date datetime not null default current_timestamp comment '등록 날짜',
add chg_date datetime not null default current_timestamp comment '변경 날짜'


===========================================================================================

insert into blog (title, writer, contents) values ("제목1", "작성자1", "내용1")
insert into blog (title, writer, contents) values ("제목2", "작성자2", "내용2")
insert into blog (title, writer, contents) values ("제목3", "작성자3", "내용3")


===========================================================================================

commit

select * from blog

select * from board















