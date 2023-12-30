-- Create t_orders table
-- Create t_order_line_items table
-- author: Ibrahim ZEROUAL

CREATE TABLE t_orders (
    id bigint(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    order_number varchar(255)
);

CREATE TABLE t_order_line_items (
    id bigint(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    sku_code varchar(255),
    price decimal(10,2),
    quantity integer(11),
    order_id bigint(11),
    CONSTRAINT fk_order_line_items_orders FOREIGN KEY (order_id) REFERENCES t_orders(id)
);
