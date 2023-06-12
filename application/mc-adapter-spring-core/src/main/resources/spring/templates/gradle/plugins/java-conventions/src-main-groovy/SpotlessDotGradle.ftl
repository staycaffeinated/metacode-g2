plugins {
    id "com.diffplug.spotless"
}

subprojects {
    apply {
        plugin("com.diffplug.spotless")
    }
}

spotless {
    java {
        palantirJavaFormat()
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