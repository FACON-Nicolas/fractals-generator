#!/bin/bash

# Variables
nomFractale="triangle"
height=2048
width=2048
nbIterations=10
directoryOutput="./$nomFractale"
fileName="$nomFractale.svg"


# Permet de créer le jar permettant de générer les fractales
./gradlew jar

# Vérifie si le dossier de destination existe
if [[ ! -d $directoryOutput ]]
then
  mkdir "$directoryOutput"
fi

java -jar build/libs/sae-2022-2023.jar -f $nomFractale -h $height -w $width -n $nbIterations \
  -o $directoryOutput/$fileName
