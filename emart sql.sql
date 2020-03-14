-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 14, 2020 at 05:21 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `emart`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill_details_table`
--

CREATE TABLE `bill_details_table` (
  `bill_details_id` int(11) NOT NULL,
  `bill_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bill_details_table`
--

INSERT INTO `bill_details_table` (`bill_details_id`, `bill_id`, `item_id`) VALUES
(701, 601, 501),
(718, 616, 505),
(719, 617, 504),
(720, 618, 504),
(721, 619, 503),
(722, 620, 503),
(723, 621, 501),
(724, 621, 501),
(725, 622, 504),
(726, 623, 504),
(727, 624, 504),
(728, 625, 501),
(729, 625, 504),
(730, 625, 502),
(731, 626, 505),
(732, 626, 508),
(733, 626, 506),
(734, 627, 504),
(735, 627, 501),
(736, 627, 503);

-- --------------------------------------------------------

--
-- Table structure for table `bill_table`
--

CREATE TABLE `bill_table` (
  `bill_id` int(20) NOT NULL,
  `buyer_id` int(30) NOT NULL,
  `bill_type` varchar(50) NOT NULL,
  `bill_date` date NOT NULL,
  `bill_remarks` varchar(25) NOT NULL,
  `bill_amount` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bill_table`
--

INSERT INTO `bill_table` (`bill_id`, `buyer_id`, `bill_type`, `bill_date`, `bill_remarks`, `bill_amount`) VALUES
(601, 201, 'cash', '2020-01-07', 'no', 25000),
(616, 201, 'Debit', '2020-03-05', 'paid', 32000),
(617, 201, 'Debit', '2020-03-05', 'paid', 18000),
(618, 201, 'Debit', '2020-03-05', 'paid', 18000),
(619, 201, 'Debit', '2020-03-06', 'paid', 21000),
(620, 201, 'Debit', '2020-03-10', 'paid', 21000),
(621, 201, 'Debit', '2020-03-10', 'paid', 50000),
(622, 201, 'Debit', '2020-03-05', 'paid', 18000),
(623, 201, 'Debit', '2020-03-05', 'paid', 18000),
(624, 201, 'Debit', '2020-03-05', 'paid', 18000),
(625, 201, 'Debit', '2020-03-13', 'paid', 49000),
(626, 201, 'Debit', '2020-03-13', 'paid', 69000),
(627, 201, 'Debit', '2020-03-13', 'paid', 64000);

-- --------------------------------------------------------

--
-- Table structure for table `buyer_signup_table`
--

