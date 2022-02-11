find src -name '*.java' > .sources &&
javac -cp src @.sources -d .build/ &&
java -cp .build edu.tmeyer.avaj_launcher.Main "$1" &&
rm -rf .build