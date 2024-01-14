above program segragates on code wise while this below transfers data using logstash 




input {
  jdbc {
    jdbc_driver_library => "C:/Users/eSewa/Desktop/mysql-conf/mysql-connector-j-8.2.0.jar"
    jdbc_driver_class => "com.mysql.cj.jdbc.Driver"
    jdbc_connection_string => "jdbc:mysql://localhost:3306/write_db?user=root&password=root"
    jdbc_user => "root"
    jdbc_password => "root"
    statement => "SELECT address, firstname, gender, lastname, phonenumber, verificationstatus FROM write_db.customer_detail WHERE verificationStatus = 'VERIFIED'"
    schedule => "*/1 * * * *"
  }
}

filter {
  jdbc_streaming {
    # JDBC driver settings
    jdbc_driver_class => "org.postgresql.Driver"
    jdbc_driver_library => "C:/Users/eSewa/Desktop/postgresql-conf/postgresql-42.5.4.jar"
    jdbc_connection_string => "jdbc:postgresql://localhost:5432/read_db?user=postgres&password=root"

    statement => "INSERT INTO customer_detail (address, firstname, gender, lastname, phonenumber, verificationstatus) VALUES (?, ?, ?, ?, ?, ?)"

    # Parameters to be bound in the SQL statement
    parameters => ["[address]", "[firstname]", "[gender]", "[lastname]", "[phonenumber]", "[verificationstatus]"]

    # Target field where the result of the query will be stored
    target => "result_field"
                                   
    # Use prepared statements
    use_prepared_statements => true

    # Name for the prepared statement (optional but useful for reusing statements)
    prepared_statement_name => "insert_customer"

    # Bind values for the prepared statement
    prepared_statement_bind_values => ["[address]", "[firstname]", "[gender]", "[lastname]", "[phonenumber]", "[verificationstatus]"]
  }
}

output {
  stdout { codec => rubydebug }
}
