-- inserting data in t_orders and t_order_line_items tables
-- author: Ibrahim ZEROUAL
INSERT INTO t_orders(order_number) VALUES('ORD11111');
INSERT INTO t_order_line_items(sku_code, price, quantity, order_id) VALUES('SKU001', 9.99, 4, 1);

INSERT INTO t_orders(order_number) VALUES('ORD22222');
INSERT INTO t_order_line_items(sku_code, price, quantity, order_id) VALUES('SKU002', 15.50, 2, 2);

INSERT INTO t_orders(order_number) VALUES('ORD33333');
INSERT INTO t_order_line_items(sku_code, price, quantity, order_id) VALUES('SKU003', 7.99, 6, 2);

INSERT INTO t_orders(order_number) VALUES('ORD44444');
INSERT INTO t_order_line_items(sku_code, price, quantity, order_id) VALUES('SKU004', 29.95, 1, 2);

INSERT INTO t_orders(order_number) VALUES('ORD55555');
INSERT INTO t_order_line_items(sku_code, price, quantity, order_id) VALUES('SKU005', 19.99, 3, 1);

