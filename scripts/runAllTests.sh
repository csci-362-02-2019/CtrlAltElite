
cd "`dirname \"$0\"`/"..
javac project/*.java

for fileName in testCases/*.txt; do
	testID=`sed '3q;d' $fileName`
	requirement=`sed '4q;d' $fileName`
	method=`sed '5q;d' $fileName`
	arg1=`sed '6q;d' $fileName`
	arg2=`sed '7q;d' $fileName`
	oracle=`sed '8q;d' $fileName`
	echo $oracle
done



output=$(java project.GCDDriver)

