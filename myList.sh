DIRECTORY="$(ls)"
echo "<html>$DIRECTORY</html>" >> currDirectory.html
apt-get install open
rm -f ./currDirectory.html
xopen ./currDirectory.html
