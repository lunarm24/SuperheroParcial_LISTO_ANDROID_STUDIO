# SUPERHERO UNIVERSE ✦ — Proyecto Android Studio

**Aplicación Kotlin + Jetpack Compose para el parcial de Desarrollo Móvil.**

## Abrir y ejecutar en Windows
1. Descomprime el ZIP y abre **esta carpeta**, la que contiene `settings.gradle.kts`, `gradlew.bat` y `app`.
2. Android Studio > File > Open > selecciona esta carpeta.
3. Configura **Gradle JDK 17** en Settings > Build, Execution, Deployment > Build Tools > Gradle.
4. Espera a Gradle Sync. La primera vez descargará la distribución oficial de Gradle 8.10.2 y las dependencias.
5. En la barra superior elige `app`, un emulador Android API 26+ con Internet y pulsa Run.
6. Para compilar desde PowerShell: `.\gradlew.bat :app:assembleDebug`.

## Incluido
- `gradlew.bat`, `gradlew`, `gradle/wrapper/gradle-wrapper.jar` y `gradle-wrapper.properties`.
- **Nota:** el JAR incluido es un lanzador Java auto-contenido que descarga y ejecuta la **distribución oficial** de Gradle 8.10.2. No es el JAR estándar generado por `gradle wrapper`, porque ese binario no estaba disponible en el entorno de generación. Los comandos `gradlew.bat` funcionan con el mismo formato habitual. Se necesita Internet en la primera ejecución.
- MVVM, UiState, ViewModel por pantalla, Retrofit, DTO, DataSource, Repository, `Result`, Hilt y navegación centralizada.
- Un archivo `.kt` por componente visual; `@Preview` en el mismo archivo que su composable.
- Lista de superhéroes con búsqueda, tarjetas compactas y perfil con datos de apariencia,
  biografía, ocupación, conexiones y estadísticas. La interfaz usa una paleta lila/coral/crema.
- API: https://akabab.github.io/superhero-api/ (lista y consulta por ID).

## Previews
Abre `ui/home/HomeScreen.kt` o `ui/detail/DetailScreen.kt` y selecciona Split o Design; pulsa Build & Refresh.

## Estado de validación
Se verificó la compilación Android con `.\gradlew.bat :app:assembleDebug`. No se ejecutó la aplicación en un emulador.
