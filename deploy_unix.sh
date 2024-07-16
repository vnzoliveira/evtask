#!/bin/bash

# Ensure we're in the correct directory (where the script is located)
cd "$(dirname "$0")" || exit

# Make this script executable
chmod +x "$0"

# Make the Maven Wrapper executable if it's not
chmod +x ./mvnw

# Run Maven Wrapper to clean and package the project
./mvnw clean package

# Check if the Maven build was successful
if [ $? -ne 0 ]; then
    echo "Maven build failed."
    exit 1
fi

# Set the classpath to include all necessary JARs
CLASSPATH="target/evtask/WEB-INF/classes"
for jar in target/evtask/WEB-INF/lib/*.jar; do
    CLASSPATH="$CLASSPATH:$jar"
done

# Run the Main class
java -cp "$CLASSPATH" com.evtask.myproject.main.Main &

# Wait for the server to start
sleep 5

# Open the default browser to localhost:8080
xdg-open "http://localhost:8080" || open "http://localhost:8080"
