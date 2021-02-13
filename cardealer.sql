-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 01, 2020 at 10:43 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cardealer`
--
CREATE DATABASE IF NOT EXISTS `cardealer` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `cardealer`;

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE `car` (
  `listingNumber` int(11) NOT NULL,
  `lastOwnerID` int(11) NOT NULL,
  `car_reg` varchar(15) NOT NULL,
  `year` varchar(45) NOT NULL,
  `make` varchar(45) NOT NULL,
  `model` varchar(45) NOT NULL,
  `colour` varchar(45) NOT NULL,
  `odometer` int(11) NOT NULL,
  `0to62` double NOT NULL,
  `engine` double NOT NULL,
  `fuel` varchar(45) NOT NULL,
  `transmision` varchar(45) NOT NULL,
  `body` varchar(45) NOT NULL,
  `isofix` tinyint(4) NOT NULL,
  `tax` int(11) NOT NULL,
  `previous_owners` int(11) NOT NULL,
  `serviceHistory` tinyint(4) NOT NULL,
  `buyPrice` int(11) NOT NULL,
  `sold` tinyint(4) NOT NULL,
  `description` varchar(1100) NOT NULL,
  `listPrice` int(11) NOT NULL,
  `note` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`listingNumber`, `lastOwnerID`, `car_reg`, `year`, `make`, `model`, `colour`, `odometer`, `0to62`, `engine`, `fuel`, `transmision`, `body`, `isofix`, `tax`, `previous_owners`, `serviceHistory`, `buyPrice`, `sold`, `description`, `listPrice`, `note`) VALUES
(4294194, 1, '202-CE-853', '2020 (201)', 'Opel', 'Elite 2.0D 170 Auto', 'olives', 254622, 9, 2, 'Diesel', 'Automatic', 'Hatchback', 0, 271, 1, 0, 36799, 0, '                                  Highlightsizveryniceandincludestwin-spokealloywheelsIntelliLuxLEDmatrixheadlightsFrontfoglightsDark-tintedrearwindowsErgonomicactivefrontseatsLeatherseatfacingsHeatedfrontseats8-inchcolourinformationdisplayMultimediaNaviProinfotainmentsystemwithfullyintegratedEuropeansatnavsystem8-inchcolourtouchscreenAM/FM/DABdigitalradioBluetooth?audiostreaming/mobilephoneportalAppleCarPlay/AndroidAutoUSBaudioconnectionSevenspeakers(fivefronttworear)Dual-zoneelectronicclimatecontrolIlluminatedvanitymirrorsStoragepocketsonfrontseatbacksAmbientLEDlightinginfrontdoorsTwinrearUSBsocketsAuto-dimmingrear-viewmirrorandmore    \r\n                        ', 39999, '                                 Reducedfrom?41000tomaswashereveryin\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"    \r\n                        '),
(4294195, 2, '119-L-7896', '2019 (191)', 'Hyundai', 'i30 i30N 2.0 T-GDi', 'Grey', 19855, 9.6, 2, 'Petrol', 'Manual', 'Hatchback', 1, 270, 1, 1, 32200, 0, 'Hyundai i30N 271Bhp?four-cylinder 2.0 T-GDi engine,?Highlights include?ABS, Passenger Airbag, Air Conditioning, Alarm, 19\' Alloys, Armrest, Auto Lights and Wipers, Bluetooth Phone, Child Locks, Cruise Control, Dual Climate Control, Electrically Adjustable Seats, Electric Mirrors, Electric Windows, Heated Seats, Immobilizer, ISO Fix, Lumbar Support, Multi-Function Steering Wheel, Power Steering, Satellite Navigation, Stop and Start System, USB, Rear Parking Sensors, Auto Dimming Rear View Mirror, Leather Steering Wheel, Auto Lights, Auxiliary Jack Input, Traction Control, Adjustable seats, Remote controlled alarm, Adjustable steering column/wheel, Foglights, Height adjustable drivers seat, Mirrors electric and heated, Outside temperature meter, Rain sensor, Rear headrests, Traction control, Media Connection, iPod Connection, Auto Wipers, Leather Gear Lever, Car History Checked, Finance Available, auto  stop/start, reversing camera, Apple CarPlay, Android Auto and much more', 35000, ''),
(4294196, 3, '161-T-365', '2016 (161)', 'Toyota', 'Rav4 Luna 2.0D-4D', 'Slate', 85411, 8.5, 2, 'Diesel', 'Manual', 'SUV', 1, 270, 1, 1, 18308, 0, 'Highlights include reversing camera ,alloy wheels, abs brakes, fog lights bluetooth isofix points multiple airbags cloth trim electric windows and wing mirrors automatic headlights, immobiliser and cruise control.', 19900, ''),
(4294197, 4, '181-L-368', '2018 (181)', 'Hyundai', 'i30 Deluxe 1.6TD', 'Sky Blue', 875471, 10, 1.6, 'Diesel', 'Automatic', 'Hatchback', 1, 190, 2, 0, 18400, 0, '                                  Air Conditioning, Central Locking, Electric Windows, Cruise Control, Fog Lamps, Rear Spoiler, Multi-function steering wheel, Parking Sensors, Bluetooth, EBD, Isofix, Stop/Start Button    \r\n                        ', 20000, '                                 ****DEPOSIT TAKEN (?1500) R Tierney (083 8454752)****    \r\n                        '),
(4294198, 5, '141-G-642', '2014 (141)', 'Volvo', 'S60 D2 SE 1.6TD', 'Dark Grey', 124004, 10.6, 1.6, 'Diesel', 'Manual', 'Saloon', 1, 190, 3, 0, 11960, 0, 'ABS, Air Conditioning, Alloy Wheels, Armrest, Climate Control, Cruise Control, Electric Mirrors, Electric Windows, Immobilizer, ISO Fix, Metallic Paint, Multi-Function Steering Wheel, Power Steering, Side Impact Protection, Multiple Airbags, 3x3point rear seat belts, Adjustable seats, Adjustable steering wheel,', 13000, ''),
(4294199, 6, '131-L-974', '2013 (131)', 'Peugeot', '1.6 HDI ACTIVE 113BHP', 'Charcoal', 240000, 12, 1.6, 'Diesel', 'Manual', 'MPV', 1, 270, 2, 0, 8280, 0, 'Air Conditioning, Central Locking, CD Player, Electric Windows, Cruise Control, Fog Lamps, Immobiliser, Centre Armrest, Multi-function steering wheel, Traction Control Metallic Paint, Multiple Air Bags, Parking Sensors, Trade in accepted, Bluetooth, EBD, Isofix, Active Braking System', 9000, ''),
(4294200, 7, '191-D-87452', '2019 (191)', 'Volkswagen', 'Up!', 'White', 8900, 0, 1, 'Petrol', 'Manual', 'Hatchback', 0, 180, 1, 1, 11040, 0, 'Daytime Running Lights, ESP, ISO Fix, Multiple Airbags, Immobilizer, Auto Lights and Wipers, Remote Central Locking, Adjustable Steering Column, Auxiliary Socket, Bluetooth Phone, Split Fold Rear Seats, USB.?Comes fully prepared, serviced & valeted', 12000, ''),
(4294201, 8, '15-L-15', '2015 (151)', 'Ford', 'Focus TITANIUM 1.6TDCI 115PS', 'Silver', 119875, 9.1, 1.6, 'Diesel', 'Manual', 'Saloon', 1, 190, 2, 0, 11684, 0, 'r Conditioning, Central Locking, Electric Windows, Cruise Control, Fog Lamps, Centre Armrest, Multi-function steering wheel, Traction Control, Metallic Paint, Bluetooth, EBD, Isofix, Active Braking System, Touch Button Start, Touch Screen Infotainment sysytem', 12700, ''),
(4294202, 9, '171-L-2753', '2017 (171)', 'Nissan', 'NOTE 1.5 SV', 'Cherry', 39452, 0, 1.5, 'Diesel', 'Manual', 'MPV', 1, 180, 1, 0, 13064, 0, 'issan Note SV model 1.5dci Spec includes CD Player, Bluetooth Connectivity, Air Conditioning, Cruise Control, Speed Limiter, Idle Stop Start System, Onboard Computer, Power Steering, Multi-Function Steering Wheel, Adjustable Steering Wheel, Sliding Rear Seat, Rear Folding Seats - 40:60 Split, Rear Headrests, Front Centre Armrest, Electric Windows, Electric Mirrors, Fog Lamps', 14200, '****DEPOSIT TAKEN (?500) A Boyle (086 3414752)****'),
(4294203, 10, '10-L-471', '2010', 'Renault', 'Clio 1.2 16V ROYALE ECO', 'Brown', 180000, 16, 1.1, 'Petrol', 'Manual', 'Hatchback', 1, 280, 3, 0, 4600, 0, 'Air Conditioning, Central Locking, Electric Windows, Fog Lamps, Privacy Glass, Multi-function steering wheel, EBD, Isofix', 5000, ''),
(4294204, 11, '152-LK-754', '2015 (152)', 'Dacia', 'Duster ALTERNATIVE 1.5 DCI110', 'Black', 108009, 0, 1.5, 'Diesel', 'Manual', 'SUV', 1, 200, 2, 0, 9292, 0, 'Auxiliary Jack Input, Bluetooth, 6 Speed', 10100, ''),
(4294205, 12, '171-L-774', '2017 (171)', 'Audo', 'A4 3.0 TDI 218 S Tronic SE', 'Silver', 79254, 7.2, 3, 'Diesel', 'Automatic', 'Saloon', 1, 180, 1, 1, 25024, 0, 'ABS, 18 inch Alloys, Armrest, Auto Handbrake, Dual Climate Control, Immobilizer, Rear Parking Sensors, Auto Lights, Adjustable seats, Adjustable steering column/wheel, Body Coloured Bumpers, Mirrors electric and heated, Rain sensor, Finance Available, Sat Nav.', 27200, ''),
(4294206, 13, '171-D-63547', '2017 (171)', 'BMW', 'X3 AUTOMATIC SPORT', 'Black', 97854, 0, 2, 'Diesel', 'Automatic', 'SUV', 1, 180, 1, 0, 31740, 0, 'Jut in stock, This Beautiful BMW X3, One owner from new. Fully Loaded with extras including Power Tailgate, Navigation, Heated seats, Dynamic Driving modes Front and rear parking asistance, and loads more!', 34500, 'Ex-fleet'),
(4294207, 14, '181-L-554', '2018 (181)', 'Ford', 'EcoSport TITANIUM 1.0T 140PS 6', 'Brown', 57895, 0, 1, 'Petrol', 'Manual', 'SUV', 1, 180, 1, 1, 17434, 0, 'A one owner car with full service history', 18950, ''),
(4294208, 15, '182-KK-1024', '2018 (182)', 'Mercedes-Benz', 'CLA-Class CLA 180 AMG SPORT 4DR AUTO', 'Black', 37512, 10, 1.6, 'Petrol', 'Automatic', 'Saloon', 1, 180, 1, 1, 29439, 0, '182 Mercedes CLA 180 Petrol AMG Sport Auto. This is a pristine example of a used Mercedes CLA 180 AMG petrol Auto with genuine low mileage. Air Conditioning, 18\' Alloys, Armrest, Auto Lights and Wipers, Bluetooth Phone, Climate Control, Cruise Control, ISO Fix, Multi-Function Steering Wheel, Radio/CD/MP3, Adjustable seats, iPhone Connection, Car History Checked,', 31999, 'Reduced from ?40,500'),
(4294209, 16, '181-OY-114', '2018 (181)', 'Mercedes-Benz', '-Class CLA 180 D URBAN 4DR', 'Grey', 85497, 0, 1.5, 'Diesel', 'Manual', 'Saloon', 1, 180, 1, 1, 25709, 0, 'ABS, Air Conditioning, Alloy Wheels, Bluetooth Phone, CD player, ISO Fix, Leather Interior, Metallic Paint, Multi-Function Steering Wheel, Power Steering, Radio/CD/MP3, Car History Checked,', 27945, ''),
(4294210, 17, '182-L-4781', '2018 (182)', 'Jaguar', 'E-PACE 2.0 D150PS AWD S AUTO', 'Black', 107566, 8.7, 2, 'Diesel', 'Automatic', 'Saloon', 1, 270, 1, 1, 34132, 0, '182 Jaguar E Pace S Auto finished in Santorin Black with Ivory leather Upholstery. This E Pace is coming with an excellent level of specification including Panoramic Sunroof,  Wheel Drive, Air Conditioning, 18\' Alloys, Auto Lights and Wipers, Bluetooth Phone, Climate Control, Cruise Control, Electrically Adjustable Seats,, ISO Fix, Leather Interior, Multi-Function Steering Wheel, Parking Assistance, Power Steering, Radio/CD/MP3, Satellite Navigation, Multiple Airbags, 3x3point rear seat belts, Car History Checked, LED Lights, Rear View Camera, Front & Rear Parking Sensors, 10\" Touch Screen, Electric Seats, Navigation.', 37100, ''),
(4294211, 18, '202-D-24730', '2020 (202)', 'Jaguar', 'F-PACE Chequered Flag 2.0 Auto RWD 180PS', 'Metallic Eiger Grey', 5, 8.4, 2, 'Diesel', 'Automatic', 'Saloon', 1, 180, 1, 0, 60168, 0, 'equipped with extras such as: - Power-fold / Heated / Auto-Dimming Mirrors - Privacy Glass - Fog lights - Adaptive LED headlamps with Signature DRL - Powered Bootlid Packs such as: Drive Pack, Park Pack and Black Pack. ABS, Alloy Wheels, 17\' Alloys, Auto Handbrake, Auto Lights and Wipers, Bluetooth Phone, Climate Control, Electric Mirrors, Heated Seats, ISO Fix, Leather Interior, Metallic Paint, Multi-Function Steering Wheel, Onboard Computer, Satellite Navigation, Stop and Start System, Tiptronic, USB, Wooden Inlay, Front Parking Sensors, Rear Parking Sensors, Privacy Glass, Leather Steering Wheel, Front Fog Lights, Traction Control, Rain sensor, Traction control, Media Connection, Finance Available, Rear View Camera, Sat Nav, Panoramic Glass Roof, Adaptive Cruise Control, Bluetooth, Heated seats, Rear camera, Privacy glass, Apple Car Play, Android Auto.', 65400, 'Demo model'),
(4294212, 19, '162-LS-115', '2016 (162)', 'Mazda', 'CX-5 2WD 2.2D (150PS) EXEC SE', 'Grey', 63574, 7, 2.2, 'Diesel', 'Manual', 'SUV', 0, 190, 1, 0, 17020, 0, 'The Mazda CX-5 may be a large practical SUV, but it is also a very economical stylish and SUV that is enjoyable to drive. Bluetooth, automatic headlights, automatic wipers, automatic dimming interior mirror, keyless start, parking sensors front and rear with visual display, cruise control, dual climate control, electric folding mirrors, rear privacy glass, twin exhausts, USB connection and much more. All our cars are provided with a warranty (with Manufacturers or our own), HPI clearance & are professionally valeted & detailed. We pride ourselves on customer service and our cars are prepared to the highest standards.', 18500, 'Needs a service. Unlikely to pass the NCT.'),
(4294213, 20, '172-D-96347', '2017 (172)', 'Land Rover', 'Discovery 2.0 SD4 SE 240PS', 'Black', 105102, 0, 2, 'Diesel', 'Automatic', 'SUV', 1, 280, 2, 0, 47794, 0, '4 Wheel Drive, Air Conditioning, Alloy Wheels, Bluetooth Phone, Climate Control, Cruise Control, Extended Warranty, ISO Fix, Multi-Function Steering Wheel, Radio/CD/MP3, Split Fold Rear Seats, Stop and Start System, USB, Height adjustable drivers seat, Rear armrest, Roof rails, Traction control, Remote Boot Release, Car History Checked, Finance Available, Parking Sensors, Apple Car Play', 51950, ''),
(4294214, 21, '171-D-78412', '2017 (171)', 'Renault', 'Captur', 'Red', 19005, 0, 1.5, 'Diesel', 'Manual', 'SUV', 1, 180, 1, 1, 16100, 0, 'Stunning Renault Captur Signature 1.5D , beautiful colour combination with Black contrast roof . This Captur has only done 19,000 and is as new . It also comes with a huge level of specification as standard. For an incrediblely well specked compact, economical SUV with exceptionally low mileage it\'s hard to beat this Renault Captur. ABS, Air Conditioning, Alloy Wheels, Auto Handbrake, Bluetooth Phone, Centralised locking, Cruise Control, Electrically Adjustable Seats, Electric Mirrors, Electric Windows, Heated Seats, Immobilizer, Leather Interior, Metallic Paint, Multi-Function Steering Wheel, Onboard Computer, Power Steering, Satellite Navigation, Privacy Glass, Auto Lights, Front Fog Lights, Traction Control, Foglights, Traction control, Finance Available, Sat Nav.', 17500, ''),
(4294215, 22, '161-D-105785', '2016 (161)', 'Audi', 'A4 1.4 TFSI SPORT 150PS 4DR', 'Black', 88954, 7.9, 1.4, 'Petrol', 'Manual', 'Saloon', 1, 270, 2, 1, 19500, 0, 'Air Conditioning, 17\' Alloys, Bluetooth Phone, Heated Seats, Multi-Function Steering Wheel, Satellite Navigation, Xenon Headlights, Car History Checked, Front & Rear Parking Sensors.', 19500, 'Reduced to clear'),
(4294216, 23, '152-L-1425', '2015 (152)', 'Hyundai', 'i20', 'Bronze', 754010, 16.2, 1.2, 'Petrol', 'Manual', 'SUV', 1, 270, 2, 0, 10074, 0, 'Climate Control, Cruise control, Bluetooth, CD Player, Reversing parking sensors, Multi functional steering wheel, Alloy Wheels, Remainder of Hyundai unlimited mileage warranty, Adjustable steering wheel, USB, AUX port,', 10950, ''),
(4294217, 24, '172-L-3470', '2017 (172)', 'Ford', 'Fiesta TITANIUM 1.25 60PS M5 5', 'Blue', 654020, 17, 1.2, 'Petrol', 'Manual', 'Hatchback', 1, 270, 1, 0, 12144, 0, 'Air Conditioning, Central Locking, CD Player, Electric Windows, Cruise Control, Fog Lamps, Immobiliser, Centre Armrest, Multi-function steering wheel, Traction Control,', 13200, '****DEPOSIT TAKEN (?700) F Moroney (087 1985254)****'),
(4294218, 25, '171-KK-445', '2017 (171)', 'Mazda', 'Mazda 6', 'Brown', 67520, 6.9, 2.2, 'Diesel', 'Manual', 'Saloon', 0, 190, 1, 0, 17388, 0, 'Mazda 6 2.2 Diesel (150PS)PLATINUM ONLY 67.000KMS Leather Seats,Heated Seats,Electric Seats,Metallic Paint,Heads Up Display,Camera,Nav,Keyless Start,Parking Sensors,Upgrade Alloy Wheels', 18900, ''),
(4294219, 18, '202-D-3614', '2020 (202)', 'Mercedes-Benz', 'A-Class A160 AMG 1.3', 'Black', 3, 11, 1.3, 'Petrol', 'Manual', 'Hatchback', 0, 190, 1, 0, 37030, 0, 'Mercedes A160 AMG 1.3 Petrol 109 BHP 3 Years Free Servicing,MBUX,Heated Seats,Reversing Camera,Night Package,Advantage Package,HD Navigation,Packing Pilot,10\"HU. Passenger Airbag, Air Conditioning, Alloy Wheels, Auto Handbrake, Auto Lights and Wipers, Bluetooth Phone, Centralised locking, Child Locks, Climate Control, Cruise Control, Dual Climate Control, Electric Mirrors, Electric Windows, ESP, Hands Free Kit, Immobilizer, ISO Fix, Multi-Function Steering Wheel, Onboard Computer, Parking Assistance, Remote Central Locking, Satellite Navigation, Rear Parking Sensors, Auto Lights, Multiple Airbags, Curtain Airbags, Front Electric Windows, Rear Electric Windows, Adjustable seats, Adjustable steering column/wheel, Body Kit, Heat preventing glass, Heated screen, Height adjustable drivers seat, Mirrors electric and heated, Outside temperature meter, Rear armrest, Media Connection, MP3 Connection, iPod Connection, Passenger Knee Airbag, Auto Wipers, Rear Curtain Airbags. Display,Electric Folding Mirrors', 40250, 'Demo model'),
(4294220, 26, '181-KK-364', '2018 (181)', 'Skoda', 'Citigo AMBITION', 'Red', 11957, 17, 1, 'Petrol', 'Manual', 'Hatchback', 1, 190, 1, 0, 8298, 0, 'Lovely little Automatic cheap tax car, In great condition and great fun to drive. Long Nct and even taxed ready to go. Trade in accepted, Central Locking, CD Player, Electric Windows, Immobiliser, Luggage Cover, Traction Control, Metallic Paint, Remote Central Locking, EBD, Isofix, Active Braking System, 2 Keys', 9020, ''),
(4294221, 27, '171-L-158', '2017 (171)', 'SEAT', 'Ateca', 'Blue', 50475, 14, 1, 'Petrol', 'Manual', 'SUV', 1, 190, 1, 0, 18308, 0, 'One owner from new. Air Conditioning, sat nav, front and rear parking sensors, upgraded alloys.', 19900, 'Just had a major service carried out'),
(4294222, 28, '191-L-9710', '2019 (191)', 'Toyota', 'Camry', 'Pearl Red', 24874, 0, 1.6, 'Hybrid', 'Automatic', 'Saloon', 1, 190, 1, 0, 325772, 0, '2019 (191) Camry Hybrid in pristine condition, comes with the all new improved CVT transmission engineered to perfection for a fuel efficient drive that allows up to and over 50% in full Electric. Annual road tax of just ?190, this state of the art modern vehicle is ready to view immediately', 354100, ''),
(4294223, 29, '151-L-625', '2015 (151)', 'Toyota', 'Avensis', 'Grey', 74257, 0, 1.6, 'Diesel', 'Manual', 'Saloon', 1, 190, 1, 0, 14260, 0, 'Adjustable Steering Wheel / Airbags Multiple / Air Conditioning / Alloy Wheels / Bluetooth / CD Player / Cruise Control / Climate Control / Automatic Start/Stop / Electric Heated Mirrors / Electric Windows (All) / Front Fog Lights / Reversing Camera / Trip Computer / Alarm / Automatic Lights', 15500, 'Ex-fleet'),
(4294224, 30, '172-WW-674', '2017 (172)', 'Toyota', 'C-HR SOL', 'White', 79457, 9.2, 1.8, 'Hybrid', 'Automatic', 'Hatchback', 1, 180, 2, 0, 20700, 0, 'Climate Control / Cruise Control / Bluetooth / CD Player / Leather Part / Leather Steering Wheel / iPod / USB Port / Isofix / Electric Windows (All) / Parking Sensors (Rear) / Parking Sensors (Front) / Reversing Camera / Sat Nav System', 22500, ''),
(4294225, 18, '202-D-47520', '2020 (202)', 'Ford', 'Puma ST-LINE 5D 1.0T 125 MHEV', 'White', 24, 0, 1.6, 'Hybrid', 'Automatic', 'Coupe', 1, 180, 1, 1, 23915, 0, '18\" Alloys / LED Headlamps with Auto Highbeam / Pre-Collission Assist / Front Fogs with Cornering / 8? Sync 3 Touchscreen with Sat Nav and B&O Play Sound System /  Ford Pass Connect / Heated Windscreen / Keyfree Entry with Handsfree Tailgate and Push Button Start / Climate Control / Ambient Lighting / Wireless Phone Charging / Intelligent Adaptive Cruise Control with Evasive Steering / Speed Limiter / Rear Spoiler / Active Park Assist incl Front & Rear Sensors / Alarm / Lane Keeping Aid / Megabox Boot / Auto Wipers / Partial Leather Sports Trim / Privacy Glass / Radar & Camera Fusion Pre-Collision Assist / BLIS with Active Braking / Rear View Camera', 25995, 'Demo model'),
(4294226, 31, '06-C-1847', '2006', 'Lexus', 'GS 300', 'Black', 287541, 7.2, 3, 'Petrol', 'Automatic', 'Saloon', 0, 1494, 5, 0, 2500, 1, 'Air Conditioning, Central Locking, CD Player, Immaculate condition, Electric Windows, Alloy Wheels, Cruise Control, Electric Mirrors, Electric Seats, Fog Lamps, Immobiliser, Leather Upholstery, Full Leather, Automatic Wipers, Automatic Lights, Centre Armrest, Multi-function steering wheel, Climate Control, Traction Control, Metallic Paint, Multiple Air Bags, Parking Sensors, Bluetooth, Remote Central Locking, EBD, Isofix, History Checked, Finance Checked, Keyless Entry, Heated Front Seats, Wireless Smartphone Control, Touch Screen Media Control, Drive Mode Selector', 2600, 'Reduced to clear'),
(4294227, 32, '07-D-9851', '2007', 'Aston Martin', 'Vantage', 'Black', 75457, 4.9, 4.2, 'Diesel', 'Automatic', 'Convertible', 0, 0, 1, 0, 45908, 1, 'Six-speed manual, rear-wheel drive', 49900, 'Left hand drive. Orginally from Spain. Only 2 seats. On hold for T. Mullane (087 6472547)7'),
(4294228, 33, '191-L-686', '2019 (191)', 'Kia', 'Soul', 'Brown', 7899, 0, 0, 'Electric', 'Automatic', 'Hatchback', 1, 120, 1, 0, 23919, 0, 'This Kia e-Soul offers 100kW Fast Charge on DC and 6.6kw on AC or residential Wallbox. Specification includes air conditioning, bluetooth, cruise control, electric windows, sat nav, alloy wheels, fog lights and much much more', 25999, '7 Year Warranty'),
(4294229, 34, '191-L-980', '2019 (191)', 'Renault', 'KADJAR', 'Red', 25640, 0, 1.3, 'Petrol', 'Manual', 'SUV', 1, 180, 1, 1, 23919, 0, 'Adjustable steering column/wheel, Air Conditioning, Armrest, Auxiliary Jack Input, Dual Climate Control, Electrically Adjustable Seats, Heat preventing glass, Heated Seats, Height adjustable drivers seat, Lumbar Support, Media Connection, Mirrors electric and heated, Multi-Function Steering Wheel, Onboard Computer, Satellite Navigation, Split Fold Rear Seats, Stop and Start System, 3x3point rear seat belts, Auto Dimming Rear View Mirror, Auto Handbrake, Xenon Headlights 19\' Alloys, Alloy Wheels, Metallic Paint, Pearlescent paint, Privacy Glass, Roof rails, Sport exhaust pipe', 25999, ''),
(4294230, 35, '162-L-1020', '2016 (162)', 'SEAT', 'Alhambra', 'Red', 74501, 0, 2, 'Diesel', 'Automatic', 'MPV', 1, 270, 2, 1, 22995, 0, 'This Alhambra is the ideal family MPV, it has?fantastic specification for a full size 7 seater and is a textbook car for a growing family; with 3 ISOFIX points in the middle row, automatic boot AND rear doors, wipable leather upholstry, rear sun blinds to keep the kids eyes safe, refrigerated glove box for the snacks, storage for 1.5l bottles in front doors, panoramic roof and 17\" Kosta alloys. With the kids covered, to make the transition to a big car easier for the driver there are heated comfort seats, auto lights and wipers, cruise control, dipping passenger wing mirror when reverse is engaged to keep those alloys safe, front and rear sensors, reverse camera, electronic brake with hill assist. In addition there are multiple airbags in all rows, bluetooth connectivity, anti-lock brakes, electronic stability control, emergency brake assist, tow bar and more.', 24995, '****SOLD****'),
(4294231, 36, '141-L-6651', '2014 (141)', 'Nissan', 'Leaf', 'White', 36841, 0, 0, 'Electric', 'Automatic', 'Hatchback', 1, 120, 2, 1, 10115, 0, 'Adjustable steering column/wheel, Air Conditioning, Auxiliary Jack Input, Electric Mirrors, Media Connection, Mirrors electric and heated, Multi-Function Steering Wheel, USB, 3x3point rear seat belts, ABS, Centralised locking, Child Locks, ESP, Foglights, Immobilizer, ISO Fix, Multiple Airbags, Rear wiper', 10995, 'Battery needs to be replaced');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customerID` int(11) NOT NULL,
  `fullname` varchar(45) NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerID`, `fullname`, `address`, `phone`) VALUES
(1, 'Brendan Watson', 'Moylish LIT Limerick', '012 456789'),
(2, 'Des Ocarroll', 'Moylish LIT Limerick', '012 455988'),
(3, 'Niall Corcoran', 'Moylish LIT Limerick', '012 456000'),
(4, 'James Fennel', 'Moylish LIT Limerick', '069 182395');

-- --------------------------------------------------------

--
-- Table structure for table `previous_owner`
--

CREATE TABLE `previous_owner` (
  `ID` int(11) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `fullName` varchar(45) NOT NULL,
  `address` varchar(90) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `previous_owner`
--

INSERT INTO `previous_owner` (`ID`, `phone`, `fullName`, `address`) VALUES
(1, '087 6645257', 'Barry O\'Brien', 'St Barts, O\'Connell Avenue, Limerick'),
(2, '086 5547874', 'Fergal Keegan', '34 Ferndale, Ennis Road, Limerick'),
(3, '083 6684774', 'Dorota Kowalski', '1 Kimberley Villas, Millitary Hill, Ennis'),
(4, '083 4125874', 'Jaqueline Freeman', '8 Ashwood, Seacrest, Shangort Road, Knocknacarra, Galway'),
(5, '087 4578543', 'Lisa Munroe', '165 Ivy Exchange, Parnell Street, Limerick'),
(6, '086 6634785', 'Catherine Fitzgibbon', '29 Riverbank Hall, Addison Park, Glasnevin, Dublin'),
(7, '086 9987456', 'Joe Crawley', '10 Bloomfield, Monaleen, Limerick'),
(8, '087 1247856', 'Ruth OBrien', '6 Newtown Park, Annacotty, Limerick'),
(9, '087 6235395', 'Robert Clancy', '88 Lagmore Glen, Limerick'),
(10, '087 1025175', 'Phillip Rose', '26 Lawrence Hill, Caherdavin, Limerick'),
(11, '086 6237936', 'Liam Ryan', '12 Mount Rochfort Close, Adare, Limerick'),
(12, '086 5494017', 'Nigel Fairbanks', '12 Killard, Kilteragh, Dooradoyle, Limerick'),
(13, '083 2051611', 'Jennifer Laws', '79 Hollybrook Grove, Clontarf, Dublin'),
(14, '087 3450025', 'Martha Garcia', '18 Nicholas Street, Limerick'),
(15, '868 7774281', 'Doireann Sheehan', '31 Francis Terrace, Kilkenny'),
(16, '085 5170783', 'Pawel Nowak', '4 Tegan Court, Screggan, Tullamore, Offaly'),
(17, '086 9706749', 'Annika Smirnov', '33 Beaumont Road, Corbally, Limerick'),
(18, '01 4578965', 'Long Mile Road Motors', 'Long Mile Rd, Dublin'),
(19, '086 8499065', 'James Doody', 'The Cresent, Kilminchy, Portlaoise, Laois'),
(20, '086 3231949', 'Seamus Haugh', '31 Northumberland Road, Ballsbridge, Dublin 4'),
(21, '086 9262414', 'Dermot Boyle', '4 Portobello Road, Portobello, Dublin 8'),
(22, '087 2456843', 'Terry McGrath', '36 Bulfin Road, Inchicore, Dublin 8'),
(23, '083 1542867', 'Fintan Cooper', '65 Sarsfield Terrace, Richmond Hill, Limerick'),
(24, '086 8276894', 'Shelia Noonan', '6 Ashbrook Lawn, Ennis Road, Limerick'),
(25, '086 7791561', 'Mary Barrett', '10 Marian Place, Bennettsbridge, Kilkenny'),
(26, '087 5776948', 'Maude Condon', '51 Seville Lawns, Margaretsfields, Callan Road, Kilkenny'),
(27, '087 7007777', 'Rita Byrne', '14 Beechwood Drive, Greystones, Ennis Road, Co. Limerick'),
(28, '086 1636400', 'David Bourke', '15 Haymarket, Cathedral Place, Limerick City,'),
(29, '087 5636825', 'Jorge Gonzalez', '15 Alandale Orchard, Ashbourne Avenue, South Circular Road, Limerick'),
(30, '087 3115251', 'Khristina Yahontov', '108 Curragh birin, Castletroy, Limerick'),
(31, '086 2777146', 'Diego Lopez', 'Apt 4 Avery House, Windmill Street, Limerick'),
(32, '086 3209255', 'Imelda Franciosi', 'Apartment 3, Scots Marsh House, William Street, Waterford'),
(33, '086 8812005', 'Aarna Ahluwalia', '14 High Street, Croom, Co. Limerick'),
(34, '083 8121891', 'Moira Broe', 'Kilcurly, Manister, Crecora, Co. Limerick'),
(35, '087 7364930', 'Katina Turgenev', 'Touchwood Stables, Dooneen, Crecora, Co. Limerick'),
(36, '086 1394459', 'Kathy Blake', '6 The Beacon Courtyard, Main Street Patrickswell, Patrickswell, Co. Limerick');

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE `sales` (
  `salesID` int(11) NOT NULL,
  `listingNumber` int(11) NOT NULL,
  `customerID` int(11) NOT NULL,
  `staffID` int(11) NOT NULL,
  `tradein` varchar(15) DEFAULT NULL,
  `tradein_value` int(11) DEFAULT NULL,
  `amount_paid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`salesID`, `listingNumber`, `customerID`, `staffID`, `tradein`, `tradein_value`, `amount_paid`) VALUES
