CREATE TABLE `task` (
  `task_id` int PRIMARY KEY,
  `task_type_id` int NOT NULL,
  `task_title` varchar(45),
  `task_description` varchar(45),
  `repeating_number` int NOT NULL DEFAULT 1,
  `task_color` varchar(45),
  `neglected_total_probability_addition` float,
  `active_for_days_number` int NOT NULL,
  `is_in_progress` boolean,
  `is_current_to_do_task` boolean,
  `is_choosen_task` boolean
);

CREATE TABLE `task_completed` (
  `task_completed_id` int,
  `task_id` int NOT NULL,
  `completion_date` date,
  `task_completion_imageURL` varchar(45)
);

CREATE TABLE `task_type` (
  `task_type_id` int PRIMARY KEY,
  `task_type_scope` varchar(45) DEFAULT 'small',
  `type_description` varchar(45),
  `experience_multiplier` int
);

CREATE TABLE `subject` (
  `subject_id` int PRIMARY KEY,
  `subject_title` varchar(45),
  `subject_description` varchar(45),
  `subject_color` varchar(45),
  `is_active` boolean NOT NULL,
  `paw_print_type_id` int NOT NULL,
  `subject_appearance_probability_multiplier` int,
  `form_type_of_tasks` varchar(45) NOT NULL
);

CREATE TABLE `paw_print_type` (
  `paw_print_id` int PRIMARY KEY,
  `type` varchar(45),
  `color` varchar(45)
);

CREATE TABLE `timer` (
  `timer_id` int PRIMARY KEY,
  `timer_name` varchar(45),
  `time` time
);

CREATE TABLE `user_profile` (
  `user_id` int PRIMARY KEY,
  `theme_id` int NOT NULL,
  `experience_points` int,
  `active_task_amount` int,
  `reroll_usage_amount_today` int NOT NULL,
  `start_time_sending_notifications` time,
  `end_time_sending_notifications` time,
  `timer_timer_id` int NOT NULL,
  `refresh_task_time` time DEFAULT 0
);

CREATE TABLE `daily_task_completion_chart` (
  `completion_chart_id` int,
  `user_id` int,
  `pawprint_amount` int,
  `date` date NOT NULL,
  PRIMARY KEY (`completion_chart_id`, `user_id`)
);

CREATE TABLE `task_prerequisite_for_appearance_of_task` (
  `fk_prerequisite_task_id` int,
  `fk_child_task_id` int,
  PRIMARY KEY (`fk_prerequisite_task_id`, `fk_child_task_id`)
);

CREATE TABLE `item` (
  `item_id` int PRIMARY KEY,
  `is_unlocked` boolean NOT NULL,
  `base_cost` int NOT NULL,
  `art_url` varchar(45) NOT NULL,
  `cost_type_multiplier` int NOT NULL,
  `special_material_cost` int NOT NULL
);

CREATE TABLE `unlocked_item` (
  `unlocked_item_id` int PRIMARY KEY,
  `user_id` int NOT NULL,
  `item_id` int NOT NULL,
  `purchase_date` date NOT NULL,
  `purchased_amount` int
);

CREATE TABLE `item_rarity` (
  `item_rarity_id` int,
  `item_id` int,
  `rarity_type` varchar(45) NOT NULL,
  `rarity_appearance_probabilities` int NOT NULL,
  `rarity_color` varchar(45),
  PRIMARY KEY (`item_rarity_id`, `item_id`)
);

CREATE TABLE `paw_print_type_has_item` (
  `paw_print_type_id` int,
  `item_id` int,
  PRIMARY KEY (`paw_print_type_id`, `item_id`)
);

CREATE TABLE `theme` (
  `theme_id` int,
  `theme_color_sixty_percent` varchar(45),
  `theme_color_thirty_percent` varchar(45),
  `theme_color_ten_percent` varchar(45),
  `themecol` varchar(45)
);

CREATE TABLE `penalty` (
  `penalty_id` int PRIMARY KEY,
  `penalty_date` date,
  `penalty_amount` int
);

CREATE TABLE `notification` (
  `notification_id` int PRIMARY KEY,
  `user_id` int NOT NULL,
  `notification_name` varchar(45),
  `notification_text` varchar(45),
  `notification_time` time
);

