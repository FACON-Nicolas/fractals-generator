#!/bin/bash

# Variables
nomFractale="mandelbrotGeneralise"
height=2048
width=2048
nbIterations=100
directoryOutput="./$nomFractale"
nbZoom=5
scale=$(echo "2/$height" | bc -l)


# Permet de créer le jar permettant de générer les fractales
./gradlew jar

# Vérifie si le dossier de destination existe
if [[ ! -d $directoryOutput ]]
then
  mkdir "$directoryOutput"
fi


for ((i=1;i<=nbZoom;i++))
do
  fileName="$nomFractale-$i.png"

  java -jar build/libs/sae-2022-2023.jar -f $nomFractale -h $height -w $width -n $nbIterations \
  -o $directoryOutput/$fileName -s "$scale" "$@"

  scale=$(echo "$scale/1.5" | bc -l)

done