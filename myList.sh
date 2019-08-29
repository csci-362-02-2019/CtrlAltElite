DIRECTORY="$(ls)"
echo "<html>$DIRECTORY</html>" >> currDirectory.html
sudo apt-get install open
rm -f ./currDirectory.html
open ./currDirectory.html
