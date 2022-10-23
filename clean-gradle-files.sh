#!/bin/sh
echo "clean gradle.properties, settings.properties, gradle wrapper to sub chapers."

PROJECT_FOLDER_LIST=`cat "project-folder-list.txt"`

for f in $PROJECT_FOLDER_LIST;
do
  folder=$(echo $f | sed 's/\\/\//g')

  rm $folder/gradle.properties
  rm $folder/settings.gradle

  rm -r $folder/gradle
  rm $folder/gradlew
  rm $folder/gradlew.bat
done

echo "remove is complete."
