plugins {
    id "com.diffplug.spotless"
    id "com.palantir.java-format"
}

subprojects {
    apply {
        plugin("com.diffplug.spotless")
        plugin("com.palantir.java-format")
    }
}

/**
 * Since the Palantir formatter is explicitly used,
 * the 'palantirJavaFormat()' option isn't specified here.
 * (Doing so causes an error: "Multiple steps for spotless format".)
 * Other formatters are 'eclipse()' and ' googleJavaFormat().aosp()'
 *
 * The Palantir formatter also adds a 'format' task to Gradle for easy usage.
 */
spotless {
    java {
        removeUnusedImports()
        importOrder ' '         // allow blank lines between imports
        indentWithSpaces(4)
        trimTrailingWhitespace()
    }
    format 'misc', {
        // define the files to apply `misc` to
        target '*.gradle', '*.md', '.gitignore'

        // define the steps to apply to those files
        trimTrailingWhitespace()
        indentWithSpaces(4)
        endWithNewline()
    }
}

// With this dependsOn, spotlessApply is auto-applied when the 'build' or 'check' task runs
build.dependsOn 'spotlessApply'
check.dependsOn 'spotlessApply'