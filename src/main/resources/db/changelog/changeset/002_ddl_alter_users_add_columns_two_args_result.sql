--liquibase formatted sql
 --changeset katya:add_three_columns_to_users runAlways:false runOnChange:true
ALTER TABLE users
   ADD COLUMN first_arg DOUBLE PRECISION,
   ADD COLUMN second_arg DOUBLE PRECISION,
   ADD COLUMN result DOUBLE PRECISION;
