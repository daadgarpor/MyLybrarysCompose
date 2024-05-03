# Dots Lybrary

La libreria DotsIndicator es un componente visual Composable diseñado para indicar visualmente una posición específica dentro de una serie de elementos. 
Este indicador es ideal para carruseles de imágenes, vistas de paginación, o cualquier interfaz donde sea necesario mostrar la posición actual en un conjunto de elementos.

## Implementacion 

#### STEP 1. Add it in your root build.gradle at the end of repositories:

	dependencyResolutionManagement {
		repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
		repositories {
			mavenCentral()
			maven { url 'https://jitpack.io' }
		}
	}

#### Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.daadgarpor:MyLybrarysCompose:Tag'
	}

### Prerrequisitos

## Uso

Para utilizar esta función, simplemente inclúyela en tu proyecto

```kotlin
# Importar la función desde tu módulo en una funcion Composable

# currentDotPosition parametro que indica dot que se selecciona
# dotCount parametro que indica cantidad de dots a implementar

    DotsIndicator(dotCount = 3, currentDotPosition = 0)

