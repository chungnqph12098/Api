-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 22, 2021 lúc 05:32 PM
-- Phiên bản máy phục vụ: 10.4.18-MariaDB
-- Phiên bản PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `datnss`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `branches`
--

CREATE TABLE `branches` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `create_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loginorlogout`
--

CREATE TABLE `loginorlogout` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `login` date DEFAULT NULL,
  `logout` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `mynotice`
--

CREATE TABLE `mynotice` (
  `id` bigint(20) NOT NULL,
  `User_id` bigint(20) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `type` bit(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `posts`
--

CREATE TABLE `posts` (
  `id` bigint(20) NOT NULL,
  `User_id` bigint(20) DEFAULT NULL,
  `type` bit(1) DEFAULT NULL,
  `anonymus` bit(1) DEFAULT NULL,
  `displayStatus` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `posts`
--

INSERT INTO `posts` (`id`, `User_id`, `type`, `anonymus`, `displayStatus`) VALUES
(1, 1, b'1', b'1', b'1'),
(2, 10, b'1', b'1', b'1');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `post_approval`
--

CREATE TABLE `post_approval` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `post_id` bigint(20) NOT NULL,
  `status` bit(1) DEFAULT NULL,
  `create_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `post_vote`
--

CREATE TABLE `post_vote` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `posts_id` bigint(20) DEFAULT NULL,
  `LikeOrDis` bit(1) DEFAULT NULL,
  `PostPins` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `questionhs`
--

CREATE TABLE `questionhs` (
  `id` bigint(20) NOT NULL,
  `posts_id` bigint(20) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(8000) DEFAULT NULL,
  `point` int(11) DEFAULT NULL,
  `Limg` varchar(255) DEFAULT NULL,
  `create_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `questionhs`
--

INSERT INTO `questionhs` (`id`, `posts_id`, `title`, `content`, `point`, `Limg`, `create_date`) VALUES
(1, 1, 'Title cau 1', 'content cau 1', 10, 'anh.img', '2021-10-10'),
(2, 2, 'Title cau 2', 'content cau 2', 10, 'anh.img', '2021-10-10');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `reply`
--

CREATE TABLE `reply` (
  `id` bigint(20) NOT NULL,
  `questionHS_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `type` bit(1) DEFAULT NULL,
  `anonymus` bit(1) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `Limg` varchar(255) DEFAULT NULL,
  `create_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `reply`
--

INSERT INTO `reply` (`id`, `questionHS_id`, `user_id`, `content`, `type`, `anonymus`, `status`, `Limg`, `create_date`) VALUES
(1, 1, 1, 'tra loi cau 1', b'1', b'1', '1', 'anh.img', '2021-10-10'),
(2, 2, 10, 'tra loi cau 2', b'1', b'1', '1', 'anh.img', '2021-10-10');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `reply_vote`
--

CREATE TABLE `reply_vote` (
  `id` bigint(20) DEFAULT NULL,
  `User_id` bigint(20) DEFAULT NULL,
  `reply_id` bigint(20) DEFAULT NULL,
  `LikeOrDis` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `reply_vote`
--

INSERT INTO `reply_vote` (`id`, `User_id`, `reply_id`, `LikeOrDis`) VALUES
(1, 4, 1, b'1');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `reports`
--

CREATE TABLE `reports` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `create_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `report_question`
--

CREATE TABLE `report_question` (
  `id` bigint(20) NOT NULL,
  `reports_id` bigint(20) DEFAULT NULL,
  `questionHS_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `report_reply`
--

CREATE TABLE `report_reply` (
  `id` bigint(20) NOT NULL,
  `reports_id` bigint(20) DEFAULT NULL,
  `reply_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `subject`
--

CREATE TABLE `subject` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `SmallPoint` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `subject`
--

INSERT INTO `subject` (`id`, `name`, `SmallPoint`) VALUES
(1, 'Java', 10),
(2, 'PHP', 10),
(3, 'C+', 10);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `systemnotifications`
--

CREATE TABLE `systemnotifications` (
  `id` bigint(20) NOT NULL,
  `User_id` bigint(20) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `sendTo` varchar(255) DEFAULT NULL,
  `create_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tags`
--

CREATE TABLE `tags` (
  `id` bigint(20) NOT NULL,
  `subject_id` bigint(20) DEFAULT NULL,
  `posts_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `point` int(11) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `appellation` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `Img` varchar(255) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `full_name`, `email`, `point`, `role`, `appellation`, `create_date`, `Img`) VALUES
(1, 'anh', 'anh@gmail.com', 0, 'SV', NULL, '2021-10-07', 'anh.img'),
(4, 'chung', 'chung@gmail.com', 0, 'GV', NULL, '2021-10-05', 'anh2.img'),
(10, 'Nguyễn Văn Thuần', 'thuannv01@fpt.edu.vn', 100, 'SV', NULL, '2021-10-01', 'anh3.img');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users_posts`
--

CREATE TABLE `users_posts` (
  `id` bigint(20) NOT NULL,
  `User_id` bigint(20) DEFAULT NULL,
  `posts_id` bigint(20) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `create_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_report`
--

CREATE TABLE `user_report` (
  `id` bigint(20) NOT NULL,
  `User_id` bigint(20) DEFAULT NULL,
  `reports_id` bigint(20) DEFAULT NULL,
  `create_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `branches`
--
ALTER TABLE `branches`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `loginorlogout`
--
ALTER TABLE `loginorlogout`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_users` (`user_id`);

--
-- Chỉ mục cho bảng `mynotice`
--
ALTER TABLE `mynotice`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_usersnotice` (`User_id`);

--
-- Chỉ mục cho bảng `posts`
--
ALTER TABLE `posts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `User_id` (`User_id`);

--
-- Chỉ mục cho bảng `post_approval`
--
ALTER TABLE `post_approval`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FOREIGN KEY` (`user_id`),
  ADD KEY `FK` (`post_id`);

--
-- Chỉ mục cho bảng `post_vote`
--
ALTER TABLE `post_vote`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FOREIGNKey` (`user_id`),
  ADD KEY `FOREIGN KEY2` (`posts_id`);

--
-- Chỉ mục cho bảng `questionhs`
--
ALTER TABLE `questionhs`
  ADD PRIMARY KEY (`id`),
  ADD KEY `questionhs_ibfk_1` (`posts_id`);

--
-- Chỉ mục cho bảng `reply`
--
ALTER TABLE `reply`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_usersreply` (`user_id`),
  ADD KEY `fk_questionHSreply` (`questionHS_id`);

--
-- Chỉ mục cho bảng `reply_vote`
--
ALTER TABLE `reply_vote`
  ADD KEY `fk_replyvote` (`reply_id`),
  ADD KEY `fk_uservote` (`User_id`);

--
-- Chỉ mục cho bảng `reports`
--
ALTER TABLE `reports`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_usersreport` (`User_id`);

--
-- Chỉ mục cho bảng `report_question`
--
ALTER TABLE `report_question`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FOREIGN KEY1` (`questionHS_id`),
  ADD KEY `FoReNiGn KeY2` (`reports_id`);

--
-- Chỉ mục cho bảng `report_reply`
--
ALTER TABLE `report_reply`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Fk1` (`reply_id`),
  ADD KEY `fK2` (`reports_id`);

--
-- Chỉ mục cho bảng `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `systemnotifications`
--
ALTER TABLE `systemnotifications`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FOREIGNkey1` (`User_id`);

--
-- Chỉ mục cho bảng `tags`
--
ALTER TABLE `tags`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKey1` (`posts_id`),
  ADD KEY `Fkey2` (`subject_id`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `users_posts`
--
ALTER TABLE `users_posts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKKKK1` (`User_id`),
  ADD KEY `FKKK2` (`posts_id`);

--
-- Chỉ mục cho bảng `user_report`
--
ALTER TABLE `user_report`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FFkk1` (`User_id`),
  ADD KEY `FFFKk2` (`reports_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `branches`
--
ALTER TABLE `branches`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `loginorlogout`
--
ALTER TABLE `loginorlogout`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `posts`
--
ALTER TABLE `posts`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `post_approval`
--
ALTER TABLE `post_approval`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `post_vote`
--
ALTER TABLE `post_vote`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `questionhs`
--
ALTER TABLE `questionhs`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `reply`
--
ALTER TABLE `reply`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `reports`
--
ALTER TABLE `reports`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `report_question`
--
ALTER TABLE `report_question`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `report_reply`
--
ALTER TABLE `report_reply`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `subject`
--
ALTER TABLE `subject`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `systemnotifications`
--
ALTER TABLE `systemnotifications`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `tags`
--
ALTER TABLE `tags`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `users_posts`
--
ALTER TABLE `users_posts`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `user_report`
--
ALTER TABLE `user_report`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `loginorlogout`
--
ALTER TABLE `loginorlogout`
  ADD CONSTRAINT `fk_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `mynotice`
--
ALTER TABLE `mynotice`
  ADD CONSTRAINT `fk_usersnotice` FOREIGN KEY (`User_id`) REFERENCES `users` (`id`) ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `posts`
--
ALTER TABLE `posts`
  ADD CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`User_id`) REFERENCES `users` (`id`);

--
-- Các ràng buộc cho bảng `post_approval`
--
ALTER TABLE `post_approval`
  ADD CONSTRAINT `FK` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`),
  ADD CONSTRAINT `FOREIGN KEY` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Các ràng buộc cho bảng `post_vote`
--
ALTER TABLE `post_vote`
  ADD CONSTRAINT `FOREIGN KEY2` FOREIGN KEY (`posts_id`) REFERENCES `posts` (`id`),
  ADD CONSTRAINT `FOREIGNKey` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Các ràng buộc cho bảng `questionhs`
--
ALTER TABLE `questionhs`
  ADD CONSTRAINT `questionhs_ibfk_1` FOREIGN KEY (`posts_id`) REFERENCES `posts` (`id`);

--
-- Các ràng buộc cho bảng `reply`
--
ALTER TABLE `reply`
  ADD CONSTRAINT `fk_questionHSreply` FOREIGN KEY (`questionHS_id`) REFERENCES `questionhs` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_usersreply` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Các ràng buộc cho bảng `reply_vote`
--
ALTER TABLE `reply_vote`
  ADD CONSTRAINT `fk_replyvote` FOREIGN KEY (`reply_id`) REFERENCES `reply` (`id`),
  ADD CONSTRAINT `fk_uservote` FOREIGN KEY (`User_id`) REFERENCES `users` (`id`) ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `reports`
--
ALTER TABLE `reports`
  ADD CONSTRAINT `fk_usersreport` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `report_question`
--
ALTER TABLE `report_question`
  ADD CONSTRAINT `FOREIGN KEY1` FOREIGN KEY (`questionHS_id`) REFERENCES `questionhs` (`id`),
  ADD CONSTRAINT `FoReNiGn KeY2` FOREIGN KEY (`reports_id`) REFERENCES `reports` (`id`);

--
-- Các ràng buộc cho bảng `report_reply`
--
ALTER TABLE `report_reply`
  ADD CONSTRAINT `Fk1` FOREIGN KEY (`reply_id`) REFERENCES `reply` (`id`),
  ADD CONSTRAINT `fK2` FOREIGN KEY (`reports_id`) REFERENCES `reports` (`id`);

--
-- Các ràng buộc cho bảng `systemnotifications`
--
ALTER TABLE `systemnotifications`
  ADD CONSTRAINT `FOREIGNkey1` FOREIGN KEY (`User_id`) REFERENCES `users` (`id`);

--
-- Các ràng buộc cho bảng `tags`
--
ALTER TABLE `tags`
  ADD CONSTRAINT `FKey1` FOREIGN KEY (`posts_id`) REFERENCES `posts` (`id`),
  ADD CONSTRAINT `Fkey2` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`);

--
-- Các ràng buộc cho bảng `users_posts`
--
ALTER TABLE `users_posts`
  ADD CONSTRAINT `FKKK2` FOREIGN KEY (`posts_id`) REFERENCES `posts` (`id`),
  ADD CONSTRAINT `FKKKK1` FOREIGN KEY (`User_id`) REFERENCES `users` (`id`);

--
-- Các ràng buộc cho bảng `user_report`
--
ALTER TABLE `user_report`
  ADD CONSTRAINT `FFFKk2` FOREIGN KEY (`reports_id`) REFERENCES `reports` (`id`),
  ADD CONSTRAINT `FFkk1` FOREIGN KEY (`User_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