CREATE TABLE `progression_line` (
  `progression_line_id` int PRIMARY KEY
);

CREATE TABLE `loot_box` (
  `loot_box_id` int PRIMARY KEY,
  `loot_box_rarity` varchar(45),
  `loot_box_appearance_percentage` int,
  `loot_box_art_image_url` varchar(45)
);

CREATE TABLE `penalty_has_paw_print_type` (
  `penalty_penalty_id` int,
  `paw_print_type_id` int,
  `amount` int,
  PRIMARY KEY (`penalty_penalty_id`, `paw_print_type_id`)
);

CREATE TABLE `user_item_inventory` (
  `user_id` int NOT NULL,
  `item_id` int NOT NULL,
  `amount` int DEFAULT 1,
  PRIMARY KEY (`user_id`, `item_id`)
);

CREATE TABLE `user_lootbox_inventory` (
  `user_id` int NOT NULL,
  `lootbox_id` int NOT NULL,
  `amount` int NOT NULL,
  PRIMARY KEY (`user_id`, `lootbox_id`)
);

CREATE TABLE `user_pawprint_inventory` (
  `user_id` int NOT NULL,
  `paw_print_type_id` int NOT NULL,
  `amount` int NOT NULL,
  PRIMARY KEY (`user_id`, `paw_print_type_id`)
);

ALTER TABLE `task_completed` ADD FOREIGN KEY (`task_id`) REFERENCES `task` (`task_id`);

ALTER TABLE `task` ADD FOREIGN KEY (`task_type_id`) REFERENCES `task_type` (`task_type_id`);

ALTER TABLE `subject` ADD FOREIGN KEY (`paw_print_type_id`) REFERENCES `paw_print_type` (`paw_print_id`);

ALTER TABLE `user_profile` ADD FOREIGN KEY (`theme_id`) REFERENCES `theme` (`theme_id`);

ALTER TABLE `user_profile` ADD FOREIGN KEY (`timer_timer_id`) REFERENCES `timer` (`timer_id`);

ALTER TABLE `daily_task_completion_chart` ADD FOREIGN KEY (`user_id`) REFERENCES `user_profile` (`user_id`);

ALTER TABLE `task_prerequisite_for_appearance_of_task` ADD FOREIGN KEY (`fk_prerequisite_task_id`) REFERENCES `task` (`task_id`);

ALTER TABLE `task_prerequisite_for_appearance_of_task` ADD FOREIGN KEY (`fk_child_task_id`) REFERENCES `task` (`task_id`);

ALTER TABLE `unlocked_item` ADD FOREIGN KEY (`user_id`) REFERENCES `user_profile` (`user_id`);

ALTER TABLE `unlocked_item` ADD FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`);

ALTER TABLE `item_rarity` ADD FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`);

ALTER TABLE `paw_print_type_has_item` ADD FOREIGN KEY (`paw_print_type_id`) REFERENCES `paw_print_type` (`paw_print_id`);

ALTER TABLE `paw_print_type_has_item` ADD FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`);

ALTER TABLE `notification` ADD FOREIGN KEY (`user_id`) REFERENCES `user_profile` (`user_id`);

ALTER TABLE `penalty_has_paw_print_type` ADD FOREIGN KEY (`penalty_penalty_id`) REFERENCES `penalty` (`penalty_id`);

ALTER TABLE `penalty_has_paw_print_type` ADD FOREIGN KEY (`paw_print_type_id`) REFERENCES `paw_print_type` (`paw_print_id`);

ALTER TABLE `user_item_inventory` ADD FOREIGN KEY (`user_id`) REFERENCES `user_profile` (`user_id`);

ALTER TABLE `user_item_inventory` ADD FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`);

ALTER TABLE `user_lootbox_inventory` ADD FOREIGN KEY (`user_id`) REFERENCES `user_profile` (`user_id`);

ALTER TABLE `user_lootbox_inventory` ADD FOREIGN KEY (`lootbox_id`) REFERENCES `loot_box` (`loot_box_id`);

ALTER TABLE `user_pawprint_inventory` ADD FOREIGN KEY (`user_id`) REFERENCES `user_profile` (`user_id`);

ALTER TABLE `user_pawprint_inventory` ADD FOREIGN KEY (`paw_print_type_id`) REFERENCES `paw_print_type` (`paw_print_id`);
