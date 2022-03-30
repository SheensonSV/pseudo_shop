SELECT * FROM product limit 3 ;
SELECT EXISTS(SELECT * FROM product limit 1) as Basic_count;
select * from user;
insert into product (id, description, expiration_date, incoming_date, k_cal, name, price)
values (1, 'First test description of test product', '29.12.2022', '22.03.2022', 330, 'Test Product 1 - Sugar', 65.),
       (2, 'Second test description of test product', '30.12.2022', '20.03.2022', 220, 'Test Product 2 - Vodka', 250.),
       (3, 'Third test description of test product', '31.12.2022', '18.03.2022', 100, 'Test Product 1 - Milk', 60.);

insert into user (id, birth_day, first_name, mail, mail_subscription, registration_day, second_name, cart_id)
VALUES (1, DATE('1985-08-13'), 'Sergei', 'ssheenson85@gmail.com', 0, DATE ('2022-03-11'), 'Sheenson' , 1);