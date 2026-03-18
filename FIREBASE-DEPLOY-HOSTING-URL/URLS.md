<!-- javafx create -->
https://openjfx.io/ 

mvn archetype:generate \
        -DarchetypeGroupId=org.openjfx \
        -DarchetypeArtifactId=javafx-archetype-simple \
        -DarchetypeVersion=0.0.6 \
        -DgroupId=org.openjfx \
        -DartifactId=sample \
        -Dversion=1.0.0 \
        -Djavafx-version=25.0.2

mvn clean javafx:run

<!-- maven compile -->
mvn clean compile exec:java -Dexec.mainClass="mn.icode.InputWriter"

<!-- firebase -->
~/.bashrc
firebase login
firebase init

<!-- deploy firebase -->
Tusul1-card:             firebase deploy --only hosting:malacca-winter-2025-khuslen-eb0ff
Tusul2-Simple-Portfolio: firebase deploy --only hosting:malacca-winter-2025-khuslen-8361d
Tusul2-ver2:             firebase deploy --only hosting:malacca-winter-2025-khuslen-7bbc2
Tusul3-cafe:             firebase deploy --only hosting:malacca-winter-2025-khuslen-5300f
Tusul4-dj:               firebase deploy --only hosting:malacca-winter-2025-khuslen-3a90d
Tusul5-calc:             firebase deploy --only hosting:malacca-winter-2025-khuslen-cde1a