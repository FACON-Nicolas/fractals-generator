#!/bin/bash

# Variables
nomFractale="mandelbrot"
height=2048
width=2048
nbIterations=100
directoryOutput="./$nomFractale"
nbZoom=5
scale=$(echo "2/$height" | bc -l)
palette=rose
focusX=-1.4002
focusY=0

# Permet de créer le jar permettant de générer les fractales
./gradlew jar

# Vérifie si le dossier de destination existe
if [[ ! -d $directoryOutput ]]
then
  mkdir "$directoryOutput"
fi

while [[ $# -gt 0 ]]; do
  case $1 in
    --help)
      java -jar build/libs/sae-2022-2023.jar --help
      exit 1
      ;;
    -p|--palette-name)
      palette="$2"
      shift
      shift
      ;;
    -x|--focus-x)
      focusX="$2"
      shift
      shift
      ;;
    -y|--focus-y)
      focusY="$2"
      shift
      shift
      ;;
  esac
done

for ((i=1;i<=nbZoom;i++))
do
  fileName="$nomFractale-$i.png"

  java -jar build/libs/sae-2022-2023.jar -f $nomFractale -h "$height" -w "$width" -n "$nbIterations" \
  -o "$directoryOutput/$fileName" -p "$palette" -x "$focusX" -y "$focusY" -s "$scale"

  scale=$(echo "$scale/2" | bc -l)

done