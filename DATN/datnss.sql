-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 16, 2021 lúc 11:20 PM
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
CREATE DATABASE IF NOT EXISTS `datnss` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `datnss`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `branches`
--

DROP TABLE IF EXISTS `branches`;
CREATE TABLE IF NOT EXISTS `branches` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loginorlogout`
--

DROP TABLE IF EXISTS `loginorlogout`;
CREATE TABLE IF NOT EXISTS `loginorlogout` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `login` date DEFAULT NULL,
  `logout` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `mynotice`
--

DROP TABLE IF EXISTS `mynotice`;
CREATE TABLE IF NOT EXISTS `mynotice` (
  `id` bigint(20) DEFAULT NULL,
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

DROP TABLE IF EXISTS `posts`;
CREATE TABLE IF NOT EXISTS `posts` (
  `id` bigint(20) DEFAULT NULL,
  `User_id` bigint(20) DEFAULT NULL,
  `type` bit(1) DEFAULT NULL,
  `anonymus` bit(1) DEFAULT NULL,
  `displayStatus` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `posts`
--

INSERT INTO `posts` (`id`, `User_id`, `type`, `anonymus`, `displayStatus`) VALUES
(1, 10, b'1', b'1', b'1'),
(2, 13, b'1', b'0', b'1'),
(3, 16, b'1', b'1', b'1'),
(4, 5, b'1', b'1', b'1'),
(5, 4, b'1', b'1', b'0'),
(6, 3, b'1', b'1', b'1'),
(7, 1, b'1', b'0', b'1'),
(8, 1, b'1', b'1', b'1'),
(9, 11, b'1', b'1', b'1'),
(10, 11, b'1', b'1', b'0'),
(11, 12, b'1', b'1', b'1'),
(12, 13, b'1', b'0', b'1'),
(13, 14, b'1', b'1', b'1'),
(14, 11, b'1', b'1', b'1'),
(15, 10, b'1', b'1', b'0');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `post_approval`
--

DROP TABLE IF EXISTS `post_approval`;
CREATE TABLE IF NOT EXISTS `post_approval` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `post_id` bigint(20) NOT NULL,
  `status` bit(1) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `post_vote`
--

DROP TABLE IF EXISTS `post_vote`;
CREATE TABLE IF NOT EXISTS `post_vote` (
  `id` bigint(20) DEFAULT NULL,
  `User_id` bigint(20) DEFAULT NULL,
  `posts_id` bigint(20) DEFAULT NULL,
  `LikeOrDis` bit(1) DEFAULT NULL,
  `PostPins` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `post_vote`
--

INSERT INTO `post_vote` (`id`, `User_id`, `posts_id`, `LikeOrDis`, `PostPins`) VALUES
(1, 1, 1, b'1', NULL),
(2, 4, 1, b'1', NULL),
(3, 2, 2, b'0', NULL),
(4, 10, 2, b'0', NULL),
(5, 11, 4, b'1', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `questionhs`
--

DROP TABLE IF EXISTS `questionhs`;
CREATE TABLE IF NOT EXISTS `questionhs` (
  `id` bigint(20) DEFAULT NULL,
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
(1, 1, 'cau hoi 1', 'cau hoi 1', 10, 'anh.img', '2021-10-10'),
(2, 1, 'cau hoi 4', 'cau hoi 4', 20, 'img.img', '2021-10-10');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `reply`
--

DROP TABLE IF EXISTS `reply`;
CREATE TABLE IF NOT EXISTS `reply` (
  `id` bigint(20) DEFAULT NULL,
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
(1, 2, 4, 'tra loi cau 4', b'1', b'1', '1', 'anh.img', '2021-10-10');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `reply_vote`
--

DROP TABLE IF EXISTS `reply_vote`;
CREATE TABLE IF NOT EXISTS `reply_vote` (
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

DROP TABLE IF EXISTS `reports`;
CREATE TABLE IF NOT EXISTS `reports` (
  `id` bigint(20) DEFAULT NULL,
  `User_id` bigint(20) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `create_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `reports`
--

INSERT INTO `reports` (`id`, `User_id`, `content`, `status`, `create_date`) VALUES
(1, 1, '1', b'1', '2021-10-10');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `report_question`
--

DROP TABLE IF EXISTS `report_question`;
CREATE TABLE IF NOT EXISTS `report_question` (
  `id` bigint(20) DEFAULT NULL,
  `reports_id` bigint(20) DEFAULT NULL,
  `questionHS_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `report_question`
--

INSERT INTO `report_question` (`id`, `reports_id`, `questionHS_id`) VALUES
(1, 2, 11);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `report_reply`
--

DROP TABLE IF EXISTS `report_reply`;
CREATE TABLE IF NOT EXISTS `report_reply` (
  `id` bigint(20) DEFAULT NULL,
  `reports_id` bigint(20) DEFAULT NULL,
  `reply_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `report_reply`
--

INSERT INTO `report_reply` (`id`, `reports_id`, `reply_id`) VALUES
(1, 3, 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `subject`
--

DROP TABLE IF EXISTS `subject`;
CREATE TABLE IF NOT EXISTS `subject` (
  `id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `SmallPoint` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `subject`
--

INSERT INTO `subject` (`id`, `name`, `SmallPoint`) VALUES
(1, 'Java', 10),
(1, 'PHP', 10),
(1, 'C+', 10);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `systemnotifications`
--

DROP TABLE IF EXISTS `systemnotifications`;
CREATE TABLE IF NOT EXISTS `systemnotifications` (
  `id` bigint(20) DEFAULT NULL,
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

DROP TABLE IF EXISTS `tags`;
CREATE TABLE IF NOT EXISTS `tags` (
  `id` bigint(20) DEFAULT NULL,
  `subject_id` bigint(20) DEFAULT NULL,
  `posts_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tags`
--

INSERT INTO `tags` (`id`, `subject_id`, `posts_id`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 1, 4),
(5, 1, 5),
(6, 3, 6),
(7, 2, 7),
(8, 1, 8),
(9, 3, 9),
(10, 1, 10);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `point` int(11) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `appellation` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `Img` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
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

DROP TABLE IF EXISTS `users_posts`;
CREATE TABLE IF NOT EXISTS `users_posts` (
  `id` bigint(20) DEFAULT NULL,
  `User_id` bigint(20) DEFAULT NULL,
  `posts_id` bigint(20) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `create_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `users_posts`
--

INSERT INTO `users_posts` (`id`, `User_id`, `posts_id`, `status`, `create_date`) VALUES
(1, 1, 1, b'1', '2021-10-10');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_report`
--

DROP TABLE IF EXISTS `user_report`;
CREATE TABLE IF NOT EXISTS `user_report` (
  `id` bigint(20) DEFAULT NULL,
  `User_id` bigint(20) DEFAULT NULL,
  `reports_id` bigint(20) DEFAULT NULL,
  `LikeOrDis` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `user_report`
--

INSERT INTO `user_report` (`id`, `User_id`, `reports_id`, `LikeOrDis`) VALUES
(1, 1, 1, b'1');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
