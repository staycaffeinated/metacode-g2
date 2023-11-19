/**
 * The Nebula Lint plugin needs to be defined in the root project,
 * otherwise you'll see the error:
 *    Failed to apply plugin 'nebula.lint'.
 *        Task with name 'fixGradleLint' not found in root project '[name-of-your-project]'.
 * The Sonar plugin is here because the subproject-configurations includes
 * SonarQube configuration DSL.
 * The lombok plugin is here to resolve this error:
 *    Error resolving plugin [id: 'io.freefair.lombok', version: 'x.y']
 *    The request for this plugin could not be satisfied because the plugin is already on the classpath with an unknown version...
 **/

plugins {
    alias(libs.plugins.nebula.lint)
    alias(libs.plugins.sonar)
    alias(libs.plugins.lombok.plugin)
    id "org.example.subproject-configurations"
}
