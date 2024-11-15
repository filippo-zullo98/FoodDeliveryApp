# FoodDeliveryApp
1. Project Title:   	**DeliveryMate - Open-Source App for Delivery Drivers**
2. Project Description:		DeliveryMate is an open-source mobile application developed in Java, designed to simplify the daily operations of food delivery drivers.
	The app allows drivers to navigate easily to customer addresses, log order payments, and calculate daily earnings. With a focus on efficiency and user-friendliness, DeliveryMate aims to enhance the delivery experience for both drivers and restaurants.

3. Features
    - Navigation: Seamless integration with Google Maps for quick access to customer locations.
    - Order Logging: Record order amounts and associate them with customer names.
    - Earnings Summary: Automatically calculate daily earnings and track completed deliveries.
    - Database Management: Secure storage of data using MySQL.
    - Offline Functionality: Core features remain available without an active internet connection.

4. Installation

   *Requirements*
    - Java Development Kit (JDK) 11 or higher
    - MySQL Server
    - IDE (e.g., IntelliJ IDEA, Eclipse, or Visual Studio Code with Java support)
    - Google Maps API Key

   *Setup Instructions*
	- Clone the repository: git clone https://github.com/filippo-zullo98/FoodDeliveryApp.git
	- Import the project into your Java IDE.
	- Set up the MySQL database:

   		1. Create a new MySQL database (e.g., deliverymate_db).

   		2. Import the provided SQL file (database/deliverymate_schema.sql) to initialize the schema.

   		3. Update the application.properties file with your MySQL credentials:
			* spring.datasource.url=jdbc:mysql://localhost:3306/deliverymate_db
			* spring.datasource.username=your_mysql_username
			* spring.datasource.password=your_mysql_password
	- Configure the Google Maps API Key:
		* Add your API key to the appropriate configuration file.
	- Build and run the application using Maven:
		* mvn clean install 
		* mvn spring-boot:run

