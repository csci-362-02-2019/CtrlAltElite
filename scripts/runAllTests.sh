
cd "`dirname \"$0\"`/"..
javac project/*.java

for fileName in testCases/*.txt; do
	echo $fileName
	for ((i = 0; i < 8; i++)) do
done



output=$(java project.GCDDriver)