CREATE TABLE `buyer_signup_table` (
  `buyer_id` int(30) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `mobile` int(10) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buyer_signup_table`
--

INSERT INTO `buyer_signup_table` (`buyer_id`, `username`, `password`, `email`, `mobile`, `date`) VALUES
(201, 'Ashwitha', '1234', 'ashwitha@gmail.com', 963258741, '2020-01-15'),
(202, 'Sana', '1234', 'sana@gmail.com', 895623412, '2019-08-06'),
(203, 'jyothi', '1234', 'jyo@gmail.com', 963258761, '2020-01-15'),
(208, 'Swetha', '1234', 'swe@gmail.com', 656165498, '2020-03-10'),
(210, 'ashu', '1234', 'ashwitha@gmail.com', 963258741, '2020-01-15'),
(211, 'ash', '1234', 'ashwitha@gmail.com', 963258741, '2020-01-15'),
(212, 'Prava', '1234', 'prava@gmail.com', 987452136, '2020-03-11'),
(222, 'yrtyr', 'trutr', 'yrtyr@h', 985456744, '2020-03-13');

-- --------------------------------------------------------

--
-- Table structure for table `category_table`
--

CREATE TABLE `category_table` (
  `category_id` int(20) NOT NULL,
  `category_name` varchar(30) NOT NULL,
  `category_brief` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category_table`
--

INSERT INTO `category_table` (`category_id`, `category_name`, `category_brief`) VALUES
(301, 'Electronics', 'good'),
(302, 'Mobiles', 'good'),
(303, 'Clothes', 'good');

-- --------------------------------------------------------

--
-- Table structure for table `item_table`
--

CREATE TABLE `item_table` (
  `item_id` int(20) NOT NULL,
  `item_name` varchar(30) NOT NULL,
  `item_image` varchar(400) NOT NULL,
  `item_price` int(200) NOT NULL,
  `item_stock` int(100) NOT NULL,
  `item_description` varchar(100) NOT NULL,
  `subcategory_id` int(20) NOT NULL,
  `item_remarks` varchar(50) NOT NULL,
  `seller_id` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `item_table`
--

INSERT INTO `item_table` (`item_id`, `item_name`, `item_image`, `item_price`, `item_stock`, `item_description`, `subcategory_id`, `item_remarks`, `seller_id`) VALUES
(501, 'Sony', 'https://images.unsplash.com/photo-1461151304267-38535e780c79?ixlib=rb-1.2.1&auto=format&fit=crop&w=1490&q=80', 25000, 5, 'Free', 401, 'no', 101),
(502, 'LG', 'https://images.unsplash.com/photo-1501645429123-a300be5fe1c2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80', 6000, 5, 'Free', 401, 'no', 101),
(503, 'Whirlpool', 'https://images.unsplash.com/photo-1551761429-8232f9f5955c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60', 21000, 5, 'Free', 402, 'no', 102),
(504, 'LG', 'https://images.unsplash.com/photo-1563310196-3f10e40dd789?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1351&q=80', 18000, 6, 'Free', 402, 'no', 102),
(505, 'Apple', 'https://images.unsplash.com/photo-1510878933023-e2e2e3942fb0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1351&q=80', 32000, 3, 'Free', 603, 'no', 102),
(506, 'Redmi', 'https://images.unsplash.com/photo-1555774698-0b77e0d5fac6?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80', 16000, 9, 'Free', 603, 'no', 102),
(507, 'Apple', 'https://images.unsplash.com/photo-1544244015-0df4b3ffc6b0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1303&q=80', 40000, 7, 'Free', 604, 'no', 101),
(508, 'Samsung', 'https://images.unsplash.com/photo-1522204523234-8729aa6e3d5f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80', 21000, 8, 'Free', 604, 'no', 101),
(509, 'Sarees', 'https://medias.utsavfashion.com/media/catalog/product/cache/1/image/1000x/040ec09b1e35df139433887a97daa66f/d/i/digital-printed-organza-saree-in-pastel-green-v1-ssf6880.jpg', 3000, 12, 'Free', 605, 'no', 101),
(510, 'Kurtis', 'https://images.unsplash.com/photo-1572804013427-4d7ca7268217?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=701&q=80', 800, 15, 'Free', 605, 'no', 101),
(511, 'Jeans', 'https://images.unsplash.com/photo-1565084888279-aca607ecce0c?ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80', 2000, 13, 'Free', 606, 'no', 102),
(512, 'Shirts', 'https://images.unsplash.com/photo-1489987707025-afc232f7ea0f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80', 900, 14, 'Free', 606, 'no', 102);

-- --------------------------------------------------------

--
-- Table structure for table `seller_signup_table`
--

CREATE TABLE `seller_signup_table` (
  `seller_id` int(10) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `company` varchar(40) NOT NULL,
  `brief` varchar(40) NOT NULL,
  `gst` int(10) NOT NULL,
  `address` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `contact` int(20) NOT NULL,
  `website` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `seller_signup_table`
--

INSERT INTO `seller_signup_table` (`seller_id`, `username`, `password`, `company`, `brief`, `gst`, `address`, `email`, `contact`, `website`) VALUES
(101, 'Gayathri', '1234', 'abc', 'very good prodcts', 6, 'chennai', 'gayathri@gmail.com', 996633225, 'www.abc.com'),
(102, 'Shanthi', '1234', 'cba', 'Best Products', 5, 'chennai', 'shanthi@gmail.com', 996655223, 'www.cba.com'),
(103, 'Hari', '1234', 'abc', 'very good prodcts', 6, 'chennai', 'hari@gmail.com', 996688225, 'www.abc.com'),
(105, 'Shan', '1234', 'cba', 'Best Products', 5, 'chennai', 'shanthi@gmail.com', 996655223, 'www.cba.com'),
(111, 'tyry', 'tyy', 'tyrty', 'tryr', 54, 'tyrty', 'rye@tyry', 987541236, 'rey');

-- --------------------------------------------------------

--
-- Table structure for table `subcategory_table`
--

CREATE TABLE `subcategory_table` (
  `subcategory_id` int(20) NOT NULL,
  `subcategory_name` varchar(30) NOT NULL,
  `category_id` int(20) NOT NULL,
  `subcategory_brief` varchar(30) NOT NULL,
  `subcategory_gst` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `subcategory_table`
--

INSERT INTO `subcategory_table` (`subcategory_id`, `subcategory_name`, `category_id`, `subcategory_brief`, `subcategory_gst`) VALUES
(401, 'TV', 301, 'gd', 4),
(402, 'Washing Machine', 301, 'gd', 4),
(603, 'Smart Phone', 302, 'good', 3),
(604, 'Tablets', 302, 'good', 4),
(605, 'Womens Wear', 303, 'Good', 2),
(606, 'Mens Wear', 303, 'Good', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill_details_table`
--
ALTER TABLE `bill_details_table`
  ADD PRIMARY KEY (`bill_details_id`),
  ADD KEY `bill_id` (`bill_id`),
  ADD KEY `item_id` (`item_id`);

--
-- Indexes for table `bill_table`
--
ALTER TABLE `bill_table`
  ADD PRIMARY KEY (`bill_id`),
  ADD KEY `buyer_id` (`buyer_id`);

--
-- Indexes for table `buyer_signup_table`
--
ALTER TABLE `buyer_signup_table`
  ADD PRIMARY KEY (`buyer_id`);

--
-- Indexes for table `category_table`
--
ALTER TABLE `category_table`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `item_table`
--
ALTER TABLE `item_table`
  ADD PRIMARY KEY (`item_id`),
  ADD KEY `subcategory_id` (`subcategory_id`),
  ADD KEY `seller_id` (`seller_id`);

--
-- Indexes for table `seller_signup_table`
--
ALTER TABLE `seller_signup_table`
  ADD PRIMARY KEY (`seller_id`);

--
-- Indexes for table `subcategory_table`
--
ALTER TABLE `subcategory_table`
  ADD PRIMARY KEY (`subcategory_id`),
  ADD KEY `subcategory_table_ibfk_1` (`category_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bill_details_table`
--
ALTER TABLE `bill_details_table`
  MODIFY `bill_details_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=737;

--
-- AUTO_INCREMENT for table `bill_table`
--
ALTER TABLE `bill_table`
  MODIFY `bill_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=628;

--
-- AUTO_INCREMENT for table `buyer_signup_table`
--
ALTER TABLE `buyer_signup_table`
  MODIFY `buyer_id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=223;

--
-- AUTO_INCREMENT for table `category_table`
--
ALTER TABLE `category_table`
  MODIFY `category_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=304;

--
-- AUTO_INCREMENT for table `item_table`
--
ALTER TABLE `item_table`
  MODIFY `item_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=514;

--
-- AUTO_INCREMENT for table `seller_signup_table`
--
ALTER TABLE `seller_signup_table`
  MODIFY `seller_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=112;

--
-- AUTO_INCREMENT for table `subcategory_table`
--
ALTER TABLE `subcategory_table`
  MODIFY `subcategory_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=607;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bill_details_table`
--
ALTER TABLE `bill_details_table`
  ADD CONSTRAINT `bill_details_table_ibfk_1` FOREIGN KEY (`bill_id`) REFERENCES `bill_table` (`bill_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bill_details_table_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `item_table` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `bill_table`
--
ALTER TABLE `bill_table`
  ADD CONSTRAINT `bill_table_ibfk_1` FOREIGN KEY (`buyer_id`) REFERENCES `buyer_signup_table` (`buyer_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `item_table`
--
ALTER TABLE `item_table`
  ADD CONSTRAINT `item_table_ibfk_1` FOREIGN KEY (`subcategory_id`) REFERENCES `subcategory_table` (`subcategory_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `item_table_ibfk_2` FOREIGN KEY (`seller_id`) REFERENCES `seller_signup_table` (`seller_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `subcategory_table`
--
ALTER TABLE `subcategory_table`
  ADD CONSTRAINT `subcategory_table_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category_table` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
