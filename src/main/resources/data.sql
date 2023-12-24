-- 유저
INSERT INTO users (name, id, password, email, bio, join_date)
VALUES ('황혜경', 'hye_123', 'password123', 'hye@example.com', '안녕!', now()),
       ('손아섭', 'son_123', 'password123', 'son@example.com', '야구가 좋아!', now());

-- 거지방
INSERT INTO rooms (name, creator_no, description, capacity)
VALUES ('커피 아끼기', 1, '커피를 덜 마셔서 거지를 탈출하자', 10),
       ('야빠 거지방', 2, '거지 두산베이스 방', 15);

-- 그룹 있는 게시글
INSERT INTO posts (amount, item, content, author_no, room_no)
VALUES (4500, '아메리카노', '죄송합니다. 제가 스벅충이라 ㅋㅋ', 1, 1),
       (16000, '닭강정 & 맥주', '야구장에서 치맥 어떻게 참나요? 오늘 졌으니까 좀 봐주셈', 2, 2)
;
