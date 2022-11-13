INSERT INTO CROP
VALUES (1, 'corn', 750, 1.00);
INSERT INTO crop (id, crop_name, water_per_feddan, time_per_feddan)
VALUES (2, 'cotton', 1200, 7.00);
INSERT INTO crop (id, crop_name, water_per_feddan, time_per_feddan)
VALUES (3, 'wool', 480, 16.00);
INSERT INTO crop (id, crop_name, water_per_feddan, time_per_feddan)
VALUES (4, 'rice', 200, 48.00);
INSERT INTO crop (id, crop_name, water_per_feddan, time_per_feddan)
VALUES (5, 'wheat', 900, 25.00);

INSERT INTO land_plot (id, area_in_feddan, time_slot, crop_id, x_coordinate, y_coordinate)
VALUES (1, 1.5, '1:30:00', 1, 0, 0);
INSERT INTO land_plot (id, area_in_feddan, time_slot, crop_id, x_coordinate, y_coordinate)
VALUES (2, 2, '2:30:00', 2, 2, 2);
INSERT INTO land_plot (id, area_in_feddan, time_slot, crop_id, x_coordinate, y_coordinate)
VALUES (3, 4, '4:30:00', 4, 6, 3);
INSERT INTO land_plot (id, area_in_feddan, time_slot, crop_id, x_coordinate, y_coordinate)
VALUES (4, 6, '1:30:00', 3, 10, 9);
INSERT INTO land_plot (id, area_in_feddan, time_slot, crop_id, x_coordinate, y_coordinate)
VALUES (5, 12, '1:30:00', 5, 25, 17);