(1, 4294226, 2, 3, 'no', 0, 2600),
(2, 4294227, 1, 4, '4294194', 30000, 19900),
(3, 4294215, 4, 5, 'no', 0, 19500),
(4, 4294231, 3, 1, 'no', 0, 10995);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `staffID` int(11) NOT NULL,
  `email` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `fullName` varchar(45) NOT NULL,
  `fax` varchar(45) NOT NULL,
  `password` varchar(200) NOT NULL,
  `admin` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`staffID`, `email`, `phone`, `fullName`, `fax`, `password`, `admin`) VALUES
(1, 'dave.lindale@moylishmotors.ie', '061208203555555', 'Dave Lindale', '061209209654654', 'd4c7c385eeb6c873b27cd5f690bb2eb474bfb2a09896b0850e903b7a78990f80', 0),
(2, 'connie.jackson@moylishmotors.ie', '061 208208', 'Connie Jackson', '061 209208', 'b51976231e40813782e020fb8da52603782bf4be1ef95acfb29bd1a6216a806b', 0),
(3, 'mary.mckeown@moylishmotors.ie', '061 208207', 'Mary McKeown', '061 207207', '6915771be1c5aa0c886870b6951b03d7eafc121fea0e80a5ea83beb7c449f4ec', 0),
(4, 'bianca.davie@moylishmotors.ie', '061 208206', 'Bianca Davies', '061 209206', 'e4d6dc0f6e2842e950ae809a86e90456285822d9d350ccc4dae596e0a724d7a3', 0),
(5, 'terry.dunlee@moylishmotors.ie', '061 208205', 'Terry Dunlee', '061 209205', 'd93feaf8c84752d0b9b2fea5f92c86f1b95357f5cb18ba59121fe08bcb4c0b16', 0),
(6, 'tomas.bunevicius@moylishmotors.ie', '085 7846932', 'Tomas Bunevicius', '062 209244', 'c9affe7f758723c3eb9fe8b143520c7d3c73fa7cacdbf1a76b34e18624cc6ecf', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`listingNumber`),
  ADD KEY `lastOwnerID` (`lastOwnerID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerID`);

--
-- Indexes for table `previous_owner`
--
ALTER TABLE `previous_owner`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`salesID`),
  ADD KEY `staffID` (`staffID`),
  ADD KEY `customerID` (`customerID`),
  ADD KEY `listingNumber` (`listingNumber`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staffID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `car`
--
ALTER TABLE `car`
  ADD CONSTRAINT `car_ibfk_1` FOREIGN KEY (`lastOwnerID`) REFERENCES `previous_owner` (`ID`);

--
-- Constraints for table `sales`
--
ALTER TABLE `sales`
  ADD CONSTRAINT `sales_ibfk_1` FOREIGN KEY (`staffID`) REFERENCES `staff` (`staffID`),
  ADD CONSTRAINT `sales_ibfk_2` FOREIGN KEY (`listingNumber`) REFERENCES `car` (`listingNumber`),
  ADD CONSTRAINT `sales_ibfk_3` FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
