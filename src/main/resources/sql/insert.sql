INSERT INTO `institutions` (`name`,`description`)
VALUES ('Fundacja `Dbam o Zdrowie`','Pomoc dzieciom z ubogich rodzin.'),
       ('Fundacja `A kogo`','Pomoc wybudzaniu dzieci ze śpiączki.'),
       ('Fundacja `Dla dzieci`','Pomoc osobom znajdującym się w trudnej sytuacji życiowej.'),
       ('Fundacja `Bez domu`','Pomoc dla osób nie posiadających miejsca zamieszkania.');

INSERT INTO `categories` (`name`)
VALUES ('ubrania, które nadają się do ponownego użycia'),
       ('ubrania, do wyrzucenia'),
       ('zabawki'),
       ('książki'),
       ('inne');

INSERT INTO `donations` (city, pick_up_comment, pick_up_date, pick_up_time, quantity, street, zip_code, phone, institution_id)
VALUES ('Wrocław','comment','2022-06-02','18:30:00',12,'Kiełbaśnicza','55-555',808111222,1),
       ('Poznań','comment2','2022-06-01','09:15:00',1,'Swobodna','55-000',644222555,2),
       ('Legnica','comment3','2022-05-28','20:00:00',2,'Główna','59-123',123456789,4);