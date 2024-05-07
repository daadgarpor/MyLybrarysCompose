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


💻 Requirements
------------

To try out these sample apps, you need to use [Android Studio](https://developer.android.com/studio).
You can clone this repository or import the
project from Android Studio following the steps
[here](https://developer.android.com/jetpack/compose/setup#sample).


🧬 Samples
------------

## Uso

Para utilizar esta función, simplemente inclúyela en tu proyecto

```kotlin
# Importar la función desde tu módulo en una funcion Composable

	@Preview(showBackground = true)
	@Composable
	fun Dots(){
	    var currentDotPosition by remember { mutableIntStateOf(0) }
	    var dotCount by remember { mutableIntStateOf(5) }
	
	    Box(modifier = Modifier
	        .fillMaxSize()
	        .background(Color.White)) {
	        Column {
	            Button(
	                onClick = {
	                    if (currentDotPosition < dotCount - 1) {
	                        currentDotPosition += 1
	                    }
	                }) {
	                Text(text = "clickNext")
	            }
	            Button(
	                onClick = {
	                    if (currentDotPosition <= 0 ) {
	                        currentDotPosition = 0
	                    }else{
	                        currentDotPosition -= 1
	                    }
	                }) {
	                Text(text = "clickAtras")
	            }
	          DotsIndicator(
	                dotCount = dotCount,
	                currentDotPosition = currentDotPosition,
	                shape = CircleShape,
	                colorBackground = Color.Gray,
	                colorDotsUnselected = Color.White,
	                onClickDot = { position ->
	                    currentDotPosition = position
	                }
	            )
	        }
	    }
	}


