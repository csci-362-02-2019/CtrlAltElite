#!/bin/bash

CONTAININGDIRECTORY="`dirname \"$0\"`/"
FILE="./currDirectory.html"
rm -f $FILE
DIRECTORYCONTENTS="$(ls $CONTAININGDIRECTORY)"
echo "<html>$DIRECTORYCONTENTS</html>" >> $FILE
xdg-open $FILE
