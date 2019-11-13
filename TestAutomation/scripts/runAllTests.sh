#!/bin/bash

cd "`dirname \"$0\"`/"..

find . -name "*.java" | xargs javac

cd ..

# defines the file we are writing output to
FILE="TestAutomation/reports/testReport.html"

# removes the previous results file if it exists
rm -f $FILE 

# writing html stuff into results.html
echo "<html>" >> $FILE
echo "<style>" >> $FILE
echo `cat TestAutomation/scripts/style.css` >> $FILE
echo "</style> " >> $FILE
echo "<h2>TEST REPORT</h2><br/>" >> $FILE

# $(date) gives the current date/time
echo "<b>This report was generated on: $(date)</b><br/>" >> $FILE

# creates a table in which the results are displayed nicely
echo "<table border='1''><tr><th>Test Case</th><th width='500'>Requirement</th><th>Component</th><th>Method</th><th>Driver</th><th>Arguments</th><th>Oracle</th><th>Result</th><th>PASS/FAIL</th></tr>" >> $FILE

# loops through each testCase file in the testCases folder
for fileName in TestAutomation/testCases/testCase*.txt; do
	
	# each of the variables below is assigned with the appropriate 
	# value from one of the lines in the test case file.
	
	testID=`sed '3q;d' $fileName`
	requirement=`sed '4q;d' $fileName`
	component=`sed '5q;d' $fileName`
	method=`sed '6q;d' $fileName`
	driver=`sed '7q;d' $fileName` 
	param1=`sed '8q;d' $fileName`
	param2=`sed '9q;d' $fileName`
	oracle=`sed '10q;d' $fileName`
	
	result=`java $driver "$param1" "$param2"`

	echo "<tr>" >> $FILE
	echo "<td>$testID</td>" >> $FILE
	echo "<td>$requirement</td>" >> $FILE
	echo "<td>$component</td>" >> $FILE
	echo "<td>$method</td>" >> $FILE
	echo "<td>$driver</td>" >> $FILE
	echo "<td>$param1, $param2</td>" >> $FILE
	echo "<td>$oracle</td>" >> $FILE
	echo "<td>$result</td>" >> $FILE
	if [ $oracle == $result ]; then 
		echo "<td>PASS</td>" >> $FILE
	else
		echo "<td>FAIL</td>" >> $FILE
	fi
	echo "</tr>" >> $FILE

done
echo "</table>" >> $FILE
echo "</html>" >> $FILE

xdg-open $FILE

