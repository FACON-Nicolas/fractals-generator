# Autour des Fractales

## Diagramme UML

```plantuml
@startuml
interface IComplex {
+{abstract}getRealPart()
+{abstract}getImaginaryPart()
+{abstract}abs()
+{abstract}negate()
+{abstract}conjugate()
+{abstract}add(IComplex other)
+{abstract}substract(IComplex other)
+{abstract}multiply(Icomplex other)
+{abstract}multiply(double value)
+{abstract}divide(Icomplex other)
}

class PlanComplexTranslationDecorator {
 - constante
 + PlanComplexTranslationDecorator(constante, plan, width, height)
}

class PlanComplexZoomDecorator {
 - constante
 + PlanComplexZoomDecorator(constante, plan, width, height)
}

class PlanComplex {
 - width
 - height
 + PlanComplex(width, height)
 + asComplex(row, column)
 + getWidth()
 + getHeight()
}

interface IPlanComplex {
 + {abstract}asComplex(row, column)
 + {abstract}getWidth()
 + {abstract}getHeight()
}

abstract class PlanComplexDecorator {
 - plan
 + asComplex(row, column)
 + getWidth()
 + getHeight()
}

class Complex {

-real
-imaginary

+Complex(int real, int imaginary)
+Complex()
+getRealPart()
+getImaginaryPart()
+abs()
+negate()
+conjugate()
+add(IComplex other)
+substract(IComplex other)
+multiply(Icomplex other)
+multiply(double value)
+divide(Icomplex other)
+toString()
+hashCode()
+equals(Object other)

}

IComplex <|---[dashed]Complex
IPlanComplex<|---[dashed]PlanComplexDecorator
PlanComplexDecorator<|---PlanComplexTranslationDecorator
PlanComplexDecorator<|---PlanComplexZoomDecorator
IPlanComplex<|----[dashed]PlanComplex
PlanComplexDecorator *-- PlanComplex : use
PlanComplexZoomDecorator *-- Complex : use
PlanComplexTranslationDecorator *-- Complex : use

note "On a choisi un décorateur pour AJOUTER une translation aux nombres complexes" as N1
note "On a choisi un décorateur pour AJOUTER le zoom aux nombres complexes" as N2
PlanComplexTranslationDecorator .. N1
PlanComplexZoomDecorator .. N2
@enduml
```

```plantuml
@startuml

interface IStrategieSuite {
 + determinerTermeSuivant(IComplex termeAnterieur) : IComplex
}

interface Iterator<E> {
 + {abstract} next() : E
 + {abstract} hasNext() : boolean
}

class SuiteIterator {
 - iterationMax : int
 - terme : IComplex
 + SuiteIterator(IStrategie suite, IComplex terme, int iterationMax)
 + hasNext() : boolean
 + next() : IComplex
}

class SuiteMandelbrot {
 - IComplex z;
 - maxIteration : int
 + SuiteMandelbrot(maxIteration, c, z)
 + determinerTermeSuivant(IComplex termeAnterieur) : IComplex
 + iterator() : Iterator<IComplex>
}

class SuiteJulia {
 - z : IComplex
 - c : IComplex
 - maxIteration : int
 + SuiteJulia(maxIteration, c, z)
 + determinerTermeSuivant(IComplex terme)
 + iterator() : Iterator<IComplex>
}


interface Iterable<E> {
 + {abstract} iterator() : Iterator<E>
}

SuiteIterator *-- IStrategieSuite : suite
Iterator <--[dashed] SuiteIterator

SuiteIterator <--[dashed] SuiteMandelbrot
Iterable <--[dashed] SuiteMandelbrot

SuiteIterator <--[dashed] SuiteJulia
Iterable <--[dashed] SuiteJulia

SuiteIterator *-- SuiteJulia : iterator
SuiteIterator *-- SuiteMandelbrot : iterator
@enduml
```


## Description

Ce projet fournit une implantation de base pour votre projet de SAÉ S3.A.01.
Pour pouvoir développer votre propre implantation de ce projet, vous devez
en créer une **divergence** en cliquant sur le bouton `Fork` en haut à droite
de cette page.

Lorsque ce sera fait, vous pourrez inviter les membres de votre groupe en tant
que *Developer* pour vous permettre de travailler ensemble sur ce projet.

## Exécution

Pour exécuter l'application, vous pouvez exécuter la tâche `run` de *Gradle*.
Afin de vous permettre de facilement contrôler la création des fractales depuis
la ligne de commande, la classe `fr.univartois.butinfo.fractals.Fractals` (qui
définit la méthode `main`) gère déjà pour vous les arguments de cette ligne
de commande (les options données sont stockées dans les attributs de cette
classe).
Vous pouvez en particulier l'exécuter à l'aide des options suivantes :

```
-f,--fractal-name  <name>      Spécifie le nom de la fractale à générer.
-h,--height        <pixels>    Spécifie la hauteur de l'image à générer.
-n,--nb-iterations <integer>   Spécifie le nombre d'itérations à appliquer pour générer la fractale.
-o,--output        <file>      Spécifie le nom du fichier dans lequel la fractale doit être sauvegardée.
-p,--palette-name  <name>      Spécifie le nom de la palette de couleurs à appliquer lors de la génération.
-s,--scale         <ratio>     Spécifie l'échelle à appliquer sur l'image.
-w,--width         <pixels>    Spécifie la largeur de l'image à générer.
-x,--focus-x       <real>      Spécifie le point central de l'image sur l'axe des abscisses.
-y,--focus-y       <real>      Spécifie le point central de l'image sur l'axe des ordonnées.
```

Évidemment, vous devrez compléter la classe `Fractals` pour qu'il se passe
quelque chose lors de l'exécution !

## JAR exécutable

Vous avez également la possibilité de générer un JAR à l'aide de *Gradle*, en
exécutant la tâche `jar`.
Ce JAR constitue un exécutable que vous pouvez facilement distribuer, et que
vous pouvez exécuter de la manière suivante :

```bash
java -jar build/libs/sae-2022-2023.jar --help
```

Les options acceptées par ce JAR sont les mêmes que celles décrites dans la
section précédente.
