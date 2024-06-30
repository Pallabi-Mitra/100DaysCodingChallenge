/* Write your PL/SQL query statement below */


select p.product_name, sum(o.unit) as unit
from Products p, Orders o
where p.product_id = o.product_id
 and o.order_date BETWEEN TO_DATE('2020-02-01', 'YYYY-MM-DD') AND TO_DATE('2020-02-29', 'YYYY-MM-DD')
  
 group by p.product_name
 having sum(o.unit) >=100;

