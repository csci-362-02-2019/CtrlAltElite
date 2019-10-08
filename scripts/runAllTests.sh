
cd "`dirname \"$0\"`/"..
javac project/*.java

for fileName in testCases/testCase*.txt; do
	testID=`sed '3q;d' $fileName`
	requirement=`sed '4q;d' $fileName`
	component=`sed '5q;d' $fileName`
	method=`sed '6q;d' $fileName`
	driver=`sed '7q;d' $fileName`
	param1=`sed '8q;d' $fileName`
	param2=`sed '9q;d' $fileName`
	oracle=`sed '10q;d' $fileName`
done
