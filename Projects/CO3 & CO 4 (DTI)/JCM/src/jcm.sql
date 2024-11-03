-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 11, 2021 at 04:18 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jcm`
--

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `author_id` int(11) NOT NULL,
  `name` varchar(150) NOT NULL,
  `image_path` varchar(150) NOT NULL,
  `description` longtext NOT NULL,
  `date_created` datetime NOT NULL DEFAULT current_timestamp(),
  `date_opened` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`id`, `author_id`, `name`, `image_path`, `description`, `date_created`, `date_opened`) VALUES
(1, 3, 'Course 01', '/ui/teacher/assets/course_algo.png', 'An introduction to Greedy Algorithms, Dynamic Programming, Tree, Graph Theory, etc', '2021-01-11 00:59:47', '2021-01-11 00:59:47'),
(2, 3, 'Java Programming', '/ui/teacher/assets/course_java.png', 'An introduction to Java syntax, Java collections, Java swing, Multithreaded Programming, Networking, etcc', '2021-01-11 01:00:08', '2021-01-11 01:00:08'),
(3, 4, 'Docker', '/ui/teacher/assets/course_java.png', 'Docker course', '2021-01-11 01:00:08', '2021-01-11 01:00:08'),
(6, 3, 'Vân tay', '/ui/assets/courses/biometrics.png', 'fdfd', '2021-01-11 22:13:46', '2021-01-11 22:13:46');

-- --------------------------------------------------------

--
-- Table structure for table `enrollment`
--

CREATE TABLE `enrollment` (
  `id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `enrollment`
--

INSERT INTO `enrollment` (`id`, `course_id`, `user_id`) VALUES
(1, 1, 1),
(5, 2, 1),
(7, 2, 2),
(8, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `lesson`
--

CREATE TABLE `lesson` (
  `id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `title` varchar(150) NOT NULL,
  `description` longtext NOT NULL,
  `content` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lesson`
--

INSERT INTO `lesson` (`id`, `course_id`, `title`, `description`, `content`) VALUES
(2, 1, 'Tiêu đề bài học 1 - course 112312', 'Nội dung cho lesson  1 - description', 'Nội dung cho lesson  1 - đã sửa'),
(3, 1, 'Lesson1 - Course 1', 'Nội dung cho lesson  2', 'Nội dung cho lesson  2'),
(4, 1, 'Lesson1 - Course 1', 'Nội dung cho lesson  3', 'Nội dung cho lesson  3'),
(7, 1, 'New title12312', 'New description', '12312'),
(9, 6, 'Vân tay của đức', 'ok', 'Thêm vân tay');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `full_name` varchar(100) NOT NULL,
  `avatar_path` varchar(200) NOT NULL,
  `role` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `full_name`, `avatar_path`, `role`) VALUES
(1, 'hocsinh', 'admin', 'Tài khoản học sinh', '/ui/teacher/assets/user_male_0.png', 2),
(2, 'hocsinh1', 'admin', 'Tài khoản học sinh1', '/ui/teacher/assets/user_male_0.png', 2),
(3, 'giaovien', 'admin', 'Trần Minh Đức', '/ui/assets/avatars/2.png', 1),
(4, 'giaovien2', 'admin', 'Tài khoản giáo viên 2', '/ui/teacher/assets/user_male_0.png', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `enrollment`
--
ALTER TABLE `enrollment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `lesson`
--
ALTER TABLE `lesson`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `enrollment`
--
ALTER TABLE `enrollment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `lesson`
--
ALTER TABLE `lesson`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
