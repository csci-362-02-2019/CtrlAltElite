
cd "`dirname \"$0\"`/"..
javac project/*.java

FILE="./results.html"

rm -r $FILE 
echo "<html>" >> $FILE
echo "<style>" >> $FILE
echo `cat style.css` >> $FILE
echo "</style> " >> $FILE
echo "<h2>TEST REPORT</h2><br/>" >> $FILE
now=$(date)
echo "<b>This report was generated on: $now</b><br/>" >> $FILE
echo "<table border='1''><tr><th>Test Case</th><th width='500'>Requirement</th><th>Method</th><th>Arguments</th><th>Oracle</th><th>Result</th><th>PASS/FAIL</th></tr>" >> $FILE
for fileName in testCases/testCase*.txt; do
	
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
	echo "<td>$method</td>" >> $FILE
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

